package Ejemplos;
import java.io.*;

public class BinariosLectur {
    public static void main(String[] args) {
        FileInputStream fiss = null;
        DataInputStream entrada = null;
        int n;
        try{
            fiss = new FileInputStream("datos.dat");
            entrada = new DataInputStream(fiss);
            while (true) {
                n = entrada.readInt();
                System.out.println(n);
            }
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch(EOFException e) {
            System.out.println("Fin de fichero");
        } catch(IOException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fiss != null) {
                    fiss.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
