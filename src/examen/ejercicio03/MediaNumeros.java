package examen.ejercicio03;

import java.util.Scanner;

public class MediaNumeros {
    public static void main(String[] args) {

        //Declaramos las variables
        double suma = 0;
        double contador = 0;
        double numero;

        //Declaro el Scanner para leer por teclado
        Scanner sc = new Scanner(System.in);

        //Mientras haya líneas que leer seguiremos leyendo
        while(sc.hasNextDouble()) {
            //Leo el numero
            numero = sc.nextDouble();
            //Sumo el numero a la variable suma
            suma += numero;
            //Incremento el contador en uno
            contador++;
        }
        //Cuando salgo del bucle muestro la media (suma/contador) por pantalla
        System.out.println(suma/contador);

        //Cerramos el Scanner
        sc.close();
    }
}
