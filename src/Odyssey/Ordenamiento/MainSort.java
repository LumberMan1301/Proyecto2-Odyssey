/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odyssey.Ordenamiento;

import Odyssey.Estructuras.Listas.ListaSimple;

/**
 *
 * @author 13mariano
 */
public class MainSort {
    public static void main(String[] args) {
        
        ListaSimple listaP = new ListaSimple();
        
        listaP.add(34);
        listaP.add(4);
        listaP.add(36);
        listaP.add(30);
        listaP.add(27);
        listaP.add(16);
        listaP.add(2);
        listaP.add(4);
        listaP.add(78);
        
        listaP.print();
        
        BubbleSort.sort(listaP);
        
        listaP.print();
                
    }
    
    
    
    
    
}
