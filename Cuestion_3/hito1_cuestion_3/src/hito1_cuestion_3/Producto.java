package hito1_cuestion_3;

public class Producto {

    private int id;
    private String nombre;
    private String fechaEnvasado;
    private int unidades;
    private double precio;
    private boolean disponible;

    public Producto() {}

    public Producto(String nombre, String fechaEnvasado, int unidades, double precio, boolean disponible) {
        this.nombre = nombre;
        this.fechaEnvasado = fechaEnvasado; 
        this.unidades = unidades; 
        this.precio = precio;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
