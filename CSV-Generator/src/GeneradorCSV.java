import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;

public class GeneradorCSV {
    public static void main(String[] args) {
    	//se crea el scanner para poder leer el input de el teclado
        Scanner scanner = new Scanner(System.in);
        //se le pide al usario que entre el nombre de la compañía
        System.out.print("Ingrese el nombre de la compañía: ");
        String compania = scanner.nextLine();
        //se le pide al usario que entre la dirección de las facilidades
        System.out.print("Ingrese la dirección de las facilidades: ");
        String facilidades = scanner.nextLine();
        //se le pide al usario el departamento
        System.out.print("Ingrese la información del departamento: ");
        String departamento = scanner.nextLine();
        //se le pide al usario el nombre del encargado
        System.out.print("Ingrese el nombre del encargado: ");
        String encargado = scanner.nextLine();
        //se obtiene la fecha actual
        LocalDate fechaActual = LocalDate.now();
        //se le da el nombre al archivo
        String nombreArchivo = "mi_archivo.csv";
        
        //se crea y se entra la información al archivo CSV con FileWrite y Print
        try (FileWriter fileWriter = new FileWriter(nombreArchivo);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(compania + ",,,,,,,");
            printWriter.println(facilidades + ",,,,,,,");
            printWriter.println(departamento + ",,,,,,,");
            
            printWriter.printf("Fecha: %s%n", fechaActual + ",,,,,,," );
            printWriter.printf("Encargado: %s%n", encargado + ",,,,,,,");

            printWriter.println("Numero, Material, SN");
            printWriter.println("Dato 1, Dato 2, Dato 3");
            printWriter.println("Dato 4, Dato 5, Dato 6");

            System.out.printf("Archivo %s creado exitosamente.%n", nombreArchivo);

        } catch (IOException e) {
        	//muestra un mensaje de error si hay problemas al crear el archivo
            System.err.println("Error al crear el archivo CSV.");
            e.printStackTrace();
        }
    }
}