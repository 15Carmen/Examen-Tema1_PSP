package examen.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEj2 {
    public static void main(String[] args) {

        //Creamos dos ProcessBuilder para ejecutar los dos programas
        ProcessBuilder pb1 = new ProcessBuilder("Java","src/examen/ejercicio2/MayoresEdad.java");
        ProcessBuilder pb2 = new ProcessBuilder("Java","src/examen/ejercicio2/OrdenaNombres.java");

        //Almacenaremos los pb en una lista para que la salida de pb1 vaya a la entrada de pb2
        List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
        lpb.add(pb1);
        lpb.add(pb2);

        //Redirecciono la entrada estandar por la del fichero donde se encuentran los alumnos
        pb1.redirectInput(new File("src/examen/ficheros/alumnos.txt"));

        //Redirecciono la salida estandar por la del fichero donde se van a escribir los alumnos mayores de edad sin la edad
        pb2.redirectOutput(new File("src/examen/ficheros/alumnos_mayores.txt"));

        //Indico que la salida de error estandar sea la Estandar
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);

        try{
            //Inicio la lista de procesos con el comando startPipeline(lpb) dando a entender que lo que estamos ejecutando es una pila de PB
            List<Process> lProcess = ProcessBuilder.startPipeline(lpb);
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println(e.getLocalizedMessage());
        }
    }
}
