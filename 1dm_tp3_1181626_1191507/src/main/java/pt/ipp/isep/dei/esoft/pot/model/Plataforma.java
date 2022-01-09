package pt.ipp.isep.dei.esoft.pot.model;

/**
 * Classe que modela a plataforma que contém toda a informação da aplicação
 *
 * @author Paulo Maio pam@isep.ipp.pt
 */
public class Plataforma {

    /**
     * O nome da plataforma
     */
    private String designacao;
    /**
     * O nome da plataforma por omissão
     */
    private final String DESIGNACAO_POR_OMISSAO = "";
    /**
     * O Registo de Anuncios associados à plataforma
     */
    private final RegistoAnuncios listaAnuncios;
    /**
     * O Registo de Organizações associadas à plataforma
     */
    private final RegistoOrganizacoes listaOrganizacoes;

    /**
     * Cria um objeto da classe Plataforma por omissão
     */
    public Plataforma() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.listaAnuncios = new RegistoAnuncios();
        this.listaOrganizacoes = new RegistoOrganizacoes();
    }

    /**
     * Cria um objeto da classe Plataforma com registos vazios
     *
     * @param strDesignacao o nome da plataforma a criar
     */
    public Plataforma(String strDesignacao) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.designacao = strDesignacao;
        this.listaAnuncios = new RegistoAnuncios();
        this.listaOrganizacoes = new RegistoOrganizacoes();
    }

    /**
     * Cria um objeto da classe Plataforma
     *
     * @param strDesignacao o nome da plataforma a criar
     * @param listaOrganizacoes a lista de organizações registadas na plataforma
     * @param listaAnuncios a lista de anúncios registadas na plataforma
     */
    public Plataforma(String strDesignacao, RegistoOrganizacoes listaOrganizacoes, RegistoAnuncios listaAnuncios) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty()) || listaOrganizacoes == null || listaAnuncios == null) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.designacao = strDesignacao;
        this.listaAnuncios = listaAnuncios;
        this.listaOrganizacoes = listaOrganizacoes;
    }

    /**
     * Retorna o Registo de Organizações da Plataforma
     *
     * @return o Registo de Organizacoes
     */
    public RegistoOrganizacoes getRegistoOrganizacoes() {
        return listaOrganizacoes;
    }

    /**
     * Retorna o Registo de Anúncios da Plataforma
     *
     * @return o Registo de Anuncios
     */
    public RegistoAnuncios getRegistoAnuncios() {
        return this.listaAnuncios;
    }

}
