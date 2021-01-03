package javaapplication9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioEstudiantes extends JFrame implements ActionListener, MouseListener {

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
//    private Guardar_archivo_plano guardar_log;
    private JLabel  Nota1_JLabel_color, Nota2_JLabel_color, Nota3_JLabel_color, Nota, Informacion_personal_lbl, informe_JLabel, ingrese_notas;
    private JButton btn_salir,Buscar, reset, clear, btn_registrar;
    private JTextField buscar, numero_identificacion_JTextField, primer_nombre_JTextField, segundo_nombre_JTextField, primer_apellido_JTextField, segundo_apellido_JTextField, Nota1_JComboBox, Nota2_JComboBox, Nota3_JComboBox;
    private JTextArea informe_estudiante_JTextArea, informe_JTextArea;
    JRadioButton cedula_ciudadania, tarjeta_identidad, cedula_extranjeria, masculino, femenido, Otro;
    Random random = new Random();
    private JComboBox tipo_documento_JComboBox, genero_JComboBox;
    JSpinner spinner;
//    JList tipo_documento_JList, genero_JList;

    JPanel jpMenu, jp_center_notas, jp_nombre_estudiante, jp_documento, jp_informe_notas, jp_cantidad, jp_iingreso_notas, jp_center_panel, jp6, jp_controles;
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
        JComboComponents();
        PanelBuscar(0, 0, alto, ancho);
        JTextAreaComponents();
        CenterPanel(0, 0, ancho, alto);

        PanelMenu(0, 0, 200, 200);
        ControlesPanelFlowLayout(0, 0, 600, 80);
        Panel_Informe(0, 0, 300, 100);

        DatosPersonalesPanelGridLayout(0, 0, 600, 80);
        jp_center_panel.add(jp_center_notas, BorderLayout.CENTER);

        setVisible(Visible_ventana);
    }

    public void Panel_Informe(int x, int y, int alt, int ancho) {
        JTextAreaComponents();
        JLabelComponents();
        jp_iingreso_notas = new JPanel();
//        contentPane = getContentPane();

        jp_iingreso_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_iingreso_notas.setBackground(Color.PINK);
        jp_iingreso_notas.setLayout(new GridLayout(2, 3));
//        jp_informe.setLayout(new GridLayout(4, 0, 10, 100));
//        jp_informe.setBackground(Color.LIGHT_GRAY);
        ingrese_notas = new JLabel("Ingrese Notas");

        jp_iingreso_notas.add(ingrese_notas);
        jp_iingreso_notas.add(Nota1_JComboBox);
        jp_iingreso_notas.add(Nota2_JComboBox);
        jp_iingreso_notas.add(Nota3_JComboBox);

        jp_iingreso_notas.add(Nota1_JLabel_color);
        jp_iingreso_notas.add(Nota2_JLabel_color);
        jp_iingreso_notas.add(Nota3_JLabel_color);
//        jp_informe.setBorder(BorderFactory.createLineBorder(Color.blue));
        jp_iingreso_notas.add(Nota);
        jp_center_notas.add(jp_iingreso_notas);
    }

    public void CenterPanel(int x, int y, int alt, int ancho) {
        jp_center_panel = new JPanel();
//        Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
//        jp_center_panel.setBorder(myRaisedBorder);
        jp_center_panel.setLayout(new BorderLayout(5, 5));
        jp_center_panel.setBackground(Color.red);

        jp_center_panel.setBounds(x, y, alt, ancho);
        jp_center_panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        this.add(jp_center_panel);
    }

    public void CenterPanelNotas(int x, int y, int alt, int ancho) {
        jp_center_notas = new JPanel();
//        Border myRaisedBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
//        jp_center_panel.setBorder(myRaisedBorder);
        jp_center_notas.setLayout(new GridLayout(2, 2));
        jp_center_notas.setBackground(Color.PINK);

        jp_center_notas.setBounds(x, y, alt, ancho);
        jp_center_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

    }

    public void PanelMenu(int x, int y, int alt, int ancho) {
        DocumentoEstudiantesPanelFlowLayout(0, 0, 200, 200);
        NombreEstudiantePanelFlowLayout(0, 0, 200, 200);
        jpMenu = new JPanel();
        jpMenu.setLayout(new BorderLayout());
        jpMenu.setBounds(x, y, alt, ancho);
        jpMenu.setBackground(Color.black);
        jpMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        jpMenu.add(jp_documento, BorderLayout.NORTH);
        jpMenu.add(jp_nombre_estudiante, BorderLayout.CENTER);
        jp_center_panel.add(jpMenu, BorderLayout.WEST);
    }

    public void DocumentoEstudiantesPanelFlowLayout(int x, int y, int alt, int ancho) {
        JTextFieldComponents();

        jp_documento = new JPanel();
        Informacion_personal_lbl = new JLabel("Ingrese Datos Personales");
        jp_documento.setLayout(new GridLayout(8, 0, 10, 10));
        jp_documento.setBounds(x, y, alt, ancho);
        jp_documento.setBackground(Color.PINK);
        jp_documento.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jp_documento.add(Informacion_personal_lbl);

        jp_documento.add(cedula_ciudadania);
        jp_documento.add(tarjeta_identidad);
        jp_documento.add(cedula_extranjeria);

        jp_documento.add(numero_identificacion_JTextField);
        jp_documento.add(masculino);
        jp_documento.add(femenido);
        jp_documento.add(Otro);

    }

    public void NombreEstudiantePanelFlowLayout(int x, int y, int alt, int ancho) {

        jp_nombre_estudiante = new JPanel();
        jp_nombre_estudiante.setLayout(new GridLayout(5, 0, 0, 0));
        jp_nombre_estudiante.setBounds(x, y, alt, ancho);
        jp_nombre_estudiante.setBackground(Color.PINK);
        jp_nombre_estudiante.setBorder(BorderFactory.createLineBorder(Color.black));
//        jp_salsa.add(Salsas_JLabel);
        jp_nombre_estudiante.add(primer_nombre_JTextField);
        jp_nombre_estudiante.add(segundo_nombre_JTextField);
        jp_nombre_estudiante.add(primer_apellido_JTextField);
        jp_nombre_estudiante.add(segundo_apellido_JTextField);
    }

    public void DatosPersonalesPanelGridLayout(int x, int y, int alt, int ancho) {

        jp_informe_notas = new JPanel();
        jp_informe_notas.setLayout(new GridLayout(3, 2, 0, 0));
        jp_informe_notas.setBounds(x, y, alt, ancho);
        jp_informe_notas.setBackground(Color.PINK);
        jp_informe_notas.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        informe_JLabel = new JLabel("Informe estudiante");

        jp_informe_notas.add(informe_JLabel);
        jp_informe_notas.add(pane);
//        jp_center_panel.add(jp_informe_notas, BorderLayout.CENTER);

        jp_center_notas.add(jp_informe_notas);
    }

    public void PanelBuscar(int x, int y, int alt, int ancho) {

        Buscar = new JButton("Buscar");
        Buscar.addActionListener(this);
        jp_cantidad = new JPanel();
        jp_cantidad.setLayout(new GridLayout(2, 2, 0, 0));
        jp_cantidad.setBounds(x, y, alt, ancho);
        jp_cantidad.setBackground(Color.WHITE);
        jp_cantidad.setBorder(BorderFactory.createLineBorder(Color.black));
        jp_cantidad.add(Buscar);
        jp_cantidad.add(buscar);

    }

    public void ControlesPanelFlowLayout(int x, int y, int alt, int ancho) {

        JComboComponents();
        jp_controles = new JPanel();
        jp_controles.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 1));
        jp_controles.setBounds(x, y, alt, ancho);
        jp_controles.setBackground(Color.pink);
        jp_controles.setBorder(BorderFactory.createLineBorder(Color.black));
        jp_center_panel.add(jp_cantidad, BorderLayout.PAGE_START);

        jp_controles.add(reset);
        jp_controles.add(btn_registrar);
        jp_controles.add(clear);
        jp_controles.add(btn_salir);
        jp_center_panel.add(jp_controles, BorderLayout.PAGE_END);
    }

    void JTextAreaComponents() {

        informe_estudiante_JTextArea = new JTextArea();

        informe_estudiante_JTextArea.setLineWrap(true);

        informe_estudiante_JTextArea.setEditable(false);
        informe_estudiante_JTextArea.setBounds(10, 5, 100, 100);
        pane_estudiante = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        informe_JTextArea = new JTextArea();

        informe_JTextArea.setLineWrap(true);

        informe_JTextArea.setEditable(false);
        informe_JTextArea.setBounds(10, 5, 100, 100);
        pane = new JScrollPane(informe_JTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    void JTextFieldComponents() {
        numero_identificacion_JTextField = new JTextField();
        numero_identificacion_JTextField.setText("# identificacion");
        numero_identificacion_JTextField.setEditable(true);
        numero_identificacion_JTextField.addMouseListener(this);

        primer_nombre_JTextField = new JTextField();
        primer_nombre_JTextField.setText("primer nombre ");
        primer_nombre_JTextField.setEditable(true);
        primer_nombre_JTextField.addMouseListener(this);

        segundo_nombre_JTextField = new JTextField();
        segundo_nombre_JTextField.setText("segundo nombre");
        segundo_nombre_JTextField.setEditable(true);
        segundo_nombre_JTextField.addMouseListener(this);

        primer_apellido_JTextField = new JTextField();
        primer_apellido_JTextField.setText("primer apellido");
        primer_apellido_JTextField.setEditable(true);
        primer_apellido_JTextField.addMouseListener(this);

        segundo_apellido_JTextField = new JTextField();
        segundo_apellido_JTextField.setText(" segundo apellido");
        segundo_apellido_JTextField.setEditable(true);
        segundo_apellido_JTextField.addMouseListener(this);

    }

    void JLabelComponents() {
//
        Nota1_JLabel_color = new JLabel("");
        Nota1_JLabel_color.setBounds(0, 0, jp_center_panel.getWidth() / 2, jp_center_panel.getHeight() / 3);
        Nota2_JLabel_color = new JLabel("");
        Nota2_JLabel_color.setBounds(0, 0, jp_center_panel.getWidth() / 2, jp_center_panel.getHeight() / 3);
        Nota3_JLabel_color = new JLabel("");
        Nota3_JLabel_color.setBounds(0, 0, jp_center_panel.getWidth() / 2, jp_center_panel.getHeight() / 3);
        Nota = new JLabel("Los valores deben estar entre 0 y 5");
        Nota.setBounds(0, 0, jp_center_panel.getWidth() / 2, jp_center_panel.getHeight() / 3);

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

        Nota1_JComboBox = new JTextField();
        Nota1_JComboBox.setText("nota 1");
        Nota1_JComboBox.setEditable(true);
        Nota1_JComboBox.addMouseListener(this);

        Nota2_JComboBox = new JTextField();
        Nota2_JComboBox.setText("nota2");
        Nota2_JComboBox.setEditable(true);
        Nota2_JComboBox.addMouseListener(this);

        Nota3_JComboBox = new JTextField();
        Nota3_JComboBox.setText("nota 3");
        Nota3_JComboBox.setEditable(true);
        Nota3_JComboBox.addMouseListener(this);

        buscar = new JTextField();
        buscar.setText("Buscar");
        buscar.setEditable(true);
        buscar.addMouseListener(this);

    }

    void Components() {

        reset = new JButton("reset");

        reset.setBounds(50, 150, 200, 30);
        reset.addActionListener(this);

        btn_registrar = new JButton("Registrar");

        btn_registrar.setBounds(50, 150, 200, 30);
        btn_registrar.addActionListener(this);

        clear = new JButton("clear");

        clear.setBounds(50, 100, 200, 30);
        clear.addActionListener(this);

        btn_salir = new JButton("Salir");

        btn_salir.setBounds(10, 200, 200, 200);
        btn_salir.addActionListener(this);

    }

    double PromedioEstudiante(double nota_1, double nota_2, double nota_3) throws IOException {
        double promedio = 0;
        try {
            promedio = (nota_1 + nota_2 + nota_3) / 3;
        } catch (Exception exxx) {
            String mens = "" + exxx;

////////            guardar_log.crear_archivo_plano("ErrorLog", mens);
        }

        return promedio;
    }

    ////         Acciones Botones  //////
    @Override
    public void actionPerformed(ActionEvent e) {
          Estudiante estudiante1 = new Estudiante();
        System.out.println(e.getSource()==cedula_ciudadania);
        if (e.getSource() == btn_registrar) {
         estudiante1.setDocumentoIdentificacion(numero_identificacion_JTextField.getText());
           estudiante1.setPrimer_nombre( primer_nombre_JTextField.getText());
           estudiante1.setSegundo_nombre(segundo_nombre_JTextField.getText()); 
                 estudiante1.setPrimer_apellido(primer_apellido_JTextField.getText()); 
                 estudiante1.setSegundo_apellido(segundo_apellido_JTextField.getText());
              
            if (Double.parseDouble(Nota1_JComboBox.getText()) >= 0 && Double.parseDouble(Nota1_JComboBox.getText()) <= 5) {
                
                estudiante1.setNota1(Nota1_JComboBox.getText());
                Nota1_JLabel_color.setBackground(Color.GREEN);

                Nota1_JLabel_color.setText("Nota 1 Valida     " + Double.parseDouble(Nota1_JComboBox.getText()));
                nota1 = Double.parseDouble(Nota1_JComboBox.getText());
                Nota1_JLabel_color.setVisible(true);
                informe_JTextArea.setText(informe_JTextArea.getText() + nota1);
            } else {
                Nota1_JLabel_color.setBackground(Color.RED);
                Nota1_JLabel_color.setText("Nota 1 no Valida");
                Nota1_JLabel_color.setVisible(true);
                nota1 = 0;

            }

            if (Double.parseDouble(Nota2_JComboBox.getText()) >= 0 && Double.parseDouble(Nota2_JComboBox.getText()) <= 5) {
                Nota2_JLabel_color.setBackground(Color.GREEN);
                nota2 = Double.parseDouble(Nota2_JComboBox.getText());
                Nota2_JLabel_color.setText("Nota 2 Valida   ");
                Nota2_JLabel_color.setVisible(true);
                informe_JTextArea.setText(informe_JTextArea.getText() + nota2);
            } else {
                Nota2_JLabel_color.setBackground(Color.RED);
                Nota2_JLabel_color.setText("Nota 2 no Valida  ");
                Nota2_JLabel_color.setVisible(true);
                nota2 = 0;

            }
            if (Double.parseDouble(Nota3_JComboBox.getText()) >= 0 || Double.parseDouble(Nota3_JComboBox.getText()) <= 5) {
                Nota3_JLabel_color.setBackground(Color.GREEN);
                nota3 = Double.parseDouble(Nota3_JComboBox.getText());
                informe_JTextArea.setText(informe_JTextArea.getText() + nota3);
                Nota3_JLabel_color.setText("Nota 3 Valida");
                Nota3_JLabel_color.setVisible(true);

            } else {
                nota3 = 0;
                Nota3_JLabel_color.setBackground(Color.RED);
                Nota3_JLabel_color.setText("Nota 3 no Valida");
                Nota3_JLabel_color.setVisible(true);

            }

            if (cedula_ciudadania.isSelected()==true || tarjeta_identidad.isSelected() || cedula_extranjeria.isSelected()) {
                if (cedula_ciudadania.isSelected()) {
                    System.out.println("ciudadanía");
                    setInforme_estudiante(getInforme_estudiante() + "\n  cedula de ciudadanía");
                } else if (tarjeta_identidad.isSelected()) {
                    setInforme_estudiante(getInforme_estudiante() + "tarjeta de identidad");
                    System.out.println("identidad");
                } else if (cedula_extranjeria.isSelected()) {
                    System.out.println("extranjeria");
                    setInforme_estudiante(getInforme_estudiante() + "cedula de extranjeria");
                }


            }else{
                System.out.println("no se seleccion tipo documento");
                System.out.println(cedula_ciudadania.isSelected());
                 System.out.println(tarjeta_identidad);
                  System.out.println(cedula_extranjeria.isSelected());
            }

            if (masculino.isSelected() || femenido.isSelected() || Otro.isSelected()) {
                if (masculino.isSelected()) {
                    System.out.println("masculino");
                    setInforme_estudiante(getInforme_estudiante() + "\n  cedula de ciudadanía");
                } else if (femenido.isSelected()) {
                    setInforme_estudiante(getInforme_estudiante() + "\n tarjeta de identidad");
                    System.out.println("femenido");
                } else if (Otro.isSelected()) {
                    System.out.println("Otro");
                    setInforme_estudiante(getInforme_estudiante() + "\n cedula de extranjeria");
                }


            }else{
                System.out.println("no se seleccion genero");
            }

            try {
                setInforme_estudiante(getInforme_estudiante() + "\n  " + nota1 + "\n  " + nota2 + "\n  " + nota3 + "\n  " + PromedioEstudiante(nota1, nota2, nota3));
            } catch (IOException ex) {
                String mens = "" + ex;

                nombrearchivo = "ErrorLog" + "";

//////////                try {
//////////                    guardar_log.crear_archivo_plano(nombrearchivo, mens);
//////////                } catch (IOException ex1) {
//////////                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex1);
//////////                }
            }
            informe_JTextArea.setText(getInforme_estudiante());

//           if (file.exists()) {
//
//        }else{
//
//           }
//           estudiante1.CrearGuardarArchivoEstudiante("Cedula",numero_identificacion_JTextField.getText(),"genero",primer_nombre_JTextField.getText(),segundo_nombre_JTextField.getText(),primer_apellido_JTextField.getText(),segundo_apellido_JTextField.getText(),""+nota1,""+nota2,""+nota3);
             estudiante1.AgregarNuevosEstudiantes("Cedula",numero_identificacion_JTextField.getText(),"masculino",primer_nombre_JTextField.getText(),segundo_nombre_JTextField.getText(),primer_apellido_JTextField.getText(),segundo_apellido_JTextField.getText(),""+nota1,""+nota2,""+nota3);



        }

        if (e.getSource() == reset) {

            informe_JTextArea.setText("");
        } else if (e.getSource() == clear) {

        } else if (e.getSource() == btn_salir) {
            System.exit(0);
        }else if (e.getSource() == Buscar) {
//                estudiante1.VerEstudiantes();
                System.out.println("#############   Buscar  #############");
                estudiante1.BuscarEstudiantes(buscar.getText());
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.toString());
        if (e.getSource().equals(numero_identificacion_JTextField)) {
            numero_identificacion_JTextField.setText("");

        }
        if (e.getSource().equals(primer_nombre_JTextField)) {
            primer_nombre_JTextField.setText("");

        }
        if (e.getSource().equals(buscar)) {
            buscar.setText("");

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
        if (e.getSource().equals(Nota1_JComboBox)) {
            Nota1_JComboBox.setText("");

        }

        if (e.getSource().equals(Nota2_JComboBox)) {
            Nota2_JComboBox.setText("");

        }

        if (e.getSource().equals(Nota3_JComboBox)) {
            Nota3_JComboBox.setText("");

        }

        if (e.getSource().equals(buscar)) {
            buscar.setText("");

        }
//  else{
//      primer_nombre_JTextField.setText("");
//        segundo_nombre_JTextField.setText("");
//        primer_apellido_JTextField.setText("");
//                segundo_apellido_JTextField.setText("");
//                Nota1_JComboBox.setText("");
//        Nota2_JComboBox.setText("");
//                        Nota3_JComboBox.setText("");
//                                buscar.setText("");
//    }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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

}
