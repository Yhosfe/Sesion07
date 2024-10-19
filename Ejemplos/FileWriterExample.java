package Ejemplos;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriterExample {
    public static void main(String[] args) {
        String fileName = "Ejemplo.txt";

        String[] lines = {
                "Primera línea del archivo.",
                "Segunda línea del archivo.",
                "Tercera del archivo.",
        };


        try (FileWriter writer = new FileWriter(fileName)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Se escribío.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
