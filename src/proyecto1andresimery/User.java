/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

/** Esta clase permite guardar informacion de cada usuario. También funciona como el Vertice del Grafo
 *
 * @author andresimery
 */
public class User {
     //Campos de la clase
    private int id;
    private String username;
    private List<Relation> relations;

    /**
     * Constructor
     * @param id Recibe id para poder guardar el id de cada usuario
     * @param username Recibe username para poder guardar el nombre de cada usuario
     */
    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.relations = new List<Relation>();
    }
    
    /**
     * Getters y setters
     *
     */
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
    
    /**
     * Agrega una relacion al usuario
     * 
     * @param relation Recibe la relación que va a agregar
     */
    public void addRelation(Relation relation) {
        getRelations().insertLast(relation);
    }
    
}
