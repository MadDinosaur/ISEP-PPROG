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
    
    private final float TAXA_ALUGAVEL = (float) 0.05;
    
    private final float TAXA_VENDAVEL = (float) 0.03;
    
    private final String NOME_POR_OMISSAO = "";
    
    private final Endereco ENDERECO_POR_OMISSAO = new Endereco();
    
    private int nObjetosAlugaveis = 0;
    
    private int nObjetosVendaveis = 0;
    

    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
    }
    
    public Anunciante() {
        this.nome = NOME_POR_OMISSAO;
        this.endereco = ENDERECO_POR_OMISSAO;
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

    public boolean addListAlugavel(Apartamento apart) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            nObjetosAlugaveis++;
            return listAlugavel.add(apart);
        } else {
            return false;
        }
    }

    public boolean addListAlugavel(Automovel aut) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            nObjetosAlugaveis++;
            return listAlugavel.add(aut);
        } else {
            return false;
        }
    }

    public boolean addListVendavel(Automovel aut) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            nObjetosVendaveis++;
            return listVendavel.add(aut);
        }
    }

    public boolean addListVendavel(Telemovel tel) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            nObjetosVendaveis++;
            return listVendavel.add(tel);
        }
    }
    
    public int getNObjetosAlugaveis(){
        return nObjetosAlugaveis;
    }
    
    public int getNObjetosVendaveis(){
        return nObjetosVendaveis;
    }
    
   public float calcularValorAluguer(Object o) {
        float valor = 0;
        if (listAlugavel.contains(o)) {
            if (o instanceof Apartamento) {
                Apartamento a = (Apartamento) o;
                valor = a.getValorAluguer();
            } else {
                Automovel a = (Automovel) o;
                valor = a.getValorAluguer();
            }
            return valor *(1+TAXA_ALUGAVEL);
        }
        return 0;
    }
    public float calcularValorVenda(Object o) {
       float valor = 0;
        if (listVendavel.contains(o)) {
            if (o instanceof Telemovel) {
                Telemovel t = (Telemovel) o;
                valor = t.getValorVenda();
            } else {
                Automovel a = (Automovel) o;
                valor = a.getValorVenda();
            }
            return valor * (1 + TAXA_VENDAVEL);
        }
        return 0;
    }
}
