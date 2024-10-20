package Ejercicio03;
import java.util.ArrayList;
import java.util.Scanner;
public class EmpleadosVista {
    Scanner teclado;

    EmpleadosVista() {
        teclado = new Scanner(System.in);
    }
    public void menu(){
        System.out.println("Empleados APP");
        System.out.println("1. Listar empleados");
        System.out.println("2. Agregar nuevo empleado");
        System.out.println("3. Buscar empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Salir");
    }
    public void mensaje(String msj){
        System.out.println(msj);
    }
    public void mostrarListaEmpleados(ArrayList<Empleado> empleados){
        System.out.print("Lista de empleados: \n");
        for(Empleado emp: empleados){
            System.out.println(emp);
            System.out.println();
        }
    }
    public String ingresarDato(String dato){
        System.out.printf("Ingrese %s", dato);
        return teclado.nextLine();
    }
    public void imprimirEmpleado(Empleado emp){
        System.out.println(emp);
    }

}
