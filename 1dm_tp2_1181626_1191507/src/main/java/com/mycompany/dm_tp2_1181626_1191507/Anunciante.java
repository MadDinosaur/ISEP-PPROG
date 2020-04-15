/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

import java.util.ArrayList;

/**
 * Classe que representa um anunciante que poderá uitilizar a plataforma online
 * Olxyz para anunciar produtos vendáveis ou alugáveis
 */
public class Anunciante {

    private String nome;

    private Endereco endereco;

    private final String NOME_POR_OMISSAO = "Sem nome";

    private final Endereco ENDERECO_POR_OMISSAO = new Endereco();

    private ArrayList<Alugavel> listAlugavel = new ArrayList();

    private ArrayList<Vendavel> listVendavel = new ArrayList();

    private final int MAX_ALUGAVEIS = 3;

    private final int MAX_VENDAVEIS = 2;

    /**
     * Constrói uma instância de Anunciante recebendo o nome e o endereco
     *
     * @param nome o nome do anunciante
     * @param endereco o endereco do anunciante
     */
    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
    }

    /**
     * Constrói uma instância de Anunciante recebendo o nome, a rua, o código
     * postal e a localidade do mesmo.
     *
     * @param nome o nome do anunciante
     * @param rua a rua do endereço do anunciante
     * @param codigoPostal o codigo postal do endereço do anunciante
     * @param localidade a localidade do endereço do anunciante
     */
    public Anunciante(String nome, String rua, String codigoPostal, String localidade) {
        this.nome = nome;
        this.endereco = new Endereco(rua, codigoPostal, localidade);
    }

    /**
     * Constrói uma instância de Anunciante por omissão, não recebendo
     * parâmetros
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
     * Devolve o endereco do anunciante.
     *
     * @return endereco do anunciante
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * Devolve a lista de produtos disponíveis para aluguer do anunciante.
     *
     * @return lista de produtos alugáveis
     */
    public ArrayList<Alugavel> getListAlugavel() {
        return new ArrayList(listAlugavel);
    }

    /**
     * Devolve a lista de produtos disponíveis para venda do anunciante.
     *
     * @return lista de produtos vendáveis
     */
    public ArrayList<Vendavel> getListVendavel() {
        return new ArrayList(listVendavel);
    }

    /**
     * Modifica o nome do anunciante.
     *
     * @param nome o nome do anunciante
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o endereço do anunciante.
     *
     * @param endereco o novo endereço
     */
    public void setEndereco(Endereco endereco) {
        this.endereco.setRua(endereco.getRua());
        this.endereco.setCodigoPostal(endereco.getCodigoPostal());
        this.endereco.setLocalidade(endereco.getLocalidade());
    }

    /**
     * Adiciona um produto à lista dos produtos alugáveis.
     *
     * @param alugavel o produto alugável a adicionar à lista
     * @return true se a adição do produto for bem sucedida, false caso
     * contrário
     */
    public boolean addListAlugavel(Alugavel alugavel) {
        if (listAlugavel.size() < MAX_ALUGAVEIS) {
            return listAlugavel.add(alugavel);
        } else {
            return false;
        }
    }

    /**
     * Adiciona um produto à lista dos produtos vendáveis.
     *
     * @param vendavel o produto vendável a adicionar à lista
     * @return true se a adição do produto for bem sucedida, false caso
     * contrário
     */
    public boolean addListVendavel(Vendavel vendavel) {
        if (listVendavel.size() == MAX_VENDAVEIS) {
            return false;
        } else {
            return listVendavel.add(vendavel);
        }
    }

    /**
     * Devolve o número de produtos na lista de alugáveis.
     *
     * @return número de produtos alugáveis
     */
    public int getNObjetosAlugaveis() {
        return listAlugavel.size();
    }

    /**
     * Devolve o número de produtos na lista de vendáveis.
     *
     * @return número de produtos vendáveis
     */
    public int getNObjetosVendaveis() {
        return listVendavel.size();
    }

    /**
     * Devolve o produto mais caro na lista de produtos alugáveis.
     *
     * @return produto alugável mais caro
     */
    public Object getAlugavelMaisCaro() {
        float maisCaro = 0;
        Alugavel produtoMaisCaro = listAlugavel.get(0); 
        for (Alugavel produto : listAlugavel) {
            if (produto.calcularValorAluguer() > maisCaro) {
                maisCaro = produto.calcularValorAluguer();
                produtoMaisCaro = produto;
            }
        }
        return produtoMaisCaro;
    }

    /**
     * Devolve a soma do valor de venda de todos os produtos vendáveis do
     * anunciante, com as taxas fixas da plataforma incluídas.
     *
     * @return o valor total de venda
     */
    public float getTotalValorVendas() {
        float totalVendas = 0;
        for (Vendavel produto : listVendavel) {
            totalVendas = totalVendas + produto.calcularValorVenda();
        }
        return totalVendas;
    }

    /**
     * Descrição textual de um anunciante.
     *
     * @return uma String com o nome e o endereço do anunciante
     */
    @Override
    public String toString() {
        return String.format("O anunciante, com o nome %s tem o endereço %s", nome, endereco.toString());
    }
}
