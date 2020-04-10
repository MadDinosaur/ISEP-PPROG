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
        this.endereco = new Endereco(endereco);
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
     * Devolve o endereço do apartamento.
     *
     * @return o endereço
     */
    public Endereco getEndereco() {
        return new Endereco(endereco);
    }

    /**
     * Modifica o endereço do apartamento
     *
     * @param endereco o novo endereço
     */
    public void setEndereco(Endereco endereco) {
        this.endereco.setRua(endereco.getRua());
        this.endereco.setCodigoPostal(endereco.getCodigoPostal());
        this.endereco.setLocalidade(endereco.getLocalidade());
    }

    /**
     * Devolve a área do apartamento, em m2
     *
     * @return a área
     */
    public float getArea() {
        return area;
    }

    /**
     * Modifica a área do apartamento, em m2
     *
     * @param area a nova área
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Devolve o valor de aluguer do apartamento.
     *
     * @return o valor de aluguer
     */
    public float getValorAluguer() {
        return valorAluguer;
    }

    /**
     * Modifica o valor de aluguer do apartamento.
     *
     * @param valorAluguer valor de aluguer
     */
    public void setValorAluguer(float valorAluguer) {
        this.valorAluguer = valorAluguer;
    }

}
