package examen.ejercicio1;

public class Calculadora {

    public static void main(String[] args) {

        //Declaramos las variables y le pasamos los parametros que nos han pasado por el comando
        int opcion = Integer.parseInt(args[0]);
        int numero1 = Integer.parseInt(args[1]);
        int numero2 = Integer.parseInt(args[2]);

        //Dependiendo de la opción que haya seleccionado el usuario, se ejecutará un case u otro
        switch (opcion) {
            case 1 -> System.out.println("El resultado de la suma es: " + (numero1 + numero2));
            case 2 -> System.out.println("El resultado de la resta es: " + (numero1 - numero2));
            case 3 -> System.out.println("El resultado de la multiplicacion es: " + (numero1 * numero2));
            case 4 -> System.out.println("El resultado de la division es: " + (numero1 / numero2));
            default -> System.out.println("La opción introducida no es válida");
        }


    }
}
