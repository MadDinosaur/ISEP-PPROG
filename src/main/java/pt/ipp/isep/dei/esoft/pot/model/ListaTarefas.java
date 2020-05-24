package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

/**
 * Classe que modela uma lista de Tarefas
 */
public class ListaTarefas {

    /**
     * A lista de Tarefas
     */
    private ArrayList<Tarefa> lista;

    /**
     * Cria um objeto da classe ListaTarefas, com um array vazio
     */
    public ListaTarefas() {
        this.lista = new ArrayList<>();
    }

    /**
     * Cria um objeto da classe ListaTarefas a partir de um ArrayList<Tarefa>
     *
     * @param lista o ArrayList de Tarefas
     */
    public ListaTarefas(ArrayList<Tarefa> lista) {
        this.lista = lista;
    }

    /**
     * Cria uma cópia de um objeto da classe ListaTarefas
     *
     * @param outraLista a ListaTarefas a copiar
     */
    public ListaTarefas(ListaTarefas outraLista) {
        this.lista = new ArrayList<>(outraLista.lista);
    }

    /**
     * Adiciona uma Tarefa à Lista de Tarefas
     *
     * @param novaTarefa a Tarefa a adicionar
     * @return true se a Tarefa for adicionada, false caso contrário
     */
    public boolean adicionarTarefa(Tarefa novaTarefa) {
        return lista.add(novaTarefa);
    }

    /**
     * Adiciona uma Tarefa à Lista de Tarefas
     *
     * @param referencia a referência da tarefa
     * @param designacao o nome da tarefa
     * @param descInformal a descrição informal da tarefa
     * @param descTecnica a descrição técnica da tarefa
     * @param duracaoEst a duração estimada da tarefa
     * @param custoEst o custo estimado da tarefa
     * @param competencias a lista de competências técnicas associadas à tarefa
     * @return true se a Tarefa for adicionada, false caso contrário
     */
    public boolean adicionarTarefa(String referencia, String designacao, String descInformal, String descTecnica,
            Integer duracaoEst, Double custoEst, ArrayList<String> competencias) {
        return lista.add(new Tarefa(referencia, designacao, descInformal, descTecnica, duracaoEst, custoEst, competencias));
    }

    /**
     * Procura e retorna a Tarefa com o nome especificado
     *
     * @param nomeTarefa o nome da Tarefa a procurar
     * @return a Tarefa
     */
    public Tarefa getTarefaPorNome(String nomeTarefa) {
        for (Tarefa t : lista) {
            if (t.getDesignacao().equalsIgnoreCase(nomeTarefa)) {
                return t;
            }
        }
        return null;
    }
}
