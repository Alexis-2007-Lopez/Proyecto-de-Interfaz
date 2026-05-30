package main;
import view.ListaVideojuegos;

public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            new ListaVideojuegos().setVisible(true);
        });

    }
}