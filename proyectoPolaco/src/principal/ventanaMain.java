package principal;

import Controlador.ControladorAgregarTarjeta;
import Modelo.Conexion;
import Modelo.Tarjeta;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException; 
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
 
public class ventanaMain extends javax.swing.JFrame {
    DefaultListModel listaNombres;
    DefaultListModel listaCodigos;
    String codigoTarjetaAbonar;
    DecimalFormat formateadorDinero = new DecimalFormat("###,###.##");

    public ventanaMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground( Color.BLACK );
        addFocusEnter();
        miselaneos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _lblTitulo = new javax.swing.JLabel();
        _panelFondo2 = new javax.swing.JPanel();
        _btnHistorial = new javax.swing.JButton();
        _btnConsCliente = new javax.swing.JButton();
        _btnInformacion = new javax.swing.JButton();
        _btnNuevoCli = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        _btnHistorial1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        _btnAgregarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setExtendedState(6);
        getContentPane().setLayout(null);

        _lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        _lblTitulo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _lblTitulo.setForeground(new java.awt.Color(0, 255, 255));
        _lblTitulo.setText("Comercial ebenezer                        Panel principal");
        getContentPane().add(_lblTitulo);
        _lblTitulo.setBounds(10, 22, 419, 30);

        _panelFondo2.setBackground(new java.awt.Color(0, 0, 0));
        _panelFondo2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        _panelFondo2.setLayout(null);

