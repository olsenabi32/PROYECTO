package Modelo;

import java.sql.*;

public class CompraDAO {

    public static void insertarCompra(Connection cn, double precioTotal, String user) {
        try {
            Statement st = cn.createStatement();
            String consulta = "INSERT INTO compras (precio_total, user) VALUES (" + precioTotal + ", '" + user + "')";
            int filas = st.executeUpdate(consulta);
            System.out.println("Compra insertada. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar compra");
            e.printStackTrace();
        }
    }

    public static void mostrarCompraSegunUser(Connection cn, String user) {
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM compras WHERE user = '" + user + "'";
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Precio total: " + rs.getDouble("precio_total") +
                ", Usuario: " + rs.getString("user"));
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar compras del usuario");
            e.printStackTrace();
        }
    }

    public static void borrarCompra(Connection cn, int idCompra) {
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM compras WHERE id = " + idCompra;
            int filas = st.executeUpdate(consulta);
            System.out.println("Compra borrada. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar compra");
            e.printStackTrace();
        }
    }
}

