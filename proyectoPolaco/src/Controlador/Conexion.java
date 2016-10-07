package Controlador;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Conexion 
{
    private Connection conexion;
    static String bd="ExpresaT";
    static String user="root";
    static String password="root";
    Statement stmt = null;
    ResultSet rs = null;
    DefaultTableModel m;
    String url = "jdbc:mysql://localhost:3306/test"; 
    String usuario = "user"; 
    Connection con = null; 
    
    public void preparardb()
    { //llamamos a la funcion para preparar nuestra Conexion
        try
        {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            if ( con != null )
            System.out.println("Se ha establecido una conexión a la base de datos : " + url );
            stmt = (Statement) con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Error en preparardb");
        }
    }

    public Connection getConexion()
    {
        return conexion;
    }
    
    public boolean autenticar(String usuario, String pass, String rol)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call login('"+usuario+"','"+pass+"','"+rol+"');");
            r.next();
            
            if (!(r.getString("count(*)").equals("0")))
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    public void prueba()
    {
        try
        {
            ResultSet r=stmt.executeQuery("call proyeccion;");
            String fila[]=new String[4];
            while(r.next())
            {
                fila[0]=r.getString("nick");
                fila[1]=r.getString("contraseña");
                fila[2]=r.getString("rol");
                fila[3]=r.getString("bloqueado");
                System.out.println(fila[0]+" "+fila[1]+" "+fila[2]+" "+fila[3]+"\n");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
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

    public void cerrar(java.sql.Statement stmt)
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

    public void destruir()
    {
        if(conexion !=null){

        try{
        conexion.close();
        }
        catch(Exception e){}
        }
    }

    public boolean registrarUsuario(String nick, String pass, String rol, String persona) 
    {
        String cedula= persona.split("_")[persona.split("_").length-1]; // obtenemos la cedula de la persona ya que viene en el siguiente formato "apellido1_nombre_cedula"

        try
        {
            ResultSet r=stmt.executeQuery("call registrarUsuarios('"+nick+"','"+pass+"','"+rol+"','"+cedula+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean registrarPersona(String nom, String ape1, String ape2, String Ced, String Gen, String fecha,String nombretipopersona)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call ins_Persona('"+nom+"','"+ape1+"','"+ape2+"','"+Ced+"','"+Gen+"','"+fecha+"','"+nombretipopersona+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean registrarEntidad(String nom, String Ced, String categoria, String Country, String prov,String can, String dis, String bar, String direccion)
    {
        try
        {   
            if(verificarEntidad(nom))
            {
                ResultSet r=stmt.executeQuery("call ins_Ente('"+nom+"','"+Ced+"','"+categoria+"','"+Country+"','"+prov+"','"+can+"','"+dis+"','"+bar+"','"+direccion+"');");
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean registrarCategoriaPer(String nom)
        {   
            try
            {   
                if(verificaCategoriaPersona(nom))
                {
                    ResultSet r;
                    r = stmt.executeQuery("call ins_tipoPersona('"+nom+"');");
                    return true;
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return false;
        }
    
        public boolean registrarCategoriaEmpresa(String nom)
        {   
            try
            {   
                if(verificaCategoriaEmpresa(nom))
                {
                    ResultSet r;
                    r = stmt.executeQuery("call ins_categoria('"+nom+"');");
                    return true;
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return false;
        }

    public boolean verificaCategoriaPersona(String nom)
        {
             try
            {   
                ResultSet r;
                r = stmt.executeQuery("call getTipoPersonas('"+nom+"');");
                
                r.next();
                if(r.getString("nombre")==null || r.getString("nombre").equals(""))
                {
                    return true;
                }
                else
                    return false;    
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return true;
        }

    public boolean verificaCategoriaEmpresa(String nom)
        {
             try
            {   
                ResultSet r;
                r = stmt.executeQuery("call retornarCategoria('"+nom+"');");

                r.next();

                if(r.getString("nombre")==null || r.getString("nombre").equals(""))
                {
                    return true;
                }
                else
                    return false;    
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }

            return true;
        }

    public boolean VerificarUsuario(String nick) 
    {
         try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarUsuario('"+nick+"');");

            r.next();

            if(r.getString("Nick")==null || r.getString("Nick").equals(""))
            {
                return true;
            }
            else
                return false;    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return true;
    }
    
    public boolean verificarEntidad(String nom)
    {
        try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarEntidad('"+nom+"');");
            r.next();
                // Verificacion de una unica empresa con los datos obligatorios
            if((r.getString("Nombre")==null ))
            {
                return true;
            }    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return true;
        }

        return false;
    }
    
    public ArrayList<String> devolverListaPersonasSinCuenta()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarPersonasSinCuenta();");
            while(r.next())
            {
                lista.add(r.getString("apellido1")+"_"+r.getString("nombre")+"_"+r.getString("cedula"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaDenuncias(String nom)
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarDenunciasUsuario('"+nom+"');");
            while(r.next())
            {
                lista.add(r.getString("nombrdenuncia")+"_"+r.getString("denuncia"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaPersonas()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarPersonasGEN();");
            while(r.next())
            {
                lista.add(r.getString("apellido1")+"_"+r.getString("nombre")+"_"+r.getString("cedula"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaEntes()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call retornarEntidadGEN();");
            while(r.next())
            {
                if(r.getString("cedulajur") != null) // Condicional que verifica la existencia de una cedula juridica.
                {
                    lista.add(r.getString("Nombre")+"_"+r.getString("cedulajur"));
                }
                else {lista.add(r.getString("Nombre"));}
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
         
        return lista;
    }
    
    public ArrayList<String> devolverListaTiposPersona()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call get_TipoPersonaGEN();");
            while(r.next())
            {
                lista.add(r.getString("Nombre"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }
    
    public ArrayList<String> devolverListaCat()
    {        
        ArrayList<String> lista= new ArrayList();
        
        try
        {
            ResultSet r=stmt.executeQuery("call getCategoriaGEN();");
            while(r.next())
            {
                lista.add(r.getString("Nombre"));
            } 
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
               
        return lista;
    }

    void insertarDenunciaPersona(String nombre, String descripcion, String listaArchivos, String persona, String privacidad, int nota, String usuario) 
    {
        String cedula= persona.split("_")[persona.split("_").length-1];
        String lista[]=listaArchivos.split("\n");
        
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarDenunciaPersona('"+descripcion+"','"+privacidad+"','"+nombre+"','"+cedula+"',"+nota+",'"+usuario+"');");
            
            for (int i = 0; i < lista.length; i++)
            {
                r=stmt.executeQuery("call agregararchivoDenuncia('"+lista[i]+"','"+nombre+"');");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iinsertar denuncia");
        }
    }
    
    void desactivardenuncia(String nombre)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call desactivardenuncia('"+nombre+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar denuncia");
        }
    }
    
    void actualizarDenuncia(String nombre, String texto)
    {
        try
        {
            ResultSet r=stmt.executeQuery("call actualizardenuncia('"+nombre+"','"+texto+"');");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al actualizar denuncia");
        }
    }
    
    void insertarDenunciaEnte(String nombre, String descripcion, String listaArchivos, String ente, String privacidad, int nota, String usuario) 
    {
        String nombreEnte= ente.split("_")[0];
        String lista[]=listaArchivos.split("\n");
        
        try
        {
            ResultSet r=stmt.executeQuery("call InsertarDenunciaEnte('"+descripcion+"','"+privacidad+"','"+nombre+"','"+nombreEnte+"',"+nota+",'"+usuario+"');");
            
            for (int i = 0; i < lista.length; i++)
            {
                r=stmt.executeQuery("call agregararchivoDenuncia('"+lista[i]+"','"+nombre+"');");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iinsertar denuncia");
        }
    }

    boolean verificarPersona(String datosPersona) 
    {
        try
        {   
            ResultSet r;
            r = stmt.executeQuery("call retornarPersona('"+datosPersona.split("_")[datosPersona.split("_").length-1]+"');");
            r.next();
                // Verificacion de una unica persona con su numero de cedula
            if((r.getString("Nombre")==null ))
            {
                return false;
            }
            else
                return true;    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }

    boolean actualizarUsuario(String nuevoNick, String pass, String viejoNick) 
    {
        try
        {
            ResultSet r=stmt.executeQuery("call actualizarUsuario('"+nuevoNick+"','"+pass+"','"+viejoNick+"');");
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return false;
    }
}