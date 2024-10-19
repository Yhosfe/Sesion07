package Ejemplos;

import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class PrintWriterExample {
    public static void main(String[] args) {
        String fileName = "Ejemplo2.txt";

        String[] lines = {
                "Primera Linea",
                "Segunda Linea",
                "Tercera Linea",
        };
        try (PrintWriter writer = new PrintWriter(fileName)){
            for (String line : lines){
                writer.println(line);
            }
            System.out.println("contenido escrito.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
