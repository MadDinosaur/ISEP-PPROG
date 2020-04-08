package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Classe que representa um apartamento disponível para alugar, na plataforma
 * online Olxyz
 */
public class Apartamento {

    private Endereco endereco;
    private float area;
    private float valorAluguer;

    /**
     * Construtor da classe Apartamento, que contrói uma instância recebendo os
     * seguintes parâmetros:
     *
     * @param endereco uma instância da classe Endereço com a morada do
     * apartamento
     * @param area a área do apartamento em metros quadrados
     * @param valorAluguer o valor de aluguer do apartamento
     */
    public Apartamento(Endereco endereco, float area, float valorAluguer) {
        this.endereco = endereco;
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    /**
     * Construtor da classe Apartamento, que contrói uma instância recebendo os
     * seguintes parâmetros:
     *
     * @param rua a rua do endereço do apartamento
     * @param codigoPostal o código postal do endereço do apartamento
     * @param localidade a localidade do endereço do apartamento
     * @param area a área do apartamento em metros quadrados
     * @param valorAluguer o valor de aluguer do apartamento
     */
    public Apartamento(String rua, String codigoPostal, String localidade, float area, float valorAluguer) {
        this.endereco = new Endereco(rua, codigoPostal, localidade);
        this.area = area;
        this.valorAluguer = valorAluguer;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * @return the valorAluguer
     */
    public float getValorAluguer() {
        return valorAluguer;
    }

    /**
     * @param valorAluguer the valorAluguer to set
     */
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

}
