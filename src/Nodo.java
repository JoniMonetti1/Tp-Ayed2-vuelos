public class Nodo {
    private final int asiento;
    private final Persona persona;
    private Nodo left;
    private Nodo right;
    private int altura;

    public Nodo(int asiento, Persona persona) {
        this.asiento = asiento;
        this.persona = persona;
        this.left = null;
        this.right = null;
        this.altura = 1;
    }

    public int getAsiento() {
        return asiento;
    }

    public Persona getPersona() {
        return persona;
    }

    public Nodo getLeft() {
        return left;
    }

    public void setLeft(Nodo left) {
        this.left = left;
    }

    public Nodo getRight() {
        return right;
    }

    public void setRight(Nodo right) {
        this.right = right;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
