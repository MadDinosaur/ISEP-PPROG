package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Plataforma {

    /**
     * O nome da plataforma
     */
    private String designacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<AreaAtividade> m_lstAreasAtividade;
    private final Set<CompetenciaTecnica> m_lstCompetencias;
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
        this.designacao = "";
        this.m_oAutorizacao = new AutorizacaoFacade();
        this.m_lstAreasAtividade = new HashSet<>();
        this.m_lstCompetencias = new HashSet<>();
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

        this.m_oAutorizacao = new AutorizacaoFacade();

        this.m_lstAreasAtividade = new HashSet<>();
        this.m_lstCompetencias = new HashSet<>();
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
        this.designacao = strDesignacao;
        this.listaAnuncios = listaAnuncios;
        this.listaOrganizacoes = listaOrganizacoes;

        this.m_oAutorizacao = new AutorizacaoFacade();
        this.m_lstAreasAtividade = new HashSet<>();
        this.m_lstCompetencias = new HashSet<>();
    }

    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.m_oAutorizacao;
    }

    // Organizações
    // <editor-fold defaultstate="collapsed">
    public Organizacao novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, String strEmail, EnderecoPostal oMorada, Colaborador oGestor) {
        Organizacao novaOrg = new Organizacao(strNome, strNIF, strWebsite, strTelefone, strEmail, oMorada, oGestor);
        this.listaOrganizacoes.adicionarOrganizacao(novaOrg);
        return novaOrg;
    }

    public boolean registaOrganizacao(Organizacao oOrganizacao, String strPwd) {
        if (this.validaOrganizacao(oOrganizacao, strPwd)) {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor, strEmailGestor, strPwd,
                    new String[]{Constantes.PAPEL_GESTOR_ORGANIZACAO, Constantes.PAPEL_COLABORADOR_ORGANIZACAO})) {
                return addOrganizacao(oOrganizacao);
            }
        }
        return false;
    }

    private boolean addOrganizacao(Organizacao oOrganizacao) {
        return listaOrganizacoes.adicionarOrganizacao(oOrganizacao);
    }

    public boolean validaOrganizacao(Organizacao oOrganizacao, String strPwd) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail())) {
            bRet = false;
        }
        if (strPwd == null) {
            bRet = false;
        }
        if (strPwd.isEmpty()) {
            bRet = false;
        }
        //

        return bRet;
    }

    public RegistoOrganizacoes getRegistoOrganizacoes() {
        return listaOrganizacoes;
    }

    // </editor-fold>
    // Competências Tecnicas
    // <editor-fold defaultstate="collapsed">
    public CompetenciaTecnica getCompetenciaTecnicaById(String strId) {
        for (CompetenciaTecnica oCompTecnica : this.m_lstCompetencias) {
            if (oCompTecnica.hasId(strId)) {
                return oCompTecnica;
            }
        }

        return null;
    }

    public CompetenciaTecnica novaCompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoCompleta, int nvlProficiencia) {
        return new CompetenciaTecnica(strId, strDescricaoBreve, strDescricaoCompleta, nvlProficiencia);
    }

    public boolean registaCompetenciaTecnica(CompetenciaTecnica oCompTecnica) {
        if (this.validaCompetenciaTecnica(oCompTecnica)) {
            return addCompetenciaTecnica(oCompTecnica);
        }
        return false;
    }

    private boolean addCompetenciaTecnica(CompetenciaTecnica oCompTecnica) {
        return m_lstCompetencias.add(oCompTecnica);
    }

    public boolean validaCompetenciaTecnica(CompetenciaTecnica oCompTecnica) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    // </editor-fold>
    // Areas de Atividade 
    // <editor-fold defaultstate="collapsed">
    public AreaAtividade getAreaAtividadeById(String strId) {
        for (AreaAtividade area : this.m_lstAreasAtividade) {
            if (area.hasId(strId)) {
                return area;
            }
        }

        return null;
    }

    public AreaAtividade novaAreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada) {
        return new AreaAtividade(strCodigo, strDescricaoBreve, strDescricaoDetalhada);
    }

    public boolean registaAreaAtividade(AreaAtividade oArea) {
        if (this.validaAreaAtividade(oArea)) {
            return addAreaAtividade(oArea);
        }
        return false;
    }

    private boolean addAreaAtividade(AreaAtividade oArea) {
        return m_lstAreasAtividade.add(oArea);
    }

    public boolean validaAreaAtividade(AreaAtividade oArea) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public List<AreaAtividade> getAreasAtividade() {
        List<AreaAtividade> lc = new ArrayList<>();
        lc.addAll(this.m_lstAreasAtividade);
        return lc;
    }

    // </editor-fold>
    // Anúncios
    // <editor-fold defaultstate="collapsed">
    public RegistoAnuncios getRegistoAnuncios() {
        return this.listaAnuncios;
    }
    // </editor-fold>
}
