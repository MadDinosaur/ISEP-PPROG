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
    
    public ListaTarefas(){
      this.lista = new ArrayList<>();
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
    
    public boolean adicionarTarefa(Tarefa novaTarefa) {
        return lista.add(novaTarefa);
    }
    
    public boolean adicionarTarefa(String referencia, String designacao, String descInformal, String descTecnica,
            Integer duracaoEst, Double custoEst, ArrayList<String> competencias) {
        return lista.add(new Tarefa(referencia, designacao, descInformal, descTecnica, duracaoEst, custoEst, competencias));
    }
    public Tarefa getTarefaPorNome(String nomeTarefa) {
        for (Tarefa t : lista) {
            if(t.getDesignacao().equalsIgnoreCase(nomeTarefa))
                return t;
        }
        return null;
    }
}
