package Modelo;

import java.sql.*;

public class RealizanDAO {

    // Insertar una relación entre una compra y un componente
    public static void insertarRelacion(Connection cn, int idCompra, String nombreComponente, int cantidad) {
        try {
            Statement st = cn.createStatement();
            String consulta = "INSERT INTO realizan VALUES (" + idCompra + ", '" + nombreComponente + "', " + cantidad + ")";
            int filas = st.executeUpdate(consulta);
            System.out.println("Relación insertada. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar relación en 'realizan'");
            e.printStackTrace();
        }
    }

    // Mostrar todas las relaciones
    public static void mostrarRelaciones(Connection cn) {
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM realizan";
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                System.out.println("Compra ID: " + rs.getInt("id_compra") + ", Componente: " + rs.getString("nombre_componente") +
                ", Cantidad: " + rs.getInt("cantidad"));
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar relaciones");
            e.printStackTrace();
        }
    }

    // Borrar una relación específica (por si se elimina una compra o un componente)
    public static void borrarRelacion(Connection cn, int idCompra, String nombreComponente) {
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM realizan WHERE id_compra = " + idCompra +" AND nombre_componente = '" + nombreComponente + "'";
            int filas = st.executeUpdate(consulta);
            System.out.println("Relación borrada. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar relación");
            e.printStackTrace();
        }
    }

    // Borrar todas las relaciones de una compra (útil si eliminas una compra completa)
    public static void borrarRelacionesDeCompra(Connection cn, int idCompra) {
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM realizan WHERE id_compra = " + idCompra;
            int filas = st.executeUpdate(consulta);
            System.out.println("Relaciones borradas para compra " + idCompra + ". Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar relaciones de la compra");
            e.printStackTrace();
        }
    }
}
