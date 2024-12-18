public class Vuelo {
    private final Destino origen;
    private final Destino destino;
    private double precioBase;
    private final ArbolAVL arbolAVL;
    private final int capacidadMaxima = 10;
    private final AsientoRandom asientoRandom;

    public Vuelo(Destino origen, Destino destino, double precioBase) {
        this.origen = origen;
        this.destino = destino;
        this.precioBase = precioBase;
        this.arbolAVL = new ArbolAVL();
        this.asientoRandom = new AsientoRandom();
    }


    public void agregarPasajero(Persona persona) {
        if (arbolAVL.contarAsientos() >= capacidadMaxima) {
            System.out.println("Vuelo lleno, no se puede agregar más pasajeros.");
            return;
        }

        int asiento;
        do {
            asiento = asientoRandom.generarAsiento();
        } while (arbolAVL.existeAsiento(asiento));

        arbolAVL.insertar(asiento, persona);
        actualizarPrecio();
        System.out.println("Pasajero " + persona.getNombre() + " " + persona.getApellido() + " asignado al asiento " + asiento + " de " + origen.getNombre() + " a " + destino.getNombre());
    }

    public void mostrarAsientos() {
        System.out.println("Asientos ocupados:");
        arbolAVL.imprimirArbol();
    }

    private void actualizarPrecio() {
        double ocupacion = (double) arbolAVL.contarAsientos() / capacidadMaxima;

        if (ocupacion >= 0.8) {
            precioBase = precioBase * 0.6;
        } else if (ocupacion >= 0.7) {
            precioBase = precioBase * 0.8;
        } else if (ocupacion >= 0.5) {
            precioBase = precioBase * 0.9;
        }
    }

    public void imprimirPasajeros() {
        if (arbolAVL.contarAsientos() == 0) {
            return;
        }
        System.out.println("Pasajeros en el vuelo de " + origen.getNombre() + " a " + destino.getNombre() + ":");
        arbolAVL.imprimirArbol();
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

    @Override
    public String toString() {
        return "Vuelo de " + origen.getNombre() + " a " + destino.getNombre() +
                " | Precio actual: $" + precioBase +
                " | Asientos ocupados: " + arbolAVL.contarAsientos() + "/" + capacidadMaxima;
    }
}
