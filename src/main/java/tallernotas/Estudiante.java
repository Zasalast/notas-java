package tallernotas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estudiante {

    private String tipo_documento;
    private String documento_identificacion;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String genero;
    private String nota1;
    private String nota2;
    private String nota3;

    public Estudiante(String tipo_documento, String documento_identificacion, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String genero, String nota1, String nota2, String nota3) {
        this.tipo_documento = tipo_documento;
        this.documento_identificacion = documento_identificacion;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.genero = genero;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    //constructor vacio
    public Estudiante() {

    }

    //getters y setters
    public String getDocumentoIdentificacion() {
        return documento_identificacion;
    }

    public void setDocumentoIdentificacion(String documento_identificacion) {
        this.documento_identificacion = documento_identificacion;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }

    private String direccion;

    void CrearGuardarArchivoEstudiante(
            String Tipo_documento,
            String DocumentoIdentificacion,
            String Genero,
            String Primer_nombre,
            String Segundo_nombre,
            String Primer_apellido,
            String Segundo_apellido,
            String Nota1,
            String Nota2,
            String Nota3
    ) {

        //      estructura Array List para guardar los objetos estudiantes
        ArrayList listaEstudiantes = new ArrayList<>();

        // Registrar    estudiante 
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setTipo_documento(Tipo_documento);
        estudiante1.setDocumentoIdentificacion(DocumentoIdentificacion);
        estudiante1.setGenero(Genero);;
        estudiante1.setPrimer_nombre(Primer_nombre);;
        estudiante1.setSegundo_nombre(Segundo_nombre);;
        estudiante1.setPrimer_apellido(Primer_apellido);;
        estudiante1.setSegundo_apellido(Segundo_apellido);;
        estudiante1.setNota1(Nota1);
        estudiante1.setNota2(Nota2);
        estudiante1.setNota3(Nota3);

        // añade un estudiante a la lista
        listaEstudiantes.add(estudiante1);

        // crea el archivo estudiantes
        OperacionArchivo.crearArchivo(listaEstudiantes);
    }

    void AgregarNuevosEstudiantes(
            String Tipo_documento,
            String DocumentoIdentificacion,
            String Genero,
            String Primer_nombre,
            String Segundo_nombre,
            String Primer_apellido,
            String Segundo_apellido,
            String Nota1,
            String Nota2,
            String Nota3
    ) {
        ArrayList listaEstudiantes = new ArrayList<>();

        // estudiante 1
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setTipo_documento(Tipo_documento);
        estudiante1.setDocumentoIdentificacion(DocumentoIdentificacion);
        estudiante1.setGenero(Genero);
        estudiante1.setPrimer_nombre(Primer_nombre);;
        estudiante1.setSegundo_nombre(Segundo_nombre);;
        estudiante1.setPrimer_apellido(Primer_apellido);;
        estudiante1.setSegundo_apellido(Segundo_apellido);;
        estudiante1.setNota1(Nota1);
        estudiante1.setNota2(Nota2);
        estudiante1.setNota3(Nota3);

        // añade un estudiante a la lista
        listaEstudiantes.add(estudiante1);

        //añade un estudiante más al archivo
        OperacionArchivo.aniadirArchivo(listaEstudiantes);
    }

    String VerEstudiantes() {
//    void VerEstudiantes() {
        String mostrar = "";
        // lista para recibir los objetos estudiantes desde el archivo
        ArrayList listaLeida = new ArrayList<>();

        // asignar a la lista los objetos
        listaLeida = OperacionArchivo.leerArchivo();
        for (Estudiante estudiante : (ArrayList<Estudiante>) listaLeida) {

            mostrar = mostrar + ("\n \n Tipo Documneto: " + estudiante.getTipo_documento() 
                            + " \n  documento identificacion: " + estudiante.getDocumentoIdentificacion()
                            + " \n   genero: " + estudiante.getGenero()
                            + " \n  primer nombre: " + estudiante.getPrimer_nombre()
                            + " \n  segundo nombre: " + estudiante.getSegundo_nombre()
                            + " \n  primer apellido: " + estudiante.getPrimer_apellido()
                            + " \n  segundo apellido: " + estudiante.getSegundo_apellido()
                            + " \n  nota 1: " + estudiante.getNota1()
                            + " \n  nota 2: " + estudiante.getNota2()
                            + " \n  nota 3: " + estudiante.getNota3()
                            + " \n ");

        }
        return mostrar;
    }

    String BuscarEstudiantes(String bus) {
              System.out.println("############   Buscar  #############");
        System.out.println("Numero cedula: " + bus);
        Operar op = new Operar();
        String resultado_busqueda = "";
        // lista para recibir los objetos estudiantes desde el archivo
        ArrayList listaLeida = new ArrayList<>();

        // asignar a la lista los objetos
        listaLeida = OperacionArchivo.leerArchivo();

        for (Estudiante estudiante : (ArrayList<Estudiante>) listaLeida) {
            resultado_busqueda = estudiante.getDocumentoIdentificacion();
            System.out.println("Documento Identificacion: " + estudiante.getDocumentoIdentificacion());
            if (bus.equals(resultado_busqueda)) {
                resultado_busqueda = ("no encontrado\n");
                System.out.println("si   entro");
                String promedio = "";
                try {
                    promedio = "" + op.PromedioEstudiante(Integer.parseInt(estudiante.getNota1()), Integer.parseInt(estudiante.getNota2()), Integer.parseInt(estudiante.getNota3()));

                    resultado_busqueda = ("\n \n Tipo Documneto: " + estudiante.getTipo_documento() 
                            + " \n  documento identificacion: " + estudiante.getDocumentoIdentificacion()
                            + " \n   genero: " + estudiante.getGenero()
                            + " \n  primer nombre: " + estudiante.getPrimer_nombre()
                            + " \n  segundo nombre: " + estudiante.getSegundo_nombre()
                            + " \n  primer apellido: " + estudiante.getPrimer_apellido()
                            + " \n  segundo apellido: " + estudiante.getSegundo_apellido()
                            + " \n  nota 1: " + estudiante.getNota1()
                            + " \n  nota 2: " + estudiante.getNota2()
                            + " \n  nota 3: " + estudiante.getNota3()
                            + " \n  promedio: " + promedio
                            + " \n ");
                    return resultado_busqueda;

                } catch (IOException ex) {
                    Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
             return resultado_busqueda=("no   entro");
            }

        }
        return resultado_busqueda;
    }
}
