package javaapplication9.src.main.java.tallernotas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionArchivo {

    public static String crear_archivo_plano(String name, String content) throws IOException {
        String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        name += ".txt";
        
      
         FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter(ruta+name);
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
          
                //escribe los datos en el archivo
                bfwriter.write( content);
            
            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
            
            e.printStackTrace();
             try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter(ruta + name
//                    "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/estudiantes4.txt"
            , true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //escribe los datos en el archivo
                bfwriter.write(content);
            
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
//        File archivo = null;
//        FileWriter fw;
//        boolean archivo_exists = archivo.exists();
//        try {
//            if (archivo_exists) {
//
//            } else {
//            }
//            archivo = new File(ruta + name);
//            fw = new FileWriter(archivo);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter salida = new PrintWriter(bw);
//            salida.write(content);
//            salida.close();
//            bw.close();
//        } catch (IOException e) {
//            return "Error: " + e.getMessage() + "\n";
//        }
        return "ARCHIVO CREADO CON EXITO...\n";
    }

    //crea el archivo en disco, recibe como parámetro la lista de estudiantes
    public static void crearArchivo(ArrayList lista,String name) {
//            ArrayList listaEstudiantes = new ArrayList();
name += ".txt";
 String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
//            flwriter = new FileWriter("/Users/DesarrolloColectivo/NetBeansProjects/tallernotas/src/main/java/tallernotas/estudiantes4.txt");
            flwriter = new FileWriter(ruta + name);

//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Estudiante estudiante : (ArrayList<Estudiante>) lista) {
                //escribe los datos en el archivo
                bfwriter.write(estudiante.getDocumentoIdentificacion() + "," + estudiante.getTipo_documento() + "," + estudiante.getPrimer_nombre() + "," + estudiante.getSegundo_nombre()
                        + "," + estudiante.getPrimer_apellido() + "," + estudiante.getSegundo_apellido() + "," + estudiante.getNota1() + "," + estudiante.getNota2() + "," + estudiante.getNota3() + "\n");
            }
            //cierra el buffer intermedio
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");

        } catch (IOException e) {
    try {
        e.printStackTrace();
        
        //además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros
        flwriter = new FileWriter(ruta + name
   , true);
        BufferedWriter bfwriter = new BufferedWriter(flwriter);
        for (Estudiante estudiante : (ArrayList<Estudiante>) lista) {
            //escribe los datos en el archivo
            bfwriter.write(estudiante.getDocumentoIdentificacion() + "," + estudiante.getTipo_documento() + "," + estudiante.getPrimer_nombre() + "," + estudiante.getSegundo_nombre()
                    + "," + estudiante.getPrimer_apellido() + "," + estudiante.getSegundo_apellido() + "," + estudiante.getNota1() + "," + estudiante.getNota2() + "," + estudiante.getNota3() + "\n");
        }
        bfwriter.close();
        System.out.println("Archivo modificado satisfactoriamente..");
    } catch (IOException ex) {
        Logger.getLogger(OperacionArchivo.class.getName()).log(Level.SEVERE, null, ex);
    }
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //añadir más estudiantes al archivo
    public static void aniadirArchivo(ArrayList lista,String name) {
        name += ".txt";
         String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        ArrayList listaEstudiantes = new ArrayList();
        FileWriter flwriter = null;
        try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter(ruta + name
//                    "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/estudiantes4.txt"
            , true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Estudiante estudiante : (ArrayList<Estudiante>) lista) {
                //escribe los datos en el archivo
                bfwriter.write(estudiante.getDocumentoIdentificacion() + "," + estudiante.getTipo_documento() + "," + estudiante.getPrimer_nombre() + "," + estudiante.getSegundo_nombre()
                        + "," + estudiante.getPrimer_apellido() + "," + estudiante.getSegundo_apellido() + "," + estudiante.getNota1() + "," + estudiante.getNota2() + "," + estudiante.getNota3() + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo modificado satisfactoriamente..");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //crea el archivo en disco, retorna la lista de estudiantes
    public static ArrayList leerArchivo(String name) {
        name += ".txt";
         String ruta = "C:/Users/ZASALAS/Documents/NetBeansProjects/JavaApplication9/src/javaapplication9/src/main/java/tallernotas/";
        // crea el flujo para leer desde el archivo
        File file = new File(ruta + name);
        ArrayList listaEstudiantes = new ArrayList<>();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (,) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma				
                delimitar.useDelimiter("\\s*,\\s*");
                Estudiante e = new Estudiante();
                e.setDocumentoIdentificacion(delimitar.next());
                e.setGenero(delimitar.next());
                e.setPrimer_nombre(delimitar.next());
                e.setSegundo_nombre(delimitar.next());
                e.setPrimer_apellido(delimitar.next());
                e.setSegundo_apellido(delimitar.next());
                e.setNota1(delimitar.next());
                e.setNota2(delimitar.next());
                e.setNota3(delimitar.next());
                listaEstudiantes.add(e);
            }
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaEstudiantes;
    }

}
