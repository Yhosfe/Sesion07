package SerializaciónObject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial1 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Persona p;

        try {
            fos = new FileOutputStream("SerializaciónObject\\dataPer.dat");
            salida = new ObjectOutputStream(fos);

            p = new Persona("ander",23,"aea");

            salida.writeObject(p);

            p = new Persona("yhosfer",24,"alo");
            salida.writeObject(p);
        } catch (FileNotFoundException e) {
            System.out.println("1: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("2: "+e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("3: "+e.getMessage());
            }
        }
    }


}


