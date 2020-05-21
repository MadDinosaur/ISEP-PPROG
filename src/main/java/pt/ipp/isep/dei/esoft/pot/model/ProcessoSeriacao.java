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

    private ArrayList<Colaborador> listaColabs = new ArrayList<>();

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
        this.listaColabs.add(colab);
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
        this.listaColabs = ps.listaColabs;
        this.seriacao = ps.seriacao;
        this.anuncio = ps.anuncio;
        this.dataRealizacao = ps.dataRealizacao;
    }

    public List<String> getColaboradores() {
        return toStringArray();
    }

    public boolean addParticipante(Colaborador part) {
        return listaColabs.add(part);
    }

    public void valida() {
    }

    public void ordenar() {
        Comparator comparador = seriacao.getComparador();
        anuncio.getListaCandidaturas().getCandidaturas().sort(comparador);
    }

    private List<String> toStringArray() {
        ArrayList<String> strColaboradores = new ArrayList<>();
        for (Colaborador colab : listaColabs) {
            strColaboradores.add(colab.toString());
        }
        return strColaboradores;
    }
}
