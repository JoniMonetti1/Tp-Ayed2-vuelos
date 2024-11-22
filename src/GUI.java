import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GUI {
    private final GrafoDeDestinos grafoDeDestinos = new GrafoDeDestinos();
    private final List<Persona> pasajeros = new ArrayList<>();

    public void start() {

        cargaInicial();
        System.out.println();
        System.out.println();
        menu();

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        sc.nextLine();

        while (opcion != 9) {
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
                    System.out.print("Ingrese el origen: ");
                    InputOrigen = sc.nextLine().toLowerCase();
                    System.out.print("Ingrese el destino: ");
                    InputDestino = sc.nextLine().toLowerCase();
                    grafoDeDestinos.imprimirPasajerosDeVuelo(InputOrigen, InputDestino);
                    break;
                case 9:
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
        System.out.println("8. Mostrar los pasajeros de un vuelo");
        System.out.println("9. Salir");

        System.out.println();
    }


    private void cargaInicial() {
        Destino buenosAires = new Destino("buenos aires");
        Destino cordoba = new Destino("cordoba");
        Destino bariloche = new Destino("bariloche");
        Destino salta = new Destino("salta");
        Destino tucuman = new Destino("tucuman");
        Destino jujuy = new Destino("jujuy");
        Destino missiones = new Destino("misiones");
        Destino santaCruz = new Destino("santa cruz");

        grafoDeDestinos.agregarDestino(buenosAires);
        grafoDeDestinos.agregarDestino(cordoba);
        grafoDeDestinos.agregarDestino(bariloche);
        grafoDeDestinos.agregarDestino(salta);
        grafoDeDestinos.agregarDestino(tucuman);
        grafoDeDestinos.agregarDestino(jujuy);
        grafoDeDestinos.agregarDestino(missiones);
        grafoDeDestinos.agregarDestino(santaCruz);

        grafoDeDestinos.agregarVuelo("cordoba", "buenos aires", 120000.00);
        grafoDeDestinos.agregarVuelo("cordoba", "jujuy", 80000);
        grafoDeDestinos.agregarVuelo("cordoba", "bariloche", 200000);

        grafoDeDestinos.agregarVuelo("buenos aires", "cordoba", 150000);
        grafoDeDestinos.agregarVuelo("buenos aires", "jujuy", 120000);
        grafoDeDestinos.agregarVuelo("buenos aires", "bariloche", 250000);
        grafoDeDestinos.agregarVuelo("buenos aires", "misiones", 200000);
        grafoDeDestinos.agregarVuelo("buenos aires", "santa cruz", 350000);

        grafoDeDestinos.agregarVuelo("Jujuj", "cordoba", 75000);
        grafoDeDestinos.agregarVuelo("jujuy", "buenos aires", 120000);
        grafoDeDestinos.agregarVuelo("jujuy", "salta", 55000);
        grafoDeDestinos.agregarVuelo("jujuy", "tucuman", 68000);

        grafoDeDestinos.agregarVuelo("bariloche", "cordoba", 220000);
        grafoDeDestinos.agregarVuelo("bariloche", "buenos aires", 350000);
        grafoDeDestinos.agregarVuelo("bariloche", "santa cruz", 550000);

        grafoDeDestinos.agregarVuelo("misiones", "buenos aires", 170000);

        grafoDeDestinos.agregarVuelo("salta", "cordoba", 60000);
        grafoDeDestinos.agregarVuelo("salta", "buenos aires", 110000);
        grafoDeDestinos.agregarVuelo("salta", "jujuy", 80000);
        grafoDeDestinos.agregarVuelo("salta", "tucuman", 60000);

        grafoDeDestinos.agregarVuelo("tucuman", "cordoba", 55000);
        grafoDeDestinos.agregarVuelo("tucuman", "buenos aires", 1250000);
        grafoDeDestinos.agregarVuelo("tucuman", "jujuy", 20000);

        grafoDeDestinos.agregarVuelo("santa cruz", "buenos aires", 380000);
        grafoDeDestinos.agregarVuelo("santa cruz", "bariloche", 550000);

        Persona persona1 = new Persona(2, "Joni", "Monetti");
        Persona persona2 = new Persona(3, "Maria", "Gomez");
        Persona persona3 = new Persona(4, "Carlos", "Perez");
        Persona persona4 = new Persona(5, "Ana", "Lopez");
        Persona persona5 = new Persona(6, "Luis", "Martinez");
        Persona persona6 = new Persona(7, "Sofia", "Garcia");
        Persona persona7 = new Persona(8, "Miguel", "Rodriguez");

        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona1);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona2);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona3);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona4);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona5);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona6);
        grafoDeDestinos.cargarPasajeroEnVuelo("cordoba", "buenos aires", persona7);
    }
}
