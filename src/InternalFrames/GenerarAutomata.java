package InternalFrames;

import Classes.TableUtilities;
import Classes.Estados;
import Classes.Transiciones;
import Classes.Archivos;
import Classes.AFD;
import Classes.QueryManager;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PC
 */
public class GenerarAutomata extends javax.swing.JInternalFrame {
    
    TableUtilities automata;
    public String alfabetoArr[], estadosArr[], estadosAceptacion[], estadosLlegada[];
    String autoName = "", alfabeto = "", estados = "", estado_inicial = "", estados_aceptacion = "";
    AFD afd;
    Archivos archivo;
    boolean flagInitialState =false, flagAceptacion =false;
    String palabrasAceptadas = "", palabrasNoAceptadas ="";
    
    QueryManager query;
    public String sql = "";
    
    public GenerarAutomata() {
        initComponents();
        automata = new TableUtilities();
        afd = new AFD();
        archivo = new Archivos();
        query = new QueryManager();
        listarAutomatas();
        listarArchivos();
        this.jRbManual.setSelected(true);
        this.jComboBoxAutomata.setEnabled(false);
        this.jComboBoxTestFiles.setEnabled(false);
        this.jButtonGenerarTabla.setEnabled(false);
        this.jButtonGenerarAutomata.setEnabled(false);
        this.jTxtAceptacionAuto.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnTransiciones = new javax.swing.JButton();
        jBtnAceptarEstadosAceptacion = new javax.swing.JButton();
        jLabalEstadoInicial = new javax.swing.JLabel();
        jLabelEstadosAceptacion = new javax.swing.JLabel();
        jTxtEstadosLlegada = new javax.swing.JTextField();
        jBtnAceptarTransiciones = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTestFiles = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxAutomata = new javax.swing.JComboBox();
        jButtonGenerarTabla = new javax.swing.JButton();
        jButtonGenerarAutomata = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTxtAceptacionAuto = new javax.swing.JTextField();
        jRbManual = new javax.swing.JRadioButton();
        jRbAutomatico = new javax.swing.JRadioButton();
        jRbNFA = new javax.swing.JRadioButton();
        jPanelEquivalencia = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableEquivalenciaNFA = new javax.swing.JTable();
        jPanelVerAutomata = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaVerCadenas = new javax.swing.JTextArea();

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
        jBtnEquivalencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEquivalenciaActionPerformed(evt);
            }
        });

        jBtnTest.setText("Probar automata");
        jBtnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTestActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Estado actual");

        jLabel3.setText("caracter de transicion");

        jLabel4.setText("Estados de llegada");

        jBtnTransiciones.setText("Agregar");
        jBtnTransiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTransicionesActionPerformed(evt);
            }
        });

        jBtnAceptarEstadosAceptacion.setText("Aceptar");
        jBtnAceptarEstadosAceptacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarEstadosAceptacionActionPerformed(evt);
            }
        });

        jLabalEstadoInicial.setText("vacio");

        jLabelEstadosAceptacion.setText("vacio");

        jBtnAceptarTransiciones.setText("Aceptar");
        jBtnAceptarTransiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarTransicionesActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setText("Tests Files:");

        jComboBoxTestFiles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Automata:");

        jComboBoxAutomata.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonGenerarTabla.setText("Generar Tabla");
        jButtonGenerarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarTablaActionPerformed(evt);
            }
        });

        jButtonGenerarAutomata.setText("Generar Automata");
        jButtonGenerarAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarAutomataActionPerformed(evt);
            }
        });

        jLabel12.setText("Estados aceptacion:");

        jRbManual.setText("Manual");
        jRbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbManualActionPerformed(evt);
            }
        });

        jRbAutomatico.setText("Desde Archivo");
        jRbAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbAutomaticoActionPerformed(evt);
            }
        });

        jRbNFA.setText("NFA");

        javax.swing.GroupLayout jPanelGenerateLayout = new javax.swing.GroupLayout(jPanelGenerate);
        jPanelGenerate.setLayout(jPanelGenerateLayout);
        jPanelGenerateLayout.setHorizontalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnEquivalencia)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnTest)
                        .addGap(190, 190, 190))
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
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
                                    .addComponent(jTxtEstadosLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jRbManual)
                                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBtnAceptarTransiciones)
                                            .addComponent(jBtnTransiciones)
                                            .addComponent(jBtnAceptarEstadosAceptacion)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jBtnEstados))
                                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabalEstadoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                                        .addComponent(jLabelEstadosAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jBtnAceptacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jBtnInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(75, 75, 75)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelGenerateLayout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jComboBoxAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelGenerateLayout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jComboBoxTestFiles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jButtonGenerarTabla)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jRbNFA)
                                                    .addComponent(jButtonGenerarAutomata)))))
                                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtAceptacionAuto)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                        .addComponent(jRbAutomatico)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(11, 11, 11)))))
                .addContainerGap())
        );
        jPanelGenerateLayout.setVerticalGroup(
            jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGenerateLayout.createSequentialGroup()
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jComboBoxEstadoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabalEstadoInicial))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jComboBoxAceptacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnAceptacion)
                                    .addComponent(jBtnAceptarEstadosAceptacion)
                                    .addComponent(jLabelEstadosAceptacion))
                                .addGap(19, 19, 19)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jComboBoxSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxTransicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jBtnTransiciones))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTxtEstadosLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBtnAceptarTransiciones)))
                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxAutomata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxTestFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jTxtAceptacionAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonGenerarTabla)
                                    .addComponent(jButtonGenerarAutomata))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRbNFA)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGenerateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGenerateLayout.createSequentialGroup()
                                .addComponent(jRbManual)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGenerateLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jRbAutomatico))))
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jTableEquivalenciaNFA.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTableEquivalenciaNFA);

        javax.swing.GroupLayout jPanelEquivalenciaLayout = new javax.swing.GroupLayout(jPanelEquivalencia);
        jPanelEquivalencia.setLayout(jPanelEquivalenciaLayout);
        jPanelEquivalenciaLayout.setHorizontalGroup(
            jPanelEquivalenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEquivalenciaLayout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanelEquivalenciaLayout.setVerticalGroup(
            jPanelEquivalenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEquivalenciaLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Equivalencia", jPanelEquivalencia);

        jPanelVerAutomata.setLayout(new java.awt.BorderLayout());

        jTextAreaVerCadenas.setColumns(20);
        jTextAreaVerCadenas.setRows(5);
        jScrollPane1.setViewportView(jTextAreaVerCadenas);

        jPanelVerAutomata.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Ver Cadenas", jPanelVerAutomata);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void listarAutomatas(){
        this.sql = "select t.tablename \n "
                + "from sys.systables t inner join \n"
                + "sys.sysschemas s on t.schemaid = s.schemaid \n"
                + "where s.schemaname = 'TEST' "; 
        query.setComboBoxDataRows(this.jComboBoxAutomata, this.sql);
    }
    private void listarArchivos(){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(); 
        for(String file: archivo.getTestFiles()){
           comboModel.addElement(file);
        }
        this.jComboBoxTestFiles.setModel(comboModel);
    }
    private void jBtnEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEstadosActionPerformed
        this.alfabeto = this.jTxtAlfabeto.getText();
        this.alfabetoArr = automata.splitString(this.alfabeto);
        System.out.println("El arreglo de alfabeto dice: "+this.alfabetoArr);
        afd.setAlfabeto(this.alfabetoArr);
        this.estados = this.jTxtEstados.getText();
        this.estadosArr = automata.splitString(this.estados);

        automata.generarColumnas(this.jTable1, this.alfabetoArr, this.estadosArr);

        automata.setComboBoxData(this.jComboBoxEstadoInicial, estadosArr);
        automata.setComboBoxData(this.jComboBoxAceptacion, estadosArr);
        automata.setComboBoxData(this.jComboBoxSalida, estadosArr);
        automata.setComboBoxData(this.jComboBoxTransicion, alfabetoArr);
        //automata.setComboBoxData(this.jComboBoxLlegada, estadosArr);
    }//GEN-LAST:event_jBtnEstadosActionPerformed

    private void jBtnInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInicialActionPerformed
        this.estado_inicial = this.jComboBoxEstadoInicial.getSelectedItem().toString();
        int index = this.jComboBoxEstadoInicial.getSelectedIndex();
        automata.setEstadosProperties(this.jTable1, index, "->" + this.estado_inicial);
        flagInitialState = true;
        
        this.jLabalEstadoInicial.setText(this.estado_inicial);
        if(flagInitialState){
            this.jComboBoxEstadoInicial.setEnabled(false);
            this.jBtnInicial.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnInicialActionPerformed

    private void jBtnAceptacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptacionActionPerformed
        if(!this.flagAceptacion){
            this.estados_aceptacion += this.jComboBoxAceptacion.getSelectedItem().toString();
            flagAceptacion = true;
        }else{
            this.estados_aceptacion += ","+this.jComboBoxAceptacion.getSelectedItem().toString();
        }
        this.jLabelEstadosAceptacion.setText(this.estados_aceptacion);
        int index = this.jComboBoxAceptacion.getSelectedIndex();
        String valorAnterior = this.jTable1.getValueAt(index, 0).toString();
        
//        automata.setEstadosProperties(this.jTable1, index, valorAnterior + "*");
    }//GEN-LAST:event_jBtnAceptacionActionPerformed

    private void jBtnTransicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTransicionesActionPerformed
        int row = this.jComboBoxSalida.getSelectedIndex();
        int column = this.jComboBoxTransicion.getSelectedIndex();
        String value = this.jTxtEstadosLlegada.getText();
        this.estadosLlegada = automata.splitString(value);
        
        automata.addValues(this.jTable1, row, column + 1, value);
        
        String estadoName = this.jComboBoxSalida.getSelectedItem().toString();
        String transicion = this.jComboBoxTransicion.getSelectedItem().toString();
        
        for(int i = 0; i<estadosLlegada.length; i++){
         afd.initTransiciones(estadoName, transicion, estadosLlegada[i]);   
        }
    }//GEN-LAST:event_jBtnTransicionesActionPerformed

    private void jBtnAceptarEstadosAceptacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarEstadosAceptacionActionPerformed
        this.estadosAceptacion = automata.splitString(this.estados_aceptacion);
        afd.initStates(estadosArr, estadosAceptacion);
    }//GEN-LAST:event_jBtnAceptarEstadosAceptacionActionPerformed

    private void jBtnAceptarTransicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarTransicionesActionPerformed
        afd.imprimirEstados();
    }//GEN-LAST:event_jBtnAceptarTransicionesActionPerformed

    private void jBtnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTestActionPerformed
        String filename = this.jComboBoxTestFiles.getSelectedItem().toString();
        archivo.abrirArchivo(filename);
        System.out.println("Evaluacion de cadenas: "+archivo.getCadenasAceptas() +archivo.getCadenasNoAceptadas());
        this.jTextAreaVerCadenas.setText(archivo.getCadenasAceptas() +archivo.getCadenasNoAceptadas());
    }//GEN-LAST:event_jBtnTestActionPerformed

    private void jBtnEquivalenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEquivalenciaActionPerformed
        afd.initNFAStates();
        automata.generarTabla(this.jTableEquivalenciaNFA, afd.getEstados());
    }//GEN-LAST:event_jBtnEquivalenciaActionPerformed

    private void jButtonGenerarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarTablaActionPerformed
        this.sql = "Select * from "+this.jComboBoxAutomata.getSelectedItem().toString();
        query.seTableData(jTable1, sql);
        automata.setCombo(jTable1, this.jComboBoxAceptacion);
    }//GEN-LAST:event_jButtonGenerarTablaActionPerformed

    private void jButtonGenerarAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarAutomataActionPerformed
        this.estadosAceptacion = automata.splitString(this.jLabelEstadosAceptacion.getText());
        automata.generateAutomata(jTable1, this.estadosAceptacion);
        
    }//GEN-LAST:event_jButtonGenerarAutomataActionPerformed

    private void jRbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbManualActionPerformed
        if(this.jRbManual.isSelected()){
            this.jComboBoxAutomata.setEnabled(false);
            this.jComboBoxTestFiles.setEnabled(false);
            this.jButtonGenerarTabla.setEnabled(false);
            this.jButtonGenerarAutomata.setEnabled(false);
            this.jTxtAceptacionAuto.setEnabled(false);
            this.jRbAutomatico.setSelected(false);
            
            this.jTxtNombre.setEnabled(true);
            this.jTxtAlfabeto.setEnabled(true);
            this.jTxtEstados.setEnabled(true);
            this.jTxtEstadosLlegada.setEnabled(true);
            this.jBtnAceptarEstadosAceptacion.setEnabled(true);
            this.jBtnAceptarTransiciones.setEnabled(true);
            this.jBtnEstados.setEnabled(true);
            this.jBtnTransiciones.setEnabled(true);
            this.jComboBoxSalida.setEnabled(true);
            this.jComboBoxTransicion.setEnabled(true);
        }
    }//GEN-LAST:event_jRbManualActionPerformed

    private void jRbAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbAutomaticoActionPerformed
        if(this.jRbAutomatico.isSelected()){
            this.jTxtNombre.setEnabled(false);
            this.jTxtAlfabeto.setEnabled(false);
            this.jTxtEstados.setEnabled(false);
            this.jTxtEstadosLlegada.setEnabled(false);
            this.jBtnAceptarEstadosAceptacion.setEnabled(false);
            this.jBtnAceptarTransiciones.setEnabled(false);
            this.jBtnEstados.setEnabled(false);
            this.jBtnTransiciones.setEnabled(false);
            this.jComboBoxSalida.setEnabled(false);
            this.jComboBoxTransicion.setEnabled(false);
            this.jRbManual.setSelected(false);
            
            this.jComboBoxAutomata.setEnabled(true);
            this.jComboBoxTestFiles.setEnabled(true);
            this.jButtonGenerarTabla.setEnabled(true);
            this.jButtonGenerarAutomata.setEnabled(true);
            this.jTxtAceptacionAuto.setEnabled(true);
        }
    }//GEN-LAST:event_jRbAutomaticoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptacion;
    private javax.swing.JButton jBtnAceptarEstadosAceptacion;
    private javax.swing.JButton jBtnAceptarTransiciones;
    private javax.swing.JButton jBtnEquivalencia;
    private javax.swing.JButton jBtnEstados;
    private javax.swing.JButton jBtnInicial;
    private javax.swing.JButton jBtnTest;
    private javax.swing.JButton jBtnTransiciones;
    private javax.swing.JButton jButtonGenerarAutomata;
    private javax.swing.JButton jButtonGenerarTabla;
    private javax.swing.JComboBox jComboBoxAceptacion;
    private javax.swing.JComboBox jComboBoxAutomata;
    private javax.swing.JComboBox jComboBoxEstadoInicial;
    private javax.swing.JComboBox jComboBoxSalida;
    private javax.swing.JComboBox jComboBoxTestFiles;
    private javax.swing.JComboBox jComboBoxTransicion;
    private javax.swing.JLabel jLabalEstadoInicial;
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
    private javax.swing.JLabel jLabelEstadosAceptacion;
    private javax.swing.JPanel jPanelEquivalencia;
    private javax.swing.JPanel jPanelGenerate;
    private javax.swing.JPanel jPanelVerAutomata;
    private javax.swing.JRadioButton jRbAutomatico;
    private javax.swing.JRadioButton jRbManual;
    private javax.swing.JRadioButton jRbNFA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableEquivalenciaNFA;
    private javax.swing.JTextArea jTextAreaVerCadenas;
    private javax.swing.JTextField jTxtAceptacionAuto;
    private javax.swing.JTextArea jTxtAlfabeto;
    private javax.swing.JTextField jTxtEstados;
    private javax.swing.JTextField jTxtEstadosLlegada;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
