/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoautomata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sulay2016
 */
public class Nodo {

    String alpha;
    String nombre;
    boolean esEstAceptacion;
    List<Nodo> aristas;
    
    public Nodo(String alpha, String nombre, boolean esEstAceptacion) {
        this.alpha = alpha;
        this.nombre = nombre;
        this.esEstAceptacion = esEstAceptacion;
        this.aristas = new ArrayList<Nodo>();
    }
    
    public void AddVertice(Nodo nodo){
        this.aristas.add(nodo);
    }
    
    public boolean esValido(char x){
        for (int i = 0; i < alpha.length(); i++) {
            if(alpha.charAt(i) == x){
                return true;
            }
        }
        
        return false;
    }
    
}
