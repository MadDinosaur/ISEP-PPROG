/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

/**
 *
 * @author Francisco
 */
public class CreditoEducacao extends CreditoBancario {
    
    private static float taxaJuro = (float) 0.02;
    
    private int periodoCarencia;
    
    private final int PERIODOCARENCIA_POR_OMISSAO = 0;
    
    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, a profissão 
     * , o montante, os meses de financiamento, a taxa de juro e o periodo de carencia. 
     * 
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do cliente
     * @param mesesFinanciamento os meses de financiamento do cliente
     * @param taxaJuro a taxa de juro do cliente
     * @param periodoCarencia o periodo de carencia do cliente
     * 
     */
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, float taxaJuro, int periodoCarencia){
        super(nome, profissao, montante, mesesFinanciamento);
        this.taxaJuro = taxaJuro;
        this.periodoCarencia = periodoCarencia;
    }
    
    /**
     * Constrói uma instância de CreditoEducacao recebendo o nome, a profissão 
     * , o montante, os meses de financiamento, o periodo de carencia. 
     * 
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do cliente
     * @param mesesFinanciamento os meses de financiamento do cliente
     * @param periodoCarencia o periodo de carencia do cliente
     * 
     */
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, int periodoCarencia){
        super(nome, profissao, montante, mesesFinanciamento);
        this.periodoCarencia = periodoCarencia;
    }
    
    /**
     * Constrói uma instância de CreditoEducacao recebendo por omissão o periodo de carência. 
     */
    public CreditoEducacao(){
        super();
        this.periodoCarencia = PERIODOCARENCIA_POR_OMISSAO;
    }

    /**
     * @return the taxaJuro
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
     * @param aTaxaJuro the taxaJuro to set
     */
    public static void setTaxaJuro(float aTaxaJuro) {
        taxaJuro = aTaxaJuro;
    }

    /**
     * Modifica o período de carência.
     *
     * @param profissao a nova profissão do cliente
     * 
     */
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }


    /**
     * Devolve o montante total de juros.
     *
     * @return montanteTotalJuros do crédito educação
     */
    @Override
    public float calcularMontanteTotalJuros() {
        float juros = 0;
        float capital = super.getMontante();
        float amortizacao = capital / (super.getMesesFinanciamento() - periodoCarencia);
        juros += taxaJuro * capital * periodoCarencia;
        for (int i = 0; i < super.getMesesFinanciamento() - periodoCarencia; i++) {
            juros += taxaJuro * capital;
            capital -= amortizacao;
        }
        return juros;
    }
    
    public String toString(){
        return String.format("Crédito Educação com taxa de Juro %f, com um período de Carência de %s", taxaJuro, periodoCarencia);
    }
    
    
}
