package Ejemplos;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class FileReaderExample {
    public static void main(String[] args) {
        String filename = "Ejemplo.txt";
        BufferedReader bff = null;

        try{
            FileReader fr = new FileReader(filename);
            bff = new BufferedReader(fr);
            String line;
            System.out.println("Conenido del archivo: " + filename);
            while ((line = bff.readLine()) != null){
                System.out.println(line);
            }
            bff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
