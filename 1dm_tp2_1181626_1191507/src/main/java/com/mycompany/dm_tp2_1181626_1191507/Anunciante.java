/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

import java.util.ArrayList;

//TODO: Perguntar sobre método remove para os Arrays

public class Anunciante {

    private String nome;

    private Endereco endereco;

    private ArrayList<Object> listAlugavel = new ArrayList();

    private ArrayList<Object> listVendavel = new ArrayList();

    private final int MAX_ALUGAVEIS = 3;

    private final int MAX_VENDAVEIS = 2;

    public Anunciante(String nome, Endereco endereco, ArrayList<Object> listAlugavel, ArrayList<Object> listVendavel) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
        this.listAlugavel = listAlugavel;
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
        return listAlugavel;
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

    public boolean adicionarAlugavel(Apartamento apart) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            return listAlugavel.add(apart);
        } else {
            return false;
        }
    }

    public boolean adicionarAlugavel(Automovel aut) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            return listAlugavel.add(aut);
        } else {
            return false;
        }
    }

    public boolean addListVendavel(Automovel aut) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            return listVendavel.add(aut);
        }
    }

    public boolean addListVendavel(Telemovel tel) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            return listVendavel.add(tel);
        }
    }
}
