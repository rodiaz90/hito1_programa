package hito1_cuestion_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ficheros {

    public static void main(String[] args) {
        File filePreguntas = new File("preguntas.txt");
        File fileRespuestas = new File("respuesta.txt");
        File fileCorrector = new File("corrector.txt");

        try (Scanner scannerPreguntas = new Scanner(filePreguntas);
             Scanner scannerCorrector = new Scanner(fileCorrector);
             PrintWriter writerRespuestas = new PrintWriter(fileRespuestas)) {

            Scanner userInput = new Scanner(System.in);
            double puntaje = 0;

            while (scannerPreguntas.hasNextLine()) {
                String pregunta = scannerPreguntas.nextLine();
                System.out.println(pregunta);

                String respuestaUsuario = userInput.nextLine();
                writerRespuestas.println(respuestaUsuario);

                // Comparar la respuesta del usuario con la respuesta correcta del archivo corrector.txt
                String respuestaCorrecta = scannerCorrector.nextLine();
                if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) {
                    System.out.println("Respuesta correcta");
                    puntaje += 1; // Suma un punto por respuesta correcta
                    writerRespuestas.println("Respuesta correcta");
                } else {
                    System.out.println("Respuesta incorrecta");
                    puntaje -= 0.5; // Resta 0.5 puntos por respuesta incorrecta
                    writerRespuestas.println("Respuesta incorrecta");
                }
            }

            // Mostrar la puntuación final
            System.out.println("Puntuación obtenida: " + puntaje);
            writerRespuestas.println("Puntuación obtenida: " + puntaje);

            // Comprobar si el usuario ha aprobado
            if (puntaje >= 5) {
                System.out.println("¡Enhorabuena! Has aprobado.");
            } else {
                System.out.println("Lo siento, no has alcanzado la puntuación necesaria para aprobar.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo: " + e.getMessage());
        }
    }
}


