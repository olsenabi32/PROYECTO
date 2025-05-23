/**
 * Clase UsuarioDAO.
 * Contiene la lógica y datos del modelo relacionados con usuariodao.
 */
package Modelo;

import java.sql.*;

public class UsuarioDAO {

    /**
 * Método insertarUsuario.
 * 
 */
    public static void insertarUsuario(Connection cn, String user, String nombre, String apellidos, String email, String contraseña) {
        try {
            Statement st = cn.createStatement();
            String consulta = "INSERT INTO usuarios VALUES ('" + user + "', '" + nombre + "', '" + apellidos + "', '" + email + "', '" + contraseña + "')";
            int filas = st.executeUpdate(consulta);
            System.out.println("Usuario insertado. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario");
            e.printStackTrace();
        }
    }

/**
 * Método buscarUsuario.
 * @return resultado del método o acción realizada.
 */
    public static boolean buscarUsuario(Connection cn, String user, String contraseña) {
    boolean existe = false;

    try {
        Statement st = cn.createStatement();
        String consulta = "SELECT * FROM usuarios WHERE user = '" + user + "' AND contraseña = '" + contraseña + "'";
        ResultSet rs = st.executeQuery(consulta);

        if (rs.next()) {
            existe = true;
        }

        rs.close();
        st.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar el usuario");
        e.printStackTrace();
    }

    return existe;
}

/**
 * Método borrarUsuario.
 * 
 */
    public static void borrarUsuario(Connection cn, String user) {
        try {
            Statement st = cn.createStatement();
            String consulta = "DELETE FROM usuarios WHERE user = '" + user + "'";
            int filas = st.executeUpdate(consulta);
            System.out.println("Usuario borrado. Filas afectadas: " + filas);
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al borrar el usuario");
            e.printStackTrace();
        }
    }

    /**
 * Método esAdmin.
 * @return resultado del método o acción realizada.
 */
    public static boolean esAdmin(Connection cn, String user) {
        boolean result=false;
        try {
            
            Statement st = cn.createStatement();
            String consulta = "SELECT admin FROM usuarios WHERE user = '" + user + "'";
            ResultSet rs = st.executeQuery(consulta);

            if (rs.next()) {
            result= rs.getBoolean("admin");
            }

        rs.close();
        st.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}

}

