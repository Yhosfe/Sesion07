package Actividad07;

import javax.swing.*;
import java.io.IOException;

public class PruebaJFileChooser {
    public static void main(String[] args) throws IOException {
        DemoJFileChooser aplicacion = new DemoJFileChooser();
        aplicacion.setSize(400,400);
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.setVisible(true);
    }
}
