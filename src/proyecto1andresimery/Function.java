/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Esta clase tiene las funciones para leer y escribir en archivos de texto (.txt)
 *
 * @author andresimery
 */
public class Function {
    
    /**
     * Lee un archivo de texto
     * 
     * @param file Recibe un archivo donde va a leer o null para leer el archivo de defecto
     * @param graph Recibe un grafo donde va a almacenar la información que lea
     * @return retorna el grafo con la información que leyo agregada
     */
    public Grafo readTxt(File file, Grafo graph) {
//        Grafo graph = new Grafo();
        
        try {
            File myObj;
            if (file == null) {
                myObj = new File("archivo.txt");
            } else {
                myObj = file;

            }
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // Aqui crear grafo
                    if (data.contains("@")) {
                        String[] split = data.split(", ");
                        graph.addUser(new User(Integer.parseInt(split[0]), split[1]));
                        
                    } else if (!data.contains("Relaciones") && !data.contains("Usuarios")) {
                        String[] split = data.split(", ");
                        User user1 = graph.findUserById(Integer.parseInt(split[0]));
//                        System.out.println("user " + user1.getId());
                        User user2 = graph.findUserById(Integer.parseInt(split[1]));
                        int time = Integer.parseInt(split[2]);
                        Relation relation = new Relation(user1, user2, time);
                        user1.addRelation(relation);
                        user2.addRelation(relation);
                        graph.addRelation(relation);
                        
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return graph;
    }
    
    /**
     * Escribe un archivo de texto
     * 
     * @param graph Recibe el grafo que va a utilizar para almacenar la información en el archivo de texto
     */
    public void writeTxt(Grafo graph) {
        String string = "Usuarios\n";
        
        Nodo<User> pointer = graph.getUsers().getHead();
        for (int i = 0; i < graph.getUsers().getSize(); i++) {
            string = string + pointer.getElement().getId() + ", " + pointer.getElement().getUsername() + "\n";
            pointer = pointer.getNext();
        }
        
        string = string + "Relaciones\n";
        
        Nodo<Relation> pointer2 = graph.getRelations().getHead();
        for (int i = 0; i < graph.getRelations().getSize(); i++) {
            string = string + pointer2.getElement().getUser1().getId() + ", " + pointer2.getElement().getUser2().getId() + ", " + pointer2.getElement().getTime() + "\n";
            pointer2 = pointer2.getNext();
        }
        
//        System.out.println(string);
        
        try {
            FileWriter myWriter = new FileWriter("archivo.txt");
            
            myWriter.write(string);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
        
    
}

