/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class Manejador implements  ActionListener{

    FrameQuickSort frameQuicksort;
    MainFrame mainFrame;
    FrameSeleccion frameSeleccion;
    FrameShellSort frameShellSort;
    FrameMergeSort frameMergeSort;
    FrameIntercambio frameIntercambio;
    public Manejador(){
    //this.mainFrame = new MainFrame();
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Intercambio")){
            frameIntercambio = new FrameIntercambio();
            frameIntercambio.show(true);
        }
       if(e.getActionCommand().equals("Selección")){
       frameSeleccion = new FrameSeleccion();
            frameSeleccion.show(true);
        
       }
       if(e.getActionCommand().equals("QuickSort")){
       
        frameQuicksort = new FrameQuickSort();
            frameQuicksort.show(true);//mostra dicha ventana, los mismo para los demas metodos
       }
        if(e.getActionCommand().equals("ShellSort")){
       
        frameShellSort = new FrameShellSort();
            frameShellSort.show(true);
       }
        if(e.getActionCommand().equals("MergeSort")){
       
        frameMergeSort = new FrameMergeSort();
            frameMergeSort.show(true);
       }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }//Fin 
    
}
