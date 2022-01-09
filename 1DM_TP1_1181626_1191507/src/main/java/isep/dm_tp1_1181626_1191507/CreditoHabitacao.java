package isep.dm_tp1_1181626_1191507;

/**
 * Classe que simula um crédito à habitação e calcula os montantes a receber
 * pela instituição bancária (em juros e capital)
 */
public class CreditoHabitacao extends CreditoBancario {

    private float spread;
    private static float taxaEuribor = 0.1f;

    private final float SPREAD_POR_OMISSAO = 0f;
    
    private static int contadorInstancias = 0;

    /**
     * Constrói uma instância de CreditoHabitacao recebendo o spread
     * por omissão
     */
    public CreditoHabitacao() {
        super();
        this.spread = SPREAD_POR_OMISSAO;
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoHabitacao recebendo o nome, a profissão ,
     * o montante, os meses de financiamento e o spread.
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do crédito
     * @param mesesFinanciamento os meses de financiamento do crédito
     * @param spread: taxa de spread, em percentagem
     */
    public CreditoHabitacao(String nome, String profissao, float montante, int mesesFinanciamento, float spread) {
        super(nome, profissao, montante, mesesFinanciamento);
        this.spread = spread;
        contadorInstancias++;
    }
    
    /**
     * Devolve o número de instâncias CreditoHabitacao criadas.
     *
     * @return número de instâncias
     */
    public int getInstancias(){
        return contadorInstancias;
    }

    /**
     * Devolve a taxa de spread.
     * @return o spread
     */
    public float getSpread() {
        return spread;
    }

    /**
     * Modifica a taxa de spread.
     * @param spread a taxa de spread, em percentagem.
     */
    public void setSpread(float spread) {
        this.spread = spread;
    }

    /**
     * Devolve a taxa Euribor.
     * @return a taxaEuribor
     */
    public static float getTaxaEuribor() {
        return taxaEuribor;
    }

    /**
     * Modifica a taxa Euribor.
     * @param aTaxaEuribor a taxa Euribor, em percentagem.
     */
    public static void setTaxaEuribor(float aTaxaEuribor) {
        taxaEuribor = aTaxaEuribor;
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
        float taxaJuro = (this.spread / MESES_POR_ANO + CreditoHabitacao.taxaEuribor / MESES_POR_ANO) / 100;

        for (int i = 0; i < getMesesFinanciamento(); i++) {
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
