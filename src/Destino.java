import java.util.ArrayList;
import java.util.List;

public class Destino {
    private String nombre;
    private List<Vuelo> vuelos;


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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

}
