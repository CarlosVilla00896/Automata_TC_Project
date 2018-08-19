package InternalFrames;
import Classes.Automata;
/**
 *
 * @author PC
 */
public class GenerarAutomata extends javax.swing.JInternalFrame {
    
    Automata automata;
    String alfabeto[];
    
    public GenerarAutomata() {
        initComponents();
        System.out.println("Entro a automatas");
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
        jButtonAddAlfabeto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTxtEstadoInicial = new javax.swing.JTextField();
        jBtnInicial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnEquivalencia = new javax.swing.JButton();
        jBtnTest = new javax.swing.JButton();
        jBtnAceptacion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTxtEstadoAceptacion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
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

        jButtonAddAlfabeto.setText("Agregar");
        jButtonAddAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAlfabetoActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado inicial:");

        jBtnInicial.setText("Agregar");

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

        jLabel11.setText("Estado inicial:");

        javax.swing.GroupLayout jPanelGenerateLayout = new javax.swing.GroupLayout(jPanelGenerate);
        jPanelGenerate.setLayout(jPanelGenerateLayout);
        jPanelGenerateLayout.setHorizontalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addComponent(jTxtEstadoAceptacion)
                        .addGap(26, 26, 26)
                        .addComponent(jBtnAceptacion))
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtEstadoInicial)
                            .addComponent(jTxtEstados, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtNombre)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnEstados)
                            .addComponent(jButtonAddAlfabeto)
                            .addComponent(jBtnInicial))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnEquivalencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnTest)
                .addGap(185, 185, 185))
        );
        jPanelGenerateLayout.setVerticalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTxtEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnEstados)))
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonAddAlfabeto)))
                .addGap(18, 18, 18)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtEstadoAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnAceptacion))
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnEquivalencia)
                    .addComponent(jBtnTest))
                .addContainerGap(30, Short.MAX_VALUE))
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
    
    private void jButtonAddAlfabetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAlfabetoActionPerformed
        
    }//GEN-LAST:event_jButtonAddAlfabetoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Equivalencia;
    private javax.swing.JButton jBtnAceptacion;
    private javax.swing.JButton jBtnEquivalencia;
    private javax.swing.JButton jBtnEstados;
    private javax.swing.JButton jBtnInicial;
    private javax.swing.JButton jBtnTest;
    private javax.swing.JButton jButtonAddAlfabeto;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField jTxtEstadoAceptacion;
    private javax.swing.JTextField jTxtEstadoInicial;
    private javax.swing.JTextField jTxtEstados;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
