package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Classe que modela um Colaborador de uma dada Organização, responsável por
 * criar Anúncios e iniciar Seriações.
 *
 * @author paulomaio
 */
public class Colaborador {

    /**
     * O nome do Colaborador
     */
    private String m_strNome;
    /**
     * A função do Colaborador
     */
    private String m_strFuncao;
    /**
     * O número de telefone do Colaborador
     */
    private String m_strTelefone;
    /**
     * o email do Colaborador
     */
    private String m_strEmail;

    /**
     * Cria um objeto da classe Colaborador
     *
     * @param strNome o nome do Colaborador
     * @param strFuncao a função do Colaborador
     * @param strTelefone o numero de telefone do Colaborador
     * @param strEmail o email do Colaborador
     *
     */
    public Colaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        if ((strNome == null) || (strFuncao == null) || (strTelefone == null) || (strEmail == null)
                || (strNome.isEmpty()) || (strFuncao.isEmpty()) || (strTelefone.isEmpty()) || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strNome = strNome;
        this.m_strFuncao = strFuncao;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
    }

    /**
     * Cria uma cópia de um objeto da classe Colaborador
     *
     * @param colab o Colaborador a copiar
     */
    public Colaborador(Colaborador colab) {
        this.m_strNome = colab.m_strNome;
        this.m_strFuncao = colab.m_strFuncao;
        this.m_strTelefone = colab.m_strTelefone;
        this.m_strEmail = colab.m_strEmail;
    }

    /**
     * Retorna o nome do Colaborador
     *
     * @return o nome do Colaborador
     */
    public String getNome() {
        return this.m_strNome;
    }

    /**
     * Retorna o email do Colaborador
     *
     * @return o email do Colaborador
     */
    public String getEmail() {
        return this.m_strEmail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strEmail);
        return hash;
    }

    /**
     * Verifica se dois Colaboradores são iguais. Os Colaboradores são
     * considerados iguais se tiverem o mesmo e-mail.
     *
     * @param o Objeto a comparar
     * @return true se os Colaboradores forem iguais, false caso contrário
     */
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
        Colaborador obj = (Colaborador) o;
        return (Objects.equals(m_strEmail, obj.m_strEmail));
    }

    /**
     * Retorna um texto descritivo das características do Colaborador
     *
     * @return a descrição textual
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", this.m_strNome, this.m_strFuncao, this.m_strTelefone, this.m_strEmail);
    }
}
