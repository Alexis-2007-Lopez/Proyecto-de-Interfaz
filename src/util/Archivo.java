package util;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class Archivo {

    public static void guardar(DefaultTableModel modelo, File archivo)
            throws IOException {

        BufferedWriter bw =
                new BufferedWriter(new FileWriter(archivo));

        for (int i = 0; i < modelo.getRowCount(); i++) {

            for (int j = 0; j < modelo.getColumnCount(); j++) {

                bw.write(modelo.getValueAt(i, j).toString());

                if (j < modelo.getColumnCount() - 1) {
                    bw.write(",");
                }
            }

            bw.newLine();
        }

        bw.close();
    }

    public static void cargar(DefaultTableModel modelo, File archivo)
            throws IOException {

        BufferedReader br =
                new BufferedReader(new FileReader(archivo));

        modelo.setRowCount(0);

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            modelo.addRow(datos);
        }

        br.close();
    }
}
