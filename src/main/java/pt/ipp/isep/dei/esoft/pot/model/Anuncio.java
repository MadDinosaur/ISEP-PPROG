package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

public class Anuncio {

    /**
     * A data de início do período de publicitação
     */
    private Date dtInicioPublicitacao;
    /**
     * A data de fim do período de publicitação
     */
    private Date dtFimPublicitacao;
    /**
     * A data de início do período de apresentação de candidaturas
     */
    private Date dtInicioCandidatura;
    /**
     * A data de fim do período de apresentação de candidaturas
     */
    private Date dtFimCandidatura;
    /**
     * A data de início do período de seriação
     */
    private Date dtInicioSeriacao;
    /**
     * A data de fim do período de seriação
     */
    private Date dtFimSeriacao;
    /**
     * A lista de candidaturas apresentadas para o anúncio
     */
    private ListaCandidaturas listaCandidaturas;
    /**
     * O Colaborador que publica o anúncio
     */
    private Colaborador colaborador;
    /**
     * O ProcessoSeriacao criado pelo anúncio
     */
    private ProcessoSeriacao processoSeriacao;
    /**
     * A tarefa a que se refere o Anúncio
     */
    private Tarefa tarefa;
    /**
     * O nº de idenficação do Anuncio
     */
    private int id;

    /**
     * Cria um objeto da classe Anuncio
     *
     * @param dtInicioPublicitacao a data de início do período de publicitação
     * @param dtFimPublicitacao a data de fim do período de publicitação
     * @param dtInicioCandidatura a data de início do período de apresentação de
     * candidaturas
     * @param dtFimCandidatura a data de início do período de apresentação de
     * candidaturas
     * @param dtInicioSeriacao a data de início do período de seriação
     * @param dtFimSeriacao a data de fim do período de seriação
     * @param tarefa a Tarefa à qual se refere o anúncio
     * @param colab o Colaborador que publica o anúncio
     */
    public Anuncio(Date dtInicioPublicitacao, Date dtFimPublicitacao, Date dtInicioCandidatura,
            Date dtFimCandidatura, Date dtInicioSeriacao, Date dtFimSeriacao, Tarefa tarefa, Colaborador colab) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
        this.dtFimPublicitacao = dtFimPublicitacao;
        this.dtInicioCandidatura = dtInicioCandidatura;
        this.dtFimCandidatura = dtFimCandidatura;
        this.dtInicioSeriacao = dtInicioSeriacao;
        this.dtFimSeriacao = dtFimSeriacao;

        this.listaCandidaturas = new ListaCandidaturas();
        this.processoSeriacao = new ProcessoSeriacao(colab, this);
        this.tarefa = tarefa;
        this.colaborador = colab;
    }

    /**
     * Cria uma cópia de um objeto da classe Anuncio
     *
     * @param anun o Anuncio a copiar
     */
    public Anuncio(Anuncio anun) {
        this.dtInicioPublicitacao = anun.dtInicioPublicitacao;
        this.dtFimPublicitacao = anun.dtFimPublicitacao;
        this.dtInicioCandidatura = anun.dtInicioCandidatura;
        this.dtFimCandidatura = anun.dtFimCandidatura;
        this.dtInicioSeriacao = anun.dtInicioSeriacao;
        this.dtFimSeriacao = anun.dtFimSeriacao;
        this.listaCandidaturas = anun.listaCandidaturas;
        this.processoSeriacao = anun.processoSeriacao;
        this.tarefa = anun.tarefa;
        this.colaborador = anun.colaborador;
    }

    /**
     * Modifica o nº de identificação do Anuncio
     *
     * @param id o número de identificação
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Retorna o nº de indentificação do Anuncio
     *
     * @return o número de identificação
     */
    public int getID() {
        return this.id;
    }

    /**
     * Retorna uma cópia do colaborador que publicou o anúncio
     *
     * @return o Colaborador
     */
    public Colaborador getColaborador() {
        return new Colaborador(colaborador);
    }

    /**
     * Retorna uma cópia da lista de candidaturas recebidas para o anúncio
     *
     * @return a ListaCandidaturas do anúncio
     */
    public ListaCandidaturas getListaCandidaturas() {
        return new ListaCandidaturas(this.listaCandidaturas);
    }

    /**
     * Adiciona uma Candidatura ao Anuncio
     *
     * @param cand a candidatura a adicionar
     * @return true se a candidatura for adicionada, false caso contrário
     */
    public boolean adicionarCandidatura(Candidatura cand) {
        return listaCandidaturas.adicionarCandidatura(cand);
    }

    /**
     * Adiciona uma Candidatura ao Anuncio
     *
     * @param dataCandidatura a data de criação da candidatura
     * @param valorPretendido o valor pretendido para executar a tarefa na
     * candidatura
     * @param nrDias o nº de dias para executar a tarefa na candidatura
     * @param txtApresentacao o texto de apresentação do candidato
     * @param txtMotivacao o texto de motivação do candidato
     * @param freelancer o Freelancer que efetua a candidatura
     * @return true se a candidatura for adicionada, false caso contrário
     */
    public boolean adicionarCandidatura(Date dataCandidatura, double valorPretendido, int nrDias,
            String txtApresentacao, String txtMotivacao, Freelancer freelancer) {
        return listaCandidaturas.adicionarCandidatura(dataCandidatura, valorPretendido, nrDias, txtApresentacao, txtMotivacao, freelancer, this);
    }

    /**
     * Retorna uma cópia do processo de seriação criado pelo anúncio
     *
     * @return o ProcessoSeriacao do anúncio
     */
    public ProcessoSeriacao getProcessoSeriacao() {
        return new ProcessoSeriacao(processoSeriacao);
    }

    /**
     * Espoleta um processo de seriação para o anúncio
     *
     * @param seriacao o tipo de seriação pretendida. Os tipos de seriação são
     * os que constam no método mostrarOpcoes da classe Seriacao
     */
    public void novoProcessoSeriacao(String seriacao) {
        this.processoSeriacao.setSeriacao(seriacao);
        this.processoSeriacao.setDataRealizacao();
    }
    
    public void limparProcessoSeriacao() {
        this.processoSeriacao.setSeriacao(null);
    }

    /**
     * Retorna uma cópia da Tarefa associada ao Anuncio
     *
     * @return a tarefa a que se refere o Anuncio
     */
    public Tarefa getTarefa() {
        return new Tarefa(tarefa);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Anuncio a = (Anuncio) o;
        if (this.dtFimCandidatura.equals(a.dtFimCandidatura)
                && this.dtFimPublicitacao.equals(a.dtFimPublicitacao)
                && this.dtFimSeriacao.equals(a.dtFimSeriacao)
                && this.dtInicioCandidatura.equals(a.dtInicioCandidatura)
                && this.dtInicioPublicitacao.equals(a.dtInicioPublicitacao)
                && this.dtInicioSeriacao.equals(a.dtInicioSeriacao)
                && this.colaborador.equals(a.colaborador)
                && this.tarefa.equals(a.tarefa)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("ID %d - %s - %s", id, dtInicioPublicitacao, tarefa.getDesignacao());
    }
}
