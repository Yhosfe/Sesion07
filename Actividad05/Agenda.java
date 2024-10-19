package Actividad05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Agenda {
    ArrayPersona lista;
    FileInputStream agendaFile;
    final int longLinea = 32;

    public Agenda() {
        lista = cargaContactor();
    }
    public void bucle() {
        String nombre;
        System.out.println("Introduzca un nombre o <Enter>: ");
        try {
            while (!"".equals(nombre = leeEntrada(System.in))) {
                lista.printArray(nombre);
                System.out.println("Introduzca un nombre o <Enter>1: ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private String leeEntrada(InputStream in) throws IOException {
        byte chars[] = new byte[longLinea];
        int contador = 0;
        while (contador < longLinea && (chars[contador++] =(byte) in.read()) != '\n')
            if (chars[contador-1] == -1)
                return null;
        return (new String(chars, 0, contador-1));
    }
    private Persona cargaAgenda() throws IOException {
        String nombre = leeEntrada(agendaFile);
        if (nombre == null)
            return null;
        String telefono = leeEntrada(agendaFile);
        String direccion = leeEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion);
    }
    private ArrayPersona cargaContactor() {
        ArrayPersona directorio = new ArrayPersona();
        Persona nuevaPersona;
        try {
            agendaFile = new FileInputStream("\\Actividad05\\agenta,txt");
            while(true) {
                nuevaPersona = cargaAgenda();
                if (nuevaPersona == null)
                    return (directorio);
                directorio.addArrat(nuevaPersona);
            }
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Error en la carga de contactos");
            System.exit(1);
        }
        return (directorio);
    }
}
