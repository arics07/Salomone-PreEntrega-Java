import java.util.ArrayList;

public class Tienda {

    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    //crear tienda
    public Tienda() {
        //cuando creo la tienda, se crean los ArrayList vacios
        this.productos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    //agregar pedido a la tienda
    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        System.out.println("El pedido se agregó exitosamente.");
    }

    //eliminar pedido de la tienda

    //agregar producto a la tienda
    public void agregarProducto(Producto productoNuevo) {
        this.productos.add(productoNuevo);
    }

    //eliminar producto
    public void eliminarProducto(String id){
        boolean elimino = productos.removeIf(p -> p.getID().equals(id));
        if (elimino) {
            System.out.println("Se eliminó el producto.");
        } else {
            System.out.println("No se encontró ningún producto con ese ID.");
        }
    }

    //buscar un producto por nombre
    public void buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)){
                System.out.println("Nombre " + p.getNombre() + " || ID: " + p.getID() + " || Precio unitario; " + p.getPrecio() + " || Stock: " + p.getStock());
            }
        }
    }

    //buscar un producto por ID
    public Producto buscarProductoPorID(String id) {
        for (Producto p : productos) {
            if (p.getID().equals(id)){
                return p;
            }
        }
        System.out.println("No se encontró ningún producto con ese ID.");
        return null;
    }


    //actualizar producto
    public void actualizarProducto (Producto productoActualizado) {
        for (Producto p : productos) {
            if (p.getID().equals(productoActualizado.getID())){
                p.setNombre(productoActualizado.getNombre());
                p.setPrecio(productoActualizado.getPrecio());
                p.setStock(productoActualizado.getStock());
                System.out.println("Producto actualizado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró un producto con ese ID. No se pudo actualizar el producto.");
    }

    //mostrar productos de la tienda
    public void mostrarProductosDeLaTienda() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
            return;
        }
        System.out.println("Productos en la tienda:");
        for (Producto p : productos) {
            System.out.println("ID: " + p.getID() + ", Nombre: " + p.getNombre() + ", Precio unitario: " + p.getPrecio() + ", Stock: " + p.getStock());
        }
    }

    //crear pedido
    public Pedido crearPedido() {
        Pedido pedidoNuevo = new Pedido();
        return pedidoNuevo;
    }


    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    //mostrar (listar) pedidos
    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            System.out.println("Pedido #" + (i + 1) + " | ID: " + pedido.getID());

            ArrayList<LineaPedido> lineas = pedido.getPedido();
            if (lineas.isEmpty()) {
                System.out.println("  (Sin productos en este pedido)");
            } else {
                for (LineaPedido linea : lineas) {
                    Producto producto = linea.getProducto();
                    System.out.println("  Producto: " + producto.getNombre() +
                            " | Cantidad: " + linea.getCantidad() +
                            " | Precio unitario: $" + producto.getPrecio() +
                            " | Subtotal: $" + (producto.getPrecio() * linea.getCantidad()));
                }
            }

            // Mostrar el total del pedido
            double total = pedido.calculoCostoTotalPedido();
            System.out.println(" Total del pedido: $" + total);
            System.out.println("--------------------------");
        }
    }
}
