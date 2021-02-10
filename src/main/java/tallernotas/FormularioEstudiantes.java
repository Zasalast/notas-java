package javaapplication9.src.main.java.tallernotas;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.green;
import static java.awt.Color.red;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.TileObserver;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.Normalizer.Form;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class FormularioEstudiantes extends JFrame implements ActionListener, MouseListener, KeyListener {

    private String informe_estudiante = "";

    public String getInforme_estudiante() {
        return informe_estudiante;
    }

    public void setInforme_estudiante(String informe_estudiante) {
        this.informe_estudiante = informe_estudiante;
    }
    private JScrollPane pane, pane_estudiante;
    private Container contentPane;
    private String nombrearchivo = "";
    private OperacionArchivo guardar_log;
    private JLabel Nota1_JLabel_color, Nota2_JLabel_color, Nota3_JLabel_color, Nota, Informacion_personal_lbl, informe_JLabel, ingrese_notas;
    private JButton btn_salir, btn_buscar, btn_reset, btn_clear, btn_registrar, btn_ver_estudiantes;
//    private JTextField   /*primer_nombre_JTextField,*/ ;
    private JTextArea informe_estudiante_JTextArea, informe_JTextArea;
    JRadioButton cedula_ciudadania, tarjeta_identidad, cedula_extranjeria, masculino, femenido, Otro;
    Random random = new Random();
    private JComboBox tipo_documento_JComboBox, genero_JComboBox;
    JSpinner spinner;
//    JList tipo_documento_JList, genero_JList;

    private JPanel jpMenu, jp_center_notas, jp_nombre_estudiante, jp_documento, jp_informe_notas, jp_cantidad, jp_iingreso_notas, jp_center_panel, jp6, jp_controles;
    private JFormattedTextField jtf1, jtf2, numero_identificacion_JTextField, primer_nombre_JTextField, segundo_nombre_JTextField, primer_apellido_JTextField, segundo_apellido_JTextField, Nota1_JTextField, Nota2_JTextField, Nota3_JTextField, buscar_txf;
    private MaskFormatter jf1, jf2, jf3, jf4;

    private double nota1, nota2, nota3, promedio;

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    FormularioEstudiantes(String Titulo, int ancho, int alto, boolean bloqueo_ventana, boolean Visible_ventana) {
        setTitle(Titulo);
        setLayout(new BorderLayout(5, 5));
        setSize(ancho + 10, alto + 40);//ancho , alto
        setBackground(Color.GRAY);///color fondo
        setLocationRelativeTo(null);//centro de pantallla
//        getContentPane().setBackground(Color.black);
        setResizable(bloqueo_ventana);//cambiar tamaño de pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CenterPanelNotas(0, 0, 300, 100);
        Components();

        PanelBuscar(0, 0, alto, ancho);
        CenterPanel(0, 0, ancho, alto);
        PanelMenu(0, 0, 200, 200);
        ControlesPanelFlowLayout(0, 0, 600, 80);
        Panel_Informe(0, 0, 300, 100);
        DatosPersonalesPanelGridLayout(0, 0, 600, 80);
        jp_center_panel.add(jp_center_notas, BorderLayout.CENTER);

        setVisible(Visible_ventana);
    }

    public void Panel_Informe(int x, int y, int alt, int ancho) {

        jp_iingreso_notas = new JPanel();

        jp_iingreso_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_iingreso_notas.setBackground(Color.PINK);
        jp_iingreso_notas.setLayout(new GridLayout(2, 3));

        jp_iingreso_notas.add(ingrese_notas);
        jp_iingreso_notas.add(Nota1_JTextField);
        jp_iingreso_notas.add(Nota2_JTextField);
        jp_iingreso_notas.add(Nota3_JTextField);

        jp_iingreso_notas.add(Nota1_JLabel_color);
        jp_iingreso_notas.add(Nota2_JLabel_color);
        jp_iingreso_notas.add(Nota3_JLabel_color);
        jp_iingreso_notas.add(Nota);
        jp_center_notas.add(jp_iingreso_notas);
    }

    public void CenterPanel(int x, int y, int alt, int ancho) {
        jp_center_panel = new JPanel();
        jp_center_panel.setLayout(new BorderLayout(5, 5));
        jp_center_panel.setBackground(Color.red);

//        jp_center_panel.setBounds(x, y, alt, ancho);
        jp_center_panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        this.add(jp_center_panel);
    }

    public void CenterPanelNotas(int x, int y, int alt, int ancho) {
        jp_center_notas = new JPanel();
        jp_center_notas.setLayout(new GridLayout(2, 2));
        jp_center_notas.setBackground(Color.PINK);

//        jp_center_notas.setBounds(x, y, alt, ancho);
        jp_center_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    }

    public void PanelMenu(int x, int y, int alt, int ancho) {
        DocumentoEstudiantesPanelFlowLayout(0, 0, 200, 200);
        NombreEstudiantePanelFlowLayout(0, 0, 200, 200);
        jpMenu = new JPanel();
        jpMenu.setLayout(new BorderLayout());
//        jpMenu.setBounds(x, y, alt, ancho);
        jpMenu.setBackground(Color.black);
        jpMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        jpMenu.add(jp_documento, BorderLayout.PAGE_START);
        jpMenu.add(jp_nombre_estudiante, BorderLayout.CENTER);
        jp_center_panel.add(jpMenu, BorderLayout.WEST);
    }

    public void DocumentoEstudiantesPanelFlowLayout(int x, int y, int alt, int ancho) {
        jp_documento = new JPanel();
        Border bt_jp_documento;
        bt_jp_documento = BorderFactory.createLineBorder(green, 1);
        bt_jp_documento = BorderFactory.createTitledBorder(bt_jp_documento, "Información");
        jp_documento.setLayout(new GridLayout(8, 0, 10, 10));
//        jp_documento.setBounds(x, y, alt, ancho);
        jp_documento.setBackground(Color.PINK);
        jp_documento.setBorder(bt_jp_documento);
//        jp_documento.add(Informacion_personal_lbl);

        jp_documento.add(masculino);
        jp_documento.add(femenido);
        jp_documento.add(Otro);
        jp_documento.add(cedula_ciudadania);
        jp_documento.add(tarjeta_identidad);
        jp_documento.add(cedula_extranjeria);

        jp_documento.add(numero_identificacion_JTextField);
    }

    public void NombreEstudiantePanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_nombre_estudiante = new JPanel();
        jp_nombre_estudiante.setLayout(new GridLayout(5, 0, 0, 0));
//        jp_nombre_estudiante.setBounds(x, y, alt, ancho);
        jp_nombre_estudiante.setBackground(Color.PINK);
        jp_nombre_estudiante.setBorder(BorderFactory.createLineBorder(Color.black));

        jp_nombre_estudiante.add(primer_nombre_JTextField);
        jp_nombre_estudiante.add(segundo_nombre_JTextField);
        jp_nombre_estudiante.add(primer_apellido_JTextField);
        jp_nombre_estudiante.add(segundo_apellido_JTextField);
    }

    public void DatosPersonalesPanelGridLayout(int x, int y, int alt, int ancho) {

        jp_informe_notas = new JPanel();
        jp_informe_notas.setLayout(new GridLayout(3, 2, 0, 0));
//        jp_informe_notas.setBounds(x, y, alt, ancho);
        jp_informe_notas.setBackground(Color.PINK);
        jp_informe_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        jp_informe_notas.add(informe_JLabel);
        jp_informe_notas.add(pane);

        jp_center_notas.add(jp_informe_notas);
    }

    public void PanelBuscar(int x, int y, int alt, int ancho) {

        jp_cantidad = new JPanel();
        jp_cantidad.setLayout(new GridLayout(2, 2, 0, 0));
//        jp_cantidad.setBounds(x, y, alt, ancho);
        jp_cantidad.setBackground(Color.WHITE);
        jp_cantidad.setBorder(BorderFactory.createLineBorder(Color.black));
        jp_cantidad.add(btn_buscar);
        jp_cantidad.add(buscar_txf);

    }

    public void ControlesPanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_controles = new JPanel();
        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
