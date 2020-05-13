package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

//NOTAS
//- Getters e setters de Dates não estão definidos por composição
//- Completar construtores
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
     * O tipo de regimento do anúncio
     */
    private TipoRegimento tipoRegimento;
    /**
     * O Colaborador que publica o anúncio
     */
    private Colaborador colab;
    /**
     * O ProcessoSeriacao criado pelo anúncio
     */
    private ProcessoSeriacao ps;
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
     */
    //SE ESTE CONSTRUTOR FOR ALTERADO: ALTERAR EM INICIALIZADOR.JAVA
    public Anuncio(Date dtInicioPublicitacao, Date dtFimPublicitacao, Date dtInicioCandidatura,
            Date dtFimCandidatura, Date dtInicioSeriacao, Date dtFimSeriacao, String strNome, String strFuncao, String strTelefone, String strEmail) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
        this.dtFimPublicitacao = dtFimPublicitacao;
        this.dtInicioCandidatura = dtInicioCandidatura;
        this.dtFimCandidatura = dtFimCandidatura;
        this.dtInicioSeriacao = dtInicioSeriacao;
        this.dtFimSeriacao = dtFimSeriacao;

        this.listaCandidaturas = new ListaCandidaturas();
        this.tipoRegimento = new TipoRegimento();

        this.colab = new Colaborador(strNome, strFuncao, strTelefone, strEmail);
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    /**
     * Retorna a data de início do período de publicitação
     *
     * @return a data de início do período de publicitação, em formato Date
     */
    public Date getDtInicioPublicitacao() {
        return dtInicioPublicitacao;
    }

    /**
     * Modifica a data de início do período de publicitação
     *
     * @param dtInicioPublicitacao a data de início do período de publicitação
     */
    public void setDtInicioPublicitacao(Date dtInicioPublicitacao) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
    }

    /**
     * Retorna a data de fim do período de publicitação
     *
     * @return Date: a data de fim do período de publicitação, em formato Date
     */
    public Date getDtFimPublicitacao() {
        return dtFimPublicitacao;
    }

    /**
     * Modifica a data de fim do período de publicitação
     *
     * @param dtFimPublicitacao a data de fim do período de publicitação, em
     * formato Date
     */
    public void setDtFimPublicitacao(Date dtFimPublicitacao) {
        this.dtFimPublicitacao = dtFimPublicitacao;
    }

    /**
     * Retorna a data de início do período de apresentação de candidaturas
     *
     * @return a data de início das candidaturas, em formato Date
     */
    public Date getDtInicioCandidatura() {
        return dtInicioCandidatura;
    }

    /**
     * Modifica a data de início do período de apresentação de candidaturas
     *
     * @param dtInicioCandidatura a data de início das candidaturas
     */
    public void setDtInicioCandidatura(Date dtInicioCandidatura) {
        this.dtInicioCandidatura = dtInicioCandidatura;
    }

    /**
     * Retorna a data de fim do período de apresentação de candidaturas
     *
     * @return a data de fim das candidaturas, em formato Date
     */
    public Date getDtFimCandidatura() {
        return dtFimCandidatura;
    }

    /**
     * Modifica a data de fim do período de apresentação de candidaturas
     *
     * @param dtFimCandidatura a data de fim das candidaturas
     */
    public void setDtFimCandidatura(Date dtFimCandidatura) {
        this.dtFimCandidatura = dtFimCandidatura;
    }

    /**
     * Retorna a data de início do período de seriação
     *
     * @return a data de início da seriação, em formato Date
     */
    public Date getDtInicioSeriacao() {
        return dtInicioSeriacao;
    }

    /**
     * Modfica a data de início do período de seriação
     *
     * @param dtInicioSeriacao a data de início da seriação
     */
    public void setDtInicioSeriacao(Date dtInicioSeriacao) {
        this.dtInicioSeriacao = dtInicioSeriacao;
    }

    /**
     * Retorna a data de fim do período de seriação
     *
     * @return a data de fim da seriação, em formato Date
     */
    public Date getDtFimSeriacao() {
        return dtFimSeriacao;
    }

    /**
     * Modfica a data de fim do período de seriação
     *
     * @param dtFimSeriacao a data de fim da seriação
     */
    public void setDtFimSeriacao(Date dtFimSeriacao) {
        this.dtFimSeriacao = dtFimSeriacao;
    }

    /**
     * Retorna uma cópia do tipo de regimento do anúncio
     *
     * @return o TipoRegimento
     */
    public TipoRegimento getTipoRegimento() {
        return new TipoRegimento(tipoRegimento);
    }

    /**
     * Retorna uma cópia do colaborador que publicou o anúncio
     *
     * @return o Colaborador
     */
    public Colaborador getColaborador() {
        return new Colaborador(colab);
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
     * Retorna uma cópia do processo de seriação criado pelo anúncio
     *
     * @return o ProcessoSeriacao do anúncio
     */
    public ProcessoSeriacao getProcessoSeriacao() {
        return new ProcessoSeriacao(this.ps);
    }

    public void novoProcessoSeriacao(Colaborador colab) {
    }

    public void registaProcessoSeracao(ProcessoSeriacao ps) {
    }

    private void validaProcessoSeriacao(ProcessoSeriacao ps) {
    }

    private void setProcessoSeriacao(ProcessoSeriacao ps) {
    }

}
