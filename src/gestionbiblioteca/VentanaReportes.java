package gestionbiblioteca;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class VentanaReportes extends JFrame {

    MenuAdministrador padre;

    private JLabel jlTitulo;

    public VentanaReportes(MenuAdministrador mp) {
        super("Generación de Reportes");
        padre = mp;
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        jlTitulo = new JLabel("Módulo de Reportes (En Construcción)");
        jlTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        jlTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        jlTitulo.setBounds(30, 100, 340, 30);
        add(jlTitulo);
    }
}