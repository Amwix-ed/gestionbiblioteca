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

public class VentanaGestionUsuarios extends JFrame {

    MenuAdministrador padre;
    
    private JLabel jlId, jlNombre, jlApellido, jlCorreo, jlUsuario;
    private JTextField txtId, txtNombre, txtApellido, txtCorreo, txtUsuario;
    private JButton btnGuardar, btnLimpiar, btnListar;
    private ArrayList<String[]> listaClientes;

    public VentanaGestionUsuarios(MenuAdministrador mp, ArrayList<String[]> lista) {
        super("Gestión de Usuarios (Clientes)");
        padre = mp;
        this.listaClientes = lista;
        setSize(400, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(padre);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        jlId = new JLabel("ID (Cédula):");
        jlId.setBounds(30, 30, 100, 25);
        add(jlId);

        jlNombre = new JLabel("Nombre(s):");
        jlNombre.setBounds(30, 70, 100, 25);
        add(jlNombre);

        jlApellido = new JLabel("Apellido(s):");
        jlApellido.setBounds(30, 110, 100, 25);
        add(jlApellido);

        jlCorreo = new JLabel("Correo:");
        jlCorreo.setBounds(30, 150, 100, 25);
        add(jlCorreo);

        jlUsuario = new JLabel("Usuario:");
        jlUsuario.setBounds(30, 190, 100, 25);
        add(jlUsuario);

        txtId = new JTextField();
        txtId.setBounds(140, 30, 200, 25);
        add(txtId);

        txtNombre = new JTextField();
        txtNombre.setBounds(140, 70, 200, 25);
        add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(140, 110, 200, 25);
        add(txtApellido);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(140, 150, 200, 25);
        add(txtCorreo);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(140, 190, 200, 25);
        add(txtUsuario);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(30, 250, 100, 30);
        add(btnGuardar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(140, 250, 100, 30);
        add(btnLimpiar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(250, 250, 100, 30);
        add(btnListar);

        btnGuardar.addActionListener((e) -> evento_guardar());

        btnLimpiar.addActionListener((e) -> evento_limpiar());

        btnListar.addActionListener((e) -> evento_listar());
    }

    private void evento_guardar() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        String usuario = txtUsuario.getText();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean existe = false;
        for (String[] cliente : this.listaClientes) { 
            if (cliente[0].equals(id)) {
                existe = true;
                break;
            }
        }

        if (existe) {
            JOptionPane.showMessageDialog(this, "El ID ya fue asignado a otra persona", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String[] nuevoCliente = new String[6];
            nuevoCliente[0] = id;
            nuevoCliente[1] = nombre;
            nuevoCliente[2] = apellido;
            nuevoCliente[3] = correo;
            nuevoCliente[4] = usuario;
            nuevoCliente[5] = "true";
            this.listaClientes.add(nuevoCliente); 

            int respuesta = JOptionPane.showConfirmDialog(this, "Se guardó el registro. ¿Desea guardar otro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                this.dispose();
            } else {
                evento_limpiar();
            }
        }
    }

    private void evento_limpiar() {
        txtId.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtCorreo.setText(null);
        txtUsuario.setText(null);
    }

    private void evento_listar() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Correo", "Usuario", "Activo"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        for (String[] cliente : this.listaClientes) { 
            modeloTabla.addRow(cliente);
        }

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JFrame ventanaListado = new JFrame("Listado de Clientes");
        ventanaListado.setSize(600, 400);
        ventanaListado.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaListado.setLocationRelativeTo(this);
        
        ventanaListado.add(scrollPane);
        ventanaListado.setVisible(true);
    }
}