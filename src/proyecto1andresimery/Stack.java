/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/**
 *
 * @author andresimery
 */
public class Stack<T> {
    private Nodo<T> head;
    private int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

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

