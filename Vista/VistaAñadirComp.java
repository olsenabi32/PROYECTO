
package Vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

    public class VistaAñadirComp {

    private JFrame ventana;
    public JTextField campoNombre;
    public JTextField campoTipo;
    public JTextField campoCompatible;
    public JTextField campoPrecio;
    public JTextField campoStock;
    public JButton btnRegistrar;
    public JButton btnVolver;

    public VistaAñadirComp() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        // Título
        JLabel titulo = new JLabel("Añadir Componente:");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(200, 60, 400, 50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setBounds(180, 120, 100, 30);
        ventana.getContentPane().add(lblNombre);

        campoNombre = new JTextField();
        campoNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        campoNombre.setBounds(300, 120, 300, 30);
        ventana.getContentPane().add(campoNombre);

        // Tipo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTipo.setBounds(180, 170, 100, 30);
        ventana.getContentPane().add(lblTipo);

        campoTipo = new JTextField();
        campoTipo.setFont(new Font("Arial", Font.PLAIN, 16));
        campoTipo.setBounds(300, 170, 300, 30);
        ventana.getContentPane().add(campoTipo);

        // Compatible con
        JLabel lblCompatible = new JLabel("Compatible con:");
        lblCompatible.setFont(new Font("Arial", Font.PLAIN, 18));
        lblCompatible.setBounds(130, 220, 150, 30);
        ventana.getContentPane().add(lblCompatible);

        campoCompatible = new JTextField();
        campoCompatible.setFont(new Font("Arial", Font.PLAIN, 16));
        campoCompatible.setBounds(300, 220, 300, 30);
        ventana.getContentPane().add(campoCompatible);

        // Precio
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new Font("Arial", Font.PLAIN, 18));
        lblPrecio.setBounds(180, 270, 100, 30);
        ventana.getContentPane().add(lblPrecio);

        campoPrecio = new JTextField();
        campoPrecio.setFont(new Font("Arial", Font.PLAIN, 16));
        campoPrecio.setBounds(300, 270, 300, 30);
        ventana.getContentPane().add(campoPrecio);

        // Stock
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setFont(new Font("Arial", Font.PLAIN, 18));
        lblStock.setBounds(180, 320, 100, 30);
        ventana.getContentPane().add(lblStock);

        campoStock = new JTextField();
        campoStock.setFont(new Font("Arial", Font.PLAIN, 16));
        campoStock.setBounds(300, 320, 300, 30);
        ventana.getContentPane().add(campoStock);

        // Botón Registrar
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 20));
        btnRegistrar.setBounds(320, 400, 150, 50);
        ventana.getContentPane().add(btnRegistrar);

        // Botón Volver
        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40);
        ventana.getContentPane().add(btnVolver);

        

    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    public static void main(String[] args) {
        VistaAñadirComp vista = new VistaAñadirComp();
        vista.mostrarVentana();
    }
}