/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase permite organizar objetos de cualquier tipo en una Lista
 *
 * @author andresimery
 */
public class List<T> {
     //Campos de la clase
    private Nodo<T> head;
    private int size;

    /**
     * Constructor
     *
     */
    public List() {
        this.head = null;
    }

    /**
     * Setters y getters
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
    
    /**
     * Devuelve un valor de true o false
     * @return La lista esta vacia?
     */
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    /**
     * Agrega al final de la lista
     * 
     * @param element Recibe un objeto cualquiera del mismo tipo de la lista
     */
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
    
    /**
     * Borra el elemento en el index
     * 
     * @param index recibe el index donde va a borrar un elemento de la lista
     */
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
    
    /**
     * Borra el elemento
     * 
     * @param element Recibe un objeto cualquiera del mismo tipo de la lista
     */
    public void deleteByElement(T element) {
        Nodo<T> pointer = getHead();
        if (!isEmpty()) {
            if (element == pointer.getElement()) {
                setHead(pointer.getNext());
                size--;
            } else {
                while (pointer.getNext() != null) {
                    if (element == pointer.getNext().getElement()) {
                        pointer.setNext(pointer.getNext().getNext());
                        size--;
                        break;
                    }

                    pointer = pointer.getNext();
                }
            }
            
        }
    }
    
    /**
     * Imprime los elementos de la lista
     * 
     */
    public void printList() {
        System.out.println("-----");
        Nodo pointer = getHead();
        for (int i = 0; i < getSize(); i++) {
            System.out.println(pointer.getElement());
            pointer = pointer.getNext();
        }
    }
    
    /**
     * Imprime los elementos de la lista de usuarios
     * 
     * @param userList Recibe userList como una lista de usuarios
     */
    public void printListUser(List<User> userList) {
        System.out.println("-----");
        Nodo<User> pointer = userList.getHead();
        for (int i = 0; i < getSize(); i++) {
            System.out.println("ID: " + pointer.getElement().getId() + " Username: " + pointer.getElement().getUsername());
            pointer = pointer.getNext();
        }
    }
    
    /**
     * Imprime los elementos de la lista de relaciones
     * 
     * @param relationList Recibe relationList como una lista de relaciones
     */
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
