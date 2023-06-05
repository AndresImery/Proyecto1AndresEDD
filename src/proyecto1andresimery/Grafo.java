/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
/**
 *
 * @author andresimery
 */
public class Grafo {
    private List<User> users;
    private List<Relation> relations;

    public Grafo() {
        this.users = new List<User>();
        this.relations = new List<Relation>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public void addUser(User user) {
        this.users.insertLast(user);
    }
    
    public void addRelation(Relation relation) {
        this.relations.insertLast(relation);
    }
    
    public void deleteUserByName(String username) {
        User user = findUserByName(username);
        System.out.println(user.getUsername());
        Nodo<User> pointer = getUsers().getHead();
        
        for (int i = 0; i < getUsers().getSize(); i++) {
            if (user == pointer.getElement()) {
                getUsers().deleteInIndex(i);
                break;
            }
            
            pointer.getNext();
        }
        
        
        Nodo<Relation> pointer2 = getRelations().getHead();
        Nodo<Relation> pointer3 = user.getRelations().getHead();
        for (int i = 0; i < getRelations().getSize(); i++) {
            for (int j = 0; j < user.getRelations().getSize(); j++) {
                if (pointer3.getElement() == pointer2.getElement()) {
                    getRelations().deleteInIndex(i);
                }
                
                pointer3 = pointer3.getNext();
            }
            pointer3 = user.getRelations().getHead();
            pointer2 = pointer2.getNext();
        }
        
        Nodo<Relation> pointer4 = user.getRelations().getHead();
        User user2 = null;
        
        for (int i = 0; i < user.getRelations().getSize(); i++) {
            user2 = pointer4.getElement().getOtherUser(user);
            Nodo<Relation> pointer5 = user2.getRelations().getHead();
            for (int j = 0; j < user2.getRelations().getSize(); j++) {
                if (pointer5.getElement() == pointer4.getElement()) {
                    user2.getRelations().deleteInIndex(i);
                }
            }
            pointer4 = pointer4.getNext();
        }
        
    }
    
    public User findUserById(int id) {
        User user = null;
        Nodo<User> pointer = getUsers().getHead();
        for (int i = 0; i < getUsers().getSize(); i++) {
            if (pointer.getElement().getId() == id) {
                user = pointer.getElement();
                break;
            }
            pointer = pointer.getNext();
        }
        return user;
    }
    
    public User findUserByName(String username) {
        User user = null;
        Nodo<User> pointer = getUsers().getHead();
        for (int i = 0; i < getUsers().getSize(); i++) {
            if (pointer.getElement().getUsername().equals(username)) {
                user = pointer.getElement();
                break;
            }
            pointer = pointer.getNext();
        }
        return user;
    }
    
    
    public int depthFirstTraversal() {
        List<User> usersVisited = new List<>();
        Stack<User> stack = new Stack<>();
        
        User currentUser = getUsers().getHead().getElement();
        
        int contador = 0;
        
        while (getNextIsland(usersVisited) != null) {
            
            currentUser = getNextIsland(usersVisited);
            
            stack.push(currentUser);
            usersVisited.insertLast(currentUser);

            // current User should always be the one on top of the stack
            while (!stack.isEmpty()) {
//                System.out.println("current: " + stack.getHead().getElement().getUsername() + " ID: " + stack.getHead().getElement().getId());
                currentUser = getNextUser(stack.getHead().getElement(), usersVisited);

                stack.push(currentUser);
                usersVisited.insertLast(currentUser);


                while (getNextUser(currentUser, usersVisited) == currentUser) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        currentUser = stack.getHead().getElement();
                    } else {
                        break;
                    }
                }
//                usersVisited.printListUser(usersVisited);
            }
            contador++;
//            System.out.println(contador);
        }
        
