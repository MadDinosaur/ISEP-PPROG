/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

/**
 * Classe que simula um crédito à automóvel e calcula os montantes a receber
 * pela instituição bancária (em juros e capital)
 */
public class CreditoAutomovel extends CreditoBancario {

    private static float taxaJuro = 6f;
    private float desconto = 1f;
    private static int periodoDesconto = 24;
    private boolean aplicarDesconto = getMesesFinanciamento() <= periodoDesconto;
    private static int contadorInstancias = 0;

    /**
     * Constrói uma instância de CreditoAutomovel sem receber parâmetros.
     */
    public CreditoAutomovel() {
        super();
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoAutomovel recebendo o nome, a profissão
     * , o montante, os meses de financiamento e desconto.
     *
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do crédito
     * @param mesesFinanciamento os meses de financiamento do crédito
     * @param desconto desconto mensal para créditos com prazo inferior ou igual
     * ao estipulado
     */
    public CreditoAutomovel(String nome, String profissao, float montante, int mesesFinanciamento, float desconto) {
        super(nome, profissao, montante, mesesFinanciamento);
        this.desconto = desconto;
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoAutomovel recebendo o nome, a profissão
     * , o montante e os meses de financiamento.
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do crédito
     * @param mesesFinanciamento os meses de financiamento do crédito
     */
    public CreditoAutomovel(String nome, String profissao, float montante, int mesesFinanciamento) {
        super(nome, profissao, montante, mesesFinanciamento);
        contadorInstancias++;
    }

    /**
     * Devolve o número de instâncias CreditoEducacao criadas.
     *
     * @return número de instâncias
     */
    public int getInstancias() {
        return contadorInstancias;
    }

    /**
     * Devolve a taxa de juro.
     *
     * @return a taxaJuro
     */
    public static float getTaxaJuro() {
        return taxaJuro;
    }

    /**
     * Modifica a taxa de juro.
     *
     * @param aTaxaJuro a taxa de juro, em percentagem.
     */
    public static void setTaxaJuro(float aTaxaJuro) {
        taxaJuro = aTaxaJuro;
    }

    /**
     * Devolve o desconto.
     *
     * @return o desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * Modifica o desconto.
     *
     * @param desconto desconto mensal para créditos com prazo inferior ou igual
     * ao estipulado
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * Devolve o periodo de desconto - o nº de meses limite que um crédito pode
     * ter para que seja aplicado o desconto.
     *
     * @return o periodoDesconto
     */
    public static int getPeriodoDesconto() {
        return periodoDesconto;
    }

    /**
     * Modifica o periodo de desconto.
     *
     * @param aPeriodoDesconto o nº de meses limite que um crédito pode ter para
     * que seja aplicado o desconto.
     */
    public static void setPeriodoDesconto(int aPeriodoDesconto) {
        periodoDesconto = aPeriodoDesconto;
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
        float capital = getMontante();
        float amortizacao = getCapitalAmortizadoMensal();

        for (int i = 0; i < getMesesFinanciamento(); i++) {
            juros += taxaJuro / 100 / MESES_POR_ANO * capital;
            capital -= amortizacao;
        }
        return juros;
    }

    /**
     * Devolve o montante a receber pela instituição bancária por um dado
     * crédito.
     *
     * @return montantePorCredito do crédito automóvel
     */
    @Override
    public float calcularMontanteAReceberPorCadaCredito() {

        if (aplicarDesconto) {
            return (getMontante() + calcularMontanteTotalJuros()) * (1 - desconto / 100);
        } else {
            return getMontante() + calcularMontanteTotalJuros();
        }
    }

    /**
     * Devolve a descrição textual de um crédito automóvel
     *
     * @return as características do crédito automóvel
     */
    @Override
    public String toString() {
        if (aplicarDesconto) {
            return String.format(super.toString() + " de tipo Automóvel e com taxa de juro %.2f%% e desconto de %.2f%%.%n", taxaJuro, desconto);
        } else {
            return String.format(super.toString() + " de tipo Automóvel e com taxa de juro %.2f%%.", taxaJuro);
        }
    }
}
