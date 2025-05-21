package Modelo;

import java.sql.*;

public class CompraDAO {

    public boolean insertarCompra(Connection cn, double precioTotal, String user,String resumenComponentes) {
        boolean result = true;
        try {
            Statement st = cn.createStatement();
            resumenComponentes = resumenComponentes.replace("'", "''");
                String consulta = "INSERT INTO compras (precio_total, user, componentes_comprados) VALUES (" 
                    + precioTotal + ", '" + user + "', '" + resumenComponentes + "')";
            int filas = st.executeUpdate(consulta);
            if (filas == 0) {
                System.out.println("No se pudo insertar la compra");
                result = false;
            } else {
                System.out.println("Compra insertada con éxito");
            } 
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar compra");
            e.printStackTrace();
        }
        return result;
    }

    public String mostrarCompraSegunUser(Connection cn, String user) {
        String compras = "";
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM compras WHERE user = '" + user + "'";
            ResultSet rs = st.executeQuery(consulta);
            

            while (rs.next()) {
                compras += "ID: " + rs.getInt("id") + 
                    ", Precio total: " + rs.getDouble("precio_total") +
                    ", Usuario: " + rs.getString("user") + 
                    ", Componentes comprados: " + rs.getString("componentes_comprados") + "\n\n";
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar compras del usuario");
            e.printStackTrace();
        }

        return compras;
    }

    public boolean  borrarCompra(Connection cn, int idCompra) {
        boolean result = true;
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM compras WHERE id = " + idCompra;
            int filas = st.executeUpdate(consulta);

            if (filas == 0) {
                System.out.println("No se encontró la compra con ID: " + idCompra);
                result = false;
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar compra");
            e.printStackTrace();
        }

        return result;
    }
}

