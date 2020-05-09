/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

/**
 *
 * @author Francisco
 */
public class Freelancer {
    
    private String nome;
    
    private String NIF;
    
    private String telefone;
    
    private String email;
    
    public Freelancer(String nome, String NIF, String telefone, String email){
        this.nome = nome;
        this.NIF = NIF;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Freelancer(Freelancer freelancer){
        this.nome = freelancer.getNome();
        this.NIF = freelancer.getNIF();
        this.telefone = freelancer.getTelefone();
        this.email = freelancer.getEmail();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
