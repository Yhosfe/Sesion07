package Actividad01;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba el nombre del archivo o directorio: ");
        // crear objeto path con base en la entrada del usuario
        Path ruta = Paths.get(sc.nextLine());
        if (Files.exists(ruta)) {
            // mostrar información de archivo (o direcctorio)
            System.out.printf("%n%s existe%n", ruta.getFileName());
            System.out.printf("%s un directorio%n", Files.isDirectory(ruta) ? "Es": "No es");
            System.out.printf("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es": "No es");
            System.out.printf("Fecha de ultima modificación: %s%n", Files.getLastModifiedTime(ruta));
            System.out.printf("Tamanio : %s%n", Files.size(ruta));
            System.out.printf("Ruta: %s%n", ruta);
            System.out.printf("Ruta Absoluta: %s%n", ruta.toAbsolutePath());
            if (Files.isDirectory(ruta)) {
                System.out.printf("%nContenido del directorio:%n");
                //objeto para iterar en el contenido de un directorio
                DirectoryStream<Path> FlujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p: FlujoDirectorio) {
                    System.out.println(p);
                }
            }
        }
    }
}
