package principal;
import javax.swing.ButtonGroup;

public class buscarClientes extends javax.swing.JFrame {
    private int tipo = 0 ;
    ButtonGroup botonesGrupo = new ButtonGroup();

    public buscarClientes() {
        initComponents();
        this.setResizable(false);
        botonesGrupo.add(_radID);
        botonesGrupo.add(_radNombre);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _panelFondo = new javax.swing.JPanel();
        _lblClienteId = new javax.swing.JLabel();
        _txtNombreCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        _listClientes = new javax.swing.JList<>();
        _txtIdCliente1 = new javax.swing.JTextField();
        _radID = new javax.swing.JRadioButton();
        _radNombre = new javax.swing.JRadioButton();
        _btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _lblClienteId.setText("Cliente:");

        _listClientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        _listClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                _listClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(_listClientes);

        _radID.setText("ID");

        _radNombre.setText("Nombre");

        _btnBuscar.setText("Buscar");

        javax.swing.GroupLayout _panelFondoLayout = new javax.swing.GroupLayout(_panelFondo);
        _panelFondo.setLayout(_panelFondoLayout);
        _panelFondoLayout.setHorizontalGroup(
            _panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, _panelFondoLayout.createSequentialGroup()
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(_lblClienteId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(_txtIdCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_radID)
                    .addComponent(_radNombre)
                    .addComponent(_btnBuscar))
                .addContainerGap())
        );
        _panelFondoLayout.setVerticalGroup(
            _panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(_panelFondoLayout.createSequentialGroup()
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(_txtIdCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_radID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(_panelFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(_lblClienteId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_radNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(_panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_btnBuscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _listClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event__listClientesMouseClicked
        if(tipo==1){
            actualizarP2 vent2Pagos = new actualizarP2(); 
            vent2Pagos.setNombre("Juan Perez");
            vent2Pagos.setVisible(true);
        }
        if(tipo == 2){
            consultaCliente cCliente = new consultaCliente();
            cCliente.setVisible(true);
            this.dispose();
        
        }
        
        
        this.dispose();
    }//GEN-LAST:event__listClientesMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnBuscar;
    private javax.swing.JLabel _lblClienteId;
    private javax.swing.JList<String> _listClientes;
    private javax.swing.JPanel _panelFondo;
    private javax.swing.JRadioButton _radID;
    private javax.swing.JRadioButton _radNombre;
    private javax.swing.JTextField _txtIdCliente1;
    private javax.swing.JTextField _txtNombreCliente;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
