package Ejemplos;
import java.io.File;
import java.text.SimpleDateFormat;

public class FileInfo {
    public static void main(String[] args){
        File archivo1 = new File("APrueba1");

        if (archivo1.exists()){

            System.out.println("El archivo se encuentra en la Base de Datos");
            String nombreArc = archivo1.getName();
            long tamanio = archivo1.length(); // tamanio en bytes
            long ultiaMod = archivo1.lastModified();
            boolean isDirec = archivo1.isDirectory();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String ultiModifiDate = sdf.format(ultiaMod);

            System.out.println("Nombre del archivo: " + nombreArc);
            System.out.println("Tamanio del archivo: " + tamanio);
            System.out.println("Ultima modificación: " + ultiModifiDate);
            System.out.println("Es un direcotorio? " + (isDirec ? "Si": "No"));


        }else {
            System.out.println("El archivo no existe en la Base de Datos");
        }
        archivo1.delete();
    }

}
