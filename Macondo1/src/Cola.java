public class Cola {
    private Nodo cabeza;
    private Nodo cola;
    private Nodo cabezaAux;
    private Nodo colazaAux;

    public Cola() {
    }

    public Cola(Nodo cabeza, Nodo cola, Nodo cabezaAux, Nodo colazaAux) {
        this.cabeza = cabeza;
        this.cola = cola;
        this.cabezaAux = cabezaAux;
        this.colazaAux = colazaAux;
    }
    //--------------------------------------------------------------------

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public Nodo getCabezaAux() {
        return cabezaAux;
    }

    public void setCabezaAux(Nodo cabezaAux) {
        this.cabezaAux = cabezaAux;
    }

    public Nodo getColazaAux() {
        return colazaAux;
    }

    public void setColazaAux(Nodo colazaAux) {
        this.colazaAux = colazaAux;
    }
}
