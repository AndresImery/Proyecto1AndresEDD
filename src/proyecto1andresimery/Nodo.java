/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase permite organizar objetos enlazandolos entre si
 *
 * @author andresimery
 */
public class Nodo<T> {
     //Campos de la clase
    private Nodo<T> next;
    private T element;

    /**
     * Constructor
     * @param element Recibe element para poder guardar cualquier objeto
     */
    public Nodo(T element) {
        this.next = null;
        this.element = element;
    }

    /**
     * Getters y Setters
     * 
     */
    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
    
}
