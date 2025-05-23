/**
 * Clase VistaMenuAdmin.
 * Vista gráfica relacionada con la interfaz de usuario.
 */
package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaMenuAdmin {

    private JFrame ventana;
    public JButton btnBorrar;
    public JButton btnAñadir;
    public JButton btnVolver;
    public JButton btnActualizar;

    public VistaMenuAdmin() {
        initialize();
    }

    /**
     * Inicializa la ventana y sus componentes.
     */

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Menu Administrador");
        titulo.setBounds(100, 80, 600, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        btnBorrar = new JButton("Borrar Componente");
        btnBorrar.setBounds(250, 200, 300, 60);
        btnBorrar.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnBorrar);

        btnAñadir = new JButton("Añadir Componente");
        btnAñadir.setBounds(250, 280, 300, 60);
        btnAñadir.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnAñadir);
        

        btnActualizar = new JButton("Actualizar Componente");
        btnActualizar.setBounds(250, 360, 300, 60);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnActualizar);


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
     * Oculta la ventana.
     */
    public void cerrarVentana() {
        ventana.dispose();
    }


    public static void main(String[] args) {
        VistaMenuAdmin vista = new VistaMenuAdmin();
        vista.mostrarVentana();
    }
}

