package Modelo;

public class Usuario {
    private String user;
    private String contraseña;
    public String nombre;
    public String apellido;
    public String email;

    public Usuario(String user, String contraseña, String nombre, String apellido, String email) {
        this.user = user;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    } 

    public String getUser() {
        return user;
    } 

    public void setUser(String user) {
        this.user = user;
    }  

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }   
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   


}
