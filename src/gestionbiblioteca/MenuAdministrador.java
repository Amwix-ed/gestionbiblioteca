package gestionbiblioteca;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MenuAdministrador extends JFrame {

    public ArrayList<String[]> listaClientes = new ArrayList<>();
    public ArrayList<String[]> listaLibros = new ArrayList<>();

    private JLabel jlTitulo;
    private JButton btnGestionUsuarios;
    private JButton btnGestionCatalogo;
    private JButton btnGestionPrestamos;
    private JButton btnGenerarReportes;

    public MenuAdministrador() {
        super("Panel de Administrador - Gestión de Biblioteca");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        jlTitulo = new JLabel("Panel de Administración");
        jlTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        jlTitulo.setBounds(200, 40, 300, 30);
        add(jlTitulo);

        btnGestionUsuarios = new JButton("Gestionar Usuarios");
        btnGestionUsuarios.setBounds(250, 120, 200, 50);
        add(btnGestionUsuarios);

        btnGestionCatalogo = new JButton("Gestionar Catálogo");
        btnGestionCatalogo.setBounds(250, 200, 200, 50);
        add(btnGestionCatalogo);

        btnGestionPrestamos = new JButton("Gestionar Préstamos");
        btnGestionPrestamos.setBounds(250, 280, 200, 50);
        add(btnGestionPrestamos);
        
        btnGenerarReportes = new JButton("Generar Reportes");
        btnGenerarReportes.setBounds(250, 360, 200, 50);
        add(btnGenerarReportes);

        
        btnGestionUsuarios.addActionListener((e) -> {
            VentanaGestionUsuarios formUsuario = new VentanaGestionUsuarios(MenuAdministrador.this, listaClientes);
            formUsuario.setVisible(true);
        });

        btnGestionCatalogo.addActionListener((e) -> {
            VentanaCatalogo formCatalogo = new VentanaCatalogo(MenuAdministrador.this, listaLibros);
            formCatalogo.setVisible(true);
        });
        
        btnGestionPrestamos.addActionListener((e) -> {
            VentanaPrestamos formPrestamos = new VentanaPrestamos(MenuAdministrador.this);
            formPrestamos.setVisible(true);
        });
        
        btnGenerarReportes.addActionListener((e) -> {
            VentanaReportes formReportes = new VentanaReportes(MenuAdministrador.this);
            formReportes.setVisible(true);
        });
    }

}