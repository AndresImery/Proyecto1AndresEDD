/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase es una pila utilizada para poder aplicar el método de depthFirstTraversal (DFS)
 *
 * @author andresimery
 */
public class Stack<T> {
     //Campos de la clase
    private Nodo<T> head;
    private int size;

    /**
     * Constructor
     * 
     */
    public Stack() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Getters y Setters
     * 
     */
    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    /**
     * Agrega un elemento a la pila
     * 
     * @param element el elemento que agrega
     */
    public void push(T element) {
        Nodo<T> node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            node.setNext(getHead());
            setHead(node);
        }
        size++;
    }
    
    /**
     * Quita un elemento de la pila
     * 
     * @return devuelve un nodo del elemento
     */
    public Nodo<T> pop() {
        Nodo<T> node;
        if (!isEmpty()) {
            node = getHead();
            setHead(getHead().getNext());
            node.setNext(null);
        } else {
            node = null;
        }
        return node;
    }
    
}

