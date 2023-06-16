public class Nodo {
    private String nombre;
    private Nodo Siguiente;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }
    public Nodo(String nombre, Nodo siguiente) {
        this.nombre = nombre;
        Siguiente = siguiente;
    }
    //-------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }
}
