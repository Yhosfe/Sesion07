package Actividad06;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Serial5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        Alumno a;
        Fecha f;
        try {
            fos = new FileOutputStream("Actividad06\\alumnos.dat");
            salida = new ObjectOutputStream(fos);
            f = new Fecha(5,9,2011);
            a = new Alumno("Raul","876","Av Siempre Viva",f);
            salida.writeObject(a);
            f= new Fecha(5,9,2011);
            a = new Alumno("Elis","333","Av calle1",f);
            salida.writeObject(a);
            f= new Fecha(8,9,2011);
            a = new Alumno("Jose","111","Av calle2",f);
            salida.writeObject(a);

        } catch (IOException e) {
            System.out.println("Error1: " + e.getMessage());
        } finally {
            try{
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
            }catch (IOException e) {
                System.out.println("Error2: " + e.getMessage());
            }
        }
    }
}
