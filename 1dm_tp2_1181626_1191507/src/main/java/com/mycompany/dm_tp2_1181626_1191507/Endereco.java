package com.mycompany.dm_tp2_1181626_1191507;

/**
 * Classe Endereço que representa um endereço físico, contendo uma dada rua,
 * código postal e localidade.
 */
public class Endereco {

    private String rua;
    private String codigoPostal;
    private String localidade;

    private final String RUA_POR_OMISSAO = "Rua desconhecida";
    private final String CODIGO_POSTAL_POR_OMISSAO = "Código postal desconhecido";
    private final String LOCALIDADE_POR_OMISSAO = "Localidade desconhecida";

    /**
     * Construtor vazio da classe Endereço, que constrói uma instância com os
     * valores por omissão.
     */
    public Endereco() {
        this.rua = RUA_POR_OMISSAO;
        this.codigoPostal = CODIGO_POSTAL_POR_OMISSAO;
        this.localidade = LOCALIDADE_POR_OMISSAO;
    }

    /**
     * Construtor da classe Endereço, que contrói uma instância recebendo os
     * seguintes parâmetros:
     *
     * @param rua a rua do endereço
     * @param codigoPostal o código postal do endereço
     * @param localidade a localidade do endereço
     */
    public Endereco(String rua, String codigoPostal, String localidade) {
        this.rua = rua;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
    }

    /**
     * Construtor da classe Endereço, que constrói uma instância recebendo os
     * seguintes parâmetros:
     *
     * @param endereco uma instância da classe Endereço
     */
    public Endereco(Endereco endereco) {
        this.rua = endereco.rua;
        this.codigoPostal = endereco.codigoPostal;
        this.localidade = endereco.localidade;
    }

    /**
     * Devolve a rua do endereço.
     *
     * @return a rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Modifica a rua do endereço.
     *
     * @param rua a nova rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Devolve o código postal do endereço.
     *
     * @return o código postal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Modifica o código postal do endereço.
     *
     * @param codigoPostal o novo código postal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Devolve a localidade do endereço.
     *
     * @return a localidade
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Modifica a localidade do endereço.
     *
     * @param localidade a nova localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Descrição textual de um endereço.
     * @return uma String com a rua, código postal e localidade
     */
    @Override
    public String toString() {
        return rua + ", " + codigoPostal + ", " + localidade;
    }
}
