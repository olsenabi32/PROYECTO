package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaInicioMenu {

    private JFrame ventana;
    public JButton btnVerCompras;
    public JButton btnComprarcomp;
    public JButton btnAdministrar;
    public JLabel etiquetaUsuario;
    public JButton btnVolver;

    public VistaInicioMenu() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Menu Principal");
        titulo.setBounds(100, 50, 600, 60);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        btnVerCompras = new JButton("Ver Compras");
        btnVerCompras.setBounds(250, 160, 300, 60);
        btnVerCompras.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnVerCompras);

        btnComprarcomp = new JButton("Comprar Componenetes");
        btnComprarcomp.setBounds(250, 240, 300, 60);
        btnComprarcomp.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnComprarcomp);

        btnAdministrar = new JButton("Administrar Componentes");
        btnAdministrar.setBounds(250, 320, 300, 60);
        btnAdministrar.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnAdministrar);

        etiquetaUsuario = new JLabel("User: ");
        etiquetaUsuario.setBounds(20, 20, 300, 30); // Esquina superior izquierda
        etiquetaUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
        ventana.getContentPane().add(etiquetaUsuario);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40); // posición abajo a la derecha
        ventana.getContentPane().add(btnVolver);


    }

    // Método para mostrar la ventana
    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    // Método para cerrarla
    public void cerrarVentana() {
        ventana.dispose();
    }

    public void setNombreUsuario(String nombre) {
    etiquetaUsuario.setText("Usuario: " + nombre);
}


    // Para probar directamente
    public static void main(String[] args) {
        VistaInicioMenu vista = new VistaInicioMenu();
        vista.mostrarVentana();
    }
}
