public class Producto {

    private String ID;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String ID, String nombre, double precio, int cantidad){
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = cantidad;
    };

    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = cantidad;
    };

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
