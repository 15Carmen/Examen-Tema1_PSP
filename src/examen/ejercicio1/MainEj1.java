package examen.ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class MainEj1 {

    public static void main(String[] args) {

        //Declaramos un scanner para poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pasamos por parametro el sc y pedimos los datos que necesita para ejecutarse la calculadora
        String opc = menu(sc);
        String numero1 = pedirNumero(sc);
        String numero2 = pedirNumero(sc);

        //Una vez pedido los datos, se le pasa por parametros en el comando a ejecutar, justo después de llamar a Java Calculadora.java se le ponen los parametros que van en el String[] args
        ProcessBuilder pb = new ProcessBuilder("Java", "src/examen/ejercicio1/Calculadora.java", opc, numero1, numero2);

        //Le decimos que coja la herencia por defecto
        pb.inheritIO();

        try {
            //Arrancamos el proceso
            Process p = pb.start();

            //Obtenemos el valor devuelto por el proceso
            int retorno = p.waitFor();

            //Compruebo cómo ha terminado el proceso y escribo un mensaje en consecuencia
            if (retorno == 0) {
                System.out.println("El proceso ha finalizado correctamente");
            } else {
                System.out.println("El comando ha terminado con el siguiente código de error: " + retorno);
            }
        } catch(IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.out.println(e.getLocalizedMessage());

        } catch(InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.out.println(e.getLocalizedMessage());

        }

        //Cerramos el scanner
        sc.close();

    }

    /**
     * Método que muestra el menú de la calculadora
     * @param sc Scanner para poder leer por consola
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static String menu(Scanner sc) {
        // En opc guardaremos la opción seleccionada por el usuario
        String opc;
        // Imprimimos el menú con las diversas opciones
        System.out.println("""
                Elija qué calculo desea realizar:
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                """);
        // Leemos la opción de teclado
        opc = sc.next();
        return opc;
    }

    /**
     * Método que pedirá un número por consola
     * @param sc Scanner para poder leer por consola
     * @return Devuelve el número introducido por el usuario
     */
    private static String pedirNumero(Scanner sc) {
        //Declaramos la variable
        String numero;  //Variable que guardará el número introducido por el usuario

        //Pedimos el número al usuario y lo guardamos en la variable
        System.out.println("Introduce un numero");
        numero = sc.next();

        //Devolvemos el número
        return numero;
    }


}