package examen.ejercicio3;

import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {

        //Declaramos las variables
        double suma = 0;
        double numero;

        //Declaro el Scanner para leer por teclado
        Scanner sc = new Scanner(System.in);

        //Mientras haya líneas que leer seguiremos leyendo
        while(sc.hasNextDouble()) {
            //Leo el numero
            numero = sc.nextDouble();
            //Sumo el numero a la variable suma
            suma += numero;
        }
        //Cuando salgo del bucle muestro la suma por pantalla
        System.out.println("Esta suma es del fichero: " + suma);

        //Cerramos el Scanner
        sc.close();
    }
}
