public class Metodos {
    Cola col = new Cola(); // Instancia compartida de la clase Cola

    public void registrarPaciente(String nombre) {
        Nodo nuevoNodo = new Nodo(nombre); // Crea un nuevo nodo con el nombre del paciente
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola
        Nodo C = col.getCola(); // Obtiene el nodo de la cola de la cola

        if (P == null) { // Comprueba si la cola está vacía
            col.setCabeza(nuevoNodo); // Establece el nuevo nodo como la cabeza de la cola
            col.setCola(nuevoNodo); // Establece el nuevo nodo como la cola de la cola
        } else {
            C.setSiguiente(nuevoNodo); // Establece el nuevo nodo como el siguiente nodo después del último nodo de la cola
            col.setCola(nuevoNodo); // Establece el nuevo nodo como la cola de la cola
        }

        System.out.println("Paciente '" + nombre + "' registrado correctamente."); // Imprime un mensaje de confirmación
    }

    public void retirarPaciente(String nombre) {
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola

        if (P == null) { // Comprueba si la cola está vacía
            System.out.println("La cola está vacía."); // Imprime un mensaje de que la cola está vacía
            return;
        }

        if (P.getNombre().equals(nombre)) { // Comprueba si el paciente a retirar es el primero de la cola
            col.setCabeza(P.getSiguiente()); // Establece el siguiente nodo como la nueva cabeza de la cola
            System.out.println("Paciente '" + nombre + "' retirado correctamente."); // Imprime un mensaje de confirmación
            return;
        }

        Nodo nodoActual = P;
        while (nodoActual.getSiguiente() != null) { // Recorre la cola hasta encontrar el paciente a retirar
            if (nodoActual.getSiguiente().getNombre().equals(nombre)) { // Comprueba si el siguiente nodo contiene al paciente a retirar
                nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente()); // Salta el nodo que contiene al paciente a retirar
                System.out.println("Paciente '" + nombre + "' retirado correctamente."); // Imprime un mensaje de confirmación
                return;
            }
            nodoActual = nodoActual.getSiguiente(); // Avanza al siguiente nodo de la cola
        }

        System.out.println("El paciente '" + nombre + "' no se encuentra en la cola."); // Imprime un mensaje de que el paciente no se encuentra en la cola
    }

    public void partirColaGuardarAuxiliar(int numPacientes1) {
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola
        Nodo CabezaAux = null; // Cabeza de la cola auxiliar
        Nodo ColaAux = null; // Cola de la cola auxiliar

        if (P == null || numPacientes1 >= contarPacientes()) { // Comprueba si la cola está vacía o si el número de pacientes para la primera cola es mayor o igual que el tamaño de la cola actual
            System.out.println("El número de pacientes para la primera cola es mayor o igual que el tamaño de la cola actual.");
            return;
        }

        Nodo nodoActual = P;
        int contador = 1;
        while (contador < numPacientes1) { // Recorre la cola hasta llegar al número de pacientes para la primera cola
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }

        CabezaAux = nodoActual.getSiguiente(); // Establece el siguiente nodo como la cabeza de la cola auxiliar
        ColaAux = col.getCola(); // Obtiene el nodo de la cola de la cola
        nodoActual.setSiguiente(null); // Establece el siguiente nodo como nulo para truncar la cola original

        col.setCabezaAux(CabezaAux); // Establece la cabeza de la cola auxiliar
        col.setColazaAux(ColaAux); // Establece la cola de la cola auxiliar

        System.out.println("Cola original:"); // Imprime un mensaje para indicar que se mostrará la cola original
        mostrarCola(P); // Muestra la cola original

        System.out.println("Cola auxiliar:"); // Imprime un mensaje para indicar que se mostrará la cola auxiliar
        mostrarCola(CabezaAux); // Muestra la cola auxiliar
    }

    public void unirColas() {
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola
        Nodo aux = col.getCabezaAux(); // Obtiene el nodo de la cabeza de la cola auxiliar

        if (aux == null) { // Comprueba si la cola auxiliar está vacía
            System.out.println("No hay cola auxiliar para unir."); // Imprime un mensaje de que no hay cola auxiliar para unir
            return;
        }

        Nodo nodoActual = P;
        while (nodoActual.getSiguiente() != null) { // Recorre la cola hasta llegar al último nodo
            nodoActual = nodoActual.getSiguiente();
        }

        nodoActual.setSiguiente(aux); // Une la cola auxiliar al final de la cola original

        System.out.println("Colas unidas:"); // Imprime un mensaje para indicar que se mostrarán las colas unidas
        mostrarCola(P); // Muestra las colas unidas

        col.setCabezaAux(null); // Restablece la cabeza de la cola auxiliar a nulo
        col.setColazaAux(null); // Restablece la cola de la cola auxiliar a nulo
    }

    public int contarPacientes() {
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola
        int contador = 0; // Inicializa el contador en 0

        Nodo nodoActual = P;
        while (nodoActual != null) { // Recorre la cola hasta llegar al último nodo
            contador++; // Incrementa el contador
            nodoActual = nodoActual.getSiguiente(); // Avanza al siguiente nodo de la cola
        }

        return contador; // Devuelve el número de pacientes contados
    }

    public void mostrarCola(Nodo cabeza) {
        if (cabeza == null) { // Comprueba si la cabeza de la cola está vacía
            System.out.println("La cola está vacía."); // Imprime un mensaje de que la cola está vacía
            return;
        }

        Nodo nodoActual = cabeza;
        while (nodoActual != null) { // Recorre la cola hasta llegar al último nodo
            System.out.println("Paciente: " + nodoActual.getNombre()); // Imprime el nombre del paciente
            nodoActual = nodoActual.getSiguiente(); // Avanza al siguiente nodo de la cola
        }
    }

    public void mostrar() {
        Nodo P = col.getCabeza(); // Obtiene el nodo de la cabeza de la cola
        Nodo aux = col.getCabezaAux(); // Obtiene el nodo de la cabeza de la cola auxiliar

        System.out.println("Cola original:"); // Imprime un mensaje para indicar que se mostrará la cola original
        mostrarCola(P); // Muestra la cola original

        System.out.println("Cola auxiliar:"); // Imprime un mensaje para indicar que se mostrará la cola auxiliar
        mostrarCola(aux); // Muestra la cola auxiliar
    }
}
