/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoautomata;

/**
 *
 * @author Sulay2016
 */
public class Grafo {
    Nodo head;
    
    public Nodo validarAutomata (String cadena, Nodo nodo){
        
        if(cadena == null || cadena.isEmpty() ){
            return nodo;
        }
        
        //obtengo el caracter a validar
        char pri = cadena.charAt(0);
        cadena = cadena.substring(1);
        
        for (Nodo arista : nodo.aristas) {
            if(arista.esValido(pri)){
                return validarAutomata(cadena, arista);
            }
        }
        
        return null;
    }
}
