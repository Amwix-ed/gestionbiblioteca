package gestionbiblioteca;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrestamos extends JFrame {

    MenuAdministrador padre;

    private JLabel jlTitulo, jlPrestamosActivos, jlReservas, jlHistorial;

    public VentanaPrestamos(MenuAdministrador mp) {
        super("Gestión de Préstamos y Devoluciones");
        padre = mp;
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        jlTitulo = new JLabel("Gestión de Préstamos");
        jlTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        jlTitulo.setBounds(140, 30, 300, 30);
        add(jlTitulo);

        jlPrestamosActivos = new JLabel("Módulo de Préstamos Activos");
        jlPrestamosActivos.setFont(new Font("Arial", Font.PLAIN, 16));
        jlPrestamosActivos.setBounds(50, 100, 300, 25);
        add(jlPrestamosActivos);
        
        jlReservas = new JLabel("Módulo de Reservas");
        jlReservas.setFont(new Font("Arial", Font.PLAIN, 16));
        jlReservas.setBounds(50, 150, 300, 25);
        add(jlReservas);

        jlHistorial = new JLabel("Historial de Devoluciones");
        jlHistorial.setFont(new Font("Arial", Font.PLAIN, 16));
        jlHistorial.setBounds(50, 200, 300, 25);
        add(jlHistorial);
        
    }
}