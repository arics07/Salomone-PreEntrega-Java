import javax.management.NotCompliantMBeanException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creo la tienda
        Tienda tienda = new Tienda();

        Scanner entrada = new Scanner(System.in);

        int opcionUsuario;

        System.out.println("BIENVENIDO A LA APP DDE COMPRAS!");

        boolean running = true;

        while (running) {

            System.out.println("""
                            Ingrese una opción:
                            
                            1 - AGREGAR UN PRODUCTO A LA TIENDA -
                            2 - LISTAR PRODUCTOS DE LA TIENDA -
                            3 - BUSCAR PRODUCTO POR NOMBRE EN LA TIENDA - 
                            4 - ACTUALIZAR PRODUCTO DE LA TIENDA -
                            5 - ELIMINAR PRODUCTO DE LA TIENDA -
                            6 - CREAR PEDIDO - 
                            7 - LISTAR PEDIDOS 
                            0 - SALIR -
                            
                            """);

            try{
                opcionUsuario = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
                entrada.nextLine(); // limpia el buffer
                continue; // vuelve al inicio del while
            };


            switch (opcionUsuario) {

                //listo
                case 0:
                    System.out.println("""
                                       Saliendo del programa...
                                       Gracias por usar la app de compras.
                                       """);
                    running = false;
                    break;

                //listo
                case 1:
                    try {
                        //agregar un producto a la tienda
                        System.out.println("Ingrese el ID del producto: ");
                        String idProducto = entrada.next();
                        System.out.println("Ingrese el nombre del producto: ");
                        String nombreProducto = entrada.next();
                        System.out.println("Ingrese el precio por unidad: ");
                        double precioProducto = entrada.nextDouble();
                        System.out.println("Ingrese el stock del producto: ");
                        int stockProducto = entrada.nextInt();
                        Producto nuevoProducto = new Producto(idProducto, nombreProducto, precioProducto, stockProducto);
                        //lo tengo que agregar al ArrayList de Productos de la Tienda
                        tienda.agregarProducto(nuevoProducto);
                    } catch (InputMismatchException e) {

                    }
                    break;

                //listo
                case 2:
                    //listar productos de la tienda
                    tienda.mostrarProductosDeLaTienda();
                    break;

                //listo
                case 3:
                    //buscar producto por nombre en la tienda
                    // la tienda tiene un array list de productos, hay que recorrerla buscado el nombre del producto
                    System.out.println("Ingrese el nombre del producto que busca: ");
                    String nombreProductoBuscado = entrada.next();
                    tienda.buscarProductoPorNombre(nombreProductoBuscado);
                    break;

                //listo
                case 4:
                    //actualizar producto de la tienda
                    System.out.println("Ingrese el ID del producto que desea actualizar: ");
                    String id = entrada.next();
                    System.out.println("Ingrese nombre actualizado: ");
                    String nombreActualizado = entrada.next();
                    System.out.println("Ingrese el precio por unidad actualizado: ");
                    double precioActualizado = entrada.nextDouble();
                    System.out.println("Ingrese el stock actualizado: ");
                    int stockActualizado = entrada.nextInt();
                    Producto productoActualizado = new Producto(id, nombreActualizado, precioActualizado, stockActualizado);
                    tienda.actualizarProducto(productoActualizado);
                    break;

                //listo;
                case 5:
                    //eliminar producto de la tienda
                    // la tienda debe encargarse de elimar el producto
                    System.out.println("Ingrese el id del producto: ");
                    String idProductoEliminar = entrada.next();
                    tienda.eliminarProducto(idProductoEliminar);
                    break;

                case 6:
                    //crear pedido en la tienda
                    Pedido nuevoPedido = tienda.crearPedido();
                    boolean creandoPedido = true;
                    String seguir;

                    while (creandoPedido) {
                        //pedir información de los Productos y la cantidad
                        System.out.println("Ingrese el id del producto que desea agregar al compra: ");
                        String idProducto = entrada.next();
                        //la tienda tiene que buscar el producto y darmelo; lo guardo en una variable
                        Producto productoEncontrado = tienda.buscarProductoPorID(idProducto);
                        // Si no existe, ofrecer volver a intentar o salir
                        if (productoEncontrado == null) {
                            System.out.println("Producto no encontrado.");
                            System.out.println("¿Desea intentar con otro producto? (SI/NO)");
                            String respuesta = entrada.next().trim().toLowerCase();

                            if (respuesta.equals("n") || respuesta.equals("no")) {
                                creandoPedido = false;
                            }
                            continue; // vuelve al inicio del while sin seguir con el resto
                        }
                        System.out.println("Ingrese la cantidad que desea comprar: ");
                        int cantidad = entrada.nextInt();
                        //actualizar el stock del producto
                        //-------------------------------------
                        LineaPedido nuevaLineaPedido = new LineaPedido(productoEncontrado, cantidad);
                        //lo agrego al pedido
                        nuevoPedido.agregarLineaPedido(nuevaLineaPedido);
                        System.out.println("Desea agregar otro producto? SI/NO");
                        seguir = entrada.next();
                        if (seguir.toLowerCase().trim().equals("n") || seguir.toLowerCase().trim().equals("no")) {
                            creandoPedido = false;
                        }
                    }
                    System.out.println("Pedido creado con éxito!!");
                    tienda.agregarPedido(nuevoPedido);
                    break;

                //listo
                case 7:
                    //listar pedidos de la tienda
                    tienda.mostrarPedidos();
                    break;

                //listo
                default:
                    System.out.println("La opción ingresada no es correcta.");
                    break;

            }

        }
    }
}