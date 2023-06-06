/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase es una cola que se utiliza para poder utilizar el metodo breadthFirstTraversal (BFS)
 *
 * @author andresimery
 */
public class Queue<T> {
     //Campos de la clase
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    /**
     * Constructor
     * 
     */
    public Queue() {
        this.head = null;
        this.tail = null;
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

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
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
     * Agrega un elemento a la cola
     * 
     * @param data el elemento que agrega
     */
    public void enqueue(T data) {
        Nodo<T> node = new Nodo(data);
        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        
        size++;
    }
    
    /**
     * Quita un elemento de la cola
     * 
     * @return el elemento que quita
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        Nodo<T> temp = getHead();
        this.head = temp.getNext();
        temp.setNext(null);
        this.size--;
        return temp.getElement();
    }
    
    /**
     * Imprime la cola
     * 
     */
    public void print() {
        for (int i = 0; i < getSize(); i++) {
            T aux = dequeue();
            System.out.println(aux);
            enqueue(aux);
        }
    }
}

