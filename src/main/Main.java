package main;
import vista.ListaVideojuegos;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            new ListaVideojuegos().setVisible(true);
        });

    }
}