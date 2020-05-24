package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Classe que modela uma Competência Técnica associada a uma Tarefa ou a um
 * Freelancer
 *
 * @author paulomaio
 */
public class CompetenciaTecnica {

    /**
     * Nome da Competência Técnica
     */
    private String m_strId;
    /**
     * Descrição breve da Competência Técnica
     */
    private String m_strDescricaoBreve;
    /**
     * Descrição detalhada da Competência Técnica
     */
    private String m_strDescricaoDetalhada;
    /**
     * O nível de proficiencia do freelancer.
     */
    private int nivelProficiencia;

    /**
     * Cria um objeto da classe Competência Técnica
     *
     * @param strId o nome da Competência Técnica
     * @param strDescricaoBreve a descrição breve da Competência Técnica
     * @param strDescricaoDetalhada a descrição detalhada da Competência Técnica
     * @param nivelProficiencia o nível de proficiencia de referência
     *
     */
    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, int nivelProficiencia) {
        if ((strId == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null) || (strId.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        this.nivelProficiencia = nivelProficiencia;
    }

    /**
     * Cria um objeto da classe Competência Técnica
     *
     * @param linha uma String com o seguinte formato: *
     * identificador;descricao_breve;descricao_detalhada;nivel_proficiencia
     */
    public CompetenciaTecnica(String linha) {
        String[] params = linha.split(";");

        if (linha.length() < 4) {
            throw new IllegalArgumentException("O argumento não é válido.");
        }

        this.m_strId = params[0];
        this.m_strDescricaoBreve = params[1];
        this.m_strDescricaoDetalhada = params[2];
        try {
            this.nivelProficiencia = Integer.parseInt(params[3]);
        } catch (NumberFormatException e) {
            System.out.println("O nível de proficiência tem que ser um número inteiro!");
        }
    }

    /**
     * Retorna o nível de proficiência da Competencia Tecnica
     *
     * @return the nivelProficiencia
     */
    public int getNivelProficiencia() {
        return nivelProficiencia;
    }
    
    /**
     * Verifica se duas Competências Técnicas têm o mesmo id
     * @param strId
     * @return 
     */
    public boolean hasId(String strId)
    {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
        return hash;
    }

    /**
     * Verifica se duas Competências Técnicas são iguais. As Competências
     * Técnicas são consideradas iguais se tiverem o mesmo nome.
     *
     * @param o Objeto a comparar
     * @return true se as competências forem iguais, false caso contrário
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
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return this.m_strId.equalsIgnoreCase(obj.m_strId);
    }

    /**
     * Retorna um texto descritivo das características da Competência Técnica
     *
     * @return a descrição textual
     */
    @Override
    public String toString() {
        return String.format("%s - %s - %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada);
    }
}
