/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

import java.util.ArrayList;

/**
 *
 * @author Francisco
 */
public class Anunciante {
    
    private String nome;
    
    private Endereco endereco;
    
    private ArrayList<Object> listAluger = new ArrayList();
    
    private ArrayList<Object> listVendavel = new ArrayList();
    
    public Anunciante(String nome, Endereco end, ArrayList<Object> listAluger, ArrayList<Object> listVendavel){
        this.nome = nome;
        this.endereco = new Endereco(end);
        this.listAluger = listAluger;
        this.listVendavel = listVendavel;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @return the listAluger
     */
    public ArrayList<Object> getListAluger() {
        return listAluger;
    }

    /**
     * @return the listVendavel
     */
    public ArrayList<Object> getListVendavel() {
        return listVendavel;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @param listAluger the listAluger to set
     */
    public void setListAluger(ArrayList<Object> listAluger) {
        this.listAluger = listAluger;
    }

    /**
     * @param listVendavel the listVendavel to set
     */
    public void setListVendavel(ArrayList<Object> listVendavel) {
        this.listVendavel = listVendavel;
    }

    
    
}
