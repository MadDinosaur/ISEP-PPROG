package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Interface que define a taxa de aluguer e um método de cálculo do valor de
 * aluguer com taxas incluídas, a ser implementada nas classes de produtos
 * alugáveis.
 */
public interface Alugavel {

    static float TAXA_ALUGUER = 0.05f;

    /**
     * Calcula o valor final do aluguer do produto, com as taxas fixas da
     * plataforma incluídas.
     *
     * @return o valor de aluguer
     */
    float calcularValorAluguer();
    
    /**
     * Devolve o valor de aluguer pretendido do produto.
     *
     * @return o valor de aluguer pretendido
     */
    float getValorAluguer();
    
     /**
     * Modifica o valor de aluguer pretendido do produto.
     *
     * @param valorAluguer valor de aluguer pretendido
     */
    void setValorAluguer(float valorAluguer);
}
