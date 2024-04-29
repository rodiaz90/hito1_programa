package hito1_3t_programacion;

// Creamos una clase base llamada Vehiculo
class Vehiculo {
    // Atributos de la clase Vehiculo
    String marca;
    String modelo;

    // Constructor de la clase Vehiculo
    Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    // Método para imprimir los detalles del vehículo
    void imprimirDetalles() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

// Creamos una subclase llamada Coche que hereda de la clase Vehiculo
class Coche extends Vehiculo {
    // Atributo específico de la clase Coche
    int puertas;

    // Constructor de la clase Coche
    Coche(String marca, String modelo, int puertas) {
        // Llamamos al constructor de la clase base usando super()
        super(marca, modelo);
        this.puertas = puertas;
    }

    // Método para imprimir los detalles del coche, incluyendo los heredados de Vehiculo
    @Override
    void imprimirDetalles() {
        super.imprimirDetalles(); // Llamamos al método de la clase base para imprimir los detalles del vehículo
        System.out.println("Número de puertas: " + puertas);
    }
}

// Creamos una clase llamada Operaciones
class Operaciones {
    // Método para sumar dos números enteros
    int sumar(int a, int b) {
        return a + b;
    }

    // Método sobrecargado para sumar dos números decimales
    double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar dos números enteros
    int restar(int a, int b) {
        return a - b;
    }

    // Método sobrescrito para restar dos números enteros
    int restar(int a, int b, int c) {
        return a - b - c;
    }
}