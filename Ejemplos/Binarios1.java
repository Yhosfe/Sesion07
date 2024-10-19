package Ejemplos;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Binarios1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            fos = new FileOutputStream("datos.dat");
            salida = new DataOutputStream(fos);

            System.out.print("Introduce número entero. -1 para acabar: ");
            n = sc.nextInt();
            while (n!= -1){
                salida.writeInt(n);
                System.out.print("Introduce número entero. -1 para acabar: ");
                n = sc.nextInt();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if ( fos != null ) {
                    fos.close();
                }
                if ( salida != null ) {
                    salida.close();
                }

            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
