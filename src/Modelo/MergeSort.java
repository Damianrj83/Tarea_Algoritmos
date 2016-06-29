/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.FrameMergeSort;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class MergeSort {
     /**
     * Algoritmo recursivo que permite ordenar el vector por medio del
     * MergeSort.
     * 
     */
    
    static JTextField[] vectorTextField;
    static FrameMergeSort frameMergeSort;
    
     private int tempMergArr[];
      private int length;
      private int array[];
    
     public MergeSort(FrameMergeSort frameMergeSort) {
       
        this.frameMergeSort = frameMergeSort;
        
    }//Fin constructor num1
    
    
    public static void inicializarVector(JTextField [] vectorTextField) {//Metodo para incializar vector de tipo JtextField
        MergeSort.vectorTextField = vectorTextField;
         
    }
    
     
      
     public int mergeSort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        return 0;
    }
    
    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
    
    /**
     * Método que se encarga de ir separando el vector en sub vectores más
     * pequeños hasta llegar a un estado donde todos los elementos estén 
     * separados.
     * 
     */
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                try {
                    array[k] = tempMergArr[i];
                    frameMergeSort.setTextVector(i, array[k]+"", Color.yellow);///cambio
                    frameMergeSort.setTextVector(k, tempMergArr[i]+"", Color.blue);//cambio, cambia el valor del vector
                    Thread.sleep(2000);
                    i++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    array[k] = tempMergArr[j];
                    frameMergeSort.setTextVector(k, tempMergArr[j]+"", Color.yellow);//cambio
                    frameMergeSort.setTextVector(j, array[k]+"", Color.blue);//cambio
                    Thread.sleep(2000);
                    j++;
                } catch (InterruptedException ex) {
                    Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            frameMergeSort.setTextVector(k, tempMergArr[j]+"", Color.yellow);//cambio
            frameMergeSort.setTextVector(j, array[k]+"", Color.blue);//cambio
            
            k++;
            i++;
        }
    } 
}
