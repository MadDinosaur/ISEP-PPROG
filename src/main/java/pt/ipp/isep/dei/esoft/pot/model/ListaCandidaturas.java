package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;
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
        return listaCandidaturas;
    }

    public void getCandidatura(int candID) {

    }

    public ListaCandidaturas getCandidaturas(int anuncioID) {
        ListaCandidaturas candidaturasDoAnuncio = new ListaCandidaturas();
        for (Candidatura cand : listaCandidaturas) {
            if (cand.getAnuncio().getID() == anuncioID) {
                candidaturasDoAnuncio.adicionarCandidatura(cand);
            }
        }
        return candidaturasDoAnuncio;
    }

    public boolean adicionarCandidatura(Candidatura cand) {
        return listaCandidaturas.add(cand);
    }

    public boolean adicionarCandidatura(Date dataCandidatura, double valorPretendido, int nrDias,
            String txtApresentacao, String txtMotivacao, Freelancer freelancer, Anuncio anuncio) {
        return listaCandidaturas.add(new Candidatura(dataCandidatura, valorPretendido, nrDias, txtApresentacao, txtMotivacao, freelancer, anuncio));
    }

    public Candidatura get(int i) {
        return listaCandidaturas.get(i);
    }

    public List<String> toStringArray() {
        ArrayList<String> strCandidaturas = new ArrayList<>();
        for (Candidatura cand : listaCandidaturas) {
            strCandidaturas.add(cand.toString());
        }
        return strCandidaturas;
    }

    public int getSize() {
        return listaCandidaturas.size();
    }
    
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        return this.listaCandidaturas.equals(((ListaCandidaturas) o).listaCandidaturas);
    }
}
