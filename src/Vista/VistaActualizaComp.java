/**
 * Clase VistaActualizaComp.
 * Vista gráfica relacionada con la interfaz de usuario.
 */

package Vista;

import javax.swing.*;

import java.awt.*;

public class VistaActualizaComp {

    private JFrame ventana;
    public JTextField campoNombre;
    public JTextField campoStock;
    public JButton btnActualizar;
    public JButton btnVolver;
    public JTextArea almacenArea;
    
    

    public  VistaActualizaComp() {
        initialize();
    }
    /**
     * Inicializa la ventana y sus componentes.
     */

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 1200, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Actualizar Componente");
        titulo.setBounds(90, 30, 500, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        JLabel nombreLabel = new JLabel("Nombre del Componente:");
        nombreLabel.setBounds(100, 170, 300, 30);
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(nombreLabel);

        campoNombre = new JTextField();
        campoNombre.setBounds(100, 210, 400, 40);
        campoNombre.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(campoNombre);


        JLabel stockLabel = new JLabel("Nuevo Stock:");
        stockLabel.setBounds(100, 270, 300, 30);
        stockLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(stockLabel);

        campoStock = new JTextField();
        campoStock.setBounds(100, 310, 400, 40);
        campoStock.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(campoStock);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(150, 390, 250, 50);
        btnActualizar.setFont(new Font("Arial", Font.PLAIN, 22));
        ventana.getContentPane().add(btnActualizar);

        JLabel lblAlmacen = new JLabel("Almacén:");
        lblAlmacen.setFont(new Font("Arial", Font.BOLD, 24));
        lblAlmacen.setBounds(700, 100, 300, 30);
        ventana.getContentPane().add(lblAlmacen);

        almacenArea = new JTextArea();
        almacenArea.setEditable(false); // Para que el usuario no pueda escribir
        almacenArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Tamaño y tipo de letra
        almacenArea.setLineWrap(true); // Que salte de línea si se pasa del ancho
        almacenArea.setWrapStyleWord(true); // Que no corte palabras a la mitad

        JScrollPane scroll = new JScrollPane(almacenArea);
        scroll.setBounds(700, 140, 450, 400); // Tamaño y posición del scroll (no del JTextArea)
        ventana.getContentPane().add(scroll);

        btnVolver = new JButton("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.setBounds(1020, 600, 150, 40);
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
        VistaActualizaComp vista = new VistaActualizaComp();
        vista.mostrarVentana();
    }
}
