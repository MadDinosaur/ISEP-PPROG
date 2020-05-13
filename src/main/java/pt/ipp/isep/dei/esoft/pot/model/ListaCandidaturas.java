package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;

public class ListaCandidaturas {

    /**
     * A lista de candidaturas para um dado Anuncio
     */
    private List<Candidatura> listaCandidaturas;

    /**
     * Cria um objeto de ListaCandidaturas com um ArrayList vazio
     */
    public ListaCandidaturas() {
        this.listaCandidaturas = new ArrayList<>();
    }

    public ListaCandidaturas(ListaCandidaturas listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas.getCandidaturas();
    }

    /**
     * Retorna uma cópia da lista de candidaturas
     *
     * @return a lista de Candidaturas
     */
    public List<Candidatura> getCandidaturas() {
        return new ArrayList<>(listaCandidaturas);
    }

    public void getCandidatura(int candID) {

    }

    public List<String> toStringArray() {
        ArrayList<String> strCandidaturas = new ArrayList<>();
        for (Candidatura cand : listaCandidaturas) {
            strCandidaturas.add(cand.toString());
        }
        return strCandidaturas;
    }
}
