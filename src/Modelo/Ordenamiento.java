/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author damian
 */
public class Ordenamiento {

    /**
     * @param args the command line arguments
     */
    static JTextField[] vectorTextField;
//    public static void main(String[] args) {
//        
//        int j[] ={8,6,4,2};
//       //int j[]={8,6,4,2,1,6};
//        //int j[]={50,20,40,80,30,20};
//        int j[]={79,21,15,99,88,65,75,85,76,46,84,24};
//        
//      // ordQuickSort(j,0,j.length-1);
//        
//        //ordIntercambio(s);
//        
//       // ordSeleccion(j);
//        
//       ordBurbuja(j);
//      
//      ordShell(j);
//      
//      
//       for(int i=0;i<j.length;i++)
//            System.out.print("  " +j[i]);
//        System.out.println("");

//    }
   static FrameQuickSort frameQuicksort;
   static FrameSeleccion frameSeleccion;
   static FrameIntercambio frameIntercambio;
   static FrameShellSort frameShellSort;
   static FrameMergeSort frameMergeSort;
   

    public Ordenamiento(FrameQuickSort frameQuicksort, FrameSeleccion frameSeleccion, FrameIntercambio frameIntercambio, FrameShellSort frameShellSort,FrameMergeSort frameMergeSort) {
        this.frameQuicksort = frameQuicksort;
        this.frameSeleccion = frameSeleccion;
        this.frameIntercambio = frameIntercambio;
        this.frameShellSort = frameShellSort;
        this.frameMergeSort = frameMergeSort;
        
    }//Fin constructor
    
    
    public static void inicializarVector(JTextField [] vectorTextField) {
        Ordenamiento.vectorTextField = vectorTextField;
        
        
    }
    
    
    public static void intercambiar(int [] a,int i,int j){
        int aux=a[i];
        a[i]=a[j];//
       // frameSeleccion.setTextVector(i, a[j]+"", Color.yellow);
        //frameSeleccion.setTextVector(j, a[i]+"", Color.blue);
        a[j]=aux;
    }
    
    public static void ordIntercambio(int a[]){//ordenacion por intercambio
        int i , j;
        for(i=0; i<a.length; i++){//se coloca en la posicion 0
            for(j=i+1;j<a.length;j++){//se coloca en la posicion 1
                if(a[i]>a[j]){//compara la posicion 0 con la 1(Si la posicion  1 es menor que la 0) entra
                    intercambiar(a, i, j);//hace el cambio de la 1 con la 0
                }
            }
        }
    }
    
    
    
    public static void ordSeleccion(int a[]){
        int indiceMenor ,i , j ,n;
        n=a.length;//tamanio
        for(i=0;i<n-1;i++){//i hasta el tamanio - 1 primer for
            //comienza la exploracion indice i
            indiceMenor =i;//el indice menor es i
            //
            for(j=i+1;j<n;j++){//segundo for q va de la pos siguiente de i
                if(a[j]<a[indiceMenor])//si en la pos siguiente es menor a la de i, comparelo con todos los elementos
                    indiceMenor=j;
                
                
            }
            if(i!=indiceMenor)
                
                
                intercambiar(a, i, indiceMenor);
        }
    }
    //interruptor es 0 para cuando no hubo cambio sale del metodo y no realiza las pasadas si fuera necesario
   public static void ordBurbuja(int a[]){
       int interruptor = 1;
        int n = a.length;
        int pasada,j;
        for(pasada = 0; pasada < n -1 && interruptor != 0; pasada ++){
            //bucle externo controla la cantidad de pasadas
            interruptor = 0;
            for(j=0; j<n-pasada-1; j++)
                if(a[j] > a[j+1]){
                    //elementos desordenados, es necesario intercambio
                    int aux;
                    interruptor = 1;
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
   } 
   
   public static void ordShell(int a[]){
       int intervalo,i,j,k;
       int n = a.length;
       intervalo= n/2;
       while(intervalo>0){
            for(i=0;i<n;i++){    
               j=i -intervalo;
                    while(j>0){
                        k=j+intervalo;
                        if(a[j]<=a[k])
                            j=-1;
                        
                        else{
                            int temp;
                            temp=a[j];
                            a[j]=a[k];
                            a[k]=temp;
                            j-=intervalo;
                        }
                    }
               }
            intervalo = intervalo / 2;
       }
   }//ord
   
   
   public static int ordQuickSort(int vector[],int izq,int der){
        try{
            int pivote = vector[izq]; // tomamos primer elemento como pivote
            
            //vista.setTextVector(izq, pivote+"", Color.red);
             //Thread.sleep(2000);
            int i = izq; // i realiza la búsqueda de izquierda a derecha
            int d = der; // d realiza la búsqueda de derecha a izquierda
            int aux;
            
            while (i < d) {            // mientras no se crucen las búsquedas
                while (vector[d] > pivote) {
                    d--;         // busca elemento menor que pivote  
                }
                while (vector[i] <= pivote && i < d) {
                    i++; // busca elemento mayor que pivote
                }
                if (i < d) {                      // si no se han cruzado
                    aux = vector[i];                  // los intercambia
                    

                    frameQuicksort.setTextVector(i, vector[d]+"", Color.yellow);
                    frameQuicksort.setTextVector(d, aux+"", Color.GREEN);
                    Thread.sleep(2000);
                    vector[i] = vector[d];
                    vector[d] = aux;
                    frameQuicksort.setTextVector(i, vector[i]+"", null);
                    frameQuicksort.setTextVector(d, aux+"", null);
                    Thread.sleep(2000);
                }
            }
             
            vector[izq] = vector[d]; // se coloca el pivote en su lugar de forma que tendremos
            frameQuicksort.setTextVector(izq, vector[d]+"", Color.GREEN);
            vector[d] = pivote; // los menores a su izquierda y los mayores a su derecha
            frameQuicksort.setTextVector(d, vector[d]+"", Color.yellow);
            Thread.sleep(2000);
            frameQuicksort.setTextVector(izq,vector[izq]+"", null);
            frameQuicksort.setTextVector(d,  vector[d]+"",null);
            Thread.sleep(1000);
            if (izq < d - 1) {
                ordQuickSort(vector, izq, d - 1); // ordenamos subarray izquierdo
                 Thread.sleep(2000);
            }
            if (d + 1 < der) {
                ordQuickSort(vector, d + 1, der); // ordenamos subarray derecho
                 Thread.sleep(2000);
            }
            
           
        } catch (InterruptedException ex) {
            System.out.println("error en el sleep");
        }
        
        return 0;
   }//Fin ordQuiksort////////////////////////////
    public static void print(){
        
    }
    
       
}
