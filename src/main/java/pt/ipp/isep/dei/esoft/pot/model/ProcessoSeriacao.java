package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

public class ProcessoSeriacao {

    /**
     * Data de realização do processo de seriação
     */
    private Date dataRealizacao;

    /**
     * Cria um objeto da classe ProcessoSeriacao
     *
     * @param tipoReg o TipoRegimento do processo
     * @param colab o Colaborador que realiza o processo
     */
    public ProcessoSeriacao(TipoRegimento tipoReg, Colaborador colab) {
    }

    /**
     * Cria uma cópia de um objeto da classe ProcessoSeriacao
     *
     * @param ps o ProcessoSeriacao a copiar
     */
    public ProcessoSeriacao(ProcessoSeriacao ps) {
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
}
