/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

/**
 *
 * @author Francisco
 */
public class ListaTarefas{
    
    private  ArrayList<Tarefa> lista;
    
    private final ArrayList<Tarefa> LISTA_POR_EXCESSAO = new ArrayList();
    
    public ListaTarefas(){
        
    }
    
    public ListaTarefas(ArrayList<Tarefa> lista){
        this.lista = lista;
    }

    /**
     * @return the lista
     */
    public ArrayList<Tarefa> getLista() {
        return lista;
    }
    
}
