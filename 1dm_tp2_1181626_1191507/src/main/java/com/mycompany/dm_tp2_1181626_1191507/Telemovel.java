/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

/**
    * Classe que representa um telemóvel disponível para
    * comprar no site de vendas olxyz
    */
public class Telemovel {
    
    private String designacao;
    
    private float valorVenda;
    
    /**
     * Constrói uma instância de Telemovel recebendo a designacao
     * e o valor de venda.
     *
     *
     * @param designacao a designacao do telemóvel
     * @param valorVenda o valor de venda do telemóvel
     */
    public Telemovel(String designacao, float valorVenda){
        this.designacao = designacao;
        this.valorVenda = valorVenda;
    }

    /**
     * Devolve a designação do telemóvel.
     *
     * @return designação do telemõvel
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Devolve o valor de venda do telemóvel.
     *
     * @return valor de venda do telemõvel
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * Modifica a designacao.
     *
     * @param designacao designação do telemóvel
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Modifica o valor de venda.
     *
     * @param valorVenda valor de venda do telemóvel
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
}
