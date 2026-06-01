package Clases;
import Interfaces.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void mostrarMenu(){
        System.out.println();
        System.out.println("1. Crear robot");
        System.out.println("2. Mostrar tracciones disponibles");
        System.out.println("3. Asignar o cambiar traccion");
        System.out.println("4. Simular recorrido");
        System.out.println("5. Mostrar datos del robot");
        System.out.println("6. Reiniciar kilometros de la traccion");
        System.out.println("7. Salir");
    }

    public static int pedirEntero(Scanner scanner, String mensaje){
        int numero = 0;
        boolean valido = false;

        while (valido == false){
            System.out.print(mensaje);
            try{
                numero = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            }
            catch (Exception e){
                System.out.println("Debe ingresar un numero entero.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    public static ArrayList<iTraccion> crearTraccionesDisponibles(){
        ArrayList<iTraccion> tracciones = new ArrayList<>();
        tracciones.add(new RuedaDeCaucho());
        tracciones.add(new Oruga());
        return tracciones;
    }

    public static void mostrarTracciones(ArrayList<iTraccion> tracciones){
        for (int i = 0; i < tracciones.size(); i++){
            System.out.println((i + 1) + ". " + tracciones.get(i).obtenerTipo());
        }
    }

    public static iTraccion elegirTraccion(Scanner scanner, ArrayList<iTraccion> tracciones){
        mostrarTracciones(tracciones);
        int opcion = pedirEntero(scanner, "Seleccione una traccion: ");
        while (opcion < 1 || opcion > tracciones.size()) {
            opcion = pedirEntero(scanner, "Seleccione una opcion valida: ");
        }
        return tracciones.get(opcion - 1);
    }

    public static Robot crearRobot(Scanner scanner){
        System.out.print("Numero de serie: ");
        String numeroSerie = scanner.nextLine();
        int potencia = pedirEntero(scanner, "Potencia base: ");
        while (potencia <= 0) {
            System.out.println("La potencia debe ser mayor a 0.");
            potencia = pedirEntero(scanner, "Potencia base: ");
        }
        return new Robot(numeroSerie, potencia);
    }

    public static void simularRecorrido(Scanner scanner, Robot robot){
        int km = pedirEntero(scanner, "Ingrese kilometros: ");
        while (km <= 0){
            System.out.println("Los kilometros deben ser mayores a 0.");
            km = pedirEntero(scanner, "Ingrese kilometros: ");
        }
        robot.avanzar(km);
        if (robot.necesitaReemplazo()){
            System.out.println("La traccion necesita reemplazo.");
        }
    }
}