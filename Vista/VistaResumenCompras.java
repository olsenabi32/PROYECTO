package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaResumenCompras {

    private JFrame ventana;
    public JButton btnVolver;

    public VistaResumenCompras() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Resumen de compras");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(150, 50, 500, 60);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        // Espacio en blanco (solo de ejemplo)
        JTextArea areaBlanca = new JTextArea();
        areaBlanca.setBounds(100, 150, 600, 250);
        areaBlanca.setEditable(false); // para que no se pueda escribir aún
        ventana.getContentPane().add(areaBlanca);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 22));
        btnVolver.setBounds(325, 450, 150, 50);
        ventana.getContentPane().add(btnVolver);
    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    public static void main(String[] args) {
        VistaResumenCompras vista = new VistaResumenCompras();
        vista.mostrarVentana();
    }
}

