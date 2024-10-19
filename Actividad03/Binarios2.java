package Actividad03;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FileOutputStream fos = null;
        DataOutputStream salida = null;

        double[][] matriz;
        int fila, columnas, i, j;
        do{
            System.out.print("Número de filas: ");
            fila = sc.nextInt();
        } while (fila <= 0);
        do{
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        matriz = new double[fila][columnas]; // se crea la matriz
        for (i = 0; i < fila ; i++) {
            for (j = 0; j < columnas; j++) {
                System.out.print("Matriz["+i+"]["+j+"]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }
        try {
            // crear el fichero de salida
            fos = new FileOutputStream("Actividad03\\matris.dat");
            salida = new DataOutputStream(fos);
            // escribir el número de filas y columnas en el fichero
            salida.writeInt(fila);
            salida.writeInt(columnas);
            // escribir la matriz en el fichero
            for (i = 0; i < fila ; i++) {
                for (j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
