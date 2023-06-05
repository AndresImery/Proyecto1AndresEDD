/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/**
 *
 * @author andresimery
 */
public class Relation {
    private User user1;
    private User user2;
    private int time;

    public Relation(User user1, User user2, int time) {
        this.user1 = user1;
        this.user2 = user2;
        this.time = time;
    }

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
    
    public User getOtherUser(User currentUser) {
        if (getUser1() == currentUser) {
            return getUser2();
        } else {
            return getUser1();
        }
    }
    
    
}

