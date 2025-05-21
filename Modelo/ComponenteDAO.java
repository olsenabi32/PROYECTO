package Modelo;

import java.sql.*;

public class ComponenteDAO {

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

    public boolean restarStock(Connection cn, String componente) {
        boolean result = true;
        try {
            Statement st = cn.createStatement();
            String consulta = "UPDATE componentes SET stock = stock - 1 WHERE nombre = '" + componente + "'";
            int filas = st.executeUpdate(consulta);
            if (filas == 0) {
                result = false;
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al restar stock");
            e.printStackTrace();
        }
        return result;
        }

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

