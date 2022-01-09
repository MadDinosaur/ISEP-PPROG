
package isep.dm_tp1_1181626_1191507;

/**
 * Classe que simula um crédito à educação e calcula os montantes a receber
 * pela instituição bancária (em juros e capital)
 */
public class CreditoEducacao extends CreditoBancario {

    private static float taxaJuro = 2f;

    private int periodoCarencia;

    private final int PERIODOCARENCIA_POR_OMISSAO = 0;
    
    private static int contadorInstancias = 0;

    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, a profissão ,
     * o montante, os meses de financiamento, a taxa de juro e o periodo de
     * carencia.
     *
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do crédito
     * @param mesesFinanciamento os meses de financiamento do crédito
     * @param taxaJuro a taxa de juro do crédito
     * @param periodoCarencia o periodo de carencia do crédito
     *
     */
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, float taxaJuro, int periodoCarencia) {
        super(nome, profissao, montante, mesesFinanciamento);
        CreditoEducacao.taxaJuro = taxaJuro;
        this.periodoCarencia = periodoCarencia;
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, a profissão ,
     * o montante, os meses de financiamento, o periodo de carencia.
     *
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do crédito
     * @param mesesFinanciamento os meses de financiamento do crédito
     * @param periodoCarencia o periodo de carencia do crédito
     *
     */
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, int periodoCarencia) {
        super(nome, profissao, montante, mesesFinanciamento);
        this.periodoCarencia = periodoCarencia;
        contadorInstancias++;
    }

    /**
     * Constrói uma instância de CreditoEducacao recebendo o periodo
     * de carência por omissão.
     */
    public CreditoEducacao() {
        super();
        this.periodoCarencia = PERIODOCARENCIA_POR_OMISSAO;
        contadorInstancias++;
    }
    
    /**
     * Devolve o número de instâncias CreditoEducacao criadas.
     *
     * @return número de instâncias
     */
    public int getInstancias(){
        return contadorInstancias;
    }

    /**
     * Devolve a taxa de juro.
     * @return a taxaJuro
     */
    public static float getTaxaJuro() {
        return taxaJuro;
    }

    /**
     * Devolve o período de carência.
     *
     * @return período de carência
     */
    public int getPeriodoCarencia() {
        return periodoCarencia;
    }

    /**
     * Modifica a taxa de juro.
     * @param aTaxaJuro a taxa de juro em percentagem
     */
    public static void setTaxaJuro(float aTaxaJuro) {
        taxaJuro = aTaxaJuro;
    }

    /**
     * Modifica o período de carência.
     *
     * @param periodoCarencia o nº de meses do período de carência
     *
     */
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
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
       
        float amortizacao;
        if (getMesesFinanciamento() - periodoCarencia <= 0)
            amortizacao = 0;
        else
            amortizacao = capital / (getMesesFinanciamento() - periodoCarencia);
        
        juros += taxaJuro/100 / MESES_POR_ANO * capital * periodoCarencia;
        for (int i = 0; i < getMesesFinanciamento() - periodoCarencia; i++) {
            juros += taxaJuro/100 / MESES_POR_ANO * capital;
            capital -= amortizacao;
        }
        return juros;
    }
    
    /**
     * Devolve a descrição textual de um crédito à educação
     *
     * @return as características do crédito à educação
     */
    @Override
    public String toString() {
        return String.format(super.toString() + " de tipo Educação com taxa de juro %.2f%% e período de carência de %d meses.", taxaJuro, periodoCarencia);
    }

}
