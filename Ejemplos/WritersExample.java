package Ejemplos;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WritersExample {
    public static void main(String[] args) {
        String name1 = "Ejemplo3.txt";
        String name2 = "Ejemplo4.txt";

        String contend = "Hola, esto es un ejemplo de escritura.\n";
        int number = 42;
        // usando FileWriter
        try (FileWriter filewriter = new FileWriter(name1)) {
            filewriter.write(contend);
            filewriter.write("El número es: " + number);
        } catch (IOException e ){
            e.printStackTrace();
        }
        // usando PrintWriter
        try (PrintWriter printwriter = new PrintWriter(name2)) {
            printwriter.println(contend);
            printwriter.printf("El número es: %d%n", number);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
