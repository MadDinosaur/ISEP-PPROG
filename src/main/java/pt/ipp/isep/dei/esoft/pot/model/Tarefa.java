package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

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
        this.referencia = tarefa.getReferencia();
        this.designacao = tarefa.getDesignacao();
        this.descInformal = tarefa.getDescInformal();
        this.descTecnica = tarefa.getDescTecnica();
        this.duracaoEst = tarefa.getDuracaoEst();
        this.custoEst = tarefa.getCustoEst();
        this.competencias = tarefa.getCompetencias();
    }

    /**
     * Retorna a referência da tarefa
     *
     * @return a referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Modifica a referência da tarefa
     *
     * @param referencia
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
     * Modifica a designação da tarefa
     *
     * @param designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Retorna a descrição informal da tarefa
     *
     * @return a descrição informal
     */
    public String getDescInformal() {
        return descInformal;
    }

    /**
     * Modifica a descrição informal da tarefa
     *
     * @param descInformal
     */
    public void setDescInformal(String descInformal) {
        this.descInformal = descInformal;
    }

    /**
     * Retorna a descrição técnica da tarefa
     *
     * @return a descrição técnica
     */
    public String getDescTecnica() {
        return descTecnica;
    }

    /**
     * Modifica a descrição técnica da tarefa
     *
     * @param descTecnica
     */
    public void setDescTecnica(String descTecnica) {
        this.descTecnica = descTecnica;
    }

    /**
     * Retorna a duração estimada da tarefa
     *
     * @return a duração estimada
     */
    public Integer getDuracaoEst() {
        return duracaoEst;
    }

    /**
     * Modifica a duração estimada da tarefa
     *
     * @param duracaoEst
     */
    public void setDuracaoEst(Integer duracaoEst) {
        this.duracaoEst = duracaoEst;
    }

    /**
     * Retorna o custo estimado
     *
     * @return o custo
     */
    public Double getCustoEst() {
        return custoEst;
    }

    /**
     * Modifica o custo estimado
     *
     * @param custoEst
     */
    public void setCustoEst(Double custoEst) {
        this.custoEst = custoEst;
    }

    /**
     * @return the competencias
     */
    public ArrayList<CompetenciaTecnica> getCompetencias() {
        return competencias;
    }

    /**
     * @param competencias the competencias to set
     */
    public void setCompetencias(ArrayList<CompetenciaTecnica> competencias) {
        this.competencias = competencias;
    }
    
    public int getNivelProficiencia(int i){
        return competencias.get(i).getNivelProficiencia();
    }

}
