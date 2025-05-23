/**
 * Clase VistaResumenCompras.
 * Vista gráfica relacionada con la interfaz de usuario.
 */
package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaResumenCompras {

    public JFrame ventana;
    public JButton btnVolver;
    public JTextArea areaBlanca;

    public VistaResumenCompras() {
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

        JLabel titulo = new JLabel("Resumen de compras");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(150, 50, 500, 60);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        // Creamos el área de texto
        areaBlanca = new JTextArea();
        areaBlanca.setEditable(false); // Para que el usuario no pueda escribir
        areaBlanca.setFont(new Font("Arial", Font.PLAIN, 18)); // Tamaño y tipo de letra
        areaBlanca.setLineWrap(true); // Que salte de línea si se pasa del ancho
        areaBlanca.setWrapStyleWord(true); // Que no corte palabras a la mitad

        // Creamos el scroll y lo metemos dentro
        JScrollPane scroll = new JScrollPane(areaBlanca);
        scroll.setBounds(100, 150, 600, 250); // Tamaño y posición del scroll (no del JTextArea)
        ventana.getContentPane().add(scroll);

        

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 22));
        btnVolver.setBounds(325, 450, 150, 50);
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
        VistaResumenCompras vista = new VistaResumenCompras();
        vista.mostrarVentana();
    }
}

