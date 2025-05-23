package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import java.awt.*;

/** 
 * Clase ContComponenetes. 
 * Controlador que gestiona los eventos de la vista asociada y la lógica de interacción con el modelo. 
 * Se encarga de responder a las acciones del usuario y actualizar vistas o datos según sea necesario.
 */

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
    

    /** 
     * Método ContComponenetes.
     * Lógica asociada a esta parte del controlador.
     */
    public ContComponenetes(VistaComponentes vistaComponenetes,VistaInicioMenu vistaInicioMenu,String user) {
    
        vistaComponenetes.btnVolver.addActionListener(new ActionListener() {
            @Override
        /** 
         * Método actionPerformed.
         * Ejecuta la acción principal del controlador.
         * @param e evento recibido desde la interfaz de usuario
        */
            public void actionPerformed(ActionEvent e) {
                vistaComponenetes.cerrarVentana();
                vistaInicioMenu.mostrarVentana();
            }
        });

        vistaComponenetes.btnConfirmar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
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
                        
                        String[] componentes={placa, procesador, ram, disco, grafica, fuente, caja, refrigeracion};
                        precioTotal = componenteDAO.calcularPrecioTotal(cn, componentes);

                        vistaComponenetes.lblPrecio.setText("Precio: " + precioTotal + " €");
                        vistaComponenetes.lblPrecio.setFont(new Font("Arial", Font.BOLD, 20)); 
                        vistaComponenetes.lblPrecio.setVisible(true);
                
                        vistaComponenetes.btnComprar.setVisible(true);
                        
                    }

                    JOptionPane.showMessageDialog(null,"Componentes compatibles");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al confirmar: " + ex.getMessage());
                }
            }
        });


        vistaComponenetes.btnComprar.addActionListener(new ActionListener() {
            @Override
            /** 
             * Método actionPerformed.
             * Ejecuta la acción principal del controlador.
             * @param e evento recibido desde la interfaz de usuario
             */
            public void actionPerformed(ActionEvent e) {
                try{
                    String resumenComponentes = ""+placa+ "," +procesador+ "," +ram+ ","+disco+","+grafica+","+ fuente+","+ caja +","+refrigeracion;
                    Connection cn = ConexionBD.conectar();
                    String[] componentes={placa, procesador, ram, disco, grafica, fuente, caja, refrigeracion};
                    boolean todoRestadoCorrectamente = true;

                if(new CompraDAO().insertarCompra(cn, precioTotal, user, resumenComponentes)){
                    for (String componente : componentes) {
                        boolean restado = componenteDAO.restarStock(cn, componente);
                            
                        if (!restado) {
                            JOptionPane.showMessageDialog(null, "No se ha restado correctamente el stock del componente: " + componente);
                            todoRestadoCorrectamente = false;
                        }
                    }
                    
                    if(todoRestadoCorrectamente){
                        JOptionPane.showMessageDialog(null,"Compra realizada con éxito");
                        new CompraDAO().crearXML( user,precioTotal, componentes);
                    } else {
                        JOptionPane.showMessageDialog(null,"No se ha podido realizar la compra");
                    }
                }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al comprar: " + ex.getMessage());
                }
            }
        });


    }

}
