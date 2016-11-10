package principal;

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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class agregarTarjeta extends javax.swing.JFrame {
    Tarjeta nuevaTarjeta;
    DefaultListModel listaPagos;
    
    public agregarTarjeta() {
        initComponents();
        this.setResizable(false);
        iniciarJList();
        this.nuevaTarjeta = new Tarjeta();
        addFocusEnter();
        Calendar c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
    }
    
    public void iniciarJList() {
        listaPagos = new DefaultListModel();
        jList2.setModel(listaPagos);
    }
    
    private void limpiarCampos () {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jList2.removeAll();
        jDateChooser1.setDate(null);
    }
    
    private boolean checkCampos() { 
        System.out.println(!ControladorAgregarTarjeta.isNumeric(jTextField3.getText().trim()));
        
        if (jList2.getModel().getSize() == 0 || jTextField1.getText().trim().equals("") || jTextField3.getText().trim().equals("") || !ControladorAgregarTarjeta.isNumeric(jTextField3.getText().trim()) || jTextField5.getText().trim().equals("") || jTextField7.getText().trim().equals("") || jTextField9.getText().trim().equals("") || jTextArea3.getText().trim().equals("")) {
            System.out.println(jList2.getModel().getSize());
            return false;
        }
        
        return true;
    }
    
    private boolean checkPagosRepetidos(String fecha, String monto) {
        for (int index = 0; index < nuevaTarjeta.getPayments().size(); index++) {
            if (nuevaTarjeta.getPayments().get(index).getAmount().equals(monto) && nuevaTarjeta.getPayments().get(index).getDate().equals(fecha)) {
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

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
        _btnAgregarCliente.setBounds(10, 450, 200, 70);

        _btnPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        _btnPrincipal.setForeground(new java.awt.Color(0, 255, 255));
        _btnPrincipal.setText("Principal");
        _btnPrincipal.setOpaque(false);
        _btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnPrincipalMouseClicked(evt);
            }
        });
        jPanel1.add(_btnPrincipal);
        _btnPrincipal.setBounds(220, 450, 200, 70);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos principales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 255, 255));
        jPanel2.setLayout(null);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 255));
        jLabel7.setText("Tipo pago:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 270, 80, 30);

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setForeground(new java.awt.Color(0, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semanal", "Quincenal", "Mensual" }));
        jComboBox1.setOpaque(false);
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(150, 270, 240, 30);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 255));
        jLabel5.setText("Día de cobro");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 119, 90, 30);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(151, 116, 240, 30);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4);
        jTextField4.setBounds(151, 154, 240, 30);

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
        jTextField1.setBounds(151, 40, 240, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("Telefono");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 81, 70, 30);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(151, 78, 240, 30);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Dirección:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 310, 80, 30);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(150, 190, 240, 30);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 255));
        jLabel11.setText("Codigo:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 190, 70, 30);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(150, 230, 240, 30);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 255));
        jLabel6.setText("Saldo total:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 230, 90, 30);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(150, 310, 240, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 11, 410, 430);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos adquiridos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 255, 255));
        jPanel3.setLayout(null);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jPanel3.add(jScrollPane5);
        jScrollPane5.setBounds(20, 20, 680, 120);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(430, 10, 720, 160);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Historial de pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 14), new java.awt.Color(0, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 255, 255));
        jPanel4.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 255));
        jLabel9.setText("Pagos registrados:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(310, 20, 250, 18);

        jScrollPane3.setViewportView(jList2);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(400, 50, 300, 280);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(0, 255, 255));
        jButton3.setText(">");
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(311, 50, 80, 30);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(0, 255, 255));
        jButton4.setText("x");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(310, 300, 80, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setText("Fecha:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(20, 150, 220, 20);

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 255));
        jLabel14.setText("Detalle:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(20, 200, 200, 18);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(20, 230, 270, 100);

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 255));
        jLabel15.setText("¢");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(20, 50, 140, 18);

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 255));
        jLabel16.setText("Abono:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(20, 30, 230, 18);

        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel4.add(jTextField8);
        jTextField8.setBounds(40, 50, 250, 20);
        jPanel4.add(jTextField6);
        jTextField6.setBounds(40, 120, 250, 20);

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 255));
        jLabel10.setText("Pago a agregar (monto en colones y solo números):");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 90, 400, 20);

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 255, 255));
        jLabel17.setText("¢");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(20, 120, 140, 18);
        jPanel4.add(jDateChooser1);
        jDateChooser1.setBounds(90, 150, 200, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(430, 180, 720, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1169, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        agregarPagos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jList2.getSelectedIndex() != -1) {
            int indexItemEliminado = jList2.getSelectedIndex();
            this.listaPagos.remove(indexItemEliminado);
            this.nuevaTarjeta.getPayments().remove(indexItemEliminado);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        jTextField6.setText(jTextField8.getText()+ evt.getKeyChar());
    }//GEN-LAST:event_jTextField8KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnAgregarCliente;
    private javax.swing.JButton _btnPrincipal;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

    private void addFocusEnter() {
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField1.transferFocus();
            }
        });
        jTextField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField2.transferFocus();
            }
        });
        jTextField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField3.transferFocus();
            }
        });
        jTextField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField4.transferFocus();
            }
        });
        jTextField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField5.transferFocus();
            }
        });
        jTextField6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextArea2.requestFocus();
            }
        });
        jTextField7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField7.transferFocus();
            }
        });
        jComboBox1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        jTextField9.requestFocus();
                    } else {
                        jTextField9.requestFocus();
                    }

                }
            }
        });
        jTextField9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextArea3.requestFocus();
            }
        });
        jTextArea3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        jTextField8.requestFocus();
                    } else {
                        jTextField8.requestFocus();
                    }

                }
            }
        });
        jTextField8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 jTextField6.requestFocus();
            }
        });
        jTextArea2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        agregarPagos();
                        _btnAgregarCliente.requestFocus();
                    } else {
                        agregarPagos();
                        _btnAgregarCliente.requestFocus();
                    }

                }
            }
        });
        _btnAgregarCliente.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.getModifiers() > 0) {
                        agregarNuevaTarjeta();
                    } else {
                        agregarNuevaTarjeta();
                    }

                }
            }
        });
    }

    private void agregarNuevaTarjeta() {
        if (!checkCampos()) {
            JOptionPane.showMessageDialog(this, "Faltaron campos por llenar. \n Mínimo: nombre, dirección, saldo (SOLO NÚMEROS), día de cobro,\n productos, al menos un pago y código de la tarjeta");
        }
        else if (!Conexion.yaExisteTarjeta(jTextField7.getText()))
        {
            if (ControladorAgregarTarjeta.isNumeric(jTextField7.getText().trim())) {
                nuevaTarjeta.setClient(new Cliente(jTextField1.getText(),jTextField2.getText(),jTextField4.getText(), jTextField9.getText()));
                nuevaTarjeta.setPeriodicity(String.valueOf(jComboBox1.getSelectedItem()));  
                nuevaTarjeta.setCodigo(jTextField7.getText());
                nuevaTarjeta.setDiaPago(jTextField5.getText());
                nuevaTarjeta.setProducts(jTextArea3.getText());
                nuevaTarjeta.setSaldoTotal(Integer.parseInt(jTextField3.getText()));
                if (ControladorAgregarTarjeta.eventoAgregarTarjeta(nuevaTarjeta))
                    limpiarCampos();
            }
            else {
                JOptionPane.showMessageDialog(this, "El código de la tarjeta debe ser solamente numérico");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "El código de la tarjeta ya esta registrado");
        }
    }

    private void agregarPagos() {
        if (!jTextField6.getText().trim().equals("")  && jDateChooser1.getDate()!=null && !checkPagosRepetidos(jDateChooser1.getDate().getDate()+ "/" + (jDateChooser1.getDate().getMonth() + 1)+ "/" + (jDateChooser1.getDate().getYear() + 1900),jTextField6.getText())) {
            if (ControladorAgregarTarjeta.isNumeric(jTextField6.getText().trim())) {
                this.listaPagos.addElement(String.valueOf(jTextField6.getText().trim() + " --- Fecha: " + jDateChooser1.getDate().getDate()+ "/" + (jDateChooser1.getDate().getMonth() + 1)+ "/" + (jDateChooser1.getDate().getYear() + 1900)+ " --- Nota: " + (jTextArea2.getText().equals("")?"Ninguna":jTextArea2.getText())));
                nuevaTarjeta.getPayments().add(new Payment(jDateChooser1.getDate().getDate()+ "/" + (jDateChooser1.getDate().getMonth() + 1)+ "/" + (jDateChooser1.getDate().getYear() + 1900),jTextField6.getText().trim(),String.valueOf(jComboBox1.getSelectedItem()),jTextArea2.getText()));
                jTextField6.setText("");
            }
            else
                JOptionPane.showMessageDialog(this, "El campo de 'Pago a agregar' debe contener solo cifras o números");
        }
        else
            JOptionPane.showMessageDialog(this, "Debe llenar al menos el campo de fecha (con formato válido DD/MM/YYYY) y el de 'Pago a agregar'");
    }
}