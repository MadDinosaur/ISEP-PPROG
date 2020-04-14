package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Interface que define a taxa de venda e um método de cálculo do valor de venda
 * com taxas incluídas, a ser implementada nas classes de produtos vendáveis.
 */
public interface Vendavel {

    static float TAXA_VENDA = 0.03f;

    /**
     * Calcula o valor final do venda do produto, com as taxas fixas da
     * plataforma incluídas.
     *
     * @return o valor de venda
     */
    float calcularValorVenda();

    /**
     * Devolve o valor de venda pretendido do produto.
     *
     * @return o valor de venda pretendido
     */
    float getValorVenda();

    /**
     * Modifica o valor de venda pretendido do produto.
     *
     * @param valorVenda valor de venda pretendido
     */
    void setValorVenda(float valorVenda);
}
