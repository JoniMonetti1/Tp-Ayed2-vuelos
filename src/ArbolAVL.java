public class ArbolAVL {
    private Nodo raiz;

    public Nodo insertar(Nodo nodo, int asiento, Persona persona) {
        if (nodo == null) {
            return new Nodo(asiento, persona);
        }
        if (asiento < nodo.getAsiento()) {
            nodo.setLeft(insertar(nodo.getLeft(), asiento, persona));
        } else if (asiento > nodo.getAsiento()) {
            nodo.setRight(insertar(nodo.getRight(), asiento, persona));
        } else {
            System.out.println("Asiento ocupado");
            return nodo;
        }

        nodo.setAltura(1 + Math.max(getAltura(nodo.getLeft()), getAltura(nodo.getRight())));

        int balance = getBalanceo(nodo);

        //caso 1: rotacion a la derecha
        if (balance > 1 && asiento < nodo.getLeft().getAsiento()) {
            return rotacionDerecha(nodo);
        }

        //caso 2: rotacion a la izquierda
        if (balance < -1 && asiento > nodo.getRight().getAsiento()) {
            return rotacionIzquierda(nodo);
        }

        //caso 3: rotacion izquierda-derecha
        if (balance > 1 && asiento > nodo.getLeft().getAsiento()) {
            nodo.setLeft(rotacionIzquierda(nodo.getLeft()));
            return rotacionDerecha(nodo);
        }

        //caso 4: rotacion derecha-izquierda
        if (balance < -1 && asiento < nodo.getRight().getAsiento()) {
            nodo.setRight(rotacionDerecha(nodo.getRight()));
            return rotacionIzquierda(nodo);
        }

        return nodo;

    }

    private int getAltura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    private int getBalanceo(Nodo nodo) {
        return (nodo == null) ? 0 : getAltura(nodo.getLeft()) - getAltura(nodo.getRight());
    }

    private Nodo rotacionDerecha(Nodo nodo) {
        Nodo temp = nodo.getLeft();
        nodo.setLeft(temp.getRight());
        temp.setRight(nodo);
        nodo.setAltura(1 + Math.max(getAltura(nodo.getLeft()), getAltura(nodo.getRight())));
        temp.setAltura(1 + Math.max(getAltura(temp.getLeft()), getAltura(temp.getRight())));
        return temp;
    }

    private Nodo rotacionIzquierda(Nodo nodo) {
        Nodo temp = nodo.getRight();
        nodo.setRight(temp.getLeft());
        temp.setLeft(nodo);
        nodo.setAltura(1 + Math.max(getAltura(nodo.getLeft()), getAltura(nodo.getRight())));
        temp.setAltura(1 + Math.max(getAltura(temp.getLeft()), getAltura(temp.getRight())));
        return temp;
    }

    // Metodo para iniciar la insercion desde la raiz
    public void insertar(int asiento, Persona persona) {
        raiz = insertar(raiz, asiento, persona);
    }

    private boolean existeAsiento(Nodo nodo, int asiento) {
        if (nodo == null) {
            return false;
        }
        if (asiento < nodo.getAsiento()) {
            return existeAsiento(nodo.getLeft(), asiento);
        } else if (asiento > nodo.getAsiento()) {
            return existeAsiento(nodo.getRight(), asiento);
        } else {
            return true;
        }
    }

    public boolean existeAsiento(int asiento) {
        return existeAsiento(raiz, asiento);
    }

    public int contarAsientos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarAsientos(nodo.getLeft()) + contarAsientos(nodo.getRight());
    }

    public int contarAsientos() {
        return contarAsientos(raiz);
    }

    public void cargarTripulantes() {
        AsientoRandom asientoRandom = new AsientoRandom();

        Persona[] tripulantes = {
                new Persona(1, "Juan", "Perez"),
                new Persona(2, "Maria", "Gomez"),
                new Persona(3, "Pedro", "Gonzalez"),
                new Persona(4, "Ana", "Rodriguez"),
                new Persona(5, "Luis", "Fernandez"),
                new Persona(6, "Laura", "Lopez"),
                new Persona(7, "Carlos", "Martinez"),
                new Persona(8, "Sofia", "Sanchez"),
                new Persona(9, "Jorge", "Diaz"),
                new Persona(10, "Marta", "Torres")
        };

        while (contarAsientos() < 10) {
            int asiento = asientoRandom.generarAsiento();
            if (!existeAsiento(asiento)) {
                int index = contarAsientos();
                insertar(asiento, tripulantes[index]);
                System.out.println("Asiento " + asiento + " ocupado por " + tripulantes[index].getNombre() + " " + tripulantes[index].getApellido());
            } else {
                System.out.println("Asiento " + asiento + " ocupado. Generando un nuevo asiento...");
            }
        }
    }

    public void imprimirArbol() {
        imprimirArbol(raiz, "", true);
    }

    private void imprimirArbol(Nodo nodo, String prefix, boolean isTail) {
        if (nodo == null) {
            return;
        }
        System.out.println(prefix + (isTail ? "└── " : "├── ") + nodo.getAsiento() + " (" + nodo.getPersona().getNombre() + " " + nodo.getPersona().getApellido() + ")");
        imprimirArbol(nodo.getLeft(), prefix + (isTail ? "    " : "│   "), false);
        imprimirArbol(nodo.getRight(), prefix + (isTail ? "    " : "│   "), true);
    }
}
