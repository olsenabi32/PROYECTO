package Modelo;

import java.sql.*;

public class ComponenteDAO {

    public void insertarComponente(Connection cn, String nombre, String tipo, String compatibleCon, double precio, int stock) {
        try {
            Statement st = cn.createStatement();
            String consulta = "INSERT INTO componentes VALUES ('" + nombre + "', '" + tipo + "', '" + compatibleCon + "', " + precio + ", " + stock + ")";
            int filas = st.executeUpdate(consulta);
            System.out.println("Componente insertado. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar componente");
            e.printStackTrace();
        }
    }

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

}

