package Modelo;

public class Componente {
    
    private String nombre;
    private String tipo;
    private String compatiblecon;
    private double precio;
    private int stock;

    public Componente(String nombre, String tipo, String compatiblecon, double precio, int stock) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.compatiblecon = compatiblecon;
        this.precio = precio;
        this.stock = stock;
    }

    public Componente(String nombre, String tipo, String compatiblecon) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.compatiblecon = compatiblecon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCompatiblecon() {
        return compatiblecon;
    }

    public void setCompatiblecon(String compatiblecon) {
        this.compatiblecon = compatiblecon;
    }
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
