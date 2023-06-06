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
        getUsers().deleteByElement(user);
        
        List<Relation> relationList = user.getRelations();
        Nodo<Relation> pointer = relationList.getHead();
        
//        List<Relation> userRelationList;
        
        while (pointer != null) {
            getRelations().deleteByElement(pointer.getElement());
            pointer.getElement().getOtherUser(user).getRelations().deleteByElement(pointer.getElement());
//            userRelationList.deleteByElement(pointer.getElement());
            
            
            pointer = pointer.getNext();
        }
        
        
    }
    
    public Relation findRelation(User user1, User user2) {
        List<Relation> relationList = user1.getRelations();
        Nodo<Relation> pointer = relationList.getHead();
        
        while (pointer != null) {
            if (pointer.getElement().getOtherUser(user1) == user2) {
                return pointer.getElement();
            }
            
            pointer = pointer.getNext();
        }
        
        return null;
    }
    
    public void deleteRelation(String user1String, String user2String) {
        User user1 = findUserByName(user1String);
        User user2 = findUserByName(user2String);
        Relation relation = findRelation(user1, user2);
        
        getRelations().deleteByElement(relation);
        user1.getRelations().deleteByElement(relation);
        user2.getRelations().deleteByElement(relation);
        
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
            if (pointer.getElement().getUsername().toLowerCase().equals(username.toLowerCase())) {
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
        Graph graph = new SingleGraph("embedded");
        Nodo<User> pointer = getUsers().getHead();
        Nodo<Relation> pointer2 = getRelations().getHead();
        for (int i = 0; i < getUsers().getSize(); i++) {
            Node node = graph.addNode(Integer.toString(pointer.getElement().getId()));
            node.setAttribute("ui.label", pointer.getElement().getUsername());
            
            pointer = pointer.getNext();    
        }
        
        
        for (int i = 0; i < getRelations().getSize(); i++) {
            Edge edge = graph.addEdge(pointer2.getElement().getUser1().getId() + " + " + pointer2.getElement().getUser2().getId(), Integer.toString(pointer2.getElement().getUser1().getId()), Integer.toString(pointer2.getElement().getUser2().getId()));
            edge.addAttribute("ui.label", Integer.toString(pointer2.getElement().getTime()));
            
            pointer2 = pointer2.getNext();
        }
        graph.setAttribute("ui.stylesheet", styleSheet);
        return graph;
        
    }
    protected String styleSheet =
            "node {" +
            "   size: 20;" +
            "   text-size: 20;" +
            "   text-alignment: at-left;" +
            "	fill-color: red;" +
            "   text-offset: 0px, 4px;" +
            "}" +
            "node { text-alignment: under; text-color: black; text-style: bold; text-background-mode: rounded-box; text-background-color: #222C; text-padding: 1px; text-offset: 0px, 2px; } node#C {text-alignment:above; text-offset: 0px, -2px;}" + 
            "node.marked {" +
            "	fill-color: red;" +
            "}" +
            "edge {" +
            "   text-size: 30;" +
            "   text-color: gray;" +
            "   text-alignment: center;" +
            "}";
    
}

