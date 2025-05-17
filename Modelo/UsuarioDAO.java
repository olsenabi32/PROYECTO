package Modelo;

import java.sql.*;

public class UsuarioDAO {

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

    public static void mostrarUsuarios(Connection cn) {
        try {
            Statement st = cn.createStatement();
            String consulta = "SELECT * FROM usuarios";
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                String user = rs.getString("user");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String contraseña = rs.getString("contraseña");
                System.out.println("Usuario: " + user + ", Nombre: " + nombre + " " + apellidos + ", Email: " + email + ", Contraseña: " + contraseña);
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar los usuarios");
            e.printStackTrace();
        }
    }

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
}

