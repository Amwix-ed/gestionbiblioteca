package gestionbiblioteca;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class VentanaCatalogo extends JFrame {

    MenuAdministrador padre;
    private ArrayList<String[]> listaLibros;

    private JButton btnAnadirLibro;
    private JLabel jlTituloBuscador, jlBuscarTitulo, jlBuscarAutor;
    private JTextField txtBuscarTitulo, txtBuscarAutor;
    private JButton btnBuscar;

    public VentanaCatalogo(MenuAdministrador mp, ArrayList<String[]> lista) {
        super("Gestión de Catálogo de Libros");
        padre = mp;
        this.listaLibros = lista;
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        btnAnadirLibro = new JButton("Añadir Nuevo Libro");
        btnAnadirLibro.setBounds(150, 30, 200, 40);
        add(btnAnadirLibro);

        JSeparator separador = new JSeparator();
        separador.setBounds(20, 90, 460, 10);
        add(separador);

        jlTituloBuscador = new JLabel("Buscador de Libros");
        jlTituloBuscador.setFont(new Font("Arial", Font.BOLD, 18));
        jlTituloBuscador.setBounds(160, 110, 200, 30);
        add(jlTituloBuscador);

        jlBuscarTitulo = new JLabel("Buscar por Título:");
        jlBuscarTitulo.setBounds(50, 160, 120, 25);
        add(jlBuscarTitulo);

        txtBuscarTitulo = new JTextField();
        txtBuscarTitulo.setBounds(180, 160, 250, 25);
        add(txtBuscarTitulo);

        jlBuscarAutor = new JLabel("Buscar por Autor:");
        jlBuscarAutor.setBounds(50, 200, 120, 25);
        add(jlBuscarAutor);

        txtBuscarAutor = new JTextField();
        txtBuscarAutor.setBounds(180, 200, 250, 25);
        add(txtBuscarAutor);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 260, 100, 30);
        add(btnBuscar);


        btnAnadirLibro.addActionListener((e) -> {
            FormularioLibro formLibro = new FormularioLibro(padre, listaLibros);
            formLibro.setVisible(true);
        });

        btnBuscar.addActionListener((e) -> {
            JOptionPane.showMessageDialog(padre,
                    "La funcionalidad de búsqueda aún no está implementada.",
                    "Búsqueda",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
}