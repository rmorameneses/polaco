/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author JoseR
 */
public class consultaCliente extends javax.swing.JFrame {

    /**
     * Creates new form consultaCliente
     */
    public consultaCliente() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _panelFondo = new javax.swing.JPanel();
        _lblNombre = new javax.swing.JLabel();
        _txtNombre = new javax.swing.JTextField();
        _lblPrima = new javax.swing.JLabel();
        _txtPrima = new javax.swing.JTextField();
        _lblSaldo = new javax.swing.JLabel();
        _txtDeuda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        _listProductos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        _listPagos = new javax.swing.JList<>();
        _lblProductos = new javax.swing.JLabel();
        _lblPagos = new javax.swing.JLabel();
        _btnPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _lblNombre.setText("Nombre");

        _txtNombre.setEditable(false);

        _lblPrima.setText("Prima");

        _txtPrima.setEditable(false);

        _lblSaldo.setText("Deuda saldo");

        _txtDeuda.setEditable(false);

        _listProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(_listProductos);

        _listPagos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(_listPagos);

        _lblProductos.setText("Productos");

        _lblPagos.setText("Pagos");

        _btnPrincipal.setText("Principal");
        _btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _btnPrincipalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout _panelFondoLayout = new javax.swing.GroupLayout(_panelFondo);
        _panelFondo.setLayout(_panelFondoLayout);
        _panelFondoLayout.setHorizontalGroup(
            _panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(_panelFondoLayout.createSequentialGroup()
                            .addComponent(_lblNombre)
                            .addGap(64, 64, 64)
                            .addComponent(_txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(_panelFondoLayout.createSequentialGroup()
                            .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(_lblPrima)
                                .addComponent(_lblSaldo))
                            .addGap(39, 39, 39)
                            .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(_txtPrima)
                                .addComponent(_txtDeuda))))
                    .addComponent(_btnPrincipal))
                .addGap(111, 111, 111)
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_lblProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_lblPagos))
                .addContainerGap())
        );
        _panelFondoLayout.setVerticalGroup(
            _panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_lblProductos)
                    .addComponent(_lblPagos))
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_lblNombre)
                            .addComponent(_txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_lblPrima)
                            .addComponent(_txtPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_lblSaldo)
                            .addComponent(_txtDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btnPrincipal))
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(_panelFondoLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(_panelFondoLayout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(_panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btnPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__btnPrincipalMouseClicked
        ventanaMain vMain = new  ventanaMain();
        vMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event__btnPrincipalMouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnPrincipal;
    private javax.swing.JLabel _lblNombre;
    private javax.swing.JLabel _lblPagos;
    private javax.swing.JLabel _lblPrima;
    private javax.swing.JLabel _lblProductos;
    private javax.swing.JLabel _lblSaldo;
    private javax.swing.JList<String> _listPagos;
    private javax.swing.JList<String> _listProductos;
    private javax.swing.JPanel _panelFondo;
    private javax.swing.JTextField _txtDeuda;
    private javax.swing.JTextField _txtNombre;
    private javax.swing.JTextField _txtPrima;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
