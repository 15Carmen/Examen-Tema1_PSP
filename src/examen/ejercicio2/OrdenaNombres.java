package examen.ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenaNombres {

    public static void main(String[] args) {
        //Declaramos las variables
        String linea;            // Variable que contendrá los datos de una linea del fichero
        String[] arrayPersona;   // Array que contendrá los datos de la persona
        List<String> listaPersonas = new ArrayList<>(); // Lista que contendrá los nombres de las personas

        //Declaro el Scanner para leer por consola
        Scanner sc = new Scanner(System.in);

        // Mientras haya líneas que leer seguiremos leyendo
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            // Separamos los datos de la línea en un array de Strings
            arrayPersona = linea.split(",");
            // Añadimos el nombre y el apellido a la lista
            listaPersonas.add(arrayPersona[1] + " " + arrayPersona[0]);
        }

        // Ordenamos la lista
        Collections.sort(listaPersonas);

        // Mostramos la lista por pantalla
        for (String p : listaPersonas) {
            System.out.println(p);
        }

        // Cerramos el Scanner
        sc.close();
    }
}
