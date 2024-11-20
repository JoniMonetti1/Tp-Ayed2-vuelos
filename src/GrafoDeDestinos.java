import java.util.*;

public class GrafoDeDestinos {
    private Map<String, Destino> destinos;

    public GrafoDeDestinos() {
        this.destinos = new HashMap<>();
    }

    public void agregarDestino(Destino destino) {
        if (destinos.containsKey(destino.getNombre())) {
            return;
        }
        destinos.put(destino.getNombre(), destino);
    }

    public void agregarVuelo(String origen, String destino, double precioBase) {
        if (!destinos.containsKey(origen) || !destinos.containsKey(destino)) {
            return;
        }
        Destino origenDestino = destinos.get(origen);
        Destino destinoDestino = destinos.get(destino);
        Vuelo vuelo = new Vuelo(origenDestino, destinoDestino, precioBase);
        origenDestino.agregarVuelo(vuelo);
    }

    public void imprimirVuelos() {
        destinos.forEach((nombreDestino, destino) -> {
            System.out.println("Destino: " + nombreDestino);
            destino.getVuelos().forEach(System.out::println);
            System.out.println();
        });
    }

    public List<Vuelo> buscarVueloMasBarato(String origen, String destino) {
        if (!destinos.containsKey(origen) || !destinos.containsKey(destino)) {
            return null;
        }

        Destino origenDestino = destinos.get(origen);
        Destino destinoDestino = destinos.get(destino);

        Map<Destino, Double> precios = new HashMap<>();
        Map<Destino, Vuelo> vuelosPrevios = new HashMap<>();
        PriorityQueue<Destino> cola = new PriorityQueue<>(Comparator.comparing(precios::get));

        for (Destino d : destinos.values()) {
            precios.put(d, Double.MAX_VALUE);
        }
        precios.put(origenDestino, 0.0);
        cola.add(origenDestino);

        while (!cola.isEmpty()) {
            Destino actual = cola.poll();

            if (actual.equals(destinoDestino)) {
                break;
            }

            for (Vuelo vuelo : actual.getVuelos()) {
                Destino vecino = vuelo.getDestino();
                double nuevoPrecio = precios.get(actual) + vuelo.getPrecioBase();

                if (nuevoPrecio < precios.get(vecino)) {
                    precios.put(vecino, nuevoPrecio);
                    vuelosPrevios.put(vecino, vuelo);
                    cola.add(vecino); // Añade el vecino con menor distancia.
                }
            }
        }

        List<Vuelo> ruta = new LinkedList<>();
        Destino actual = destinoDestino;

        while (vuelosPrevios.containsKey(actual)) {
            Vuelo vuelo = vuelosPrevios.get(actual);
            ruta.add(0, vuelo);
            actual = vuelo.getOrigen();
        }

        if (ruta.isEmpty() || !ruta.get(0).getOrigen().equals(origenDestino)) {
            return null;
        }

        return ruta;
    }

    public void imprimirRuta(List<Vuelo> ruta) {
        if (ruta == null) {
            System.out.println("No se encontró una ruta.");
            return;
        }

        double precioTotal = 0;
        for (Vuelo vuelo : ruta) {
            System.out.println("Vuelo de " + vuelo.getOrigen().getNombre() + " a " + vuelo.getDestino().getNombre() + " por $" + vuelo.getPrecioBase());
            precioTotal += vuelo.getPrecioBase();
        }
        System.out.println("Precio total: " + precioTotal);
    }

    public void cargarPasajeroEnVuelo(String origen, String destino, Persona persona) {
        if (!destinos.containsKey(origen) || !destinos.containsKey(destino)) {
            System.out.println("Origen o destino no válido.");
            return;
        }

        Destino origenDestino = destinos.get(origen);
        for (Vuelo vuelo : origenDestino.getVuelos()) {
            if (vuelo.getDestino().getNombre().equals(destino)) {
                vuelo.agregarPasajero(persona);
                return;
            }
        }
        System.out.println("Vuelo no encontrado entre " + origen + " y " + destino);
    }

    public void imprimirPasajerosDeTodosLosVuelos() {
        for (Destino destino : destinos.values()) {
            for (Vuelo vuelo : destino.getVuelos()) {
                vuelo.imprimirPasajeros();
            }
        }
    }
}
