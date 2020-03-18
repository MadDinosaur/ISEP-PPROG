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
        this.spread = SPREAD_POR_OMISSAO;
    }
    /**
     * Inicializa um objeto de CreditoHabitacao com o spread indicado como parâmetro
     * @param spread: taxa de spread, em percentagem
     */
    public CreditoHabitacao(float spread) {
        this.spread = spread;
    }

    /**
     * Obtém o montante de capital a amortizar a cada mês tendo em conta o prazo e o montante do crédito
     * @return capital amortizado mensal
     */
    public float getCapitalAmortizadoMensal() {
        return super.getMontante() / super.getMesesFinanciamento();
    }


    /**
     * Calcula o montante total de juros a ser pagos à instituição bancária ao longo do prazo do crédito
     * @return montante acumulado de juros recebidos no final do prazo do crédito
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float juros = 0;
        float capital = super.getMontante();
        float amortizacao = getCapitalAmortizadoMensal();
        float taxaJuro = (this.spread/12 + CreditoHabitacao.taxaEuribor) / 100;

        for (int i = 0; i < super.getMesesFinanciamento(); i++) {
            juros += taxaJuro * capital;
            capital -= amortizacao;
        }
        return juros;
    }
    
    /**
     * Devolve a descrição textual de um crédito à habitação
     * @return as características do crédito à habitação
     */
    @Override
    public String toString() {
        return String.format("Crédito Habitação contratado à taxa de %.2f%%n." + this.spread + this.taxaEuribor);
    }
}
