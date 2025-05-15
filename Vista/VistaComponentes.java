package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaComponentes {

    private JFrame ventana;
    public JComboBox<String> comboPlacas;
    public JButton btnConfirmar;
    public JButton btnVolver;

    public VistaComponentes() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Componentes");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(150, 50, 500, 60);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        JLabel lblPlacas = new JLabel("Placas base:");
        lblPlacas.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPlacas.setBounds(150, 150, 150, 30);
        ventana.getContentPane().add(lblPlacas);

        // ComboBox para placas base
        comboPlacas = new JComboBox<>();
        comboPlacas.setBounds(300, 150, 300, 30);
        comboPlacas.setFont(new Font("Arial", Font.PLAIN, 16));
        comboPlacas.addItem("Placa A");
        comboPlacas.addItem("Placa B");
        comboPlacas.addItem("Placa C");
        ventana.getContentPane().add(comboPlacas);

        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(300, 220, 200, 50);
        btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnConfirmar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(300, 300, 200, 50);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnVolver);
    }

    public void mostrarVentana() {
        ventana.setVisible(true);
    }

    public void cerrarVentana() {
        ventana.dispose();
    }

    public static void main(String[] args) {
        VistaComponentes vista = new VistaComponentes();
        vista.mostrarVentana();
    }
}

