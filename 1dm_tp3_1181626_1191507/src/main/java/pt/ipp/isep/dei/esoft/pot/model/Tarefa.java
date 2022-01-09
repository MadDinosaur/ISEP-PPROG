package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

/**
 * Classe que modela uma Tarefa de uma dada Organização
 */
public class Tarefa {

    /**
     * A referência da tarefa
     */
    private String referencia;
    /**
     * O nome da tarefa
     */
    private String designacao;
    /**
     * A descrição informal da tarefa
     */
    private String descInformal;
    /**
     * A descrição técnica da tarefa
     */
    private String descTecnica;
    /**
     * A duração estimada da tarefa
     */
    private Integer duracaoEst;
    /**
     * O custo estimado da tarefa
     */
    private Double custoEst;
    /**
     * O nível de porficiencia da tarefa
     */
    private ArrayList<CompetenciaTecnica> competencias = new ArrayList<>();

    /**
     * Cria um objeto da classe Tarefa
     *
     * @param referencia a referência da tarefa
     * @param designacao o nome da tarefa
     * @param descInformal a descrição informal da tarefa
     * @param descTecnica a descrição técnica da tarefa
     * @param duracaoEst a duração estimada da tarefa
     * @param custoEst o custo estimado da tarefa
     * @param competencias a lista de competências técnicas associadas à tarefa
     */
    public Tarefa(String referencia, String designacao, String descInformal, String descTecnica,
            Integer duracaoEst, Double custoEst, ArrayList<String> competencias) {
        this.referencia = referencia;
        this.designacao = designacao;
        this.descInformal = descInformal;
        this.descTecnica = descTecnica;
        this.duracaoEst = duracaoEst;
        this.custoEst = custoEst;
        for (String str : competencias) {
            this.competencias.add(new CompetenciaTecnica(str));
        }
    }

    /**
     * Cria uma cópia de um objeto da classe Tarefa
     *
     * @param tarefa a Tarefa a copiar
     */
    public Tarefa(Tarefa tarefa) {
        this.referencia = tarefa.referencia;
        this.designacao = tarefa.designacao;
        this.descInformal = tarefa.descInformal;
        this.descTecnica = tarefa.descTecnica;
        this.duracaoEst = tarefa.duracaoEst;
        this.custoEst = tarefa.custoEst;
        this.competencias = tarefa.competencias;
    }

    /**
     * Retorna o nome da tarefa
     *
     * @return a designacao
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Retorna uma cópia da lista de Competencias Tecnicas associadas à Tarefa
     *
     * @return a lista de competencias
     */
    public ArrayList<CompetenciaTecnica> getCompetencias() {
        return new ArrayList<>(competencias);
    }

    /**
     * Retorna o nível de proficiência da Competencia Tecnica na posição i da
     * lista
     *
     * @param i o índice da Competencia Tecnica na lista de competências da
     * Tarefa
     * @return o nível de proficiência
     */
    public int getNivelProficiencia(int i) {
        return competencias.get(i).getNivelProficiencia();
    }

}
