package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaActualizaComp {

    private JFrame ventana;
    public JTextField campoNombre;
    public JTextField campoStock;
    public JButton btnActualizar;
    public JButton btnVolver;
    

    public  VistaActualizaComp() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Actualizar Componente");
        titulo.setBounds(150, 50, 500, 60);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        JLabel nombreLabel = new JLabel("Nombre del Componente:");
        nombreLabel.setBounds(220, 150, 360, 30);
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(nombreLabel);

        campoNombre = new JTextField();
        campoNombre.setBounds(220, 190, 360, 40);
        campoNombre.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(campoNombre);


        JLabel stockLabel = new JLabel("Nuevo Stock:");
        stockLabel.setBounds(220, 250, 360, 30);
        stockLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(stockLabel);

        campoStock = new JTextField();
        campoStock.setBounds(220, 290, 360, 40);
        campoStock.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(campoStock);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(280, 360, 220, 50);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnActualizar);



        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(630, 480, 120, 40); 
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

    // Para probar directamente
    public static void main(String[] args) {
        VistaActualizaComp vista = new VistaActualizaComp();
        vista.mostrarVentana();
    }
}
