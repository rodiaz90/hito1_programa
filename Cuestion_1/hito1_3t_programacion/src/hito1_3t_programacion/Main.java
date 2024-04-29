package hito1_3t_programacion;


//Clase principal para probar la herencia en Java
public class Main {
 public static void main(String[] args) {
     // Creamos un objeto de la clase Coche
     Coche miCoche = new Coche("Toyota", "Corolla", 4);
     // Llamamos al método para imprimir los detalles del coche
     miCoche.imprimirDetalles();

     // Creamos un objeto de la clase Operaciones
     Operaciones operaciones = new Operaciones();

     // Ejemplo de sobrecarga: suma de enteros y suma de decimales
     int sumaEnteros = operaciones.sumar(5, 3); // Se utiliza el primer método sumar
     double sumaDecimales = operaciones.sumar(5.5, 3.5); // Se utiliza el segundo método sumar
     System.out.println("Suma de enteros: " + sumaEnteros);
     System.out.println("Suma de decimales: " + sumaDecimales);

     // Ejemplo de sobreescritura: resta de dos números y resta de tres números
     int restaDosNumeros = operaciones.restar(10, 5); // Se utiliza el primer método restar
     int restaTresNumeros = operaciones.restar(20, 5, 3); // Se utiliza el segundo método restar
     System.out.println("Resta de dos números: " + restaDosNumeros);
     System.out.println("Resta de tres números: " + restaTresNumeros);
 }
}