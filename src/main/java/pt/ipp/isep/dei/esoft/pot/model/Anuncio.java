package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;
import java.util.List;

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
            Date dtFimCandidatura, Date dtInicioSeriacao, Date dtFimSeriacao) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
        this.dtFimPublicitacao = dtFimPublicitacao;
        this.dtInicioCandidatura = dtInicioCandidatura;
        this.dtFimCandidatura = dtFimCandidatura;
        this.dtInicioSeriacao = dtInicioSeriacao;
        this.dtFimSeriacao = dtFimSeriacao;
        
        this.listaCandidaturas = new ListaCandidaturas();
        this.tipoRegimento = new TipoRegimento();
    }

    /**
     * Retorna uma cópia da lista de candidaturas recebidas para o anúncio
     */
    public ListaCandidaturas getListaCandidaturas() {
        return new ListaCandidaturas(listaCandidaturas);
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
