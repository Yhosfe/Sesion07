package Ejercicio01;

import Actividad05.Persona;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Gestor {
    private Map<String, Personaje> personajes;
    private File archivo;

    public Gestor(String nameFile) throws IOException {
        personajes = new HashMap<>();
        archivo = new File(nameFile);
        // Si el archivo existe leera los Pjs y los guardara en Map personajs
        if (archivo.exists()) {
            leerPersonajes();
        }
    }
    //Lectura de PJs desde el archivo
    private void leerPersonajes() throws IOException {
        // Se lanza una excepción si ocurre un error de lectura
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // splitt devide la cadena delimitada (" ") en subcadenas
                String[] datos = linea.split(" ");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    Personaje pj = new Personaje(nombre, vida, ataque, defensa, alcance);
                    // se añade al Mapa según la clave y el valor
                    personajes.put(nombre, pj);
                }
            }
        }
    }
    // Guardar personajes en el archivo
    private void guardarPersonajes() throws IOException {
        try (PrintWriter pw = new PrintWriter(archivo)) {
            for (Personaje pj : personajes.values()) {
                pw.println(pj.toString());
            }
        }
    }
    // Agregar nuevo personaje
    public void agergarPersonajes(Personaje pj) throws IOException {
        if (personajes.containsKey(pj.getNombre())) {
            System.out.println("El personaje ya existe.");
        } else {
            personajes.put(pj.getNombre(), pj);
            guardarPersonajes();
            System.out.println("Personaje agregado exitosamente.");
        }
    }
    public void modificarPersonaje(String nombre,int vida, int ataque, int defensa, int alcance) throws IOException {
        Personaje pj = personajes.get(nombre);
        if (pj == null) {
            System.out.println("No se encontro el personaje");
        } else {
          pj.setVida(vida);
          pj.setAtaque(ataque);
          pj.setDefensa(defensa);
          pj.setAlcance(alcance);
          guardarPersonajes();
          System.out.println("PJ modificado exitosamente.");
        }
    }
    public void eliminarPersonaje(String nombre) throws IOException {
        // verifica si en nombre no está vacio y luego realizar el remove
        if (personajes.remove(nombre) != null) {
            guardarPersonajes();
            System.out.println("Personaje eliminado exitosamente.");
        } else {
            System.out.println("No se encontro el personaje");
        }
    }
    public void listarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay Personajes");
        } else {

            for (Personaje pj : personajes.values()) {
                System.out.println(pj.toString());
            }
        }
    }
}
