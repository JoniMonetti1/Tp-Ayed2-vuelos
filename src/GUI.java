import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GUI {
    private GrafoDeDestinos grafoDeDestinos = new GrafoDeDestinos();
    private List<Persona> pasajeros = new ArrayList<>();

    public void start() {

        menu();

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();

        while (opcion != 8) {
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del destino: ");
                    String nombreDestino = sc.nextLine().toLowerCase();
                    Destino destino = new Destino(nombreDestino);
                    grafoDeDestinos.agregarDestino(destino);
                    break;
                case 2:
                    System.out.print("Ingrese el origen: ");
                    String InputOrigen = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el destino: ");
                    String InputDestino = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el precio: ");
                    double precio = sc.nextDouble();
                    grafoDeDestinos.agregarVuelo(InputOrigen, InputDestino, precio);
                    break;
                case 3:
                    grafoDeDestinos.imprimirVuelos();
                    break;
                case 4:
                    grafoDeDestinos.imprimirDestinos();
                    break;
                case 5:
                    System.out.print("Ingrese el origen: ");
                    InputOrigen = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el destino: ");
                    InputDestino = sc.nextLine().toLowerCase();
                    List<Vuelo> vuelos = grafoDeDestinos.buscarVueloMasBarato(InputOrigen, InputDestino);
                    grafoDeDestinos.imprimirRuta(vuelos);
                    break;
                case 6:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = sc.nextLine();
                    System.out.print("Ingrese el id: ");
                    int id = sc.nextInt();
                    Persona persona = new Persona(id, nombre, apellido);
                    pasajeros.add(persona);
                    break;
                case 7:
                    System.out.print("Ingrese el origen: ");
                    InputOrigen = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el destino: ");
                    InputDestino = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el id del pasajero: ");
                    int idPasajero = sc.nextInt();
                    Persona pasajero = pasajeros.stream().filter(p -> p.getId() == idPasajero).findFirst().orElse(null);
                    grafoDeDestinos.cargarPasajeroEnVuelo(InputOrigen, InputDestino, pasajero);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            System.out.println();
            menu();
            opcion = sc.nextInt();
            sc.nextLine();
        }

    }

    private void menu() {
        System.out.println("Ingrese una opción: ");

        System.out.println("1. Ingresar un destino");
        System.out.println("2. Ingresar un vuelo");
        System.out.println("3. Mostrar vuelos");
        System.out.println("4. Mostrar destinos");
        System.out.println("5. Buscar vuelo más barato");
        System.out.println("6. Cargar pasajero");
        System.out.println("7. Cargar pasajero en un vuelo");
        System.out.println("8. Salir");

        System.out.println();
    }
}
