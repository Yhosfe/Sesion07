package Ejercicio02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Gestor {
    private Map<String, Personaje> personajes;
    private File archivo;

    public Gestor(String nameFile) throws IOException {
        personajes = new HashMap<>();
        archivo = new File(nameFile);
        // Si el archivo existe leera los Pjs y los guardara en Map personajs
        if (archivo.exists()) {
            System.out.println("El Cargando Personajes");
            leerPersonajes();
        // En caso no exista creara uno y genera Personajes y actualiza el archivo
        } else {
            generarPersonajes();
            guardarPersonajes();
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
                if (datos.length == 6) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    int nivel = Integer.parseInt(datos[5]);
                    Personaje pj = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
                    // se añade al Mapa según la clave y el valor
                    personajes.put(nombre, pj);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
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
    public void agregarPersonajes(Personaje pj) throws IOException {
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
    public void filtroAtributos(){
    }
    // Personajes Predefinidos
    public void cargarPersonajesPredefinidos(){
        personajes.put("Caballero",new Personaje("Caballero",4,2,4,2));
        personajes.put("Guerrero",new Personaje("Guerrero",2,4,2,4));
        personajes.put("Arquero",new Personaje("Arquero",2,4,1,8));
    }
    // Genera tres personaje de estadisticas aleatorias
    public void cargarPersonajesAleatorios() {
        Random rand = new Random();
        String[] namePJ = {"Caballero","Guerrero","Arquero"};
        for (String nombre : namePJ) {
            int vida = rand.nextInt(5) +1;
            int ataque = rand.nextInt(5) +1;
            int defensa = rand.nextInt(5) +1;
            int alcance = rand.nextInt(5) +1;
            personajes.put(nombre, new Personaje(nombre, vida, ataque, defensa, alcance));
        }
    }
    // Seleciona de forma aleatoria entre Personajes predefenidos o de estadisticas Aleatorias
    public void generarPersonajes() {
        Random rand = new Random();
        int numRan = rand.nextInt((2));
        switch (numRan) {
            case 0:
                System.out.println("Generando Personajes Predefinidos");
                cargarPersonajesPredefinidos();
                break;
            case 1:
                System.out.println("Generando Personajes Aleatorios");
                cargarPersonajesAleatorios();
                break;
        }
    }

    //
    public void actualizarAtributo(String nombre, String atributo, int valor) {
        Personaje pj = personajes.get(nombre);
        if (pj == null) {
            System.out.println("No se encontro el personaje");
        } else {
            switch (atributo) {
                case "ataque":
                    pj.setAtaque(valor);
                    System.out.println("Atributo actualizado exitosamente.");
                    break;
                case "defensa":
                    pj.setDefensa(valor);
                    System.out.println("Atributo actualizado exitosamente.");
                    break;
                case "vida":
                    pj.setVida(valor);
                    System.out.println("Atributo actualizado exitosamente.");
                    break;
                case "alcance":
                    pj.setAlcance(valor);
                    System.out.println("Atributo actualizado exitosamente.");
                    break;
                default:
                    System.out.println("No se encontro el atributo");
                    break;
            }
        }
    }
    public void mostrarEstadisticasGenerales() {
        int promVida =0;
        int promAtaque=0;
        int promDefensa=0;
        int promAlcance=0;
        int promNivel = 0;
        for (Personaje pj : personajes.values()) {
            promVida += pj.getVida();
            promAtaque += pj.getAtaque();
            promDefensa += pj.getDefensa();
            promAlcance += pj.getAlcance();
            promNivel += pj.getNivel();
        }
        System.out.println("Estadisticas Generales");
        System.out.println("    Toral de Personakes: "+ personajes.size());
        System.out.println("    Promedio Vida: " + promVida);
        System.out.println("    Promedio Ataque: " + promAtaque);
        System.out.println("    Promedio Defensa: " + promDefensa);
        System.out.println("    Promedio Alcance: " + promAlcance);
        System.out.println("    Promedio Nivel: " + promNivel);

    }
    public void importarPersonajesExternos(String path) throws IOException {
        String ruta = "PersonajesExternos.txt";
        File fr = new File(path);
        // Se lanza una excepción si ocurre un error de lectura
        try (BufferedReader br2 = new BufferedReader(new FileReader(fr))) {
            String linea;
            while ((linea = br2.readLine()) != null) {
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
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
    }
    public void subirNivelPersonaje(String nombre) {
        Personaje personaje = personajes.get(nombre);
        if (personaje == null) {
            System.out.println("No se encontro el personaje");
        } else {
            personaje.subirNivel();
            System.out.println("Personaje subido de nivel.");
        }

    }
}
