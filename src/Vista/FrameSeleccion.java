/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Ordenamiento;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FrameSeleccion extends javax.swing.JFrame {

    int posicion;
     int vectorNumeros[]= new int[10];
    Ordenamiento ordenamiento;
    
    public FrameSeleccion() {
        initComponents();
        
         for(posicion=0; posicion<10; posicion++){
           
            
              do{//Para evitar que el usuario digite 0
              //vectorNumeros[posicion]=Integer.parseInt(JOptionPane.showInputDialog("Numero: "+ posicion));
            
              vectorNumeros[posicion]=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "+ posicion));
                              System.out.println("entro a do-while");

              }while(vectorNumeros[posicion] < -1);
              
        }//Fin for
        
        
    }//Fin constructor

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
