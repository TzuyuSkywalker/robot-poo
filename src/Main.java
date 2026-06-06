import Clases.*;
import Interfaces.*;
import java.util.Scanner;
import java.util.ArrayList;


void main(){

    Scanner scanner = new Scanner(System.in);
    Robot robot = null;
    int opcion;
    ArrayList<iTraccion> listaTracciones = Main.crearTraccionesDisponibles();

    do{
        Main.mostrarMenu();
        opcion = Main.pedirEntero(scanner, "Seleccione una opcion: ");
        switch (opcion){
            case 1:
                robot = Main.crearRobot(scanner);
                System.out.println("Robot creado correctamente.");
                break;

            case 2:
                Main.mostrarTracciones(listaTracciones);
                break;

            case 3:
                if (robot == null){
                    System.out.println("Primero debe crear un robot.");
                }else{
                    iTraccion traccionElegida = Main.elegirTraccion(scanner, listaTracciones);
                    robot.setTraccion(traccionElegida);
                    System.out.println("Traccion asignada correctamente.");
                }
                break;

            case 4:
                if (robot == null){
                    System.out.println("Primero debe crear un robot.");
                }else if (robot.tieneTraccion() == false){
                    System.out.println("Primero debe asignar una traccion.");
                }else{
                    Main.simularRecorrido(scanner, robot);
                    robot.encenderLuces();


                }
                break;

            case 5:
                if (robot == null){
                    System.out.println("Primero debe crear un robot.");
                }else{
                    robot.mostrarDatos();
                }
                break;

            case 6:
                if (robot == null){
                    System.out.println("Primero debe crear un robot.");
                }else{
                    robot.reiniciarKilometros();
                    System.out.println("Kilometros reiniciados.");
                }
                break;

            case 7:
                System.out.println("Programa finalizado.");
                break;

            default:
                System.out.println("Opcion inexistente.");
                break;
        }
    }while(opcion != 7);
    scanner.close();
}