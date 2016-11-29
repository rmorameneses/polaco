package principal;

import java.text.DecimalFormat;
import Controlador.ControladorAgregarTarjeta;
import Modelo.Cliente;
import Modelo.Conexion;
import Modelo.Payment;
import Modelo.Tarjeta;
import com.mysql.fabric.xmlrpc.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class agregarTarjeta extends javax.swing.JFrame {
    Tarjeta nuevaTarjeta;
    DefaultListModel listaPagos;
    DecimalFormat formateadorDinero = new DecimalFormat("###,###.##");
    Calendar c2;
    
    public agregarTarjeta() {
        initComponents();
        miscelaneo();
    }
    
    private void limpiarCampos () {
//        jTextField1.setText("");
//        jTextField2.setText("");
//        jTextField3.setText("");
//        jTextField4.setText("");
//        jTextField5.setText("");
//        jTextField10.setText("");
//        jTextField7.setText("");
//        jTextField6.setText("");
//        jTextField11.setText("");
//        jTextField9.setText("");
//        c2 = new GregorianCalendar();
//        jDateChooser1.setCalendar(c2);
    }
    
    private boolean checkCampos() {         
        if ((!jTextField6.getText().trim().equals("") && !ControladorAgregarTarjeta.isNumeric(jTextField6.getText().trim().replace(",", ""))) || jTextField1.getText().trim().equals("") || jTextField3.getText().trim().replace(",", "").equals("") || !ControladorAgregarTarjeta.isNumeric(jTextField3.getText().trim().replace(",", "")) || jTextField7.getText().trim().replace(",", "").equals("") || jTextField9.getText().trim().equals("") || jTextField10.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Faltaron campos por llenar. \n Mínimo: nombre, dirección, saldo total (SOLO NÚMEROS),\n artículos, fecha de creación, cuota periódica (SOLO NÚMEROS) y código de la tarjeta");
            return false;
        }
        else if (!ControladorAgregarTarjeta.esAlfaNumerica(jTextField1.getText()) || !ControladorAgregarTarjeta.esAlfaNumerica(jTextField5.getText()) || !ControladorAgregarTarjeta.esAlfaNumerica(jTextField9.getText()) || !ControladorAgregarTarjeta.esAlfaNumerica(jTextField10.getText())) {
            JOptionPane.showMessageDialog(this, "Se detectaron letras o símbolos inválidos, \n solo se aceptan caracteres alfanuméricos en los campos de: \n nombre, día de cobro, dirección y artículos");
            return false;
        }
        else if (!jTextField4.getText().equals("") && !ControladorAgregarTarjeta.validadorEmail(jTextField4.getText())) {
            JOptionPane.showMessageDialog(this, "El correo introducido es inválido");
            return false;
        }
        
        return true;
    }
    
    private boolean checkPagosRepetidos(String fecha, int monto) {
        for (int index = 0; index < nuevaTarjeta.getPayments().size(); index++) {
            if (nuevaTarjeta.getPayments().get(index).getAmount()== monto && nuevaTarjeta.getPayments().get(index).getDate().equals(fecha)) {
                return true;
            }
        }
        
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        _btnAgregarCliente = new javax.swing.JButton();
        _btnPrincipal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        _btnAgregarCliente.setBackground(new java.awt.Color(0, 0, 0));
        _btnAgregarCliente.setForeground(new java.awt.Color(0, 255, 255));
        _btnAgregarCliente.setText("Agregar tarjeta");
        _btnAgregarCliente.setOpaque(false);
        _btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(_btnAgregarCliente);
        _btnAgregarCliente.setBounds(10, 520, 330, 60);

        _btnPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        _btnPrincipal.setForeground(new java.awt.Color(0, 255, 255));
        _btnPrincipal.setText("Principal");
        _btnPrincipal.setOpaque(false);
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
        jPanel1.add(_btnPrincipal);
        _btnPrincipal.setBounds(350, 520, 230, 60);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos principales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(null);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("Cuota periódica: ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(360, 390, 250, 30);

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setForeground(new java.awt.Color(0, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanal", "Quincenal", "Mensual" }));
        jComboBox1.setOpaque(false);
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(30, 430, 150, 30);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Día de cobro");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 119, 90, 30);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(171, 116, 380, 30);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4);
        jTextField4.setBounds(171, 154, 380, 30);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("Correo");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 157, 70, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("Nombre");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 43, 70, 30);

        jTextField1.setName(""); // NOI18N
        jPanel2.add(jTextField1);
        jTextField1.setBounds(171, 40, 380, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Telefono");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 81, 70, 30);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(171, 78, 380, 30);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Artículos:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 340, 80, 30);

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField7);
        jTextField7.setBounds(170, 190, 380, 30);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Codigo:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 190, 70, 30);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(170, 230, 380, 30);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Saldo total:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 230, 90, 30);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(170, 310, 380, 30);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(170, 350, 380, 30);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 255));
        jLabel8.setText("Dirección:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 300, 80, 30);

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField11);
        jTextField11.setBounds(190, 430, 160, 30);

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 255));
        jLabel12.setText("Tipo pago:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(30, 390, 90, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setText("Fecha de creación:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(30, 270, 150, 20);
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(170, 270, 380, 30);

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(360, 430, 190, 30);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Prima: ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(190, 390, 250, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 570, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnPrincipalMouseClicked
       ventanaMain vMain = new ventanaMain();
       vMain.setVisible(true);
       this.dispose();
    }//GEN-LAST:event__btnPrincipalMouseClicked

    private void _btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAgregarClienteActionPerformed
        // agregar los pagos
        agregarNuevaTarjeta();
    }//GEN-LAST:event__btnAgregarClienteActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        try {
            if (!jTextField7.getText().trim().equals("")) {
                jTextField7.setText(jTextField7.getText().replace(" ", ""));
                
                if (jTextField7.getText().length() > 2)
                    jTextField7.setText(jTextField7.getText().substring(0, 2)+" "+jTextField7.getText().substring(2, jTextField7.getText().length()));
            }
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        try {
            if (!jTextField3.getText().trim().equals("")) {
                jTextField3.setText(formateadorDinero.format(Integer.parseInt(jTextField3.getText().replace(",", ""))));
            }
            
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        try {
            if (!jTextField11.getText().trim().equals("")) {
                jTextField11.setText(formateadorDinero.format(Integer.parseInt(jTextField11.getText().replace(",", ""))));
            }
            
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void _btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__btnPrincipalActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        try {
            if (!jTextField6.getText().trim().equals("")) {
                jTextField6.setText(formateadorDinero.format(Integer.parseInt(jTextField6.getText().replace(",", ""))));
            }
            
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        try {
            if (jTextField2.getText().trim().length()>8) {
                jTextField2.setText(jTextField2.getText().substring(jTextField2.getText().trim().length()-9, jTextField2.getText().trim().length() -1));
            }
            
            //System.out.println(formateador.format(Integer.parseInt(jTextField7.getText())));
        }
        catch(Exception ex) {
//            Logger.getLogger(ventanaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnAgregarCliente;
    private javax.swing.JButton _btnPrincipal;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    private void addFocusEnter() {
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField2.requestFocus();
                }
            }
        });
        jTextField2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField1.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField5.requestFocus();
                }
            }
        });
        jTextField5.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField2.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField4.requestFocus();
                }
            }
        });
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField5.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField7.requestFocus();
                }
            }
        });
        jTextField7.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField4.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField3.requestFocus();
                }
            }
        });
        jTextField3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField7.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jDateChooser1.getComponents()[1].requestFocus();
                }
            }
        });
        jDateChooser1.getComponents()[1].addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField3.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField9.requestFocus();
                }
            }
        });
        jTextField9.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jDateChooser1.getComponents()[1].requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jTextField10.requestFocus();
                }
            }
        });
        jTextField10.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField9.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    jComboBox1.requestFocus();
                }
            }
        });
        jComboBox1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (!jComboBox1.isPopupVisible() && e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField10.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jTextField11.requestFocus();
                }
                else if (!jComboBox1.isPopupVisible() && e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    jTextField11.requestFocus();
                }
            }
        });
        jTextField11.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    jComboBox1.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    jTextField6.requestFocus();
                }
            }
        });
        jTextField6.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    jTextField11.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    _btnAgregarCliente.requestFocus();
                }
            }
        });
        _btnAgregarCliente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    jTextField11.requestFocus();
                }
                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    agregarNuevaTarjeta();
                }
            }
        });
    }

    private void agregarNuevaTarjeta() {
        this.nuevaTarjeta = new Tarjeta();
        
        if (!checkCampos()) {
        }
        else if (!Conexion.yaExisteTarjeta(jTextField7.getText().replace("'", "")))
        {
            if ((jTextField11.getText().replace("'", "").trim().equals("")? 0:Integer.parseInt(jTextField11.getText().replace(",", "").replace("'", ""))) > Integer.parseInt(jTextField3.getText().replace(",", "").replace("'", ""))) {
                JOptionPane.showMessageDialog(this, "La prima es mayor al saldo total de la tarjeta");
            }
            else if (ControladorAgregarTarjeta.isValidCode(jTextField7.getText().replace("'", "").trim())) {
                nuevaTarjeta.setClient(new Cliente(jTextField1.getText().replace("'", ""),jTextField2.getText().replace("'", ""),jTextField4.getText().replace("'", ""), jTextField9.getText().replace("'", "")));
                nuevaTarjeta.setPeriodicity(String.valueOf(jComboBox1.getSelectedItem()));  
                nuevaTarjeta.setCodigo(jTextField7.getText().replace("'", ""));
                nuevaTarjeta.setProducts(jTextField10.getText().replace("'", ""));
                nuevaTarjeta.setDiaPago(jTextField5.getText().replace("'", ""));

                try {
                    nuevaTarjeta.setFechaInicial(jDateChooser1.getDate().getDate()+ "/" + (jDateChooser1.getDate().getMonth() + 1)+ "/" + (jDateChooser1.getDate().getYear() + 1900));
                }
                catch (NullPointerException ex) {
                    nuevaTarjeta.setFechaInicial("");
                }

                nuevaTarjeta.setSaldoTotal(Integer.parseInt(jTextField3.getText().replace("'", "").replace(",", "")));
                
                if (agregarPrimaCuotaPeriodica())
                    if (ControladorAgregarTarjeta.eventoAgregarTarjeta(nuevaTarjeta))
                        limpiarCampos();

                jTextField1.requestFocus();
            }
            else {
                JOptionPane.showMessageDialog(this, "El código de la tarjeta debe ser solamente numérico, los 2 primeros dígitos deben estar separados del resto por un espacio \n Ejemplo: XX XX...");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "El código de la tarjeta ya esta registrado");
        }
    }

    private boolean agregarPrimaCuotaPeriodica() {
        nuevaTarjeta.setCuotaPeriodica(jTextField6.getText().replace("'", "").trim().equals("")? 0:Integer.parseInt(jTextField6.getText().replace("'", "").replace(",", "").trim()));
        
        if (ControladorAgregarTarjeta.isNumeric(jTextField11.getText().replace(",", "").trim())) {
            nuevaTarjeta.getPayments().add(new Payment(jDateChooser1.getDate().getDate()+ "/" + (jDateChooser1.getDate().getMonth() + 1)+ "/" + (jDateChooser1.getDate().getYear() + 1900),Integer.parseInt(jTextField11.getText().trim().equals("")?"0":jTextField11.getText().replace("'", "").trim().replace(",", "")),"Prima"));
        }
        else {
            JOptionPane.showMessageDialog(this, "El campo de 'Pago a agregar' debe contener solo cifras o números");
            return false;
        }
        
        return true;
    }

    private void miscelaneo() {
        this.setResizable(false);
        this.nuevaTarjeta = new Tarjeta();
        addFocusEnter();
        c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
    }
}