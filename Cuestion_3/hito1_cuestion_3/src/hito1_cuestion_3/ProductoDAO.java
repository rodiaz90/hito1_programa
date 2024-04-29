package hito1_cuestion_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO {
    
    private Connection con;
    
    public ProductoDAO(Connection con) {
        this.con = con;
    }

    public boolean insertarProducto(Producto producto) {
        String query = "INSERT INTO productos (nombre, fechaEnvasado, unidades, precio, disponible) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getFechaEnvasado());
            stmt.setInt(3, producto.getUnidades());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setBoolean(5, producto.isDisponible());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void mostrarProductos() {
        String query = "SELECT * FROM productos";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID Producto: " + rs.getInt("idProducto") + ", Nombre: " + rs.getString("nombre") + ", Fecha de Envasado: " + 
            rs.getString("fechaEnvasado") + ", Unidades: " + rs.getInt("unidades") + ", Precio: " + rs.getDouble("precio") + ", Disponible: " + rs.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean actualizarProducto(Producto producto) {
        String query = "UPDATE productos SET nombre = ?, fechaEnvasado = ?, unidades = ?, precio = ?, disponible = ? WHERE idProducto = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getFechaEnvasado());
            stmt.setInt(3, producto.getUnidades());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setBoolean(5, producto.isDisponible());
            stmt.setInt(6, producto.getId());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;	
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String query = "DELETE FROM productos WHERE idProducto = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
