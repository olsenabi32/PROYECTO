package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaComponentes {

    public JFrame ventana;
    public JComboBox<String> comboPlacas;
    public JComboBox<String> comboProcesador;
    public JComboBox<String> comboRAM;
    public JComboBox<String> comboDisco;
    public JComboBox<String> comboGrafica;
    public JComboBox<String> comboFuente;
    public JComboBox<String> comboCaja;
    public JComboBox<String> comboRefrigeracion;
    public JLabel lblPrecio;
    public JButton btnComprar;
    public JButton btnConfirmar;
    public JButton btnVolver;

    public VistaComponentes() {
        initialize();
    }

    public void initialize() {
        ventana = new JFrame();
        ventana.setBounds(100, 100, 1400, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(null);
        ventana.getContentPane().setBackground(Color.decode("#E6CCFF"));

        JLabel titulo = new JLabel("Selecciona tus Componentes");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setBounds(400, 30, 600, 60);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        ventana.getContentPane().add(titulo);

        JLabel lblPlacas = new JLabel("Placas Base:");
        lblPlacas.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPlacas.setBounds(200, 120, 250, 30);
        ventana.getContentPane().add(lblPlacas);

        // ComboBox para placas base
        comboPlacas = new JComboBox<>();
        comboPlacas.setBounds(450, 120, 350, 30);
        comboPlacas.setFont(new Font("Arial", Font.PLAIN, 16));
        comboPlacas.addItem("MSI B560M PRO");
        comboPlacas.addItem("ASUS ROG STRIX B550-F");
        comboPlacas.addItem("ASUS PRIME Z690-P");
        ventana.getContentPane().add(comboPlacas);


        JLabel lblProcesador = new JLabel("Procesadores:");
        lblProcesador.setFont(new Font("Arial", Font.PLAIN, 20));
        lblProcesador.setBounds(200, 180, 250, 30);
        ventana.getContentPane().add(lblProcesador);

        // ComboBox para placas base
        comboProcesador = new JComboBox<>();
        comboProcesador.setBounds(450, 180, 350, 30);
        comboProcesador.setFont(new Font("Arial", Font.PLAIN, 16));
        comboProcesador.addItem("Intel i5 11400F");
        comboProcesador.addItem("AMD Ryzen 5 5600X");
        comboProcesador.addItem("Intel i7-12700K");
        ventana.getContentPane().add(comboProcesador);

        JLabel lblRAM = new JLabel("Memorias RAM:");
        lblRAM.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRAM.setBounds(200, 240, 250, 30);
        ventana.getContentPane().add(lblRAM);

        // ComboBox para placas base
        comboRAM = new JComboBox<>();
        comboRAM.setBounds(450, 240, 350, 30);
        comboRAM.setFont(new Font("Arial", Font.PLAIN, 16));
        comboRAM.addItem("16GB DDR4");
        comboRAM.addItem("32GB DDR4");
        comboRAM.addItem("16GB DDR5");
        ventana.getContentPane().add(comboRAM);

        JLabel lblDisco = new JLabel("Discos Duros:");
        lblDisco.setFont(new Font("Arial", Font.PLAIN, 20));
        lblDisco.setBounds(200, 300, 250, 30);
        ventana.getContentPane().add(lblDisco);

        comboDisco = new JComboBox<>();
        comboDisco.setBounds(450, 300, 350, 30);
        comboDisco.setFont(new Font("Arial", Font.PLAIN, 16));
        comboDisco.addItem("SSD 500GB NVMe");
        comboDisco.addItem("SSD 1TB NVMe");
        comboDisco.addItem("SSD 1TB Gen4 NVMe");
        ventana.getContentPane().add(comboDisco);

        JLabel lblGrafica = new JLabel("Tarjetas Graficas:");
        lblGrafica.setFont(new Font("Arial", Font.PLAIN, 20));
        lblGrafica.setBounds(200, 360, 250, 30);
        ventana.getContentPane().add(lblGrafica);

        comboGrafica = new JComboBox<>();
        comboGrafica.setBounds(450, 360, 350, 30);
        comboGrafica.setFont(new Font("Arial", Font.PLAIN, 16));
        comboGrafica.addItem("NVIDIA RTX 3060");
        comboGrafica.addItem("Radeon RX 6600 XT");
        comboGrafica.addItem("NVIDIA RTX 4070");
        ventana.getContentPane().add(comboGrafica);

        JLabel lblFuente = new JLabel("Fuentes de Alimentación:");
        lblFuente.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFuente.setBounds(200, 420, 250, 30);
        ventana.getContentPane().add(lblFuente);

        comboFuente = new JComboBox<>();
        comboFuente.setBounds(450, 420, 350, 30);
        comboFuente.setFont(new Font("Arial", Font.PLAIN, 16));
        comboFuente.addItem("650W Bronze");
        comboFuente.addItem("750W Gold");
        comboFuente.addItem("850W Modular");
        ventana.getContentPane().add(comboFuente);

        JLabel lblCaja = new JLabel("Cajas:");
        lblCaja.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCaja.setBounds(200, 480, 250, 30);
        ventana.getContentPane().add(lblCaja);

        comboCaja = new JComboBox<>();
        comboCaja.setBounds(450, 480, 350, 30);
        comboCaja.setFont(new Font("Arial", Font.PLAIN, 16));
        comboCaja.addItem("ATX Blanca");
        comboCaja.addItem("ATX Negra");
        comboCaja.addItem("ATX RGB");
        ventana.getContentPane().add(comboCaja);

        JLabel lblRefrigeracion = new JLabel("Refrigeraciones:");
        lblRefrigeracion.setFont(new Font("Arial", Font.PLAIN, 20));
        lblRefrigeracion.setBounds(200, 540, 250, 30);
        ventana.getContentPane().add(lblRefrigeracion);

        comboRefrigeracion = new JComboBox<>();
        comboRefrigeracion.setBounds(450, 540, 350, 30);
        comboRefrigeracion.setFont(new Font("Arial", Font.PLAIN, 16));
        comboRefrigeracion.addItem("Cooler normal");
        comboRefrigeracion.addItem("Liquida básica");
        comboRefrigeracion.addItem("Disipador doble");
        ventana.getContentPane().add(comboRefrigeracion);


        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(450, 620, 250, 50);
        btnConfirmar.setFont(new Font("Arial", Font.PLAIN, 18));
        ventana.getContentPane().add(btnConfirmar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(1200, 650, 120, 40);
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 20));
        ventana.getContentPane().add(btnVolver);

        lblPrecio = new JLabel("Precio: ");
        lblPrecio.setFont(new Font("Arial", Font.BOLD, 22));
        lblPrecio.setBounds(1000, 360, 300, 30); // Justo debajo del último combo o antes del botón
        lblPrecio.setVisible(false); // Lo ocultamos de entrada
        ventana.getContentPane().add(lblPrecio);

        btnComprar = new JButton("Comprar");
        btnComprar.setBounds(1000, 400, 250, 40);
        btnComprar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnComprar.setVisible(false);
        ventana.getContentPane().add(btnComprar);

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

