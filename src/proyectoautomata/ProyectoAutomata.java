/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoautomata;

import java.io.Console;
import javax.swing.JOptionPane;

/**
 *
 * @author Sulay2016
 */
public class ProyectoAutomata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        // TODO code application logic here
        String abc = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        Grafo abecedario = new Grafo();
        abecedario.head = new Nodo(abc, "q0", true);
        abecedario.head.aristas.add(abecedario.head);
        
        
        //valido que sea una letra
        String estadoAceptacion = JOptionPane.showInputDialog("Ingrese el estado de aceptacion");
        if( abecedario.validarAutomata(estadoAceptacion, abecedario.head) == null){
            JOptionPane.showMessageDialog(null, "Su estado de aceptacion NO es valido");
            return;
        }
        
        
        //////////grafo automata usario
        Grafo grafo = new Grafo();
        
        Nodo tmp = null;
        for (int i = estadoAceptacion.length() - 1; i >= 0 ; i--) {
            Nodo nodo = new Nodo(estadoAceptacion.charAt(i) + "", "q" + i, false );
            
            if(i == estadoAceptacion.length() - 1) nodo.esEstAceptacion = true;
            
            if(tmp == null){
                tmp = nodo; 
            }else{
                nodo.aristas.add(tmp);
                tmp = nodo;
            }
        }
        
        grafo.head = tmp;
        /////////
        
        
        String cadena = JOptionPane.showInputDialog("Ingrese la cadena para validar ('0' para salir)");
        boolean valido = false;
        
        while(!cadena.equals("0")){
            
            //valido que sea una letra
            if( abecedario.validarAutomata(cadena, abecedario.head) == null){
                valido = false;
            }else{
                //Validar con el automata del usuario
                if(grafo.head.esValido(cadena.charAt(0))){
                    Nodo result = grafo.validarAutomata(cadena.substring(1), grafo.head);

                    if(result == null){
                        valido = false;
                    }else{
                        if(result.esEstAceptacion == true){
                            valido = true;
                        }else{
                            valido = false;
                        }
                    }
                }else{
                    valido = false;
                }
            }
            
            if(valido){
                JOptionPane.showMessageDialog(null, "La cadena ingresada es valida");
            }else{
                JOptionPane.showMessageDialog(null, "La cadena ingresada NO es valida");
            }
            
            valido = false;
            cadena = JOptionPane.showInputDialog("Ingrese la cadena para validar ('0' para salir)");
            
        }
        
        
        
       
        
        //
        
        
    }
    
}
