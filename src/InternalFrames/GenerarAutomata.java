package InternalFrames;
import Classes.Automata;
/**
 *
 * @author PC
 */
public class GenerarAutomata extends javax.swing.JInternalFrame {
    
    Automata automata;
    String alfabetoArr[], estadosArr[];
    String autoName = "", alfabeto = "", estados ="", estado_inicial ="", estados_aceptacion ="";
    
    public GenerarAutomata() {
        initComponents();
        automata = new Automata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelGenerate = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtAlfabeto = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTxtEstados = new javax.swing.JTextField();
        jBtnEstados = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jBtnInicial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnEquivalencia = new javax.swing.JButton();
        jBtnTest = new javax.swing.JButton();
        jBtnAceptacion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxEstadoInicial = new javax.swing.JComboBox();
        jComboBoxAceptacion = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxSalida = new javax.swing.JComboBox();
        jComboBoxTransicion = new javax.swing.JComboBox();
        jComboBoxLlegada = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnAceptacion1 = new javax.swing.JButton();
        Equivalencia = new javax.swing.JPanel();
        jPanelVerAutomata = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel6.setText("Nombre Automata:");

        jLabel7.setText("Alfabeto:");

        jTxtAlfabeto.setColumns(20);
        jTxtAlfabeto.setRows(5);
        jScrollPane2.setViewportView(jTxtAlfabeto);

        jLabel8.setText("Estados(Separar con coma ','):");

        jBtnEstados.setText("Agregar");
        jBtnEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEstadosActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado inicial:");

        jBtnInicial.setText("Agregar");
        jBtnInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInicialActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jBtnEquivalencia.setText("Equivalencia");

        jBtnTest.setText("Probar automata");

        jBtnAceptacion.setText("Agregar");
        jBtnAceptacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptacionActionPerformed(evt);
            }
        });

        jLabel11.setText("Estados de aceptacion:");

        jComboBoxEstadoInicial.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxAceptacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Transiciones");

        jComboBoxSalida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxTransicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxLlegada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Estado de salida");

        jLabel3.setText("caracter de transicion");

        jLabel4.setText("Estado de llegada");

        jBtnAceptacion1.setText("Agregar");
        jBtnAceptacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptacion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGenerateLayout = new javax.swing.GroupLayout(jPanelGenerate);
        jPanelGenerate.setLayout(jPanelGenerateLayout);
        jPanelGenerateLayout.setHorizontalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                                .addComponent(jBtnEquivalencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnTest)
                                .addGap(180, 180, 180)))))
                .addContainerGap())
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxTransicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxAceptacion, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtEstados, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtNombre)
                    .addComponent(jComboBoxEstadoInicial, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jComboBoxSalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxLlegada, 0, 201, Short.MAX_VALUE))
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtnEstados)
                                .addComponent(jBtnInicial))
                            .addComponent(jBtnAceptacion, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnAceptacion1))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelGenerateLayout.setVerticalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEstados))
                .addGap(18, 18, 18)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jBtnInicial)
                    .addComponent(jComboBoxEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAceptacion)
                    .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jComboBoxAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jBtnAceptacion1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEquivalencia)
                    .addComponent(jBtnTest))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Generar Automata", jPanelGenerate);

        Equivalencia.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Equivalencia", Equivalencia);

        jPanelVerAutomata.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanelVerAutomata.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ver Cadenas", jPanelVerAutomata);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jBtnEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEstadosActionPerformed
        this.alfabeto =  this.jTxtAlfabeto.getText();
        this.alfabetoArr =  automata.splitString(this.alfabeto);
        this.estados = this.jTxtEstados.getText();
        this.estadosArr = automata.splitString(this.estados);
        
        automata.generarColumnas(this.jTable1, this.alfabetoArr, this.estadosArr);
        
        automata.setComboBoxData(this.jComboBoxEstadoInicial, estadosArr);
        automata.setComboBoxData(this.jComboBoxAceptacion, estadosArr);
        automata.setComboBoxData(this.jComboBoxSalida, estadosArr);
        automata.setComboBoxData(this.jComboBoxTransicion, alfabetoArr);
        automata.setComboBoxData(this.jComboBoxLlegada, estadosArr);
    }//GEN-LAST:event_jBtnEstadosActionPerformed

    private void jBtnInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInicialActionPerformed
        this.estado_inicial = this.jComboBoxEstadoInicial.getSelectedItem().toString();
        int index = this.jComboBoxEstadoInicial.getSelectedIndex();
        automata.setEstadosProperties(this.jTable1, index, "->"+this.estado_inicial);
    }//GEN-LAST:event_jBtnInicialActionPerformed

    private void jBtnAceptacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptacionActionPerformed
        this.estados_aceptacion = this.jComboBoxAceptacion.getSelectedItem().toString();
        int index = this.jComboBoxAceptacion.getSelectedIndex();
        automata.setEstadosProperties(this.jTable1, index, this.estados_aceptacion+"*");
    }//GEN-LAST:event_jBtnAceptacionActionPerformed

    private void jBtnAceptacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptacion1ActionPerformed
       int row = this.jComboBoxSalida.getSelectedIndex();
       int column = this.jComboBoxTransicion.getSelectedIndex();
       String value = this.jComboBoxLlegada.getSelectedItem().toString();
       
       automata.addValues(this.jTable1, row, column+1, value);
    }//GEN-LAST:event_jBtnAceptacion1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Equivalencia;
    private javax.swing.JButton jBtnAceptacion;
    private javax.swing.JButton jBtnAceptacion1;
    private javax.swing.JButton jBtnEquivalencia;
    private javax.swing.JButton jBtnEstados;
    private javax.swing.JButton jBtnInicial;
    private javax.swing.JButton jBtnTest;
    private javax.swing.JComboBox jComboBoxAceptacion;
    private javax.swing.JComboBox jComboBoxEstadoInicial;
    private javax.swing.JComboBox jComboBoxLlegada;
    private javax.swing.JComboBox jComboBoxSalida;
    private javax.swing.JComboBox jComboBoxTransicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelGenerate;
    private javax.swing.JPanel jPanelVerAutomata;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTxtAlfabeto;
    private javax.swing.JTextField jTxtEstados;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
