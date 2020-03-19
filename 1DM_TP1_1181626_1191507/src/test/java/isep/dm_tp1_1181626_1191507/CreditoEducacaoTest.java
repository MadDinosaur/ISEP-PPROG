/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

import org.junit.Test;

public class CreditoEducacaoTest {

    
    private final int PERIODO_CARENCIA = 24;
    private final float CAPITAL = 18000f;
    private final float TAXA_JURO_POR_OMISSAO = 2f;
    private final float TAXA_JURO = 3f;
    private final int PRAZO = 60;
    private final float TOTAL_JUROS = 1275f;
    private final float TOTAL_A_RECEBER = 19275f;

    CreditoEducacao completeInstance = new CreditoEducacao("NNNNN", "PPPPP", CAPITAL, PRAZO, PERIODO_CARENCIA);
    CreditoEducacao emptyInstance = new CreditoEducacao();

    /**
     * Test of getTaxaJuro method, of class CreditoEducacao.
     */
    @Test
    public void testGetTaxaJuro() {
        System.out.println("getTaxaJuro");
        float expResult = TAXA_JURO_POR_OMISSAO;
        float result = CreditoEducacao.getTaxaJuro();
        assert (expResult == result);
    }

    /**
     * Test of getPeriodoCarencia method, of class CreditoEducacao.
     */
    @Test
    public void testGetPeriodoCarencia() {
        System.out.println("getPeriodoCarencia");
        int expResult = PERIODO_CARENCIA;
        int result = completeInstance.getPeriodoCarencia();
        assert(expResult == result);
    }
    
    /**
     * Test of getPeriodoCarencia method, of class CreditoEducacao, with empty constructor.
     */
    @Test
    public void testGetPeriodoCarenciaEmpty() {
        System.out.println("getPeriodoCarencia");
        int expResult = 0;
        int result = emptyInstance.getPeriodoCarencia();
        assert(expResult == result);
    }

    /**
     * Test of setTaxaJuro method, of class CreditoEducacao.
     */
    @Test
    public void testSetTaxaJuro() {
        System.out.println("setTaxaJuro");
        float aTaxaJuro = TAXA_JURO;
        CreditoEducacao.setTaxaJuro(aTaxaJuro);
        float expResult = aTaxaJuro;
        float result = CreditoEducacao.getTaxaJuro();
        assert(expResult == result);
        //revert to original
        CreditoEducacao.setTaxaJuro(TAXA_JURO_POR_OMISSAO);
    }

    /**
     * Test of setPeriodoCarencia method, of class CreditoEducacao.
     */
    @Test
    public void testSetPeriodoCarencia() {
        System.out.println("setPeriodoCarencia");
        int periodoCarencia = 1;
        completeInstance.setPeriodoCarencia(periodoCarencia);
        int expResult = periodoCarencia;
        int result = completeInstance.getPeriodoCarencia();
        assert (expResult == result);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoEducacao.
     */
    @Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        float expResult = TOTAL_JUROS;
        float result = completeInstance.calcularMontanteTotalJuros();
        assert(expResult == result);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoEducacao, with empty constructor.
     */
    @Test
    public void testCalcularMontanteTotalJurosEmpty() {
        System.out.println("calcularMontanteTotalJurosEmpty");
        float expResult = 0;
        float result = emptyInstance.calcularMontanteTotalJuros();
        assert(expResult == result);
    }
    
   /**
     * Test of getCapitalAmortizadoMensal method, of class CreditoEducacao.
     */
    @org.junit.Test
    public void testGetCapitalAmortizadoMensal() {
        System.out.println("getCapitalAmortizadoMensal");
        float expResult = CAPITAL/PRAZO;
        float result = completeInstance.getCapitalAmortizadoMensal();
        assert(expResult == result);
    }
    
     /**
     * Test of getCapitalAmortizadoMensal method, of class CreditoEducacao, with empty constructor.
     */
    @org.junit.Test
    public void testGetCapitalAmortizadoMensalEmpty() {
        System.out.println("getCapitalAmortizadoMensalEmpty");
        float expResult = 0;
        float result = emptyInstance.getCapitalAmortizadoMensal();
        assert(expResult == result);
    }
    
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoEducacao.
     */
    @org.junit.Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        float expResult = TOTAL_A_RECEBER;
        float result = completeInstance.calcularMontanteAReceberPorCadaCredito();
        assert(expResult == result);
    }
    
    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class CreditoEducacao, with empty constructor.
     */
    @org.junit.Test
    public void testCalcularMontanteAReceberPorCadaCreditoEmpty() {
        System.out.println("calcularMontanteAReceberPorCadaCreditoEmpty");
        float expResult = 0;
        float result = emptyInstance.calcularMontanteAReceberPorCadaCredito();
        assert(expResult == result);
    }
}
