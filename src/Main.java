import java.util.List;

public class Main {
    public static void main(String[] args) {

        GUI gui = new GUI();
        gui.start();

        //Codigo comentado sirve para comprobar que el codigo funciona correctamente

//
//        GrafoDeDestinos grafoDeDestinos = new GrafoDeDestinos();
//
//
//        Destino buenosAires = new Destino("Buenos Aires");
//        Destino cordoba = new Destino("Cordoba");
//        Destino bariloche = new Destino("Bariloche");
//        Destino salta = new Destino("Salta");
//        Destino tucuman = new Destino("Tucuman");
//        Destino jujuy = new Destino("Jujuy");
//        Destino missiones = new Destino("Misiones");
//        Destino santaCruz = new Destino("Santa Cruz");
//
//        grafoDeDestinos.agregarDestino(buenosAires);
//        grafoDeDestinos.agregarDestino(cordoba);
//        grafoDeDestinos.agregarDestino(bariloche);
//        grafoDeDestinos.agregarDestino(salta);
//        grafoDeDestinos.agregarDestino(tucuman);
//        grafoDeDestinos.agregarDestino(jujuy);
//        grafoDeDestinos.agregarDestino(missiones);
//        grafoDeDestinos.agregarDestino(santaCruz);
//
//        grafoDeDestinos.agregarVuelo("Cordoba", "Buenos Aires", 120000.00);
//        grafoDeDestinos.agregarVuelo("Cordoba", "Jujuy", 80000);
//        grafoDeDestinos.agregarVuelo("Cordoba", "Bariloche", 200000);
//
//        grafoDeDestinos.agregarVuelo("Buenos Aires", "Cordoba", 150000);
//        grafoDeDestinos.agregarVuelo("Buenos Aires", "Jujuy", 120000);
//        grafoDeDestinos.agregarVuelo("Buenos Aires", "Bariloche", 250000);
//        grafoDeDestinos.agregarVuelo("Buenos Aires", "Misiones", 200000);
//        grafoDeDestinos.agregarVuelo("Buenos Aires", "Santa Cruz", 350000);
//
//        grafoDeDestinos.agregarVuelo("Jujuj", "Cordoba", 75000);
//        grafoDeDestinos.agregarVuelo("Jujuy", "Buenos Aires", 120000);
//        grafoDeDestinos.agregarVuelo("Jujuy", "Salta", 55000);
//        grafoDeDestinos.agregarVuelo("Jujuy", "Tucuman", 68000);
//
//        grafoDeDestinos.agregarVuelo("Bariloche", "Cordoba", 220000);
//        grafoDeDestinos.agregarVuelo("Bariloche", "Buenos Aires", 350000);
//        grafoDeDestinos.agregarVuelo("Bariloche", "Santa Cruz", 550000);
//
//        grafoDeDestinos.agregarVuelo("Misiones", "Buenos Aires", 170000);
//
//        grafoDeDestinos.agregarVuelo("Salta", "Cordoba", 60000);
//        grafoDeDestinos.agregarVuelo("Salta", "Buenos Aires", 110000);
//        grafoDeDestinos.agregarVuelo("Salta", "Jujuy", 80000);
//        grafoDeDestinos.agregarVuelo("Salta", "Tucuman", 60000);
//
//        grafoDeDestinos.agregarVuelo("Tucuman", "Cordoba", 55000);
//        grafoDeDestinos.agregarVuelo("Tucuman", "Buenos Aires", 1250000);
//        grafoDeDestinos.agregarVuelo("Tucuman", "Jujuy", 20000);
//
//        grafoDeDestinos.agregarVuelo("Santa Cruz", "Buenos Aires", 380000);
//        grafoDeDestinos.agregarVuelo("Santa Cruz", "Bariloche", 550000);
//
//
//        System.out.println("Ruta mas barata de Cordoba a Santa Cruz:");
//        List<Vuelo> vuelo = grafoDeDestinos.buscarVueloMasBarato("Cordoba", "Santa Cruz");
//        grafoDeDestinos.imprimirRuta(vuelo);
//
//        System.out.println();
//
//        Persona persona1 = new Persona(2, "Joni", "Monetti");
//        Persona persona2 = new Persona(3, "Maria", "Gomez");
//        Persona persona3 = new Persona(4, "Carlos", "Perez");
//        Persona persona4 = new Persona(5, "Ana", "Lopez");
//        Persona persona5 = new Persona(6, "Luis", "Martinez");
//        Persona persona6 = new Persona(7, "Sofia", "Garcia");
//        Persona persona7 = new Persona(8, "Miguel", "Rodriguez");
//
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona1);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona2);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona3);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona4);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona5);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona6);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona7);
//        grafoDeDestinos.cargarPasajeroEnVuelo("Cordoba", "Buenos Aires", persona7);
//
//        System.out.println();
//
//        grafoDeDestinos.imprimirVuelos();
//
//        System.out.println("Todos los pasajeros de todos los vuelos:");
//        grafoDeDestinos.imprimirPasajerosDeTodosLosVuelos();

    }
}