public class ArbolAVL {
    private Nodo raiz;

    public Nodo insertar(Nodo nodo, int asiento, Persona persona) {
        if (raiz == null) {
            return new Nodo(asiento, persona);
        }
        if (asiento < nodo.getAsiento()) {
            nodo.setLeft(insertar(nodo.getLeft(), asiento, persona));
        } else if (asiento > nodo.getAsiento()) {
            nodo.setRight(insertar(nodo.getRight(), asiento, persona));
        } else {
            System.out.println("Aiento ya ocupado");
            return nodo;
        }

        nodo.setAltura(1+Math.max(getAltura(nodo.getLeft()), getAltura(nodo.getRight())));

        int balance = getBalanceo(nodo);
    }

    private int getAltura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.getAltura();
    }

    private int getBalanceo(Nodo nodo) {
        return (nodo == null) ? 0 : getAltura(nodo.getLeft()) - getAltura(nodo.getRight());
    }


}
