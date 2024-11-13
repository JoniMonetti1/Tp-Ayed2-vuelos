public class Nodo {
    private int asiento;
    private Persona persona;
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

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
