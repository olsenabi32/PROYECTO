/**
 * Clase ComponenteDAO.
 * Contiene la lógica y datos del modelo relacionados con componentedao.
 */
package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

public class ComponenteDAO {


    /**
     * Método insertarComponente.
     * @return resultado del método o acción realizada.
     */
    public boolean insertarComponente(Connection cn, String nombre, String tipo, String compatibleCon, double precio, int stock) {
        boolean result = true;
        try {
            Statement st = cn.createStatement();
            String consulta = "INSERT INTO componentes VALUES ('" + nombre + "', '" + tipo + "', '" + compatibleCon + "', " + precio + ", " + stock + ")";
            int filas = st.executeUpdate(consulta);
            if (filas == 0) {
                result = false; // no se insertó ningún componente
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar componente");
            e.printStackTrace();
        }
        return result;
    }

    
    /**
 * Método mostrarComponente.
 * 
 */

    public void mostrarComponente(Connection cn) {
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM componentes";
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre") + ", Tipo: " + rs.getString("tipo") +
                ", Compatible con: " + rs.getString("compatible_con") + ", Precio: " + rs.getDouble("precio") +
                ", Stock: " + rs.getInt("stock"));
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar componentes");
            e.printStackTrace();
        }
    }

    /**
 * Método actualizarStock.
 * 
 */

    public void actualizarStock(Connection cn, String nombre, int nuevoStock) {
        try {
            Statement st = cn.createStatement();
            String consulta = "UPDATE componentes SET stock = " + nuevoStock + " WHERE nombre = '" + nombre + "'";
            int filas = st.executeUpdate(consulta);
            System.out.println("Stock actualizado. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock");
            e.printStackTrace();
        }
    }

    /**
 * Método borrarComponente.
 * @return resultado del método o acción realizada.
 */

    public static boolean borrarComponente(Connection cn, String nombre) {
    boolean result = false;
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM componentes WHERE nombre = '" + nombre + "'";
            int filas = st.executeUpdate(consulta);

            if (filas > 0) {
                result = true; // se borró al menos un componente
            }

            System.out.println("Componente borrado. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
        System.out.println("Error al borrar componente");
        e.printStackTrace();
        }

        return result;
}




    public boolean ComprobarCompatible(Connection cn,String nombrePlaca, String procesador,String RAM,String Disco,
    String Tarjeta,String Fuente,String Cajas,String Refrigeracion) {

        boolean result = false;
        String[] componentes={procesador,RAM,Disco,Tarjeta,Fuente,Cajas,Refrigeracion};
        
        for (String componente : componentes) {
            try {
            Statement st = cn.createStatement();
            String consulta = "SELECT compatible_con FROM componentes WHERE nombre = '" + componente + "'";
            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
                String compatibleCon = rs.getString("compatible_con");
                if (compatibleCon != null && compatibleCon.equals(nombrePlaca)) {
                    result = true; // son compatibles
                }else {
                    result = false; // no son compatibles
                }
            }

            } catch (SQLException e) {
                System.out.println("Error al comprobar compatibilidad");
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
 * Método calcularPrecioTotal.
 * @return resultado del método o acción realizada.
 */

    public double calcularPrecioTotal(Connection cn, String[] componentes) {
    double total = 0.0;
    try {
        for (String nombre : componentes) {
            Statement st = cn.createStatement();
            String consulta = "SELECT precio FROM componentes WHERE nombre = '" + nombre + "'";
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                total += rs.getDouble("precio");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al calcular precio total");
        e.printStackTrace();
    }
    return total;
}

    /**
 * Método restarStock.
 * @return resultado del método o acción realizada.
 */

    public boolean restarStock(Connection cn, String componente) {
    boolean result = false;
    try {
        // Comprobamos el stock actual
        String consulta1 = "SELECT stock FROM componentes WHERE nombre = '" + componente + "'";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(consulta1);

        if (rs.next()) {
            int stockActual = rs.getInt("stock");

            if (stockActual > 0) {
                String consulta2 = "UPDATE componentes SET stock = stock - 1 WHERE nombre = '" + componente + "'";
                int filas = st.executeUpdate(consulta2); 

                if (filas > 0) {
                    result = true;
                }
            } else {
                // No hay stock suficiente
                JOptionPane.showMessageDialog(null, "No queda stock del componente: " + componente);
            }
        }

        rs.close();
        st.close();

        } catch (SQLException e) {
        System.out.println("Error al restar stock");
        e.printStackTrace();
    }


    return result;
}


    /**
 * Método mostrarAlmacen.
 * @return resultado del método o acción realizada.
 */

    public String mostrarAlmacen(Connection cn) {
        String componente = "";
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT nombre, stock FROM componentes;";
            ResultSet rs = st.executeQuery(consulta);

            while(rs.next()) {
                componente+= "Nombre: " + rs.getString("nombre") + ", Stock: " + rs.getInt("stock")+"\n";
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar componente por nombre");
            e.printStackTrace();
        }
        return componente;
    }

    /**
 * Método actualizarComponente.
 * @return resultado del método o acción realizada.
 */

    public boolean actualizarComponente(String nombre, int stock) {
        boolean result = true;
        try {
            Connection cn = ConexionBD.conectar();
            Statement st = cn.createStatement();
            String consulta = "UPDATE componentes SET stock = " + stock + " WHERE nombre = '" + nombre + "'";
            int filas = st.executeUpdate(consulta);
            if (filas == 0) {
                result = false; // no se actualizó ningún componente
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar componente");
            e.printStackTrace();
        }
        return result;
        }

}

