package examen.ejercicio03;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Declarmaos las varaibles
        int numero = 1;    //Variable que nos servirá para contar el numero de procesos
        String [] comando1 = {"Java", "src/examen/ejercicio03/NumerosAleatorios.java"};
        List<Process> listaProcesos = new ArrayList<>();

        //Creamos un ProcessBuilder para ejecutar el comando1
        ProcessBuilder pb1 = new ProcessBuilder(comando1);

        //Lanzo los 10 primeros que crean los archivos.

        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        for (int i = 0; i < 10; i++) {

            pb1.redirectOutput(new File("src/examen/ejercicio03/numero"+i+".txt"));
            Process p = null;
            try {
                p = pb1.start();
            } catch (IOException e) {
                System.err.println("Error durante la ejecución del proceso");
                System.err.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
            listaProcesos.add(p);
            numero++;
        }

        //Mientras que numero sea mayor que 0
        while (numero > 0) {
            //Reseteo el contador a 10
            numero = 10;
            // Recorro la lista de procesos para ver si siguen vivos.
            for (Process proceso : listaProcesos) {
                // Si alguno de los procesos ya ha terminado, entonces resto 1.
                if(!proceso.isAlive()) {
                    numero--;
                }
            }
        }
        //Espero a que finalicen los procesos.
        for(Process proceso : listaProcesos) {
            int retorno = proceso.exitValue();
            //Si el proceso ha terminado correctamente mostramos un mensaje
            if (retorno == 0) {
                System.out.println("El proceso ha finalizado correctamente");
            } else {    //Si el proceso ha terminado con error mostramos un mensaje
                System.out.println("El proceso ha terminado con el siguiente código de error: " + retorno);
            }
        }

        //Reseteo el contador.
        numero = 1;

        //Inicio los otros 20 procesos a la vez.
        for (int i = 0; i < 10; i++) {

            String numFichero = String.valueOf(i);
            //Creo los comandos para los procesos.
            String [] comando2 = {"java", "src/examen/ejercicio03/SumaNumeros.java", numFichero};
            String [] comando3 = {"java", "src/examen/ejercicio03/MediaNumeros.java", numFichero};

            //Creo los procesos.
            ProcessBuilder pb2 = new ProcessBuilder(comando2);
            ProcessBuilder pb3 = new ProcessBuilder(comando3);

            //String cadena2 = "numero" + i + ".txt";

            //Redirecciono la entrada del pb2 a la salida del pb1
            pb2.redirectInput(new File("src/examen/ejercicio03/numero" + i + ".txt"));

            //Redirecciono la salida del pb2 a un archivo sumas
            pb2.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/examen/ejercicio03/sumas.txt")));

            //Redirecciono la entrada del pb3 a la salida del pb1
            pb3.redirectInput(new File("src/examen/ejercicio03/numero" + i + ".txt"));

            //Redirecciono la salida del pb3 a un archivo medias
            pb3.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/examen/ejercicio03/medias.txt")));

            //Inicio los procesos.
            try {
                pb2.start();
                pb3.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
