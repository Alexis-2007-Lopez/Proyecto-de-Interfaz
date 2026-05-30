package vista;
import modelo.Videojuego;
import controlador.Archivo;
import controlador.Reloj;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;

public class ListaVideojuegos extends JFrame {

    private JTextField txtNombre;
    private JTextField txtGenero;
    private JTextField txtPlataforma;
    private JTextField txtBuscar;

    private JTextArea areaDescripcion;

    private JComboBox<String> comboEnLinea;

    private JTable tabla;
    private DefaultTableModel modelo;

    private JLabel relojLabel;

    private JRadioButton radioFisico;
    private JRadioButton radioDigital;

    private JCheckBox checkFavorito;

    public ListaVideojuegos() {

        setTitle("Lista de Videojuegos");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JMenuBar barra = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemCargar = new JMenuItem("Cargar");
        JMenuItem itemColor = new JMenuItem("Cambiar Color");

        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemCargar);
        menuArchivo.add(itemColor);
        barra.add(menuArchivo);
        setJMenuBar(barra);
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(null);
        panelSuperior.setBackground(new Color(203, 139, 242));
        panelSuperior.setBounds(0, 0, 1000, 300);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        panelSuperior.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 150, 25);
        panelSuperior.add(txtNombre);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(280, 20, 80, 25);
        panelSuperior.add(lblGenero);

        txtGenero = new JTextField();
        txtGenero.setBounds(350, 20, 150, 25);
        panelSuperior.add(txtGenero);

        JLabel lblPlataforma = new JLabel("Plataforma:");
        lblPlataforma.setBounds(530, 20, 100, 25);
        panelSuperior.add(lblPlataforma);

        txtPlataforma = new JTextField();
        txtPlataforma.setBounds(620, 20, 150, 25);
        panelSuperior.add(txtPlataforma);

        JLabel lblEnLinea = new JLabel("En línea:");
        lblEnLinea.setBounds(20, 70, 80, 25);
        panelSuperior.add(lblEnLinea);

        comboEnLinea = new JComboBox<>(new String[]{"Sí", "No"});
        comboEnLinea.setBounds(100, 70, 100, 25);
        panelSuperior.add(comboEnLinea);

        radioFisico = new JRadioButton("Físico");
        radioFisico.setBounds(280, 70, 100, 25);

        radioDigital = new JRadioButton("Digital");
        radioDigital.setBounds(390, 70, 100, 25);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioFisico);
        grupo.add(radioDigital);

        panelSuperior.add(radioFisico);
        panelSuperior.add(radioDigital);

        checkFavorito = new JCheckBox("Favorito");
        checkFavorito.setBounds(530, 70, 120, 25);
        panelSuperior.add(checkFavorito);

        JLabel lblDescripcion =
                new JLabel("Descripción:");
        lblDescripcion.setBounds(20, 120, 100, 25);

        panelSuperior.add(lblDescripcion);

        areaDescripcion = new JTextArea();

        JScrollPane scrollArea =
                new JScrollPane(areaDescripcion);

        scrollArea.setBounds(120, 120, 300, 80);

        panelSuperior.add(scrollArea);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(470, 130, 120, 35);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(610, 130, 120, 35);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(750, 130, 120, 35);

        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnModificar);
        panelSuperior.add(btnEliminar);

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(20, 230, 80, 25);

        panelSuperior.add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(100, 230, 200, 25);

        panelSuperior.add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(320, 230, 120, 30);

        panelSuperior.add(btnBuscar);
        relojLabel = new JLabel();

        relojLabel.setBounds(800, 230, 150, 30);

        panelSuperior.add(relojLabel);

        add(panelSuperior);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(null);

        panelInferior.setBackground(
                new Color(123, 31, 162));

        panelInferior.setBounds(0, 300, 1000, 350);

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Género");
        modelo.addColumn("Plataforma");
        modelo.addColumn("En línea");
        modelo.addColumn("Descripción");
        tabla = new JTable(modelo);
        tabla.getSelectionModel().addListSelectionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {

                txtNombre.setText(
                        modelo.getValueAt(fila, 0).toString());

                txtGenero.setText(
                        modelo.getValueAt(fila, 1).toString());

                txtPlataforma.setText(
                        modelo.getValueAt(fila, 2).toString());

                comboEnLinea.setSelectedItem(
                        modelo.getValueAt(fila, 3).toString());

                areaDescripcion.setText(
                        modelo.getValueAt(fila, 4).toString());
            }
        });

        JScrollPane scrollTabla =
                new JScrollPane(tabla);

        scrollTabla.setBounds(50, 30, 850, 220);

        panelInferior.add(scrollTabla);

        add(panelInferior);

        Reloj reloj = new Reloj(relojLabel);
        reloj.start();

        btnAgregar.addActionListener(e -> {

            Videojuego videojuego =
                    new Videojuego(
                            txtNombre.getText(),
                            txtGenero.getText(),
                            txtPlataforma.getText(),
                            comboEnLinea.getSelectedItem().toString()
                    );

            modelo.addRow(new Object[]{
                    videojuego.getNombre(),
                    videojuego.getGenero(),
                    videojuego.getPlataforma(),
                    videojuego.getEnLinea(),
                    areaDescripcion.getText()
            });

            limpiarCampos();
        });

        btnModificar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {

                modelo.setValueAt(txtNombre.getText(), fila, 0);
                modelo.setValueAt(txtGenero.getText(), fila, 1);
                modelo.setValueAt(txtPlataforma.getText(), fila, 2);
                modelo.setValueAt(comboEnLinea.getSelectedItem(), fila, 3);
                modelo.setValueAt(areaDescripcion.getText(), fila, 4);

                JOptionPane.showMessageDialog(
                        null,
                        "Registro modificado correctamente"
                );

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Selecciona una fila"
                );
            }
        });

        btnEliminar.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {

                int opcion =
                        JOptionPane.showConfirmDialog(
                                null,
                                "¿Eliminar videojuego?",
                                "Confirmación",
                                JOptionPane.YES_NO_OPTION
                        );

                if (opcion == JOptionPane.YES_OPTION) {
                    modelo.removeRow(fila);
                }
            }
        });

        btnBuscar.addActionListener(e -> {

            String texto = txtBuscar.getText();

            TableRowSorter<DefaultTableModel> sorter =
                    new TableRowSorter<>(modelo);

            tabla.setRowSorter(sorter);

            sorter.setRowFilter(
                    RowFilter.regexFilter(texto)
            );
        });

        itemGuardar.addActionListener(e -> {

            JFileChooser chooser =
                    new JFileChooser();

            int opcion =
                    chooser.showSaveDialog(null);

            if (opcion ==
                    JFileChooser.APPROVE_OPTION) {

                File archivo =
                        chooser.getSelectedFile();

                try {

                    Archivo.guardar(modelo, archivo);

                    JOptionPane.showMessageDialog(
                            null,
                            "Archivo guardado"
                    );

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemCargar.addActionListener(e -> {

            JFileChooser chooser =
                    new JFileChooser();

            int opcion =
                    chooser.showOpenDialog(null);

            if (opcion ==
                    JFileChooser.APPROVE_OPTION) {

                File archivo =
                        chooser.getSelectedFile();

                try {

                    Archivo.cargar(modelo, archivo);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        itemColor.addActionListener(e -> {

            Color color =
                    JColorChooser.showDialog(
                            null,
                            "Selecciona color",
                            panelSuperior.getBackground()
                    );

            if (color != null) {

                panelSuperior.setBackground(color);
                panelInferior.setBackground(color);
            }
        });
    }

    private void limpiarCampos() {

        txtNombre.setText("");
        txtGenero.setText("");
        txtPlataforma.setText("");
        areaDescripcion.setText("");
        comboEnLinea.setSelectedIndex(0);
        checkFavorito.setSelected(false);
    }
}