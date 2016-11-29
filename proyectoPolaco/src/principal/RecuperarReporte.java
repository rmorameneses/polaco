package principal;

import Controlador.ControladorAgregarTarjeta;
import Modelo.Conexion;
import Modelo.Tarjeta;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class RecuperarReporte extends javax.swing.JFrame {
    DefaultListModel listaReportes;
    DecimalFormat formateadorDinero = new DecimalFormat("###,###.##");
    
    public RecuperarReporte() {
        initComponents();
        miselaneos();
    }
    
    private void miselaneos() {
        _panelFondo.setLocation(0, 0);
        _panelFondo.setSize(1300, 700);
        this.setSize(1300, 700);
        listaReportes = new DefaultListModel();
        jList1.setModel(listaReportes);
        this.setResizable(false);
        cargarReportes();
    }
    
    public void cargarReportes() {
        ArrayList<String> reportes = Conexion.getReportes();
        
        for (int index = 0; index < reportes.size(); index++) {
            listaReportes.add(index, reportes.get(index));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _panelFondo = new javax.swing.JPanel();
        _lblFecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        _lblClienteMostrar = new javax.swing.JLabel();
        _btnPrincipal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        _panelFondo.setLayout(null);

        _lblFecha.setText("Historial de reportes");
        _panelFondo.add(_lblFecha);
        _lblFecha.setBounds(10, 40, 450, 30);

        jButton1.setText("Imprimir reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        _panelFondo.add(jButton1);
        jButton1.setBounds(10, 590, 140, 50);

        _lblClienteMostrar.setText("Consulta de reportes:");
        _panelFondo.add(_lblClienteMostrar);
        _lblClienteMostrar.setBounds(100, 10, 400, 30);

        _btnPrincipal.setText("Principal");
        _btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnPrincipalMouseClicked(evt);
            }
        });
        _btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnPrincipalActionPerformed(evt);
            }
        });
        _panelFondo.add(_btnPrincipal);
        _btnPrincipal.setBounds(160, 590, 150, 50);

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        _panelFondo.add(jScrollPane2);
        jScrollPane2.setBounds(10, 80, 300, 500);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("-----------Código------------");
        jScrollPane1.setViewportView(jTextArea1);

        _panelFondo.add(jScrollPane1);
        jScrollPane1.setBounds(330, 60, 240, 580);

        jLabel1.setText("Previsualización");
        _panelFondo.add(jLabel1);
        jLabel1.setBounds(330, 0, 210, 30);
        _panelFondo.add(jTextField1);
        jTextField1.setBounds(330, 30, 940, 30);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("-----------Fecha------------");
        jScrollPane3.setViewportView(jTextArea2);

        _panelFondo.add(jScrollPane3);
        jScrollPane3.setBounds(570, 60, 230, 580);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setText("-----------Nombre------------");
        jScrollPane4.setViewportView(jTextArea3);

        _panelFondo.add(jScrollPane4);
        jScrollPane4.setBounds(800, 60, 240, 580);

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setText("-----------Abono------------");
        jScrollPane5.setViewportView(jTextArea4);

        _panelFondo.add(jScrollPane5);
        jScrollPane5.setBounds(1040, 60, 230, 580);

        getContentPane().add(_panelFondo);
        _panelFondo.setBounds(0, 0, 1290, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnPrincipalMouseClicked
       ventanaMain venMain = new ventanaMain();
       venMain.setVisible(true);
       this.dispose();
    }//GEN-LAST:event__btnPrincipalMouseClicked

    private void _btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnPrincipalActionPerformed
        ventanaMain vMain = new ventanaMain();
        vMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event__btnPrincipalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreReporte = jList1.getSelectedValue();
        
        ArrayList<Tarjeta> abonos;
        
        try {
            // se pone primero esto para que lance el error y no haga la actualizacion en la BD en caso de que tenga el doc abierto
            File archivo= new File(ControladorAgregarTarjeta.DIRECCION_ARCHIVO_WORD);
            FileOutputStream out = new FileOutputStream(archivo);
            
            abonos = Conexion.getListaPagosReporte(nombreReporte);
            
            if (abonos.size()>0) {
                XWPFDocument document= new XWPFDocument();
                int total=0;
                //create table
                XWPFTable table = document.createTable();
                
                // pone la fecha
                XWPFTableRow tableRowOne = table.getRow(0);
                tableRowOne.getCell(0).setText("Fecha del reporte");
                tableRowOne.addNewTableCell().setText("");
                tableRowOne.addNewTableCell().setText("");
                tableRowOne.addNewTableCell().setText(nombreReporte);
                
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText("-----------Código------------ ");
                row.getCell(1).setText("-----------Fecha------------");
                row.getCell(2).setText("-----------Nombre------------");
                row.getCell(3).setText("-----------Abono------------");
                int acumulador = 0;
                
                for (int index = 0;index < abonos.size(); index ++) {                    
                    row = table.createRow();
                    row.getCell(0).setText(abonos.get(index).getCodigo());
                    row.getCell(1).setText(abonos.get(index).getPayments().get(0).getDate());
                    row.getCell(2).setText(abonos.get(index).getClient().getName());
                    row.getCell(3).setText(String.valueOf(abonos.get(index).getPayments().get(0).getAmount()));
                    
                    acumulador +=abonos.get(index).getPayments().get(0).getAmount();
                }
                
                row = table.createRow();
                row.getCell(0).setText("TOTAL: ");
                row.getCell(1).setText("");
                row.getCell(2).setText("");
                row.getCell(3).setText(""+ acumulador);
                
                document.write(out);
                out.close();

                JOptionPane.showMessageDialog(this, "Documento creado correctamente");
                
                try {
                    Desktop.getDesktop().print(archivo);
                    JOptionPane.showMessageDialog(this, "El comando para imprimir ha sido enviado");
                }
                catch (IOException ioex) {
                    JOptionPane.showMessageDialog(this, "No se pudo imprimir");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "No hay abonos para imprimir, el reporte está vacío");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cierre el documento, ya que está siendo usado por otro programa");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        //jList1ValueChanged tiene un bug que ejecuta 2 veces el evento, este if hace que solo 1 vez se ejecute
        if (jList1.getValueIsAdjusting()== false) {
            borrarjList();
            
            jList1.setEnabled(false);
            String nombreReporte = jList1.getSelectedValue();
            ArrayList<Tarjeta> abonos;

            try {
                abonos = Conexion.getListaPagosReporte(nombreReporte);

                if (abonos.size()>0) {
                    // pone la fecha
                    jTextField1.setText("Fecha y hora del reporte: "+ nombreReporte);

                    int acumulador = 0;
   
                    for (int index = 0;index < abonos.size(); index ++) {                    
                        jTextArea1.append("\n"+abonos.get(index).getCodigo());
                        jTextArea2.append("\n"+abonos.get(index).getPayments().get(0).getDate());
                        jTextArea3.append("\n"+abonos.get(index).getClient().getName());
                        jTextArea4.append("\n"+formateadorDinero.format(abonos.get(index).getPayments().get(0).getAmount()));

                        acumulador +=abonos.get(index).getPayments().get(0).getAmount();
                    }

                    jTextArea1.append("\n \n"+"TOTAL: ");
                    jTextArea2.append("\n \n");
                    jTextArea3.append("\n \n");
                    jTextArea4.append("\n \n"+ formateadorDinero.format(acumulador));
                }
                else {
                    JOptionPane.showMessageDialog(this, "No hay abonos registrados para este reporte");
                }
            } catch (Exception ex) {
                Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Hubo un error al cargar los abonos de este reporte\n Por favor, pongase en contacto con el desarrollador");
            }

            jList1.setEnabled(true);
        }   
    }//GEN-LAST:event_jList1ValueChanged

    
    
    public void setNombre(String pNombre){
        _lblClienteMostrar.setText(pNombre);

    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnPrincipal;
    private javax.swing.JLabel _lblClienteMostrar;
    private javax.swing.JLabel _lblFecha;
    private javax.swing.JPanel _panelFondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void borrarjList() {
        jTextArea1.setText("-----------Código------------");
        jTextArea2.setText("-----------Fecha------------");
        jTextArea3.setText("-----------Nombre------------");
        jTextArea4.setText("-----------Abono------------");
    }
}
