
package gestionbiblioteca;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author NEZHA
 */
public class MenuBibliotecario extends JFrame{
    
    //MenuBibliotecario padre;
    private ArrayList<String[]> listaLibros;

    private JButton btnAnadirLibro;
    private JLabel jlTituloBuscador, jlBuscarTitulo, jlBuscarAutor;
    private JTextField txtBuscarTitulo, txtBuscarAutor;
    private JButton btnBuscar;

    //public VentanaCatalogo(MenuAdministrador mp, ArrayList<String[]> lista) {
    public MenuBibliotecario() { 
        super("Gestión de Catálogo de Libros prueba");
        //padre = mp;
        //this.listaLibros = lista;
        setSize(700, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
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

        jlBuscarTitulo = new JLabel("Reservar libro");
        jlBuscarTitulo.setBounds(50, 160, 120, 25);
        add(jlBuscarTitulo);

        txtBuscarTitulo = new JTextField();
        txtBuscarTitulo.setBounds(180, 160, 250, 25);
        add(txtBuscarTitulo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(200, 260, 100, 30);
        add(btnBuscar);


        btnAnadirLibro.addActionListener((e) -> {
            FormularioLibro formLibro = new FormularioLibro(null, listaLibros);
            formLibro.setVisible(true);
        });

        btnBuscar.addActionListener((e) -> {
            JOptionPane.showMessageDialog(null,
                    "La funcionalidad de búsqueda aún no está implementada.",
                    "Búsqueda",
                    JOptionPane.INFORMATION_MESSAGE);
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuBibliotecario::new);
        
    }
}
