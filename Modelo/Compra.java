package Modelo;

public class Compra {
    private int idCompra;
    private String fecha;
    private String usuario;
    private String[] componente;

    public Compra(int idCompra, String fecha, String usuario, String[] componente) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.usuario = usuario;
        this.componente = componente;
    }
    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String[] getComponente() {
        return componente;
    }
    public void setComponente(String[] componente) {
        this.componente = componente;
    }


}
