package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProcessoSeriacao {

    /**
     * Data de realização do processo de seriação
     */
    private Date dataRealizacao;
    
    private Seriacao seriacao;
    
    private Anuncio anuncio;
    
    private TipoRegimento tipoReg;
    
    private Colaborador colab;
    
    /**
     * Cria um objeto da classe ProcessoSeriacao
     *
     * @param tipoReg o TipoRegimento do processo
     * @param colab o Colaborador que realiza o processo
     */
    public ProcessoSeriacao(TipoRegimento tipoReg, Colaborador colab, Seriacao seriacao, Anuncio anuncio, Date dataRealizacao) {
        this.tipoReg = tipoReg;
        this.colab = colab;
        this.seriacao = seriacao;
        this.anuncio = anuncio;
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * Cria um objeto da classe ProcessoSeriacao
     *
     */
    public ProcessoSeriacao() {
    }

    /**
     * Cria uma cópia de um objeto da classe ProcessoSeriacao
     *
     * @param ps o ProcessoSeriacao a copiar
     */
    public ProcessoSeriacao(ProcessoSeriacao ps) {
        this.tipoReg = ps.tipoReg;
        this.colab = ps.colab;
        this.seriacao = ps.seriacao;
        this.anuncio = ps.anuncio;
        this.dataRealizacao = ps.dataRealizacao;
    }

    public void addClassificacao(Candidatura cand, int ordem) {
    }

    private void validaClassificacao(Classificacao classif) {
    }

    private void addClassificacao(Classificacao classif) {
    }

    public void addParticipante(Colaborador part) {
    }

    public void valida() {
    }
    
    public void ordenar(Seriacao seriacao){
        List<Candidatura> lista = anuncio.getListaCandidaturas().getCandidaturas();
        Comparator comparador = seriacao.getComparador();
        lista.sort(comparador);
    }
}