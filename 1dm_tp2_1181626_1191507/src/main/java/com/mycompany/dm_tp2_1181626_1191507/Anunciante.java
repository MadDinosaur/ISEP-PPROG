/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

/**
 *
 * @author Francisco
 */
public class Anunciante {
    
    private String nome;
    
    private Endereco end;
    
    //private Aluguel listAlugavel;
    
    //private Vendavel listVendavel;
    
    public Anunciante(String nome, Endereco end, Aluguel listAluguel, Vendavel listVendavel){
        this.nome = nome;
        this.end = new Endereco(end);
        this.listAlugavel = new Aluguel(listAluguel);
        this.listVendavel = new Vendavel(listVendavel);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the end
     */
    public Endereco getEnd() {
        return end;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Endereco end) {
        this.end = end;
    }
    
}
