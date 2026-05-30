package util;
import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reloj extends Thread {

    private JLabel label;

    public Reloj(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {

            LocalTime hora = LocalTime.now();

            label.setText("Hora: " + hora.format(formato));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}