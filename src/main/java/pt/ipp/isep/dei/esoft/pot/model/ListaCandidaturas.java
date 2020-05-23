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

    /**
     * Retorna as Candidaturas da Lista de Candidaturas
     * @param anuncioID
     * @return 
     */
    public ListaCandidaturas getCandidaturas(int anuncioID) {
        ListaCandidaturas candidaturasDoAnuncio = new ListaCandidaturas();
        for (Candidatura cand : listaCandidaturas) {
            if (cand.getAnuncio().getID() == anuncioID) {
                candidaturasDoAnuncio.adicionarCandidatura(cand);
            }
        }
        return candidaturasDoAnuncio;
    }

    /**
     * Adiciona uma Candidatura á Lista de Candidaturas
     * @param cand
     * @return 
     */
    public boolean adicionarCandidatura(Candidatura cand) {
        return listaCandidaturas.add(cand);
    }

    /**
     * Adiciona uma Candidatura á Lista de Candidaturas 
     * @param dataCandidatura
     * @param valorPretendido
     * @param nrDias
     * @param txtApresentacao
     * @param txtMotivacao
     * @param freelancer
     * @param anuncio
     * @return 
     */
    public boolean adicionarCandidatura(Date dataCandidatura, double valorPretendido, int nrDias,
            String txtApresentacao, String txtMotivacao, Freelancer freelancer, Anuncio anuncio) {
        return listaCandidaturas.add(new Candidatura(dataCandidatura, valorPretendido, nrDias, txtApresentacao, txtMotivacao, freelancer, anuncio));
    }

    /**
     * Retorna uma Candidatura por id
     * @param i
     * @return 
     */
    public Candidatura get(int i) {
        return listaCandidaturas.get(i);
    }

    /**
     * Retorna a Lista de Candidaturas mas em formato ArrayList
     * @return 
     */
    public List<String> toStringArray() {
        ArrayList<String> strCandidaturas = new ArrayList<>();
        for (Candidatura cand : listaCandidaturas) {
            strCandidaturas.add(cand.toString());
        }
        return strCandidaturas;
    }

    /**
     * Retorna o tamanho da Lista de Candidaturas
     * @return 
     */
    public int getSize() {
        return listaCandidaturas.size();
    }
    
    /**
     * Verifica se duas Listas de Candidaturas são semelhantes
     * @param o
     * @return 
     */
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
