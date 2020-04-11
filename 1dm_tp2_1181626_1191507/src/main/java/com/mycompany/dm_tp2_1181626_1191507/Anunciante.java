/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

import java.util.ArrayList;

//TODO: Perguntar sobre método remove para os Arrays

/**
 * Classe que representa um anunciante que poderá uitilizar 
 * a plataforma online Olxyz para anunciar produtos vendáveis
 * ou alugáveis
 */
public class Anunciante {

    private String nome;

    private Endereco endereco;

    private ArrayList<Object> listAlugavel = new ArrayList();

    private ArrayList<Object> listVendavel = new ArrayList();

    private final int MAX_ALUGAVEIS = 3;

    private final int MAX_VENDAVEIS = 2;
    
    static public final float TAXA_ALUGAVEL = (float) 0.05;
    
    static public final float TAXA_VENDAVEL = (float) 0.03;
    
    private final String NOME_POR_OMISSAO = "Sem nome";
    
    private final Endereco ENDERECO_POR_OMISSAO = new Endereco();
    

    /**
     * Constrói uma instância de Anunciante recebendo o nome e o endereco
     *
     *
     * @param nome o nome do anunciante
     * @param endereco o endereco do anunciante
     */
    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
    }
    
    public Anunciante(String nome, String rua, String codigoPostal, String localidade) {
        this.nome = nome;
        this.endereco = new Endereco(rua, codigoPostal, localidade);
    }
    
    /**
     * Constrói uma instância de Anunciante não recebendo parâmetros
     *
     */
    public Anunciante() {
        this.nome = NOME_POR_OMISSAO;
        this.endereco = ENDERECO_POR_OMISSAO;
    }

    /**
     * Devolve o nome do anunciante.
     *
     * @return nome do anunciante
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a endereco do anunciante.
     *
     * @return endereco do anunciante
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Devolve a lista de aluguer do anunciante.
     *
     * @return lista de aluguer do anunciante
     */
    public ArrayList<Object> getListAluger() {
        return listAlugavel;
    }

    /**
     * Devolve a lista de vendáveis do anunciante.
     *
     * @return lista de aluger do anunciante
     */
    public ArrayList<Object> getListVendavel() {
        return listVendavel;
    }

    /**
     * Modifica o nome.
     *
     * @param nome nome do anunciante
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o endereco.
     *
     * @param endereco endereco do anunciante
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Adiciona um apartamento á lista dos produtos alugáveis
     * 
     * 
     * @return 
     */
    public boolean addListAlugavel(Apartamento apart) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            return listAlugavel.add(apart);
        } else {
            return false;
        }
    }

    /**
     * Adiciona um automóvel á lista dos produtos alugáveis
     * 
     * 
     * @param aut
     * @return 
     */
    public boolean addListAlugavel(Automovel aut) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            return listAlugavel.add(aut);
        } else {
            return false;
        }
    }

    /**
     * Adiciona um automóvel á lista dos produtos alugáveis
     * 
     * 
     * @param aut
     * @return 
     */
    public boolean addListVendavel(Automovel aut) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            return listVendavel.add(aut);
        }
    }

    /**
     * Adiciona um telemóvel á lista dos produtos alugáveis
     * 
     * 
     * @param aut
     * @return 
     */
    public boolean addListVendavel(Telemovel tel) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            return listVendavel.add(tel);
        }
    }
    
    /**
     * Devolve o número de produtos alugáveis.
     *
     * @return número de produtos alugáveis
     */
    public int getNObjetosAlugaveis(){
        return listAlugavel.size();
    }
    
    /**
     * Devolve o número de produtos vendáveis.
     *
     * @return número de produtos vendáveis
     */
    public int getNObjetosVendaveis(){
        return listVendavel.size();
    }
    
    /**
     * Calcula o valor de aluguer de um dado produto
     * 
     * 
     * @param o
     * @return 
     */
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
   
   /**
     * Calcula o valor de venda de um dado produto
     * 
     * 
     * @param o
     * @return 
     */
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
    
    /**
     * Devolve o produto a alugar mais caro.
     *
     * @return produto a alugar mais caro
     */
    public Object getAlugavelMaisCaro(){
        int indexMaisCaro = 0;
        for(int i = 0; i < listAlugavel.size(); i++){
            if(calcularValorAluguer(listAlugavel.get(i)) > calcularValorAluguer(listAlugavel.get(indexMaisCaro))){
                indexMaisCaro = i;
            }
        }
        return listAlugavel.get(indexMaisCaro);
    }
    
    /**
     * Devolve o valor total de vendas.
     *
     * @return valor total de vendas
     */
    public float getTotalValorVendas(){
        float totalVendas = 0;
        for(int i = 0; i < listVendavel.size(); i++){
            totalVendas = totalVendas + calcularValorVenda(listVendavel.get(i));
        }
        return totalVendas;
    }
    
    /**
     * Descrição textual de um anunciante.
     * @return uma String com o nome e o endereço do anunciante
     */
    public String toString(){
        return String.format("O anunciante, com o nome %s tem o endereço %s", nome, endereco.toString());
    }
}
