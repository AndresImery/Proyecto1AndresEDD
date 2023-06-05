/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/**
 *
 * @author andresimery
 */
public class List<T> {
    private Nodo<T> head;
    private int size;

    public List() {
        this.head = null;
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
    
    public void insertLast(T element) {
        Nodo<T> node = new Nodo<>(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
        size++;
    }
    
    public void deleteInIndex(int index) {
        if (index <= getSize()) {
            Nodo<T> pointer = getHead();
            for (int i = 0; i < index; i++) {
                pointer = pointer.getNext();
            }

            pointer.setNext(pointer.getNext().getNext());
            size--;
        }
    }
    
    public void printList() {
        System.out.println("-----");
        Nodo pointer = getHead();
        for (int i = 0; i < getSize(); i++) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
    }
    
    public void printListUser(List<User> userList) {
        System.out.println("-----");
        Nodo<User> pointer = userList.getHead();
        for (int i = 0; i < getSize(); i++) {
            System.out.println("ID: " + pointer.getElement().getId() + " Username: " + pointer.getElement().getUsername());
            pointer = pointer.getNext();
        }
    }
    
    public void printListRelation(List<Relation> relationList) {
        System.out.println("-----");
        Nodo<Relation> pointer = relationList.getHead();
        for (int i = 0; i < getSize(); i++) {
            System.out.println("-------------------");
            Relation relation = pointer.getElement();
            System.out.println("Relation " + i);
            System.out.println("User1| ID: " + relation.getUser1().getId() + " Username: " + relation.getUser1().getUsername());
            System.out.println("User2| ID: " + relation.getUser2().getId() + " Username: " + relation.getUser2().getUsername());
            System.out.println("Time: " + relation.getTime());
            pointer = pointer.getNext();
        }
    }

}
