package Ejercicio03;

import java.io.*;

public class EmpleadosControlador {
    private EmpleadosModelo modelo;
    private EmpleadosVista vista;
    private File file;
    public EmpleadosControlador() {
        vista = new EmpleadosVista();
        modelo = new EmpleadosModelo();
        cargarArchivoEmpleadosModelo();

    }
    // Iniciar El Controlador
    public void iniciar() {
        String op;
        do {
            op = vista.ingresarDato("Ingrese opcion");
            switch (op) {
                case "1":
                    listarEmpleados();
                    break;
                case "2":
                    agregarNuevoEmpleado();
                case "3":
                case "4":
                case "5":
                default:
                    vista.mensaje("Opción no válida");
            }
        } while (op !="5");
    }
    // Lectura de Empleados de un archivo
    private void cargarArchivoEmpleadosModelo() {
        String ruta = "Ejercicio03\\empleados.txt"; //Dirección absoluta del archivo
        vista.mensaje("Cargando empleados desde:" + ruta);
        File file = new File(ruta);

        // Se lanza una excepción si ocurre un error de lectura
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // splitt devide la cadena delimitada (" ") en subcadenas
                String[] datos = linea.split(" ");
                if (datos.length == 3) {
                    int num = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    double salario = Double.parseDouble(datos[2]);
                    modelo.agregarEmpleado(new Empleado(num, nombre, salario));
                }
            }
            // Msj si el archivo esta vacío
            if (file.length() ==0){
                vista.mensaje("Archivo Vacío.");
            }
        // captura errores ocurridos durante la apertura del archivo
        } catch (IOException e) {
            vista.mensaje("Error: " + e.getMessage());
        }
    }
    // envía el array de empleados a vista
    private void listarEmpleados() {
        vista.mostrarListaEmpleados(modelo.getEmpleados());
    }
    //
    private void agregarNuevoEmpleado() {
        try  {
            vista.mensaje("Datos de nuevo Empleado");
            int num = Integer.parseInt(vista.ingresarDato("Ingrese numero: "));
            String name = vista.ingresarDato("Ingrese nombre: ");
            double salario = Double.parseDouble(vista.ingresarDato("Ingrese salario: "));
            modelo.agregarEmpleado(new Empleado(num, name, salario));

        } catch (NumberFormatException e) {
            vista.mensaje("Error: " + e.getMessage());
        }
    }
}
