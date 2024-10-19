package Ejemplos;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileScannerExample {
    public static void main(String[] args) {
        String fileName = "Ejemplo.txt";
        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)){
            System.out.println("Contenido del archivo: " + sc.nextLine());
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
