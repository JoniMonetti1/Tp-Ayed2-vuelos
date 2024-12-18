import java.util.ArrayList;
import java.util.List;

public class Destino {
    private final String nombre;
    private final List<Vuelo> vuelos;


    public Destino(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

}
