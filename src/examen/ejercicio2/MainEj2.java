package examen.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEj2 {
    public static void main(String[] args) {

        //Declaramos las variables
        String[] comando1={"java","src/examen/ejercicio2/MayoresEdad.java"} ;
        String[] comando2= {"java","src/examen/ejercicio2/OrdenaNombres.java"};

        //Creamos un ProcessBuilder para ejecutar el comando1
        ProcessBuilder pb1 = new ProcessBuilder(comando1);

        //redirecciono la entrada del pb1 al fichero alumnos.txt
        pb1.redirectInput(new File("src/examen/ejercicio2/alumnos.txt"));

        //Creamos un ProcessBuilder para ejecutar el comando2
        ProcessBuilder pb2 = new ProcessBuilder(comando2);

        //redirecciono la salida del pb2 al fichero alumnos_mayores.txt
        pb2.redirectOutput(new File("src/examen/ejercicio2/alumnos_mayores.txt"));

        //Almacenaremos los pb en una lista para que la salida de pb1 vaya a la entrada de pb2
        List<ProcessBuilder> listaProcessBuilder = new ArrayList<>();
        listaProcessBuilder.add(pb1);
        listaProcessBuilder.add(pb2);

        //Indico que la salida de error estandar sea la Estandar
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);

        try {
            //Inicio la lista de procesos con el comando startPipeline(lpb) dando a entender que lo que estamos ejecutando es una pila de PB
            List<Process> listaProcesos = ProcessBuilder.startPipeline(listaProcessBuilder);

            for (Process p: listaProcesos) {
                //Espero a que termine el proceso
                p.waitFor();
                int retorno = p.exitValue();

                //Si el proceso ha terminado correctamente mostramos un mensaje
                if (retorno == 0) {
                    System.out.println("El proceso ha terminado correctamente");
                }else {
                    System.err.println("El proceso ha terminado con este código de error: "+retorno);
                }

            }


        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println(e.getLocalizedMessage());
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.err.println(e.getLocalizedMessage());
        }
    }
}
