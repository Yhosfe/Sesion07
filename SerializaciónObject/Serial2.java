package SerializaciónObject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Serial2 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        Persona p;

        try {
            fis = new FileInputStream("SerializaciónObject\\dataPer.dat");
            entrada = new ObjectInputStream(fis);
            p = (Persona) entrada.readObject();
            System.out.println(p);
            p = (Persona) entrada.readObject();
            System.out.println(p);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
