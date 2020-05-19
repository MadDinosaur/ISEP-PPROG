package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
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
    
    private ArrayList<Colaborador> colab;
    
    /**
     * Cria um objeto da classe ProcessoSeriacao
     *
     * @param tipoReg o TipoRegimento do processo
     * @param colab o Colaborador que realiza o processo
     * @param seriacao o tipo de seriação do processo
     * @param anuncio o Anuncio a seriar
     */
    public ProcessoSeriacao(TipoRegimento tipoReg, Colaborador colab, String seriacao, Anuncio anuncio) {
        this.tipoReg = tipoReg;
        this.colab.add(colab);
        this.seriacao = new Seriacao(seriacao);
        this.anuncio = anuncio;
        this.dataRealizacao = new Date();
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

    public boolean addParticipante(Colaborador part) {
        return colab.add(part);
    }

    public void valida() {
    }
    
    public void ordenar(){
        List<Candidatura> lista = anuncio.getListaCandidaturas().getCandidaturas();
        Comparator comparador = seriacao.getComparador();
        lista.sort(comparador);
    }
}