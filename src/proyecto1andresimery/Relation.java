/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase permite relacionar a los usuarios, tambien mantiene la cantidad de tiempo que llevan de amistad
 * Funciona tambien como Borde o Edge del Grafo
 *
 * @author andresimery
 */
public class Relation {
     //Campos de la clase
    private User user1;
    private User user2;
    private int time;

    /**
     * Constructor
     * @param user1 Recibe user1 para poder guardarlo como primer usuario de la relación
     * @param user2 Recibe user2 para poder guardarlo como segundo usuario de la relación
     */
    public Relation(User user1, User user2, int time) {
        this.user1 = user1;
        this.user2 = user2;
        this.time = time;
    }

    /**
     * Getters y setters
     * 
     */
    public User getUser1() {
        return user1;
    }

    public void setUser(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    /**
     * Te permite conseguir el otro user de la relacion
     * 
     * @param currentUser recibe un user de la relación
     * @return retorna el otro user
     */
    public User getOtherUser(User currentUser) {
        if (getUser1() == currentUser) {
            return getUser2();
        } else {
            return getUser1();
        }
    }
    
    
}

