package Controlador;

import Modelo.Conexion;
import Modelo.Tarjeta;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public final class ControladorAgregarTarjeta {
    private static Tarjeta tarjeta;
    private static boolean error;
    public static String DIRECCION_ARCHIVO_WORD ="C:\\Users\\ADMIN\\EBENEZER.docx";
    //String direccionArchivoWord ="C:\\Users\\Luis Barboza\\Desktop\\EBENEZER.docx"; 
    private static final String PATRON_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    public static boolean validadorEmail(String email) {
        // Compiles the given regular expression into a pattern.
        Pattern patron = Pattern.compile(PATRON_EMAIL);
        // Match the given input against this pattern
        Matcher matcher = patron.matcher(email);
        return matcher.matches();
 
    }
    
    private static boolean validacionDatos() {
        if (tarjeta.getClient().getName().length() < 100 || tarjeta.getClient().getPhone().length() < 100) {
            return false;
        }
        
        return true;
    }

    public static boolean isValidCode(String codigo) {
        try {
            String direccion = codigo.split(" ")[0];
            
            if (direccion.length()!=2) {
                return false;
            }
            else if (codigo.split(" ")[1].length()==0) {
                return false;
            }
            
            return true;
        }
        catch (Exception ex) {
        }
        
        return false;
    }
    public ControladorAgregarTarjeta() {
        
    }
    
    public static boolean esAlfaNumerica(String cadena) {
        for(int i = 0; i < cadena.length(); ++i) {
            char caracter = cadena.charAt(i);

            if(!Character.isLetterOrDigit(caracter) && caracter!=',' && caracter!='.' && caracter!=' ' && caracter!='-' && caracter!='/') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean eventoAgregarTarjeta(Tarjeta tarjeta) {
        ControladorAgregarTarjeta.tarjeta= tarjeta;
        if (isNumeric(tarjeta.getClient().getPhone().trim())) {
            Conexion.registrarTarjeta(ControladorAgregarTarjeta.tarjeta);
            JOptionPane.showMessageDialog(null, "Tarjeta introducida correctamentes");
            return true;
        }
        else
            JOptionPane.showMessageDialog(null, "El campo de teléfono debe ser solo números");
        return false;
    }
    
    public static boolean isNumeric(String cadena) {
	try {
            if (cadena.length()== 0)
                return true;
            
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
}
