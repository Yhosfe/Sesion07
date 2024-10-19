package SerializaciónObject;

import javax.swing.*;
import java.io.File;
public class FileChooserExample {
    public static void main(String[] args) {
        // crear un JFileChooser
        JFileChooser jfc = new JFileChooser();
        // mostrar el diálogo de selección de archivos
        int resul = jfc.showOpenDialog(null);
        // procesar la selección
        if (resul == JFileChooser.APPROVE_OPTION) {
            // obtener el archivo seleccionado
            File selectedFile = jfc.getSelectedFile();
            System.out.println("Archivo seleccionado: "+selectedFile.getAbsolutePath());
        } else {
            System.out.println("Archivo no seleccionado");
        }
    }
}
