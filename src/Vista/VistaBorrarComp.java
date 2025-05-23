/**
 * Clase VistaBorrarComp.
 * Vista gráfica relacionada con la interfaz de usuario.
 */

package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaBorrarComp {

    private JFrame ventana;
    public JTextField campoNombre2;
    public JTextField campoTipo;
    public JButton btnBorrar;
    public JButton btnVolver;

    public VistaBorrarComp() {
        initialize();
    }

    /**
     * Inicializa la ventana y sus componentes.
     */

    public void initialize() {
        ventana = new JFrame("Borrar Componente");
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        // Título
        JLabel titulo = new JLabel("Borrar Componente");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(200, 60, 400, 50);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNombre.setBounds(200, 170, 100, 30);
        ventana.getContentPane().add(lblNombre);

        campoNombre2 = new JTextField();
        campoNombre2.setFont(new Font("Arial", Font.PLAIN, 18));
        campoNombre2.setBounds(310, 170, 300, 35);
        ventana.getContentPane().add(campoNombre2);

        // Tipo
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTipo.setBounds(200, 230, 100, 30);
        ventana.getContentPane().add(lblTipo);

        campoTipo = new JTextField();
        campoTipo.setFont(new Font("Arial", Font.PLAIN, 18));
        campoTipo.setBounds(310, 230, 300, 35);
        ventana.getContentPane().add(campoTipo);

        // Botón Borrar
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 22));
        btnBorrar.setBounds(310, 310, 180, 50);
        ventana.getContentPane().add(btnBorrar);

        // Botón Volver
        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40);
        ventana.getContentPane().add(btnVolver);
    }

    /**
     * Muestra la ventana.
     */

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    
    /**
     * Cierra la ventana.
     */
    public void cerrarVentana() {   
        ventana.dispose();
    }

    public static void main(String[] args) {
        VistaBorrarComp vista = new VistaBorrarComp();
        vista.mostrarVentana();
    }
}
