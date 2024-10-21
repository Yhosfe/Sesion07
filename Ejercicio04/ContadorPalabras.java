package Ejercicio04;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContadorPalabras {
    public static void main(String[] args) {
        try{
            File archivo =  null;
            // Seleciona el archivo usando JFileChooser
            JFileChooser fc = new JFileChooser();
            int seleccion = fc.showOpenDialog(null);
            if(seleccion == JFileChooser.APPROVE_OPTION){
                archivo = fc.getSelectedFile();
            } else {
                System.out.println("No se puede seleccionar el archivo");
            }
            // Si el archivo existe llama al método procesar archivo
            if (archivo != null && archivo.exists()) {
                procesarArchivo(archivo);
            } else {
                System.out.println("Archivo no encontrado o inválido.");
            }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void procesarArchivo(File file) throws IOException {
        int totalLineas = 0;
        int totalCaracteres = 0;
        int totalPalabras = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                // Sin contar el fin de línea
                totalCaracteres += linea.replace("\n", "").length();
                // Separar palabras por espacios
                String[] palabras = linea.split("\\s+");
                totalPalabras += palabras.length;

                // Contar frecuencia de palabras
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        // Obtener el valor actual o 0 si no existe y sumar 1
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

        }
        // Calcular promedio de palabras por línea
        double promedioPalabrasPorLinea = totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;

        // Mostrar resultados
        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.println("Promedio de palabras por línea: " + promedioPalabrasPorLinea);

        // Mostrar palabras más frecuentes
        mostrarPalabrasMasFrecuentes(frecuenciaPalabras);

    }
    private static void mostrarPalabrasMasFrecuentes(Map<String, Integer> frecuenciaPalabras) {
        System.out.println("Palabras más frecuentes:");
        frecuenciaPalabras.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Ordenar por frecuencia
                .limit(10) // Mostrar solo las 10 más frecuentes
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
