package examen.ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class MainEj1 {

    public static void main(String[] args) {

        //Declaramos las variables
        int opc;            //Variable que contendrá la opción seleccionada por el usuario
        int numero1;        //Variable que contendrá el primer número introducido por el usuario
        int numero2;        //Variable que contendrá el segundo número introducido por el usuario
        String[] command;   //Array que contendrá el comando que ejecutará la calculadora
        ProcessBuilder pb;  //Variable que contendrá el comando que ejecutará la calculadora

        //Declaramos un scanner para poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pasamos por parametro el sc y pedimos los datos que necesita para ejecutarse la calculadora
        opc = menu(sc);

        //Le pedimos al usuario los dos números
        System.out.print("Primer número: ");
        numero1 = sc.nextInt();

        System.out.print("Segundo número: ");
        numero2 = sc.nextInt();

        //Creamos el comando que ejecutará la calculadora
        command = new String[]{"java", "src/examen/ejercicio1/Calculadora.java", Integer.toString(opc), Integer.toString(numero1), Integer.toString(numero2)};
        pb = new ProcessBuilder(command);

        try {
            //Ejecutamos el comando
            Process p = pb.start();

            //Obtenemos el valor devuelto por el proceso
            int retorno = p.waitFor();

            //Compruebo cómo ha terminado el proceso y escribo un mensaje en consecuencia
            if (retorno == 0) {
                System.out.println("El proceso ha finalizado correctamente");
            } else {
                System.out.println("El comando ha terminado con el siguiente código de error: " + retorno);
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el comando");
            System.out.println(e.getLocalizedMessage());
        }

        //Le decimos que coja la herencia por defecto
        pb.inheritIO();

        //Cerramos el scanner
        sc.close();

    }

    /**
     * Método que muestra el menú de la calculadora
     * @param sc Scanner para poder leer por consola
     * @return Devuelve la opción seleccionada por el usuario
     */
    public static int menu(Scanner sc) {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;
        // Imprimimos el menú con las diversas opciones
        System.out.println("""
                Elija qué calculo desea realizar:
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                """);
        // Leemos la opción de teclado
        opc = sc.nextInt();
        sc.nextLine();
        return opc;
    }


}