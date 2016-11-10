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
            rs=stmt.executeQuery("select tarjeta.idcontrol,cliente.nombre,pagos.abono from pagos inner join tarjeta on (pagos.idtarjeta= tarjeta.idtarjeta) inner join cliente on (tarjeta.idcliente = cliente.idcliente) where (pagos.fecha = '"+fecha+"');");
            
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setClient(new Cliente());
                tarjeta.setPayments(new ArrayList<Payment>());
                tarjeta.setCodigo(rs.getString("idcontrol"));
                tarjeta.getClient().setName(rs.getString("nombre"));
                tarjeta.getPayments().add(new Payment(rs.getString("abono")));
                
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

    public static void registrarTarjeta(Tarjeta tarjeta)
    {
        preparardb();
        
        try
        {
            stmt.executeQuery("call insertarCliente('"+tarjeta.getClient().getName()+"','"+tarjeta.getClient().getLocation()+"','"+tarjeta.getClient().getMail()+"');");
            stmt.executeQuery("call insertarTelefono('"+tarjeta.getClient().getPhone()+"','"+tarjeta.getClient().getName()+"');");
            stmt.executeQuery("call insertarTarjeta('"+tarjeta.getClient().getName()+"','"+tarjeta.getDiaPago()+"','"+tarjeta.getPeriodicity()+"','"+tarjeta.getCodigo()+"','"+tarjeta.getProducts()+"',"+tarjeta.getSaldoTotal()+");");
            
            for (int index = 0; index < tarjeta.getPayments().size(); index++) {
                stmt.executeQuery("call insertarPago('"+tarjeta.getPayments().get(index).getDate()+"',"+tarjeta.getPayments().get(index).getAmount()+",'"+tarjeta.getCodigo()+"');");
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
        
        try
        {
            System.out.println("date: "+ date);
            System.out.println("abono: "+ abono);
            System.out.println("codigoTarjetaAbonar: "+ codigoTarjetaAbonar);
            stmt.executeQuery("call insertarPago('"+date+"',"+abono+",'"+codigoTarjetaAbonar+"');");
            JOptionPane.showMessageDialog(null, "Abono insertado correctamente");
        }
        catch(Exception e)
        {
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
        preparardb();
        ArrayList<Tarjeta> lista= new ArrayList();
        
        try
        {
            if (ControladorAgregarTarjeta.isNumeric(criterioBusqueda)) {
                rs=stmt.executeQuery("select c.nombre,t.idcontrol, t.fecha from cliente c inner join tarjeta t on (c.idcliente = t.idcliente) where (t.idcontrol = '"+criterioBusqueda+"');");
            }
            else {
                rs=stmt.executeQuery("select c.nombre,t.idcontrol from cliente c inner join tarjeta t on (c.idcliente = t.idcliente) where (c.nombre = '"+criterioBusqueda+"');");
            }
            
            while(rs.next())
            {
                lista.add( new Tarjeta("", new Cliente(rs.getString("nombre"),"","",""), "",rs.getString("idcontrol"),""));
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