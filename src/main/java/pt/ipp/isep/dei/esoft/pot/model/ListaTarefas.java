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
    
    /**
     * Lista que contém uma ou mais Tarefas
     */
    private  ArrayList<Tarefa> lista;
    
    /**
     * Elimina todas as Tarefas da Lista de Tarefas 
     */
    public ListaTarefas(){
      this.lista = new ArrayList<>();
    }
    /**
     * Cria um objeto da classe ListaTarefas
     *
     * @param lista lista que contém uma ou mais Tarefasa data de início do período de publicitação
     */
    public ListaTarefas(ArrayList<Tarefa> lista){
        this.lista = lista;
    }

    /**
     * @return the lista
     */
    public ArrayList<Tarefa> getLista() {
        return lista;
    }
    
    /**
     * Adiciona uma Tarefa á Lista de Tarefas
     * @param novaTarefa
     * @return 
     */
    public boolean adicionarTarefa(Tarefa novaTarefa) {
        return lista.add(novaTarefa);
    }
    
    /**
     * Adiciona uma Tarefa á Lista de Tarefas
     * @param referencia
     * @param designacao
     * @param descInformal
     * @param descTecnica
     * @param duracaoEst
     * @param custoEst
     * @param competencias
     * @return 
     */
    public boolean adicionarTarefa(String referencia, String designacao, String descInformal, String descTecnica,
            Integer duracaoEst, Double custoEst, ArrayList<String> competencias) {
        return lista.add(new Tarefa(referencia, designacao, descInformal, descTecnica, duracaoEst, custoEst, competencias));
    }
    
    /**
     * Retorna uma Tarefa com um determinado nome
     * @param nomeTarefa
     * @return 
     */
    public Tarefa getTarefaPorNome(String nomeTarefa) {
        for (Tarefa t : lista) {
            if(t.getDesignacao().equalsIgnoreCase(nomeTarefa))
                return t;
        }
        return null;
    }
}
