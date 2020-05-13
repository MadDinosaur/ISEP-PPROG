/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class Organizacao {

    /**
     * O nome da organização
     */
    private String m_strNome;
    /**
     * O NIPC da organização
     */
    private String m_strNIF;
    /**
     * A morada da organização
     */
    private EnderecoPostal m_oEnderecoPostal;
    /**
     * O endereço web da organização
     */
    private String m_strWebsite;
    /**
     * O nº de telefone da organização
     */
    private String m_strTelefone;
    /**
     * O endereço de e-mail da organização
     */
    private String m_strEmail;
    /**
     * O Colaborador principal (gestor)
     */
    private Colaborador m_oGestor;
    /**
     * A lista de todos os Colaboradores
     */
    private ListaColaboradores listaColaboradores = new ListaColaboradores();
    /**
     * A lista de todas as Tarefas da organização
     */
   //private ListaTarefas listaTarefas = new ListaTarefas();

    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
            String strEmail, EnderecoPostal oMorada, Colaborador oColaborador) {
        if ((strNome == null) || (strNIF == null) || (strTelefone == null)
                || (strEmail == null) || (oMorada == null) || (oColaborador == null)
                || (strNome.isEmpty()) || (strNIF.isEmpty()) || (strTelefone.isEmpty())
                || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;
        this.listaColaboradores.adicionarColaborador(oColaborador);

    }

    public String getEmailExtensao() {
        return this.m_strEmail.split("@")[this.m_strEmail.split("@").length - 1];
    }

    public Colaborador getGestor() {
        return this.m_oGestor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oEnderecoPostal.toString(), this.m_oGestor.toString());
        return str;
    }

    public Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        Colaborador novoColab = new Colaborador(strNome, strFuncao, strTelefone, strEmail);
        this.listaColaboradores.adicionarColaborador(novoColab);
        return novoColab;
    }

    public static EnderecoPostal novoEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade) {
        return new EnderecoPostal(strLocal, strCodPostal, strLocalidade);
    }

}
