import java.util.Scanner;

public class MostrarMenu {
    public void Mostrar(){
        Scanner scanner = new Scanner(System.in);
        Metodos M = new Metodos();
        int opcion = 0;
        do{
            System.out.println("----- MENU -----");  // Imprime el título del menú
            System.out.println("1. Registrar paciente en la cola");  // Imprime la opción 1 del menú
            System.out.println("2. Retirar paciente de la cola");  // Imprime la opción 2 del menú
            System.out.println("3. Partir la cola");  // Imprime la opción 3 del menú
            System.out.println("4. Unir colas");  // Imprime la opción 4 del menú
            System.out.println("5. Mostrar estado de la cola");  // Imprime la opción 5 del menú
            System.out.println("6. Salir");  // Imprime la opción 6 del menú
            System.out.print("Ingrese una opción: ");  // Solicita al usuario que ingrese una opción
            opcion = scanner.nextInt();  // Lee la opción ingresada por el usuario

            switch (opcion){
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");  // Solicita al usuario que ingrese el nombre del paciente
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    M.registrarPaciente(nombre);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del paciente a retirar: ");  // Solicita al usuario que ingrese el nombre del paciente a retirar
                    scanner.nextLine();
                    String pacienteARetirar = scanner.nextLine();
                    M.retirarPaciente(pacienteARetirar);
                    break;
                case 3:
                    int numPacientes1 = M.contarPacientes() /2;
                    M.partirColaGuardarAuxiliar(numPacientes1);
                    break;
                case 4:
                    M.unirColas();
                    break;
                case 5:
                    M.mostrar();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        }while(opcion !=6);
    }
}