        return contador;
    }
    
    public User getNextUser(User currentUser, List<User> usersVisited) {
        Nodo<Relation> pointerRelations = currentUser.getRelations().getHead();
        
        while (pointerRelations != null) {
            
            if (!isVisited(pointerRelations.getElement().getOtherUser(currentUser), usersVisited)) {
                return pointerRelations.getElement().getOtherUser(currentUser);
            }
            
            pointerRelations = pointerRelations.getNext();
        }
        return currentUser;
    }
    
    public User getNextIsland(List<User> usersVisited) {
        Nodo<User> pointerUsers = getUsers().getHead();
        Nodo<User> pointerVisited = usersVisited.getHead();
        while (pointerUsers != null) {
            while (pointerVisited != null) {
                
                if (pointerUsers.getElement() == pointerVisited.getElement()) {
                    break;
                }
                
                pointerVisited = pointerVisited.getNext();
            }
            
            if (pointerVisited == null) {
                return pointerUsers.getElement();
            }
            
            pointerVisited = usersVisited.getHead();
            pointerUsers = pointerUsers.getNext();
        }
        
        return null;
    }
    
    public boolean isVisited(User nextUser, List<User> usersVisited) {
        Nodo<User> pointer = usersVisited.getHead();
        while (pointer != null) {
            if (nextUser == pointer.getElement()) {
                return true;
            }
            pointer = pointer.getNext();
        }
        return false;
    }
    
    public int breadthDepthTraversal() {
        List<User> usersVisited = new List<>();
        Queue<User> queue = new Queue<>();
        
        
        
        User currentUser = getUsers().getHead().getElement();
        User nextUser = null;
        
        int contador = 0;
        
        while (getNextIsland(usersVisited) != null) {
            currentUser = getNextIsland(usersVisited);
            
//            System.out.println(currentUser.getUsername() + " ID: " + currentUser.getId());//
            
            queue.enqueue(currentUser);
            usersVisited.insertLast(currentUser);
            

            while (getNextUser(currentUser, usersVisited) != currentUser) {
                nextUser = getNextUser(currentUser, usersVisited);
                usersVisited.insertLast(nextUser);
                queue.enqueue(nextUser);
            }
//            usersVisited.printListUser(usersVisited);//
            while (!queue.isEmpty()) {
                queue.dequeue();
                if (queue.isEmpty()) {
                    break;
                }
                
                currentUser = queue.getHead().getElement();
//                System.out.println(currentUser.getUsername() + " ID: " + currentUser.getId());//
                while (getNextUser(currentUser, usersVisited) != currentUser) {
                    nextUser = getNextUser(currentUser, usersVisited);
                    usersVisited.insertLast(nextUser);
                    queue.enqueue(nextUser);
                }
//                usersVisited.printListUser(usersVisited);//
            }
            contador++;
//            System.out.println(contador);//
        }
        return contador;
    }
    
    
    public Graph grafoToGraphStream() {
        Graph graph = new SingleGraph("Usuarios");
        Nodo<User> pointer = getUsers().getHead();
        Nodo<Relation> pointer2 = getRelations().getHead();
        for (int i = 0; i < getUsers().getSize(); i++) {
            Node node = graph.addNode(Integer.toString(pointer.getElement().getId()));
            node.setAttribute("ui.label", pointer.getElement().getUsername());
            
            pointer = pointer.getNext();    
        }
        
        for (int i = 0; i < getRelations().getSize(); i++) {
            graph.addEdge(pointer2.getElement().getUser1().getId() + " + " + pointer2.getElement().getUser2().getId(), Integer.toString(pointer2.getElement().getUser1().getId()), Integer.toString(pointer2.getElement().getUser2().getId()));
            
            pointer2 = pointer2.getNext();
        }
        graph.setAttribute("ui.stylesheet", styleSheet);
        return graph;
        
    }
    protected String styleSheet =
            "node {" +
            "	fill-color: black;" +
            "   size: 20;" +
            "   text-size: 20;" +
            "   text-alignment: at-right;" +
            "	fill-color: red;" +
            "}" +
            "node.marked {" +
            "	fill-color: red;" +
            "}" +
            "edge {" +
            "   text-size: 30;" +
            "   text-color: gray;" +
            "   text-alignment: center;" +
            "}";
    
}