        _btnHistorial.setBackground(new java.awt.Color(102, 102, 102));
        _btnHistorial.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _btnHistorial.setForeground(new java.awt.Color(0, 255, 255));
        _btnHistorial.setText("Generar reporte");
        _btnHistorial.setOpaque(false);
        _btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnHistorialMouseClicked(evt);
            }
        });
        _btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnHistorialActionPerformed(evt);
            }
        });
        _panelFondo2.add(_btnHistorial);
        _btnHistorial.setBounds(20, 270, 240, 50);

        _btnConsCliente.setBackground(new java.awt.Color(102, 102, 102));
        _btnConsCliente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _btnConsCliente.setForeground(new java.awt.Color(0, 255, 255));
        _btnConsCliente.setText("Hacer abonos");
        _btnConsCliente.setOpaque(false);
        _btnConsCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnConsClienteMouseClicked(evt);
            }
        });
        _btnConsCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnConsClienteActionPerformed(evt);
            }
        });
        _panelFondo2.add(_btnConsCliente);
        _btnConsCliente.setBounds(20, 110, 240, 43);

        _btnInformacion.setBackground(new java.awt.Color(102, 102, 102));
        _btnInformacion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _btnInformacion.setForeground(new java.awt.Color(0, 255, 255));
        _btnInformacion.setText("Consultar tarjetas");
        _btnInformacion.setOpaque(false);
        _btnInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnInformacionMouseClicked(evt);
            }
        });
        _btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnInformacionActionPerformed(evt);
            }
        });
        _panelFondo2.add(_btnInformacion);
        _btnInformacion.setBounds(20, 190, 244, 43);

        _btnNuevoCli.setBackground(new java.awt.Color(102, 102, 102));
        _btnNuevoCli.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _btnNuevoCli.setForeground(new java.awt.Color(0, 255, 255));
        _btnNuevoCli.setText("Agregar tarjeta nueva");
        _btnNuevoCli.setOpaque(false);
        _btnNuevoCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnNuevoCliMouseClicked(evt);
            }
        });
        _btnNuevoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnNuevoCliActionPerformed(evt);
            }
        });
        _panelFondo2.add(_btnNuevoCli);
        _btnNuevoCli.setBounds(20, 31, 240, 73);

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        _panelFondo2.add(jTextField9);
        jTextField9.setBounds(20, 150, 240, 30);

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });
        _panelFondo2.add(jTextField11);
        jTextField11.setBounds(20, 230, 240, 30);

        _btnHistorial1.setBackground(new java.awt.Color(102, 102, 102));
        _btnHistorial1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        _btnHistorial1.setForeground(new java.awt.Color(0, 255, 255));
        _btnHistorial1.setText("Recuperar reporte");
        _btnHistorial1.setOpaque(false);
        _btnHistorial1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnHistorial1MouseClicked(evt);
            }
        });
        _btnHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnHistorial1ActionPerformed(evt);
            }
        });
        _panelFondo2.add(_btnHistorial1);
        _btnHistorial1.setBounds(20, 320, 240, 30);

        getContentPane().add(_panelFondo2);
        _panelFondo2.setBounds(94, 70, 280, 359);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        _btnAgregarCliente.setBackground(new java.awt.Color(0, 0, 0));
        _btnAgregarCliente.setForeground(new java.awt.Color(0, 255, 255));
        _btnAgregarCliente.setText("Agregar abono");
        _btnAgregarCliente.setOpaque(false);
        _btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(_btnAgregarCliente);
        _btnAgregarCliente.setBounds(10, 250, 410, 50);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hacer abonos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Abono:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 160, 80, 18);

        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(140, 190, 240, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Fecha: ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 43, 70, 18);

        jTextField1.setName(""); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(150, 160, 230, 20);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 81, 70, 18);

        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.add(jLabel11);
        jLabel11.setBounds(140, 80, 240, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Saldo total:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 190, 100, 20);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Saldo:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 120, 90, 18);

        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 110, 240, 30);
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(140, 40, 240, 20);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("¢");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(140, 120, 20, 18);

        jSeparator1.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(130, 190, 260, 10);

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 255));
        jLabel12.setText("¢");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(140, 160, 20, 18);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 11, 410, 230);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(400, 80, 430, 310);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hacer consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 255, 255));
        jPanel4.setLayout(null);

        jScrollPane1.setViewportView(jList1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 210, 150);

        jScrollPane2.setViewportView(jList2);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(250, 60, 140, 150);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Nombre:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(20, 30, 210, 30);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText("Codigo");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(250, 30, 140, 20);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 11, 410, 230);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(390, 50, 430, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btnInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnInformacionMouseClicked
       
    }//GEN-LAST:event__btnInformacionMouseClicked

    private void _btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnHistorialMouseClicked
    }//GEN-LAST:event__btnHistorialMouseClicked

    private void _btnConsClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnConsClienteMouseClicked
       
    }//GEN-LAST:event__btnConsClienteMouseClicked

    private void _btnNuevoCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnNuevoCliMouseClicked
        agregarTarjeta aCliente = new agregarTarjeta();
        aCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event__btnNuevoCliMouseClicked

    private void _btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgregarClienteActionPerformed
        hacerAbono();
    }//GEN-LAST:event__btnAgregarClienteActionPerformed

    private void _btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnInformacionActionPerformed
        consultarCodigoTarjeta(jTextField11.getText());
    }//GEN-LAST:event__btnInformacionActionPerformed

    private void _btnConsClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnConsClienteActionPerformed
        abonarCodigoTarjeta(jTextField9.getText());
    }//GEN-LAST:event__btnConsClienteActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void _btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnHistorialActionPerformed
        ArrayList<Tarjeta> abonos;
        
        try {
            // se pone primero esto para que lance el error y no haga la actualizacion en la BD en caso de que tenga el doc abierto
            File archivo= new File(ControladorAgregarTarjeta.DIRECCION_ARCHIVO_WORD);
            FileOutputStream out = new FileOutputStream(archivo);
            Calendar c2 = new GregorianCalendar();
            jDateChooser1.setCalendar(c2);
            String fecha = jDateChooser1.getDate().getDate()+"/"+(jDateChooser1.getDate().getMonth()+1)+"/"+(jDateChooser1.getDate().getYear()+1900);
            String fechaCreacion = "Reporte del :"+fecha+", hora: " + new Date().getHours()+" : "+ new Date().getMinutes()+" : "+ new Date().getSeconds();
            abonos = Conexion.getListaPagos(fechaCreacion);
            
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
                tableRowOne.addNewTableCell().setText(fechaCreacion);
                
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
                    row.getCell(3).setText(String.valueOf(formateadorDinero.format(abonos.get(index).getPayments().get(0).getAmount())));
                    
                    acumulador +=abonos.get(index).getPayments().get(0).getAmount();
                }
                
                row = table.createRow();
                row.getCell(0).setText("TOTAL: ");
                row.getCell(1).setText("");
                row.getCell(2).setText("");
                row.getCell(3).setText(""+ formateadorDinero.format(acumulador));
                
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
                JOptionPane.showMessageDialog(this, "No hay abonos para imprimir, ya todos están impresos \n para repetir un reporte, presione el botón de Recuperar reporte");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cierre el documento, ya que está siendo usado por otro programa");
        }
    }//GEN-LAST:event__btnHistorialActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        try {
            if (!jTextField9.getText().trim().equals("")) {
                jTextField9.setText(jTextField9.getText().replace(" ", ""));
                
                if (jTextField9.getText().length() > 2)
                    jTextField9.setText(jTextField9.getText().substring(0, 2)+" "+jTextField9.getText().substring(2, jTextField9.getText().length()));
            }
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        if (ControladorAgregarTarjeta.isNumeric(jTextField11.getText())) {
            try {
                if (!jTextField11.getText().trim().equals("")) {
                    jTextField11.setText(jTextField11.getText().replace(" ", ""));

                    if (jTextField11.getText().length() > 2)
                        jTextField11.setText(jTextField11.getText().substring(0, 2)+" "+jTextField11.getText().substring(2, jTextField11.getText().length()));
                }
                //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
            }
            catch(Exception ex) {
    //            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            if (!jTextField1.getText().trim().equals("")) {
                jTextField1.setText(formateadorDinero.format(Integer.parseInt(jTextField1.getText().replace(",", ""))));
            }
            
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void _btnHistorial1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnHistorial1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event__btnHistorial1MouseClicked

    private void _btnHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnHistorial1ActionPerformed
        RecuperarReporte recuperarReporte = new RecuperarReporte();
        recuperarReporte.setVisible(true);
        this.dispose();
    }//GEN-LAST:event__btnHistorial1ActionPerformed

    private void _btnNuevoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnNuevoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__btnNuevoCliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnAgregarCliente;
    private javax.swing.JButton _btnConsCliente;
    private javax.swing.JButton _btnHistorial;
    private javax.swing.JButton _btnHistorial1;
    private javax.swing.JButton _btnInformacion;
    private javax.swing.JButton _btnNuevoCli;
    private javax.swing.JLabel _lblTitulo;
    private javax.swing.JPanel _panelFondo2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    
    private void addFocusEnter() {
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField1.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(jPanel1, "No se ha digitado ningun monto");
                }
                else if (!ControladorAgregarTarjeta.isNumeric(jTextField1.getText().replace(",", ""))) {
                    JOptionPane.showMessageDialog(jPanel1, "No se ha digitado un dígito válido");
                }
                else {
                    if (Integer.parseInt(jLabel8.getText().replace(",", "")) - Integer.parseInt(jTextField1.getText().replace(",", "")) < 0) {
                        JOptionPane.showMessageDialog(null, "El abono es mayor al saldo restante de la tarjeta, puede proseguir pero quedará un monto negativo");
                    }                    
                    
                    jLabel4.setText("¢ " + formateadorDinero.format((Integer.parseInt(jLabel8.getText().replace(",", "")) - Integer.parseInt(jTextField1.getText().replace(",", ""))))  );
                    _btnAgregarCliente.requestFocus();
                }
            }
        });
        
        _btnAgregarCliente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    hacerAbono();
                }
            }
        });
        
        jTextField9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField1.setText("");
                abonarCodigoTarjeta(jTextField9.getText());
                codigoTarjetaAbonar = jTextField9.getText();
            }
        });
        
        jTextField11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCodigoTarjeta(jTextField11.getText());
            }
        });
    }

    private void hacerAbono() {
        Conexion.agregarAbono(jTextField1.getText().replace(",", ""), codigoTarjetaAbonar, jDateChooser1.getDate().getDate()+"/"+(jDateChooser1.getDate().getMonth()+1)+"/"+(jDateChooser1.getDate().getYear()+1900));
        jTextField9.setText("");
        jTextField9.requestFocus();
        jLabel8.setText("");
        jLabel4.setText("");
        jLabel11.setText("");
        jTextField1.setText("");
    }

    private void miselaneos() {
        jPanel1.setLocation(400, 80);
        jPanel1.setVisible(false);
        jPanel3.setLocation(400, 80);
        jPanel3.setVisible(false);
        listaNombres = new DefaultListModel();
        listaCodigos = new DefaultListModel();
        jList1.setModel(listaNombres);
        jList2.setModel(listaCodigos);
    }

    private void consultarCodigoTarjeta(String criterioBusqueda) {
        if (!jTextField11.getText().trim().equals("") && ControladorAgregarTarjeta.esAlfaNumerica(criterioBusqueda)) {
            listaNombres = new DefaultListModel();
            listaCodigos = new DefaultListModel();
            jList1.setModel(listaNombres);
            jList2.setModel(listaCodigos);
            jPanel1.setVisible(false);
            jPanel3.setVisible(true);
            jTextField11.setText("");
            jTextField11.requestFocus();
            ArrayList<Tarjeta> tarjeta = (Conexion.consultarTarjetaCliente(criterioBusqueda));

            if (tarjeta.size()>0)
                for (int index = 0; index < tarjeta.size(); index++) {
                    listaNombres.addElement(tarjeta.get(index).getClient().getName());
                    listaCodigos.addElement( tarjeta.get(index).getCodigo().substring(0, 2)+" "+tarjeta.get(index).getCodigo().substring(2, tarjeta.get(index).getCodigo().length())                  );
                }
            else
                JOptionPane.showMessageDialog(this, "No hay resultados para mostrar");
        }    
        else
            JOptionPane.showMessageDialog(this, "Debe introducir un criterio de búsqueda");
    }

    private void abonarCodigoTarjeta(String criterioBusqueda) {
        if (!jTextField9.getText().trim().equals("") && ControladorAgregarTarjeta.esAlfaNumerica(criterioBusqueda)) {
            ArrayList<Tarjeta> tarjeta = (Conexion.consultarTarjetaCliente(criterioBusqueda));
            Calendar c2 = new GregorianCalendar();  
            String saldoRestante= "";
            
            if (!tarjeta.isEmpty()) {
                saldoRestante=Conexion.getSaldoTarjeta(criterioBusqueda)+ "";
                jPanel1.setVisible(true);
                jPanel3.setVisible(false);
                jTextField1.requestFocus();

                jDateChooser1.setCalendar(c2);
                jLabel11.setText(tarjeta.get(0).getClient().getName());
                jTextField1.setText(String.valueOf(formateadorDinero.format(tarjeta.get(0).getCuotaPeriodica())));
                jLabel8.setText(formateadorDinero.format(Integer.parseInt(saldoRestante)));

                if (tarjeta.size()>0)
                    for (int index = 0; index < tarjeta.size(); index++) {
                        listaNombres.addElement(tarjeta.get(index).getClient().getName());
                        listaCodigos.addElement(tarjeta.get(index).getCodigo());
                    }
                else
                    JOptionPane.showMessageDialog(this, "No se encontraron conincidencias para mostrar");
            }
            else {
                JOptionPane.showMessageDialog(this, "No se encontraron tarjetas con el código: " + criterioBusqueda);
            }
        }    
        else
            JOptionPane.showMessageDialog(this, "Debe introducir un criterio de búsqueda");
    }
}
