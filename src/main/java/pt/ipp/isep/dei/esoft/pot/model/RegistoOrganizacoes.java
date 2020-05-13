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
     *
     * @param org a Organizacao a adicionar
     * @return true se bem sucedido, false caso contrário
     */
    public boolean adicionarOrganizacao(Organizacao org) {
        return listaOrganizacoes.add(org);
    }
    /**
     * Retorna a Organizacao do utilizador, procurando a equivalência entre as extensões do endereço (o que sucede o "@")
     * Ex.: E-mail do utilizador: aaa@isep.pt
     *      E-mail da Organização: info@isep.pt
     *      Retorna a Organização ISEP
     * @param email o endereço de e-mail do utilizador
     * @return a Organizacao a que pertence o utilizador ou null se não existir correspondência
     */
    public Organizacao getOrganizacaoByEmailUtilizador(String email) {
        for (Organizacao org : listaOrganizacoes) {
            if (org.getEmailExtensao().equals(email.split("@")[email.split("@").length - 1])) {
                return org;
            }
        }
        return null;
    }
}
