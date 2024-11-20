import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private Destino origen;
    private Destino destino;
    private double precioBase;
    private double precioActual;
    private ArbolAVL arbolAVL;
    private List<Pasajero> pasajeros;
    private final int capacidadMaxima = 10;

    public Vuelo(Destino origen, Destino destino, double precioBase) {
        this.origen = origen;
        this.destino = destino;
        this.precioBase = precioBase;
        this.precioActual = precioBase;
        this.arbolAVL = new ArbolAVL();
    }


    public Destino getOrigen() {
        return origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void agregarPasajero(int asiento, Persona persona) {
        if (arbolAVL.contarAsientos() >= capacidadMaxima) {
            System.out.println("Vuelo lleno, no se puede agregar más pasajeros.");
            return;
        }
        if (arbolAVL.existeAsiento(asiento)) {
            System.out.println("El asiento " + asiento + " ya está ocupado.");
            return;
        }
        arbolAVL.insertar(asiento, persona);
        actualizarPrecio();
        System.out.println("Pasajero " + persona.getNombre() + " " + persona.getApellido() + " asignado al asiento " + asiento);
    }

    public void mostrarAsientos() {
        System.out.println("Asientos ocupados:");
        arbolAVL.imprimirArbol();
    }

    private void actualizarPrecio() {
        double ocupacion = (double) arbolAVL.contarAsientos() / capacidadMaxima;

        if (ocupacion >= 0.8) {
            precioActual = precioBase * 0.6;
        } else if (ocupacion >= 0.7) {
            precioActual = precioBase * 0.8;
        } else if (ocupacion >= 0.5) {
            precioActual = precioBase * 0.9;
        } else {
            precioActual = precioBase;
        }
    }

    @Override
    public String toString() {
        return "Vuelo de " + origen.getNombre() + " a " + destino.getNombre() +
                " | Precio actual: $" + precioActual +
                " | Asientos ocupados: " + arbolAVL.contarAsientos() + "/" + capacidadMaxima;
    }
}
