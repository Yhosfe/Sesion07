package Actividad05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Agenda {
    ArrayPersona lista;
    Scanner agendaFile;
    final int longLinea = 32; // No se utiliza realmente, lo puedes eliminar si no es necesario

    public Agenda() {
        String fileName = "E:\\Lp3\\Git\\Sesion07\\Actividad05\\agenda.txt"; // Corrige la ruta del archivo
        File file = new File(fileName);
        try {
            agendaFile = new Scanner(file); // Inicializa el Scanner correctamente
            lista = cargaContacto();        // Carga los contactos al iniciar la agenda
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public void bucle() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Introduzca un nombre o <Enter> para salir: ");
        try {
            while (!"".equals(nombre = sc.nextLine())) {
                lista.printArray(nombre);
                System.out.println("Introduzca un nombre o <Enter> para salir: ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String leeEntrada(Scanner entrada) {
        if (entrada.hasNextLine()) {
            return entrada.nextLine();
        } else {
            return null;  // Retorna null si no hay más líneas
        }
    }

    private Persona cargaAgenda() {
        String nombre = leeEntrada(agendaFile);
        if (nombre == null) {
            return null;
        }
        String telefono = leeEntrada(agendaFile);
        String direccion = leeEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion); // Crea un nuevo objeto Persona
    }

    private ArrayPersona cargaContacto() {
        ArrayPersona directorio = new ArrayPersona();
        Persona nuevaPersona;
        try {
            while ((nuevaPersona = cargaAgenda()) != null) { // Mientras haya contactos por leer
                directorio.addArrat(nuevaPersona);
            }
        } catch (Exception e) {
            System.out.println("Error en la carga de contactos: " + e.getMessage());
        }
        return directorio; // Retorna el directorio completo de contactos
    }

    public void mostraragenda() {
        lista.imprimirArray(); // Método para imprimir todos los contactos cargados
    }
}


