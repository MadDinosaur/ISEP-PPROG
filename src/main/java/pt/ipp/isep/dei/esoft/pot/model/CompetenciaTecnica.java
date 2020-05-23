/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class CompetenciaTecnica
{
    /**
     * O número de identificação da Competência Técnica 
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
     * Área de atividade da Competência Técnica
     */
    private AreaAtividade m_oAreaAtividade;
    /**
     * O nível de porficiencia do freelancer.
     */
    private int nivelProficiencia;
    
    /**
     * Cria um objeto da classe Competência Técnica
     *
     * @param strId  O número de identificação da Competência Técnica
     * @param strDescricaoBreve  a descrição breve da Competência Técnica
     * @param strDescricaoDetalhada  a descrição detalhada da Competência Técnica
     * @param nivelProficiencia  O nível de porficiencia do freelancer
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
     * @return the nivelPorficiencia
     */
    public int getNivelProficiencia() {
        return nivelProficiencia;
    }

    /**
     * @param nivelPorficiencia the nivelPorficiencia to set
     */
    public void setNivelProficiencia(int nivelPorficiencia) {
        this.nivelProficiencia = nivelPorficiencia;
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
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
        return hash;
    }
    
    /**
     * Verifica se duas Competências Técnicas são semelhantes
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }
    
    /**
     * Retorna um texto descritivo das características da Competência Técnica
     * @return 
     */
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s  - Área Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }
    
    /**
     * Verifica se duas Competências Técnicas são semelhantes
     * @param p2
     * @return 
     */
    public boolean verificarCompetenciasIguais(CompetenciaTecnica p2){
        if(nivelProficiencia == p2.getNivelProficiencia()){
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
