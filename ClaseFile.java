package javaapplication9;
import java.io.File;
import java.util.ArrayList;
public class ClaseFile {

    public static void main(String[] args) {
ArrayList listaEstudiantes = new ArrayList();
      // crea un objeto file, el constructor recibe la
// ruta del archivo del cual quiero saber sus propiedades
File file = new File("C:\\Users\\ZASALAS\\Documents\\NetBeansProjects\\TallerNotasEstudiante\\src\\tallernotasestudiante\\estudiantes.txt");
// para saber si el archivo no existe, devuelve true o false
System.out.println(file.exists());
// para saber si directorio, devuelve true o false
System.out.println(file.isDirectory());
// para saber la fecha de modificación
System.out.println(file.lastModified());
// para saber el nombre del archivo
System.out.println(file.getName());
// para saber la ruta
System.out.println(file.getPath());
// para saber el tamaño en bytes que ocupa en disco
System.out.println(file.length());
// para saber si es de lectura, devuelve true o false
System.out.println(file.canRead());
// para saber si es de escritura, devuelve true o false
System.out.println(file.canRead());
// para saber el tamaño en bytes que ocupa en disco
System.out.println(file.length());
// crea un directorio en disco, devuelve true o false, para esto la ruta no debe ser .txt
// ejemplo: "C:\\archivos\\estudiantes" y crea el directorio estudiantes
System.out.println(file.mkdir());

// elimina el arhivo o directorio (debe estar vacio), devuelve true o false
// System.out.println(file.delete());

// si fuera un directorio, para saber los arhivos que contiene
for (String string : file.list())
  System.out.println(string);
    }

}
