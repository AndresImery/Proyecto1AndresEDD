/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1andresimery;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.*;
import org.graphstream.ui.view.*;


/**
 *
 * @author andresimery
 */
public class Ventana1 extends javax.swing.JFrame {
    private static Graph graph;
    private static Grafo grafo;
    
    /**
     * Creates new form Ventana1
     */
    public Ventana1(Graph graph, Grafo grafo) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        createUIComponents(graph);
        this.graph = graph;
        this.grafo = grafo;
        
        
    }
    
    public Grafo getGrafo() {
        return this.grafo;
    }
    
    public void addUser(User user) {
        this.grafo.addUser(user);
        this.graph = this.grafo.grafoToGraphStream();
        
        jPanelGraph.removeAll();
        createUIComponents(this.graph);
    }
    
    public void addRelation(Relation relation) {
        this.grafo.addRelation(relation);
        this.graph = this.grafo.grafoToGraphStream();
        
        jPanelGraph.removeAll();
        createUIComponents(this.graph);
    }
    
    public void createUIComponents(Graph graph) {
        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        
        viewer.enableAutoLayout();
        ViewPanel viewPanel = viewer.addDefaultView(false);

        jPanelGraph.setBorder(BorderFactory.createLineBorder(null, 0));
        jPanelGraph.add(viewPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGraph = new javax.swing.JPanel();
        jButtonNewUser = new javax.swing.JButton();
        jButtonNewRelation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelGraph.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 510));

        jButtonNewUser.setText("Nuevo Usuario");
        jButtonNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewUserActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        jButtonNewRelation.setText("Nueva Relacion");
        jButtonNewRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewRelationActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewRelation, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewUserActionPerformed
        new NewUserWindow(this);
        setVisible(false);
    }//GEN-LAST:event_jButtonNewUserActionPerformed

    private void jButtonNewRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewRelationActionPerformed
        new NewRelationByNameWindow(this);
        setVisible(false);
    }//GEN-LAST:event_jButtonNewRelationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1(graph, grafo).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNewRelation;
    private javax.swing.JButton jButtonNewUser;
    private javax.swing.JPanel jPanelGraph;
    // End of variables declaration//GEN-END:variables
}
