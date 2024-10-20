package Ejercicio03;

import java.io.*;
import java.util.ArrayList;

public class EmpleadosControlador {
    private EmpleadosModelo modelo;
    private EmpleadosVista vista;
    private File file;
    private String ruta;
    public EmpleadosControlador() {
        this.vista = new EmpleadosVista();
        this.modelo = new EmpleadosModelo();
        this.ruta = "Ejercicio03\\empleados.txt"; //Dirección absoluta del archivo
        this.file = new File(this.ruta);
        cargarArchivoEmpleadosModelo();

    }
    // Iniciar El Controlador
    public void iniciar() {
        String op;
        do {
            vista.menu();
            op = vista.ingresarDato("Ingrese una opcion: ");
            switch (op) {
                case "1":
                    listarEmpleados();
                    break;
                case "2":
                    agregarNuevoEmpleado();
                    guardarEmpleados();
                    break;
                case "3":
                    buscarEmpleadoControl();;
                    break;
                case "4":
                    eliminarEmpleado();
                    guardarEmpleados();
                    break;
                case "5":
                    vista.mensaje("Saliendo de Empleados APP...");
                    guardarEmpleados();
                    break;
                default:
                    vista.mensaje("Opción no válida");
            }
        } while (!op.equals("5"));
    }
    // Lectura de Empleados de un archivo
    private void cargarArchivoEmpleadosModelo() {
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
    // Permite agregar un numero Empleado
    private void agregarNuevoEmpleado() {
        try  {
            vista.mensaje("Datos de nuevo Empleado");
            int num = Integer.parseInt(vista.ingresarDato("numero: "));
            // Si no existe el empleado procedera a ingresar los datos restantes
            if (modelo.buscarEmpleado(num) == null) {
                String name = vista.ingresarDato("nombre: ");
                double salario = Double.parseDouble(vista.ingresarDato("salario: "));
                modelo.agregarEmpleado(new Empleado(num, name, salario));
                vista.mensaje("Empleado agregado");
            } else {
                vista.mensaje("El empleado: "+ num +" ya existe.");
            }
        // Captura Errores de casting
        } catch (NumberFormatException e) {
            vista.mensaje("Error: " + e.getMessage());
        }
    }
    // Buscar empleado según el numero
    public void buscarEmpleadoControl(){
        try {
            vista.mensaje("Busquede de Empleado");
            int num = Integer.parseInt(vista.ingresarDato("numero: "));
            Empleado empleadoB = modelo.buscarEmpleado(num);
            if (empleadoB == null) {
                vista.mensaje("El empleado no existe");
            } else {
                vista.imprimirEmpleado(empleadoB);
            }
        } catch (NumberFormatException e) {
            vista.mensaje("Error: " + e.getMessage());
        }
    }
    public void eliminarEmpleado(){
        try {
            vista.mensaje("Eliminando Empleado");
            int num = Integer.parseInt(vista.ingresarDato("numero: "));
            Empleado empleadoE = modelo.buscarEmpleado(num);
            if (empleadoE == null) {
                vista.mensaje("El empleado no existe");
            } else {
                modelo.eliminarEmpleado(empleadoE);
                vista.mensaje("Empleado eliminado");
            }
        } catch (NumberFormatException e) {
            vista.mensaje("Error: " + e.getMessage());
        }
    }
    public void guardarEmpleados() {
        ArrayList<Empleado> empleados = modelo.getEmpleados();
        if (empleados.size() == 0) {
            vista.mensaje("Lista de empleados vacia");
        } else {
            try (PrintWriter pw = new PrintWriter(file)){
                for (Empleado empleado : empleados){
                    pw.println(empleado.guardaDatos());
                }
            } catch (FileNotFoundException e){
                vista.mensaje("Error: " + e.getMessage());
            }
        }
    }

}
