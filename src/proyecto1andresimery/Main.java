/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1andresimery;



import org.graphstream.graph.*;


/**
 *
 * @author andresimery
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Function func = new Function();
        Grafo grafo = func.readTxt();
        
        
        
        Graph graph = grafo.grafoToGraphStream();
        
        Ventana1 v1 = new Ventana1(graph, grafo);
       
    }
    
}
