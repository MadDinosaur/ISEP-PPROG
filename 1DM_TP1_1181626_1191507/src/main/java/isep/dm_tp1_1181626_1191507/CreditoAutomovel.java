/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

public class CreditoAutomovel extends CreditoBancario {

    private static float taxaJuro = 6f;
    private float desconto = 1f;
    private static int periodoDesconto = 24;

    /**
     * @return the taxaJuro
     */
    public static float getTaxaJuro() {
        return taxaJuro;
    }

    /**
     * @param aTaxaJuro the taxaJuro to set
     */
    public static void setTaxaJuro(float aTaxaJuro) {
        taxaJuro = aTaxaJuro;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the periodoDesconto
     */
    public static int getPeriodoDesconto() {
        return periodoDesconto;
    }

    /**
     * @param aPeriodoDesconto the periodoDesconto to set
     */
    public static void setPeriodoDesconto(int aPeriodoDesconto) {
        periodoDesconto = aPeriodoDesconto;
    }

    /**
     * Inicializa um objeto de CreditoAutomovel com os valores predefinidos de
     * taxa de juro e desconto
     */
    public CreditoAutomovel() {
        super();
    }

    /**
     * Inicializa um objeto de CreditoAutomovel com os valores pretendidos de
     * desconto
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do cliente
     * @param mesesFinanciamento os meses de financiamento do cliente
     * @param desconto desconto mensal para créditos com prazo inferior ou
     * igual a 24 meses
     */
    public CreditoAutomovel(String nome, String profissao, float montante, int mesesFinanciamento, float desconto) {
        super(nome, profissao, montante, mesesFinanciamento);
        this.desconto = desconto;
    }

    /**
     * Inicializa um objeto de CreditoAutomovel com os valores pretendidos de
     * taxa de juro e desconto
     *
     * @param taxaJuro: taxa de juro dos créditos automóveis
     * @param desconto: desconto mensal para créditos com prazo inferior ou
     * igual a 24 meses
     */
    public CreditoAutomovel(float taxaJuro, float desconto) {
        CreditoAutomovel.taxaJuro = taxaJuro;
        this.desconto = desconto;
    }


    /**
     * Calcula o montante total de juros a ser pagos à instituição bancária ao
     * longo do prazo do crédito
     *
     * @return montante acumulado de juros recebidos no final do prazo do
     * crédito
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float juros = 0;
        boolean aplicarDesconto = super.getMesesFinanciamento() <= periodoDesconto;

        float capital = super.getMontante();
        float amortizacao = getCapitalAmortizadoMensal();

        for (int i = 0; i < super.getMesesFinanciamento(); i++) {
            if (aplicarDesconto) {
                juros += (taxaJuro * capital) * (1 - desconto);
            } else {
                juros += taxaJuro * capital;
            }
            capital -= amortizacao;
        }
        return juros;
    }

    /**
     * Devolve a descrição textual de um crédito à habitação
     *
     * @return as características do crédito à habitação
     */
    @Override
    public String toString() {
        return String.format("Crédito Automóvel contratado à taxa de %.2f%%n." + taxaJuro);
    }
}
