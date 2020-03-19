package isep.dm_tp1_1181626_1191507;

/**
 * Classe que simula um crédito à habitação e calcula os montantes a receber
 * pela instituição bancária (em juros e capital)
 */

public class CreditoHabitacao extends CreditoBancario {

    private float spread;
    private static float taxaEuribor = 0.1f;

    private final float SPREAD_POR_OMISSAO = 0f;

    /**
     * @return the spread
     */
    public float getSpread() {
        return spread;
    }

    /**
     * @param spread the spread to set
     */
    public void setSpread(float spread) {
        this.spread = spread;
    }

    /**
     * @return the taxaEuribor
     */
    public static float getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * @param aTaxaEuribor the taxaEuribor to set
     */
    public static void setTaxaEuribor(float aTaxaEuribor) {
        taxaEuribor = aTaxaEuribor;
    }

    /**
     * Inicializa um objeto de CreditoHabitacao com spread = 0
     */
    public CreditoHabitacao() {
        super();
        this.spread = SPREAD_POR_OMISSAO;
    }

    /**
     * Inicializa um objeto de CreditoHabitacao com o spread indicado como
     * parâmetro
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do cliente
     * @param mesesFinanciamento os meses de financiamento do cliente
     * @param spread: taxa de spread, em percentagem
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int mesesFinanciamento, float spread) {
        super(nome, profissao, montante, mesesFinanciamento);
        this.spread = spread;
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
        float capital = super.getMontante();
        float amortizacao = getCapitalAmortizadoMensal();
        float taxaJuro = (this.spread / MESES_POR_ANO + CreditoHabitacao.taxaEuribor / MESES_POR_ANO) / 100;

        for (int i = 0; i < super.getMesesFinanciamento(); i++) {
            juros += taxaJuro * capital;
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
        return String.format(super.toString() + " do tipo Habitação, com taxa Euribor %.2f%% + spread de %.2f%%.", taxaEuribor, spread);
    }
}
