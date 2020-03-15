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
    
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, float taxaJuro, int periodoCarencia){
        super(nome, profissao, montante, mesesFinanciamento);
        this.taxaJuro = taxaJuro;
        this.periodoCarencia = periodoCarencia;
    }
    
    public CreditoEducacao(String nome, String profissao, float montante, int mesesFinanciamento, int periodoCarencia){
        super(nome, profissao, montante, mesesFinanciamento);
        this.periodoCarencia = periodoCarencia;
    }
    
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
     * @return the periodoCarencia
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
     * @param periodoCarencia the periodoCarencia to set
     */
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }

    @Override
    public float calcularMontanteAReceberPorCadaCredito() {
        return super.getMontante() + calcularMontanteTotalJuros();
    }

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
