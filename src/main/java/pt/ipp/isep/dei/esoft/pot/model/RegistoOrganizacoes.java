package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;

public class RegistoOrganizacoes {

    /**
     * A lista de organizações registadas na plataforma
     */
    private List<Organizacao> listaOrganizacoes;

    /**
     * Cria um objeto da classe RegistoOrganizacoes com um ArrayList vazio
     */
    public RegistoOrganizacoes() {
        this.listaOrganizacoes = new ArrayList<>();
    }

    /**
     * Cria um objeto da classe RegistoOrganizacoes
     *
     * @param listaOrganizacoes a lista das Organizacoes
     */
    public RegistoOrganizacoes(List<Organizacao> listaOrganizacoes) {
        this.listaOrganizacoes = listaOrganizacoes;
    }
    /**
     * Adiciona uma Organizacao ao RegistoOrganizacoes
     * @param org a Organizacao a adicionar
     * @return true se bem sucedido, false caso contrário
     */
    public boolean add(Organizacao org){
        return listaOrganizacoes.add(org);
    }
    public void getOrganizacaoByEmailUtilizador(String email) {
    }
}
