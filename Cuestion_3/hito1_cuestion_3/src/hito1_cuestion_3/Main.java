package hito1_cuestion_3;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hito1t3", "root", "")) {
            ProductoDAO productoDAO = new ProductoDAO(con);
            Scanner scanner = new Scanner(System.in);

            int opcion;
            do {
                System.out.println("Menú:");
                System.out.println("1. Añadir producto");
                System.out.println("2. Mostrar productos");
                System.out.println("3. Actualizar producto");
                System.out.println("4. Eliminar producto");
                System.out.println("5. Salir");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        agregarProducto(productoDAO, scanner);
                        break;
                    case 2:
                        productoDAO.mostrarProductos();
                        break;
                    case 3:
                        actualizarProducto(productoDAO, scanner);
                        break;
                    case 4:
                        eliminarProducto(productoDAO, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
            } while (opcion != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void agregarProducto(ProductoDAO productoDAO, Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo producto:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Fecha de envasado (YYYY-MM-DD): ");
        String fechaEnvasado = scanner.next();
        System.out.print("Unidades: ");
        int unidades = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Disponible (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Producto nuevoProducto = new Producto(nombre, fechaEnvasado, unidades, precio, disponible);
        boolean exito = productoDAO.insertarProducto(nuevoProducto);
        if (exito) {
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Error al agregar el producto.");
        }
    }

    private static void actualizarProducto(ProductoDAO productoDAO, Scanner scanner) {
        System.out.println("Ingrese el ID del producto a actualizar:");
        int idProducto = scanner.nextInt();
        System.out.println("Ingrese los nuevos datos del producto:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Fecha de envasado (YYYY-MM-DD): ");
        String fechaEnvasado = scanner.next();
        System.out.print("Unidades: ");
        int unidades = scanner.nextInt();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Disponible (true/false): ");
        boolean disponible = scanner.nextBoolean();

        Producto productoActualizado = new Producto(nombre, fechaEnvasado, unidades, precio, disponible);
        productoActualizado.setId(idProducto);
        boolean exito = productoDAO.actualizarProducto(productoActualizado);
        if (exito) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("Error al actualizar el producto.");
        }
    }

    private static void eliminarProducto(ProductoDAO productoDAO, Scanner scanner) {
        System.out.println("Ingrese el ID del producto a eliminar:");
        int idProducto = scanner.nextInt();
        boolean exito = productoDAO.eliminarProducto(idProducto);
        if (exito) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el producto.");
        }
    }
}
