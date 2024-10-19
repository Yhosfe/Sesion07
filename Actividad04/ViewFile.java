package Actividad04;

import javax.swing.*;

public class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String s) {
        super("Mostrando el contenido de un archivo");
        areaTexto = new JTextArea(s,5,40);
        add(areaTexto);
    }
}
