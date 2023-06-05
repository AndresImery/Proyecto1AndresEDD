/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/**
 *
 * @author andresimery
 */
public class User {
    private int id;
    private String username;
    private List<Relation> relations;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.relations = new List<Relation>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }
    
    public void addRelation(Relation relation) {
        getRelations().insertLast(relation);
    }
    
}
