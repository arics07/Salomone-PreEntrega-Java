import java.util.ArrayList;

public class Pedido {

    private String id;
    private ArrayList<LineaPedido> pedido = new ArrayList<>();

    //crear pedido
    public void Pedido(){

    }

    public void Pedido(LineaPedido lineaPedido){
        pedido.add(lineaPedido);
    }

    public String getID() {
        return id;
    }

    public ArrayList<LineaPedido> getPedido() {
        return pedido;
    }

    public void setId(String id) {
        this.id = id;
    }

    //agregar lineaPedido
    public void agregarLineaPedido(LineaPedido lp) {
        this.pedido.add(lp);
    }

    //eliminar producto

    //editar cantidad

    //calcular costo total
    public double calculoCostoTotalPedido () {
        double costoTotal = 0;
        for (int i = 0; i < pedido.size(); i++) {
            //tengo que multiplicar el precio unitario del producto (que está en lineaProducto por la cantidad en lineaProducto
            costoTotal =+ pedido.get(i).getProducto().getPrecio() * pedido.get(i).getCantidad();
        };
        System.out.println("El costo total del pedido " + getID() + " es de $" + costoTotal);
        return costoTotal;
    }

}
