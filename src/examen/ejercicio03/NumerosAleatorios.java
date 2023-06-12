package examen.ejercicio03;

import java.text.DecimalFormat;

public class NumerosAleatorios {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        //Recorremos 100 veces el bucle
        for (int i = 1; i <= 100; i++) {
            //Generamos un numero aleatorio entre 1 y 100
            System.out.println(df.format(Math.random()*100+1));
        }
    }
}
