package examen.ejercicio2;

import java.util.Scanner;

/**
 * Clase que lee de la entrada estándar y muestra por la salida estándar los nombres de las personas mayores de edad.
 */
public class MayoresEdad {

    /**
     * Método principal
     * @param args
     */
    public static void main(String[] args) {

        //Declaramos las variables
        String linea;       //Variable que contendrá los datos de un línea.
        String[] persona;   //Array que contendrá los datos de una persona.

        //Declaro el Scanner para leer por teclado
        Scanner sc = new Scanner(System.in);

        //Mientras haya líneas que leer seguiremos leyendo
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            //Separamos los datos de la línea en un array de Strings
            persona = linea.split(";");

            //Si la edad es mayor o igual a 18 mostramos el nombre por pantalla
            if (Integer.parseInt(persona[1]) >= 18){
                System.out.println(persona[0]);
            }
        }
        //Cerramos el Scanner
        sc.close();
    }
}
