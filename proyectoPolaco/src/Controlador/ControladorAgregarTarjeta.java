package Controlador;

import Modelo.Conexion;
import Modelo.Tarjeta;
import javax.swing.JOptionPane;

public final class ControladorAgregarTarjeta {
    private static Tarjeta tarjeta;
    private static boolean error;
    
    private static boolean validacionDatos() {
        if (tarjeta.getClient().getName().length() < 100 || tarjeta.getClient().getPhone().length() < 100) {
            return false;
        }
        
        return true;
    }
    public ControladorAgregarTarjeta() {
        
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
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
}
