CREATE DATABASE IF NOT EXISTS hito1t3;

USE hito1t3;

CREATE TABLE IF NOT EXISTS productos (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaEnvasado DATE NOT NULL,
    unidades INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    disponible BOOLEAN NOT NULL
);

INSERT INTO productos (nombre, fechaEnvasado, unidades, precio, disponible) 
VALUES 
    ('Producto A', '2024-04-29', 100, 15.99, true),
    ('Producto B', '2024-04-30', 50, 10.50, true),
    ('Producto C', '2024-04-28', 200, 25.75, false),
    ('Producto D', '2024-04-27', 75, 8.25, true),
    ('Producto E', '2024-04-26', 120, 18.49, true),
    ('Producto F', '2024-04-25', 80, 12.75, false),
    ('Producto G', '2024-04-24', 150, 20.00, true),
    ('Producto H', '2024-04-23', 90, 14.99, true),
    ('Producto I', '2024-04-22', 110, 30.25, false),
    ('Producto J', '2024-04-21', 70, 9.99, true);
