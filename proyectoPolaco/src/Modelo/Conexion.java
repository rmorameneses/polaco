package Modelo;

import Controlador.ControladorAgregarTarjeta;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.ventanaMain;

public final class Conexion 
{
    private static Connection conexion;
    private static String bd="proyectomonica";
    private static String user="root";
    private static String password="root";
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private DefaultTableModel m;
    private static String url = "jdbc:mysql://localhost:3306/test"; 
    private static String usuario = "user"; 
    private static Connection con = null; 
    
    public static void preparardb()
    { //llamamos a la funcion para preparar nuestra Conexion
        try
        {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd,user,password);
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos : " + url );
            stmt = (Statement) con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error en preparardb");
        }
    }
    
    public static ArrayList<Tarjeta> getListaPagos(String fecha) {
        preparardb();
        ArrayList<Tarjeta> listaPagos = new ArrayList<>();
        
        try
        {
            rs=stmt.executeQuery("select pagos.fecha,pagos.idpagos,tarjeta.idcontrol,cliente.nombre,pagos.abono from pagos inner join tarjeta on (pagos.idtarjeta= tarjeta.idtarjeta) inner join cliente on (tarjeta.idcliente = cliente.idcliente) where (pagos.impreso is null) order by tarjeta.idcontrol;");
            
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setClient(new Cliente());
                tarjeta.setPayments(new ArrayList<Payment>());
                tarjeta.setCodigo(rs.getString("idcontrol"));
                tarjeta.getClient().setName(rs.getString("nombre"));
                tarjeta.getPayments().add(new Payment(rs.getInt("abono"), rs.getInt("idpagos"), rs.getString("fecha")));
                
                listaPagos.add(tarjeta);
            }
            
            // crea el reporte si hay mas de un pago que agregar
            if (listaPagos.size() > 0) {
                stmt.executeUpdate("insert into reporte values (null,'"+fecha+"');");
            }
            
            // pone una marca en todos los reportes impresos y los asigna a los reportes
            for (int index = 0; index < listaPagos.size(); index++) {
                stmt.executeUpdate("update pagos set impreso= 'impreso' where pagos.idpagos = "+listaPagos.get(index).getPayments().get(0).getId()+";");
                stmt.executeUpdate("update pagos set idReporte= (SELECT reporte.idreporte FROM proyectomonica.reporte where nombre = '"+fecha+"') where pagos.idpagos = "+listaPagos.get(index).getPayments().get(0).getId()+";");
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrar(stmt);
        return listaPagos;
    }
    
    public static ArrayList<Tarjeta> getListaPagosReporte(String nombreReporte) {
        preparardb();
        ArrayList<Tarjeta> listaPagos = new ArrayList<>();
        
        try
        {
            rs=stmt.executeQuery("select pagos.idpagos,pagos.fecha,tarjeta.idcontrol,cliente.nombre,pagos.abono from pagos inner join reporte on (reporte.idreporte = pagos.idReporte) inner join tarjeta on (pagos.idtarjeta= tarjeta.idtarjeta) " +
                "inner join cliente on (tarjeta.idcliente = cliente.idcliente) where (reporte.nombre = '"+nombreReporte.toUpperCase()+"') order by tarjeta.idcontrol;");
            
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setClient(new Cliente());
                tarjeta.setPayments(new ArrayList<Payment>());
                tarjeta.setCodigo(rs.getString("idcontrol"));
                tarjeta.getClient().setName(rs.getString("nombre"));
                tarjeta.getPayments().add(new Payment(rs.getInt("abono"), rs.getInt("idpagos"), rs.getString("fecha")));
                
                listaPagos.add(tarjeta);
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrar(stmt);
        return listaPagos;
    }

    public static boolean yaExisteTarjeta(String codigo) {
        preparardb();
        int cantidad=0;
        
        try
        {
            rs=stmt.executeQuery("select count(*) from tarjeta where (tarjeta.Idcontrol = '"+codigo+"');");
            rs.next();
            cantidad = rs.getInt("count(*)");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        cerrar(stmt);
        
        return cantidad > 0;
    }
    
    public static Connection getConexion()
    {
        return conexion;
    }    

    public void cerrar(ResultSet rs)
    {
        if(rs !=null)
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                System.out.print("No es posible cerrar la Conexion");
            }
        }
    }

    public static void cerrar(java.sql.Statement stmt)
    {
        if(stmt !=null)
        {
            try
            {
                stmt.close();
            }
            catch(Exception e){}
        }
    }

    public static void destruir()
    {
        if(conexion !=null) {

        try {
            conexion.close();
        }
        catch(Exception e){}
        }
    }
    
    public static ArrayList<String> getReportes() {
        preparardb();
        ArrayList<String> lista = new ArrayList<>();
        
        try
        {
            rs=stmt.executeQuery("select * from reporte order by idreporte desc;");
            
            while(rs.next())
            {
                lista.add(rs.getString("nombre"));
            } 
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrar(stmt);
        
        return lista;
    }

    public static void registrarTarjeta(Tarjeta tarjeta)
    {
        preparardb();
        
        try
        {
            stmt.executeQuery("call insertarCliente('"+tarjeta.getClient().getName().toUpperCase()+"','"+tarjeta.getClient().getLocation().toUpperCase()+"','"+tarjeta.getClient().getMail().toUpperCase()+"');");
            stmt.executeQuery("call insertarTelefono("+(tarjeta.getClient().getPhone().equals("")?0:tarjeta.getClient().getPhone())+",'"+tarjeta.getClient().getName().toUpperCase()+"');");
            
            stmt.executeQuery("call insertarTarjeta('"+tarjeta.getClient().getName().toUpperCase()+"','"+tarjeta.getDiaPago().toUpperCase()+"','"+tarjeta.getPeriodicity().toUpperCase()+"','"+tarjeta.getCodigo()+"','"+tarjeta.getProducts().toUpperCase()+"',"+tarjeta.getSaldoTotal()+",'"+tarjeta.getFechaInicial()+"',"+tarjeta.getCuotaPeriodica()+");");
            
            for (int index = 0; index < tarjeta.getPayments().size(); index++) {
                stmt.executeQuery("call insertarPago('"+tarjeta.getPayments().get(index).getDate()+"',"+tarjeta.getPayments().get(index).getAmount()+",'"+tarjeta.getCodigo()+"','"+tarjeta.getPayments().get(index).getNota().toUpperCase()+"');");
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrar(stmt);
    }
    
    public static void agregarAbono(String abono, String codigoTarjetaAbonar, String date) {
        preparardb();
        
        try {
            System.out.println("date: "+ date);
            System.out.println("abono: "+ abono);
            System.out.println("codigoTarjetaAbonar: "+ codigoTarjetaAbonar);
            stmt.executeQuery("call insertarPago('"+date+"',"+abono+",'"+codigoTarjetaAbonar+"','');");
            JOptionPane.showMessageDialog(null, "Abono insertado correctamente");
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de insertar pago");
        }
        
        cerrar(stmt);
    }
    
    public static int getSaldoTarjeta(String codigo)
    {
        int saldoActual = 0;
        preparardb();
        
        try
        {
            rs=stmt.executeQuery("select saldoTotal-sum(abono) from pagos inner join tarjeta on (pagos.idTarjeta = tarjeta.idtarjeta) where (tarjeta.Idcontrol = '"+ codigo +"');");
            rs.next();
            saldoActual = rs.getInt("saldoTotal-sum(abono)");
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cerrar(stmt);
        
        return saldoActual;
    }
    
    public static ArrayList<Tarjeta> consultarTarjetaCliente(String criterioBusqueda) {
        criterioBusqueda = criterioBusqueda.toUpperCase();
        preparardb();
        ArrayList<Tarjeta> lista= new ArrayList();
        
        try
        {
            if (ControladorAgregarTarjeta.isValidCode(criterioBusqueda)) {
                System.out.println("1");
                rs=stmt.executeQuery("select c.nombre,t.idcontrol, t.fecha, t.cuotaperiodica from cliente c inner join tarjeta t on (c.idcliente = t.idcliente) where (t.idcontrol = '"+criterioBusqueda+"');");
            }
            else {
                rs=stmt.executeQuery("select c.nombre,t.idcontrol, t.cuotaperiodica from cliente c inner join tarjeta t on (c.idcliente = t.idcliente) where (c.nombre like '%"+criterioBusqueda.toUpperCase()+"%');");
            }
            
            while(rs.next())
            {
                lista.add( new Tarjeta("", new Cliente(rs.getString("nombre"),"","",""), "",rs.getString("idcontrol"),"",0,"",0));
                lista.get(lista.size()-1).setCuotaPeriodica(rs.getInt("cuotaperiodica"));
            } 
        }
        catch(Exception ex)
        {
            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
               
        return lista;
    }
}