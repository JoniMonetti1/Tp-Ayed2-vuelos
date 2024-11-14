// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArbolAVL avion = new ArbolAVL();
        avion.cargarTripulantes();

        System.out.println();
        System.out.println("Árbol AVL con tripulantes cargados:");
        avion.imprimirArbol();
    }
}