//        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.pink);
        jp_controles.setBorder(BorderFactory.createLineBorder(Color.black));
        jp_center_panel.add(jp_cantidad, BorderLayout.PAGE_START);
        jp_controles.add(btn_ver_estudiantes);
        jp_controles.add(btn_reset);
        jp_controles.add(btn_registrar);
        jp_controles.add(btn_clear);
        jp_controles.add(btn_salir);
        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void JTextAreaComponents() {

        informe_estudiante_JTextArea = new JTextArea();

        informe_estudiante_JTextArea.setLineWrap(true);

        informe_estudiante_JTextArea.setEditable(false);
//        informe_estudiante_JTextArea.setBounds(10, 5, 100, 100);
        pane_estudiante = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        informe_JTextArea = new JTextArea();

        informe_JTextArea.setLineWrap(true);

        informe_JTextArea.setEditable(false);
//        informe_JTextArea.setBounds(10, 5, 100, 100);
        pane = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    public void formato() {
        try {
            jf1 = new MaskFormatter("ULLLLLLLLLLLLL");//primera mayuscula el resto minuscula
            jf2 = new MaskFormatter("#,##");//nota
            jf3 = new MaskFormatter("##########");//Cedula
            jf4 = new MaskFormatter("####/##/##");//Fecha  toca probar esta por que aun no he podido

        } catch (Exception e) {
            System.out.println("Formato no valido");
        }
    }

    void JTextFieldComponents() {
        formato();

        Border bt_numero_identificacion;
        bt_numero_identificacion = BorderFactory.createLineBorder(green, 1);
        bt_numero_identificacion = BorderFactory.createTitledBorder(bt_numero_identificacion, "Número Identificacion");
        numero_identificacion_JTextField = new JFormattedTextField(jf3);
        numero_identificacion_JTextField.setBorder(bt_numero_identificacion);
        numero_identificacion_JTextField.setText("");
        numero_identificacion_JTextField.setEditable(true);
        numero_identificacion_JTextField.addMouseListener(this);

//        primer_nombre_JTextField = new JTextField();
        Border bt_primer_nombre;
        bt_primer_nombre = BorderFactory.createLineBorder(green, 1);
        bt_primer_nombre = BorderFactory.createTitledBorder(bt_primer_nombre, "Primer nombre");
//        bt_primer_nombre = BorderFactory.createTitledBorder("nombre");
        primer_nombre_JTextField = new JFormattedTextField(jf1);
        primer_nombre_JTextField.setBorder(bt_primer_nombre);
        primer_nombre_JTextField.setText("");
        primer_nombre_JTextField.setEditable(true);
        primer_nombre_JTextField.addMouseListener(this);
        primer_nombre_JTextField.addKeyListener(this);

        Border bt_segundo_nombre;
        bt_segundo_nombre = BorderFactory.createLineBorder(green, 1);
        bt_segundo_nombre = BorderFactory.createTitledBorder(bt_segundo_nombre, "Segundo nombre");
//        bt_segundo_nombre = BorderFactory.createTitledBorder("nombre");
        segundo_nombre_JTextField = new JFormattedTextField(jf1);
        segundo_nombre_JTextField.setBorder(bt_segundo_nombre);
        segundo_nombre_JTextField.setText("");
        segundo_nombre_JTextField.setEditable(true);
        segundo_nombre_JTextField.addMouseListener(this);

        Border bt_primer_apellido;
        bt_primer_apellido = BorderFactory.createLineBorder(green, 1);
        bt_primer_apellido = BorderFactory.createTitledBorder(bt_primer_apellido, "Primer Apellido");
//        bt_primer_apellido = BorderFactory.createTitledBorder("nombre");
        primer_apellido_JTextField = new JFormattedTextField(jf1);
        primer_apellido_JTextField.setBorder(bt_primer_apellido);
        primer_apellido_JTextField.setText("");
        primer_apellido_JTextField.setEditable(true);
        primer_apellido_JTextField.addMouseListener(this);

        Border bt_segundo_apellido;
        bt_segundo_apellido = BorderFactory.createLineBorder(green, 1);
        bt_segundo_apellido = BorderFactory.createTitledBorder(bt_segundo_apellido, "Segundo Apellido");
//        bt_segundo_apellido = BorderFactory.createTitledBorder("nombre");
        segundo_apellido_JTextField = new JFormattedTextField(jf1);
        segundo_apellido_JTextField.setBorder(bt_segundo_apellido);
        segundo_apellido_JTextField.setText("");
        segundo_apellido_JTextField.setEditable(true);
        segundo_apellido_JTextField.addMouseListener(this);

        Border bt_Nota1;
        bt_Nota1 = BorderFactory.createLineBorder(green, 1);
        bt_Nota1 = BorderFactory.createTitledBorder(bt_Nota1, "Nota 1");
        Nota1_JTextField = new JFormattedTextField(jf2);
        Nota1_JTextField.setBorder(bt_Nota1);
        Nota1_JTextField.setText("");
        Nota1_JTextField.setEditable(true);
        Nota1_JTextField.addMouseListener(this);

        Border bt_Nota2;
        bt_Nota2 = BorderFactory.createLineBorder(green, 1);
        bt_Nota2 = BorderFactory.createTitledBorder(bt_Nota2, "Nota2");
        Nota2_JTextField = new JFormattedTextField(jf2);
        Nota2_JTextField.setBorder(bt_Nota2);
        Nota2_JTextField.setText("");
        Nota2_JTextField.setEditable(true);
        Nota2_JTextField.addMouseListener(this);

        Border bt_Nota3;
        bt_Nota3 = BorderFactory.createLineBorder(green, 1);
        bt_Nota3 = BorderFactory.createTitledBorder(bt_Nota3, "Nota 3");
        Nota3_JTextField = new JFormattedTextField(jf2);
        Nota3_JTextField.setBorder(bt_Nota3);
        Nota3_JTextField.setText("");
        Nota3_JTextField.setEditable(true);
        Nota3_JTextField.addMouseListener(this);

        Border bt_buscar;
        bt_buscar = BorderFactory.createLineBorder(green, 1);
        bt_buscar = BorderFactory.createTitledBorder(bt_buscar, "Buscar");
        buscar_txf = new JFormattedTextField(jf3);
        buscar_txf.setBorder(bt_buscar);
        buscar_txf.setText("");
        buscar_txf.setEditable(true);
        buscar_txf.addMouseListener(this);

    }

    void JLabelComponents() {

        Nota1_JLabel_color = new JLabel("");

        Nota2_JLabel_color = new JLabel("");

        Nota3_JLabel_color = new JLabel("");
        Nota = new JLabel("Los valores deben estar entre 0 y 5");

        informe_JLabel = new JLabel("Informe estudiante");

        Informacion_personal_lbl = new JLabel("Ingrese Datos Personales");

        ingrese_notas = new JLabel("Ingrese Notas");
        Nota1_JLabel_color.setVisible(false);
        Nota2_JLabel_color.setVisible(false);
        Nota3_JLabel_color.setVisible(false);
    }

    void JComboComponents() {
        cedula_ciudadania = new JRadioButton("cedula de ciudadanía");
        cedula_ciudadania.isEnabled();
        cedula_ciudadania.setBounds(10, 60, 100, 20);
        cedula_ciudadania.setVisible(true);
        cedula_ciudadania.addActionListener(this);
        tarjeta_identidad = new JRadioButton("tarjeta de identidad");
        tarjeta_identidad.setBounds(150, 60, 100, 20);
        tarjeta_identidad.setVisible(true);
        cedula_extranjeria = new JRadioButton("cédula de extranjería");
        cedula_extranjeria.setBounds(150, 60, 100, 20);
        cedula_extranjeria.setVisible(true);
        ButtonGroup bg_tipo_documento = new ButtonGroup();
        bg_tipo_documento.add(cedula_ciudadania);
        bg_tipo_documento.add(tarjeta_identidad);
        bg_tipo_documento.add(cedula_extranjeria);

        ButtonGroup bg_genero = new ButtonGroup();
        masculino = new JRadioButton("Masculino");
        masculino.setBounds(10, 60, 100, 20);
        masculino.setVisible(true);
        femenido = new JRadioButton("Femenido");
        femenido.setBounds(150, 60, 100, 20);
        femenido.setVisible(true);
        Otro = new JRadioButton("Otro");
        Otro.setBounds(150, 60, 100, 20);
        Otro.setVisible(true);
        bg_genero.add(masculino);
        bg_genero.add(femenido);
        bg_genero.add(Otro);

    }

    void JButtonComponents() {

        btn_reset = new JButton("reset");

        btn_reset.setBounds(50, 150, 200, 30);
        btn_reset.addActionListener(this);

        btn_registrar = new JButton("Registrar");

        btn_registrar.setBounds(50, 150, 200, 30);
        btn_registrar.addActionListener(this);

        btn_clear = new JButton("clear");

        btn_clear.setBounds(50, 100, 200, 30);
        btn_clear.addActionListener(this);

        btn_salir = new JButton("Salir");

        btn_salir.setBounds(10, 200, 200, 200);
        btn_salir.addActionListener(this);

        btn_ver_estudiantes = new JButton("Ver Estudiantes");

        btn_ver_estudiantes.setBounds(10, 200, 200, 200);
        btn_ver_estudiantes.addActionListener(this);
        btn_buscar = new JButton("Buscar");
        btn_buscar.addActionListener(this);
    }

    void Components() {

        JButtonComponents();
        JTextFieldComponents();
        JTextAreaComponents();
        JComboComponents();
        JLabelComponents();
    }

    ////         Acciones Botones  //////
    @Override
    public void actionPerformed(ActionEvent e) {

        Estudiante estudiante1 = new Estudiante();
        System.out.println(e.getSource() == cedula_ciudadania);
        if (e.getSource() == btn_registrar) {
            validacionDatos();
            try {
                if (Double.parseDouble(numero_identificacion_JTextField.getText()) >= 1000 && Double.parseDouble(numero_identificacion_JTextField.getText()) <= 999999999
                        && primer_nombre_JTextField.getText().trim().length() >= 3
                        && primer_apellido_JTextField.getText().trim().length() >= 3
                        && Double.parseDouble(Nota1_JTextField.getText()) >= 0
                        && Double.parseDouble(Nota1_JTextField.getText()) <= 5
                        && Double.parseDouble(Nota2_JTextField.getText()) >= 0
                        && Double.parseDouble(Nota2_JTextField.getText()) <= 5
                        && Double.parseDouble(Nota3_JTextField.getText()) >= 0
                        && Double.parseDouble(Nota3_JTextField.getText()) <= 5) {

                    if (numero_identificacion_JTextField.getText().trim().isEmpty() && numero_identificacion_JTextField.getText().trim().length() >= 3
                            && primer_nombre_JTextField.getText().trim().isEmpty() && primer_nombre_JTextField.getText().trim().length() >= 3
                            && primer_apellido_JTextField.getText().trim().isEmpty() && primer_apellido_JTextField.getText().trim().length() >= 3) {
                        estudiante1.setDocumentoIdentificacion(numero_identificacion_JTextField.getText());
                        estudiante1.setPrimer_nombre(primer_nombre_JTextField.getText());
                        estudiante1.setSegundo_nombre(segundo_nombre_JTextField.getText());
                        estudiante1.setPrimer_apellido(primer_apellido_JTextField.getText());
                        estudiante1.setSegundo_apellido(segundo_apellido_JTextField.getText());
                        try {
                            if (Double.parseDouble(Nota1_JTextField.getText()) >= 0 && Double.parseDouble(Nota1_JTextField.getText()) <= 5) {

                                estudiante1.setNota1(Nota1_JTextField.getText());
                                Nota1_JLabel_color.setBackground(Color.GREEN);

                                Nota1_JLabel_color.setText("Nota 1 Valida     " + Double.parseDouble(Nota1_JTextField.getText()));
                                nota1 = Double.parseDouble(Nota1_JTextField.getText());
                                Nota1_JLabel_color.setVisible(true);

                            } else {
                                Nota1_JLabel_color.setBackground(Color.RED);
                                Nota1_JLabel_color.setText("Nota 1 no Valida");
                                Nota1_JLabel_color.setVisible(true);
                                nota1 = 0;
                                estudiante1.setNota1("0");
                            }
                        } catch (Exception e4) {

                            try {
                                String mens = "" + e4.getMessage();

                                nombrearchivo = "ErrorLog" + "";

                                guardar_log.crear_archivo_plano(nombrearchivo, mens);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            }

                        }

                        if (Double.parseDouble(Nota2_JTextField.getText()) >= 0 && Double.parseDouble(Nota2_JTextField.getText()) <= 5) {
                            Nota2_JLabel_color.setBackground(Color.GREEN);
                            estudiante1.setNota2(Nota2_JTextField.getText());
                            nota2 = Double.parseDouble(Nota2_JTextField.getText());
                            Nota2_JLabel_color.setText("Nota 2 Valida   ");
                            Nota2_JLabel_color.setVisible(true);

                        } else {
                            Nota2_JLabel_color.setBackground(Color.RED);
                            Nota2_JLabel_color.setText("Nota 2 no Valida  ");
                            Nota2_JLabel_color.setVisible(true);
                            nota2 = 0;
                            estudiante1.setNota2("0");
                        }

                        try {
                            if (Double.parseDouble(Nota3_JTextField.getText()) >= 0 || Double.parseDouble(Nota3_JTextField.getText()) <= 5) {
                                Nota3_JLabel_color.setBackground(Color.GREEN);
                                estudiante1.setNota3(Nota3_JTextField.getText());
                                nota3 = Double.parseDouble(Nota3_JTextField.getText());
//                informe_JTextArea.setText(informe_JTextArea.getText() + nota3);
                                Nota3_JLabel_color.setText("Nota 3 Valida");
                                Nota3_JLabel_color.setVisible(true);

                            } else {
                                nota3 = 0;
                                Nota3_JLabel_color.setBackground(Color.RED);
                                Nota3_JLabel_color.setText("Nota 3 no Valida");
                                Nota3_JLabel_color.setVisible(true);
                                estudiante1.setNota3("0");
                            }
                        } catch (NumberFormatException e5) {
                            try {
                                String mens = "" + e5.getMessage();

                                nombrearchivo = "ErrorLog" + "";

                                guardar_log.crear_archivo_plano(nombrearchivo, mens);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            }
                        }

                        try {
                            if (cedula_ciudadania.isSelected() == true || tarjeta_identidad.isSelected() || cedula_extranjeria.isSelected()) {
                                if (cedula_ciudadania.isSelected()) {
                                    System.out.println("ciudadanía");

                                    estudiante1.setTipo_documento("cedula de ciudadanía");
                                } else if (tarjeta_identidad.isSelected()) {

                                    estudiante1.setTipo_documento("tarjeta de identidad");
                                    System.out.println("identidad");
                                } else if (cedula_extranjeria.isSelected()) {
                                    System.out.println("extranjeria");
                                    setInforme_estudiante(getInforme_estudiante() + "cedula de extranjeria");
                                    estudiante1.setTipo_documento("cedula de extranjeria");
                                }

                            } else {
                                estudiante1.setTipo_documento("no definido");
                                System.out.println("no se seleccion tipo documento");
                                System.out.println(cedula_ciudadania.isSelected());
                                System.out.println(tarjeta_identidad.isSelected());
                                System.out.println(cedula_extranjeria.isSelected());
                            }
                        } catch (Exception e7) {
                            try {
                                String mens = "" + e7.getMessage();

                                nombrearchivo = "ErrorLog" + "";

                                guardar_log.crear_archivo_plano(nombrearchivo, mens);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            }
                        }

                        try {
                            if (masculino.isSelected() || femenido.isSelected() || Otro.isSelected()) {
                                if (masculino.isSelected()) {
                                    System.out.println("masculino");
                                    estudiante1.setGenero("masculino");

                                } else if (femenido.isSelected()) {
                                    estudiante1.setGenero("femenino");

                                    System.out.println("femenido");
                                } else if (Otro.isSelected()) {
                                    System.out.println("Otro");
                                    estudiante1.setGenero("otro");

                                }

                            } else {
                                estudiante1.setGenero("No definido");
                                System.out.println("no se seleccion genero");
                            }
                        } catch (Exception e8) {
                            try {
                                String mens = "" + e8.getMessage();

                                nombrearchivo = "ErrorLog" + "";

                                guardar_log.crear_archivo_plano(nombrearchivo, mens);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            }
                        }

                        estudiante1.CrearGuardarArchivoEstudiante("Cedula", numero_identificacion_JTextField.getText(), "genero", primer_nombre_JTextField.getText(), segundo_nombre_JTextField.getText(), primer_apellido_JTextField.getText(), segundo_apellido_JTextField.getText(), "" + nota1, "" + nota2, "" + nota3, "\"estudiantes4\"");
                        try {
                            estudiante1.AgregarNuevosEstudiantes(estudiante1.getTipo_documento(), estudiante1.getDocumentoIdentificacion(), estudiante1.getGenero(), estudiante1.getPrimer_nombre(), estudiante1.getSegundo_nombre(), estudiante1.getPrimer_apellido(), estudiante1.getSegundo_apellido(), estudiante1.getNota1(), estudiante1.getNota2(), estudiante1.getNota3(), "estudiantes4");
                            informe_JTextArea.setText(informe_JTextArea.getText() + "\n \n"
                                    + estudiante1.getTipo_documento() + " , " + estudiante1.getDocumentoIdentificacion() + " , "
                                    + estudiante1.getGenero() + " , " + estudiante1.getPrimer_nombre() + " , "
                                    + estudiante1.getSegundo_nombre() + " , " + estudiante1.getPrimer_apellido() + " , "
                                    + estudiante1.getSegundo_apellido() + " , " + estudiante1.getNota1() + " , " + estudiante1.getNota2() + " , "
                                    + estudiante1.getNota3());
                        } catch (Exception e9) {
                            try {
                                String mens = "" + e9.getMessage();

                                nombrearchivo = "ErrorLog" + "";

                                guardar_log.crear_archivo_plano(nombrearchivo, mens);
                            } catch (IOException ex) {
                                java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                            }
                        }

                    }
                } else {
//                    Border incorrecto = BorderFactory.createLineBorder(red, 1);
//                    TitledBorder primer_nombre = BorderFactory.createTitledBorder(incorrecto, "Dato Requerido");
//
//                    Border incorrect = BorderFactory.createLineBorder(red, 1);
//                    TitledBorder primer_nombr = BorderFactory.createTitledBorder(incorrecto, "Incorrecto primer nombre");

//                    TitledBorder numero_identificacion_border = BorderFactory.createTitledBorder(incorrecto, "Incorrecto nota 1");
//                    numero_identificacion_JTextField.setBorder(numero_identificacion_border);
//                    TitledBorder primer_apellido = BorderFactory.createTitledBorder(incorrecto, "Incorrecto primer apellido");
//                    TitledBorder nota_1 = BorderFactory.createTitledBorder(incorrecto, "Incorrecto nota 1");
//                    TitledBorder nota_2 = BorderFactory.createTitledBorder(incorrecto, "Incorrecto nota 2");
//                    TitledBorder nota_3 = BorderFactory.createTitledBorder(incorrecto, "Incorrecto nota 3");
                }
            } catch (Exception e10) {
                System.out.println("error: " + e10.getMessage());
                try {
                    String mens = "" + e10.getMessage();

                    nombrearchivo = "ErrorLog" + "";

                    guardar_log.crear_archivo_plano(nombrearchivo, mens);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(FormularioEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }

        } else if (e.getSource() == btn_reset) {

            informe_JTextArea.setText("");
        } else if (e.getSource() == btn_clear) {
            numero_identificacion_JTextField.setText("");

            buscar_txf.setText("");
            primer_nombre_JTextField.setText("");

            segundo_nombre_JTextField.setText("");
            primer_apellido_JTextField.setText("");
            segundo_apellido_JTextField.setText("");
            Nota1_JTextField.setText("");
            Nota2_JTextField.setText("");
            Nota3_JTextField.setText("");
            masculino.setSelected(false);
            femenido.setSelected(false);
            Otro.setSelected(false);
            tarjeta_identidad.setSelected(false);
            cedula_ciudadania.setSelected(false);
            cedula_extranjeria.setSelected(false);

        } else if (e.getSource() == btn_salir) {
            System.exit(0);
        } else if (e.getSource() == btn_buscar) {
            if (Integer.parseInt(buscar_txf.getText()) >= 1000) {
                informe_JTextArea.setText("\n " + estudiante1.BuscarEstudiantes(buscar_txf.getText(), "estudiantes4") + "  \n ");

            }
        } else if (e.getSource() == btn_ver_estudiantes) {

            informe_JTextArea.setText("\n " + informe_JTextArea.getText() + estudiante1.VerEstudiantes("estudiantes4") + "  \n ");
            System.out.println(
                    estudiante1.VerEstudiantes("estudiantes4")
            );

        }

    }
    Validacion validar_contenido = new Validacion();
//     TecladoMetodos validacion_teclas = new TecladoMetodos();

    private void validacionDatos() {
//        metodoLetras(numero_identificacion_JTextField);
        numero_identificacion_JTextField.setBorder(validar_contenido.validacionLongitudContenido(numero_identificacion_JTextField.getText(), ""));
//        primer_nombre_JTextField.setBorder(validar_contenido.validacionLongitudContenido(primer_nombre_JTextField.getText(),"Primer Nombre"));
//        primer_apellido_JTextField.setBorder(validar_contenido.validacionLongitudContenido(primer_apellido_JTextField.getText(),"Primer Apellido"));
//        Nota1_JTextField.setBorder(validar_contenido.validacionLongitudContenido(Nota1_JTextField.getText(),"Nota 1")));
//        Nota2_JTextField.setBorder(validar_contenido.validacionLongitudContenido(Nota2_JTextField.getText(), "Nota 2"));
//        Nota3_JTextField.setBorder(validar_contenido.validacionLongitudContenido(Nota3_JTextField.getText(),"Nota 1"));

    }
// public void metodoLetras(JTextField jtx) {
//        jtx.addKeyListener(new keyAdapter() {
//            public void keyTyped(KeyEvent evts) {
//                char teclas;
//                teclas = evts.getKeyChar();
//                if (!Character.isLetter(teclas) && teclas != KeyEvent.VK_SPACE && teclas != KeyEvent.VK_BACK_SPACE) {
//                    evts.consume();
////                    getToolkit().beep();
//                }
//            }
//        });
//        System.out.println("keyTyped");
//
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.toString());

        if (e.getSource().equals(numero_identificacion_JTextField)) {
            numero_identificacion_JTextField.setText("");

        }

        if (e.getSource().equals(buscar_txf.getText())) {
            buscar_txf.setText("");

        }

        if (e.getSource().equals(buscar_txf.getText())) {
            buscar_txf.setText("");

        }
        if (e.getSource().equals(primer_nombre_JTextField)) {
            primer_nombre_JTextField.setText("");

        }

        if (e.getSource().equals(segundo_nombre_JTextField)) {
            segundo_nombre_JTextField.setText("");

        }

        if (e.getSource().equals(primer_apellido_JTextField)) {
            primer_apellido_JTextField.setText("");

        }
        if (e.getSource().equals(segundo_apellido_JTextField)) {
            segundo_apellido_JTextField.setText("");

        }
        if (e.getSource().equals(Nota1_JTextField)) {
            Nota1_JTextField.setText("");

        }

        if (e.getSource().equals(Nota2_JTextField)) {
            Nota2_JTextField.setText("");

        }

        if (e.getSource().equals(Nota3_JTextField)) {
            Nota3_JTextField.setText("");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(buscar_txf.getText())) {
            buscar_txf.setText("");

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent evt) {
////        char tecla;
////        tecla = evt.getKeyChar();
////
////        if (evt.getSource()==primer_nombre_JTextField ) {
//////            primer_nombre_JTextField.setText(primer_nombre_JTextField.getText().toUpperCase());
////            if (Character.isDigit(tecla)) {
////                evt.consume();
////                getToolkit().beep();
////            }
////        }
        System.out.println("#" + evt.getKeyChar());
//        if (numero_identificacion_JTextField.getText().matches("[0-9]*")) {
//
//            if (Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (buscar_txf.getText().matches("[0-9]*")) {
//
//            if (Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (Nota1_JTextField.getText().matches("[0-9]*")) {
//
//            if (Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (Nota2_JTextField.getText().matches("[0-9]*")) {
//
//            if (Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (Nota3_JTextField.getText().matches("[0-9]*")) {
//
//            if (Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (segundo_nombre_JTextField.getText().matches("[0-9]*")) {
//
//            if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (primer_apellido_JTextField.getText().matches("[0-9]*")) {
//
//            if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }
//
//        if (segundo_apellido_JTextField.getText().matches("[0-9]*")) {
//
//            if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE) {
//                evt.consume();
//                getToolkit().beep();
//            }
//        }

        System.out.println("keyTyped");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("PRESIONAR");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("SOLTAR");
    }

}
