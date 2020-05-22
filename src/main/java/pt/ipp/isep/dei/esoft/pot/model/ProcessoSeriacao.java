package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProcessoSeriacao {

    /**
     * Data de realização do processo de seriação
     */
    private Date dataRealizacao;
    /**
     * Tipo de Seriação associada ao processo de seriação
     */
    private Seriacao seriacao;
    /**
     * Anúncio que espoleta o processo de seriação
     */
    private Anuncio anuncio;
    /**
     * A lista de Participantes no processo de seriação
     */
    private ListaColaboradores listaColabs = new ListaColaboradores();

    /**
     * Cria um objeto da classe ProcessoSeriacao
     *
     * @param colab o Colaborador que realiza o processo
     * @param seriacao o tipo de seriação do processo
     * @param anuncio o Anuncio a seriar
     */
    public ProcessoSeriacao(Colaborador colab, String seriacao, Anuncio anuncio) {
        this.listaColabs.adicionarColaborador(colab);
        this.seriacao = new Seriacao(seriacao);
        this.anuncio = new Anuncio(anuncio);
        this.dataRealizacao = new Date();
    }

    /**
     * Cria um objeto da classe ProcessoSeriacao. Este constutor é utilizado
     * quando um Anuncio é criado e ainda está por seriar, não tendo por isso
     * data de realização nem tipo de seriação
     *
     * @param colab o Colaborador que realiza o processo
     * @param anuncio o Anuncio a seriar
     */
    public ProcessoSeriacao(Colaborador colab, Anuncio anuncio) {
        this.listaColabs.adicionarColaborador(colab);
        this.anuncio = new Anuncio(anuncio);
    }

    /**
     * Cria uma cópia de um objeto da classe ProcessoSeriacao
     *
     * @param ps o ProcessoSeriacao a copiar
     */
    public ProcessoSeriacao(ProcessoSeriacao ps) {
        this.listaColabs = ps.listaColabs;
        this.seriacao = ps.seriacao;
        this.anuncio = ps.anuncio;
        this.dataRealizacao = ps.dataRealizacao;
    }

    /**
     * Define a data de realização do processo como a data atual do sistema
     */
    public void setDataRealizacao() {
        this.dataRealizacao = new Date();
    }

    /**
     * Retorna a lista de participantes, como uma lista de Strings
     *
     * @return a lista de participantes
     */
    public List<String> getParticipantes() {
        return this.listaColabs.getColaboradores();
    }

    /**
     * Retorna o tipo de Seriacao
     *
     * @return a descrição textual do tipo de seriação
     */
    public String getSeriacao() {
        if (seriacao == null) {
            return null;
        } else {
            return seriacao.toString();
        }
    }

    /**
     * Define o tipo de Seriacao
     *
     * @param tipoSeriacao o nome do tipo de seriação
     */
    public void setSeriacao(String tipoSeriacao) {
        if (tipoSeriacao == null) 
            this.seriacao = null;
        else
            this.seriacao = new Seriacao(tipoSeriacao);
    }

    /**
     * Adiciona um Colaborador como participante
     *
     * @param part o participante a adicionar
     * @return true se a operação for bem sucedida, false caso contrário
     */
    public boolean addParticipante(Colaborador part) {
        return listaColabs.adicionarColaborador(part);
    }

    /**
     * Efetua o processo de seriação, ordenando a lista de Candidaturas
     * associada de acordo com os critérios de Seriacao
     */
    public void ordenar() {
        Comparator comparador = seriacao.getComparador();
        anuncio.getListaCandidaturas().getCandidaturas().sort(comparador);
    }
}
