package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Classe que modela uma lista de Candidaturas
 */
public class ListaCandidaturas {

    /**
     * A lista de candidaturas para um dado Anuncio
     */
    private List<Candidatura> listaCandidaturas;

    /**
     * Cria um objeto da classe ListaCandidaturas com um ArrayList vazio
     */
    public ListaCandidaturas() {
        this.listaCandidaturas = new ArrayList<>();
    }

    /**
     * Cria uma cópia de um objeto da classe ListaCandidaturas
     *
     * @param listaCandidaturas a ListaCandidaturas a copiar
     */
    public ListaCandidaturas(ListaCandidaturas listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas.listaCandidaturas;
    }

    /**
     * Retorna a lista de candidaturas de um dado Anuncio
     *
     * @param anuncioID o nº de identificação do Anuncio
     * @return a ListaCandidaturas associadas ao Anuncio
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
     * Retorna uma Candidatura por índice na lista
     *
     * @param i o índice da Candidatura na lista
     * @return a Candidatura no índice i da lista
     */
    public Candidatura get(int i) {
        try {
            return listaCandidaturas.get(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Candidatura não encontrada no índice " + i + " da lista.");
        }
        return null;
    }

    /**
     * Adiciona uma Candidatura à lista
     *
     * @param cand a Candidatura a adicionar
     * @return true se a Candidatura for adicionada, false caso contrário
     */
    public boolean adicionarCandidatura(Candidatura cand) {
        return listaCandidaturas.add(cand);
    }

    /**
     * Adiciona uma Candidatura à lista
     *
     * @param dataCandidatura a data de criação da candidatura
     * @param valorPretendido o valor pretendido para executar a tarefa na
     * candidatura
     * @param nrDias o nº de dias para executar a tarefa na candidatura
     * @param txtApresentacao o texto de apresentação do candidato
     * @param txtMotivacao o texto de motivação do candidato
     * @param freelancer o Freelancer que efetua a candidatura
     * @param anuncio o Anuncio para a qual a Candidatura se destina
     * @return true se a Candidatura for adicionada, false caso contrário
     */
    public boolean adicionarCandidatura(Date dataCandidatura, double valorPretendido, int nrDias,
            String txtApresentacao, String txtMotivacao, Freelancer freelancer, Anuncio anuncio) {
        return listaCandidaturas.add(new Candidatura(dataCandidatura, valorPretendido, nrDias, txtApresentacao, txtMotivacao, freelancer, anuncio));
    }

    /**
     * Retorna o tamanho da Lista de Candidaturas
     *
     * @return o nº de candidaturas na lista
     */
    public int getSize() {
        return listaCandidaturas.size();
    }

    /**
     * Ordena a lista de candidaturas
     *
     * @param ordem o Comparator que define a ordem de seriação das Candidaturas
     */
    public void sort(Comparator ordem) {
        listaCandidaturas.sort(ordem);
    }

    /**
     * Verifica se duas Listas de Candidaturas são iguais. Os critério de
     * igualdade são idênticos aos da classe ArrayList
     *
     * @param o Objeto a comparar
     * @return true se as Listas forem iguais, false caso contrário
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

    /**
     * Retorna a Lista de Candidaturas mas em formato ArrayList<String>
     *
     * @return a lista de candidatura, em formato de texto
     */
    public List<String> toStringArray() {
        ArrayList<String> strCandidaturas = new ArrayList<>();
        for (Candidatura cand : listaCandidaturas) {
            strCandidaturas.add(cand.toString());
        }
        return strCandidaturas;
    }
}
