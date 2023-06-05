/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1andresimery;

import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author andresimery
 */
public class GraphStream {
    
    public void GraphExplore() {
        Graph graph = new MultiGraph("Tutorial 1");
        
        graph.setAttribute("ui.stylesheet", styleSheet);
        graph.setStrict(false);
        graph.setAutoCreate(true);
        

        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        graph.addEdge("AD", "A", "D");
        graph.addEdge("DE", "D", "E");
        graph.addEdge("DF", "D", "F");
        graph.addEdge("EF", "E", "F");
        
        graph.display();
        
        for (Node node : graph) {
            node.setAttribute("ui.label", node.getId());
            for (Edge edge : node) {
                edge.setAttribute("ui.label", edge.getId());
            }
        }
        
        
        explore(graph.getNode("A"));
        
        
    } 
    public void explore(Node source) {
        Iterator<? extends Node> k = source.getBreadthFirstIterator();
        
        sleep();
        while (k.hasNext()) {
            Node next = k.next();
            next.setAttribute("ui.class", "marked");
            sleep();   
        }
    }
    
    protected void sleep() {
        try { Thread.sleep(2000); } catch (Exception e) {}
    }
    
    protected String styleSheet =
            "node {" +
            "	fill-color: black;" +
            "   size: 50;" +
            "   text-size: 50;" +
//            "   text-alignment: at-left;" +
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

