package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Classe que representa um automóvel disponível para comprar ou alugar, nna
 * plataforma online Olxyz
 */
public class Automovel implements Vendavel, Alugavel {

    private String marca;

    private String modelo;

    private float valorVenda;

    private float valorAluguer;

    /**
     * Constrói uma instância de Automovel recebendo a marca, o modelo , o valor
     * de venda e o valor de aluguer.
     *
     *
     * @param marca a marca do automóvel
     * @param modelo o modelo do automóvel
     * @param valorVenda o valor de venda do automóvel
     * @param valorAluguer o valor de aluguer do automóvel
     */
    public Automovel(String marca, String modelo, float valorVenda, float valorAluguer) {
        this.marca = marca;
        this.modelo = modelo;
        this.valorVenda = valorVenda;
        this.valorAluguer = valorAluguer;

    }

    /**
     * Devolve a marca do automóvel.
     *
     * @return marca do automóvel
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devolve o modelo do automóvel.
     *
     * @return modelo do automóvel
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Devolve o valor de venda pretendido do automóvel.
     *
     * @return valor de venda pretendido do automóvel
     */
    @Override
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * Devolve o valor de aluguer pretendido do automóvel.
     *
     * @return valor do aluguer pretendido do automóvel
     */
    @Override
    public float getValorAluguer() {
        return valorAluguer;
    }

    /**
     * Modifica a marca do automóvel.
     *
     * @param marca marca do automóvel
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Modifica o modelo do automóvel.
     *
     * @param modelo modelo do automóvel
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Modifica o valor de venda pretendido do automóvel.
     *
     * @param valorVenda valor de venda pretendido do automóvel
     */
    @Override
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * Modifica o valor de aluguer pretendido do automóvel.
     *
     * @param valorAluguer valor de aluguer pretendido do automóvel
     */
    @Override
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

    /**
     * Descrição textual de um automóvel.
     *
     * @return uma String com a marca e modelo do automóvel
     */
    @Override
    public String toString() {
        return String.format("Automóvel de marca %s e modelo %s.", marca, modelo);
    }

    /**
     * Devolve o valor final de venda do automóvel, com a taxa fixa da
     * plataforma incluída.
     *
     * @return o valor de venda do automóvel
     */
    @Override
    public float calcularValorVenda() {
        return this.valorVenda * (1 + TAXA_VENDA);
    }

    /**
     * Devolve o valor final de aluguer do automóvel, com a taxa fixa da
     * plataforma incluída.
     *
     * @return o valor de aluguer do automóvel
     */
    @Override
    public float calcularValorAluguer() {
        return this.valorAluguer * (1 + TAXA_ALUGUER);
    }

}
