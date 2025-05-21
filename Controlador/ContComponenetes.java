package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;


public class ContComponenetes {

    String placa;
    String procesador;
    String ram ;
    String disco ;
    String grafica ;
    String fuente ;
    String caja;
    String refrigeracion;
    Double precioTotal;

    ComponenteDAO componenteDAO = new ComponenteDAO();
    

    public ContComponenetes(VistaComponentes vistaComponenetes,VistaInicioMenu vistaInicioMenu,String user) {
    
        vistaComponenetes.btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaComponenetes.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });

        vistaComponenetes.btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    placa = (String) vistaComponenetes.comboPlacas.getSelectedItem();
                    procesador = (String) vistaComponenetes.comboProcesador.getSelectedItem();
                    ram = (String) vistaComponenetes.comboRAM.getSelectedItem();
                    disco = (String) vistaComponenetes.comboDisco.getSelectedItem();
                    grafica = (String) vistaComponenetes.comboGrafica.getSelectedItem();
                    fuente = (String) vistaComponenetes.comboFuente.getSelectedItem();
                    caja = (String) vistaComponenetes.comboCaja.getSelectedItem();
                    refrigeracion = (String) vistaComponenetes.comboRefrigeracion.getSelectedItem();

                    Connection cn = ConexionBD.conectar();
                    boolean Comprobacion= componenteDAO.ComprobarCompatible(cn, placa, procesador, ram, disco, grafica, fuente, caja, refrigeracion);

                    if(Comprobacion==false){
                        JOptionPane.showMessageDialog(null,"Componentes no compatibles");
                    } else{
                        
                        String[] componentes = {placa, procesador, ram, disco, grafica, fuente, caja, refrigeracion};
                        precioTotal = componenteDAO.calcularPrecioTotal(cn, componentes);

                        vistaComponenetes.lblPrecio = new JLabel("Total: " + precioTotal + " €");
                        vistaComponenetes.lblPrecio.setVisible(true);
                        vistaComponenetes.btnComprar.setVisible(true);
                        vistaComponenetes.lblPrecio.setBounds(50, 300, 200, 30);
                        
                    }

                    JOptionPane.showMessageDialog(null,"Componentes añadidos con éxito");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al confirmar: " + ex.getMessage());
                }
            }
        });


        vistaComponenetes.btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String resumenComponentes = "" + placa + ", " + procesador + ", " +ram + ", " + disco + ", " + grafica + ", " + fuente + ", " + caja + ", " + refrigeracion;

                    Connection cn = ConexionBD.conectar();
                    if(new CompraDAO().insertarCompra(cn, precioTotal, user, resumenComponentes)){
                        componenteDAO.restarStock(cn, placa);
                        componenteDAO.restarStock(cn, procesador);    
                        componenteDAO.restarStock(cn, ram);
                        componenteDAO.restarStock(cn, disco);
                        componenteDAO.restarStock(cn, grafica);
                        componenteDAO.restarStock(cn, fuente);
                        componenteDAO.restarStock(cn, caja);
                        componenteDAO.restarStock(cn, refrigeracion);
                        
                        JOptionPane.showMessageDialog(null,"Compra realizada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null,"No se ha podido realizar la compra");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al comprar: " + ex.getMessage());
                }
            }
        });


    }

}
