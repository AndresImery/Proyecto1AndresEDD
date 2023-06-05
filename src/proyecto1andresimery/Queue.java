/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/**
 *
 * @author andresimery
 */
public class Queue<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

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
    
    public void print() {
        for (int i = 0; i < getSize(); i++) {
            T aux = dequeue();
            System.out.println(aux);
            enqueue(aux);
        }
    }
}

