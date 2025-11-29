package gestionbiblioteca;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class FormularioLibro extends JFrame {

    MenuAdministrador padre; 

    private JLabel jlIdLibro, jlTitulo, jlAutor, jlTipo;
    private JTextField txtIdLibro, txtTitulo, txtAutor, txtTipo;
    private JButton btnGuardar, btnLimpiar, btnListar;
    private ArrayList<String[]> listaLibros;

    public FormularioLibro(MenuAdministrador mp, ArrayList<String[]> lista) { 
        super("Formulario de Libros");
        padre = mp;
        this.listaLibros = lista;
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        jlIdLibro = new JLabel("ID Libro (ISBN):");
        jlIdLibro.setBounds(30, 30, 100, 25);
        add(jlIdLibro);

        jlTitulo = new JLabel("Título:");
        jlTitulo.setBounds(30, 70, 100, 25);
        add(jlTitulo);

        jlAutor = new JLabel("Autor:");
        jlAutor.setBounds(30, 110, 100, 25);
        add(jlAutor);

        jlTipo = new JLabel("Tipo (Físico/Digital):");
        jlTipo.setBounds(30, 150, 120, 25);
        add(jlTipo);

        txtIdLibro = new JTextField();
        txtIdLibro.setBounds(150, 30, 200, 25);
        add(txtIdLibro);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(150, 70, 200, 25);
        add(txtTitulo);

        txtAutor = new JTextField();
        txtAutor.setBounds(150, 110, 200, 25);
        add(txtAutor);

        txtTipo = new JTextField();
        txtTipo.setBounds(150, 150, 200, 25);
        add(txtTipo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 210, 100, 30);
        add(btnGuardar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(140, 210, 100, 30);
        add(btnLimpiar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(250, 210, 100, 30);
        add(btnListar);

        btnGuardar.addActionListener((e) -> evento_guardar());

        btnLimpiar.addActionListener((e) -> evento_limpiar());

        btnListar.addActionListener((e) -> evento_listar());
    }

    private void evento_guardar() {
        String idLibro = txtIdLibro.getText();
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String tipo = txtTipo.getText();

        if (idLibro.isEmpty() || titulo.isEmpty() || autor.isEmpty() || tipo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean existe = false;
        for (String[] libro : this.listaLibros) { 
            if (libro[0].equals(idLibro)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            JOptionPane.showMessageDialog(this, "El ID (ISBN) del libro ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] nuevoLibro = new String[5];
            nuevoLibro[0] = idLibro;
            nuevoLibro[1] = titulo;
            nuevoLibro[2] = autor;
            nuevoLibro[3] = tipo;
            nuevoLibro[4] = "true";
            this.listaLibros.add(nuevoLibro); 

            int respuesta = JOptionPane.showConfirmDialog(this, "Se guardó el registro. ¿Desea guardar otro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                this.dispose();
            } else {
                evento_limpiar();
            }
        }
    }

    private void evento_limpiar() {
        txtIdLibro.setText(null);
        txtTitulo.setText(null);
        txtAutor.setText(null);
        txtTipo.setText(null);
    }

    private void evento_listar() {
        String[] columnas = {"ID Libro (ISBN)", "Título", "Autor", "Tipo", "Activo"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (String[] libro : this.listaLibros) { 
            modeloTabla.addRow(libro);
        }

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JFrame ventanaListado = new JFrame("Listado de Libros");
        ventanaListado.setSize(600, 400);
        ventanaListado.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaListado.setLocationRelativeTo(this);
        ventanaListado.add(scrollPane);
        ventanaListado.setVisible(true);
    }
}