/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1andresimery;



import org.graphstream.graph.*;


/** Clase principal del proyecto
 *
 * @author andresimery
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function func = new Function();
        Grafo grafo = new Grafo();
        grafo = func.readTxt(null, grafo);
        
//        grafo.deleteUserByName("@andresimery");
//        grafo.findUserByName("@maxfontana").getRelations().printListRelation(grafo.findUserByName("@maxfontana").getRelations());
        
        Graph graph = grafo.grafoToGraphStream();
        
        
        Ventana1 v1 = new Ventana1(graph, grafo);
       
    }
    
}
