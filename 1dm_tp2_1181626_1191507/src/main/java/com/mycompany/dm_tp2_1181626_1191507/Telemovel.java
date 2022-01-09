package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Classe que representa um telemóvel disponível para comprar na plataforma
 * online Olxyz
 */
public class Telemovel implements Vendavel{

    private String designacao;

    private float valorVenda;

    /**
     * Constrói uma instância de Telemovel recebendo a designacao e o valor de
     * venda.
     *
     * @param designacao a designacao do telemóvel
     * @param valorVenda o valor de venda do telemóvel
     */
    public Telemovel(String designacao, float valorVenda) {
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
    @Override
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
    @Override
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    /**
     * Descrição textual de um telemóvel.
     * @return uma String com a designação do telemóvel
     */    
    @Override
    public String toString() {
        return String.format("Telemóvel com a designação %s.", designacao);
    }

    /**
     * Devolve o valor final de venda do telemóvel, com a taxa fixa da plataforma incluída.
     * @return o valor de venda do telemóvel
     */
    @Override
    public float calcularValorVenda() {
        return this.valorVenda*(1+TAXA_VENDA);
    }

}
