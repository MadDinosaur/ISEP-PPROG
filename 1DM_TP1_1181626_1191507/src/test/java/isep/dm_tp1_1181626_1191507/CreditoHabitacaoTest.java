/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

public class CreditoHabitacaoTest {

    private final float SPREAD_POR_OMISSAO = 0f;
    private final float CAPITAL = 120000f;
    private final float SPREAD = 2f;
    private final int PRAZO = 240;
    private final float TOTAL_JUROS = 25305f;
    private final float TOTAL_A_RECEBER = 145305f;

    CreditoHabitacao completeInstance = new CreditoHabitacao("NNNNN", "PPPPP", CAPITAL, PRAZO, SPREAD);
    CreditoHabitacao emptyInstance = new CreditoHabitacao();

    /**
     * Test of getSpread method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testGetSpread() {
        System.out.println("getSpread");
        float expResult = SPREAD;
        float result = completeInstance.getSpread();
        assert (expResult == result);
    }

    /**
     * Test of getSpread method, of class CreditoHabitacao, with empty
     * constructor
     */
    @org.junit.Test
    public void testGetSpreadEmpty() {
        System.out.println("getSpreadEmpty");
        float expResult = SPREAD_POR_OMISSAO;
        float result = emptyInstance.getSpread();
        assert (expResult == result);
    }

    /**
     * Test of setSpread method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testSetSpread() {
        System.out.println("setSpread");
        float spread = 3.5f;
        completeInstance.setSpread(spread);
        float expResult = spread;
        float result = completeInstance.getSpread();
        assert (expResult == result);
    }

    /**
     * Test of getTaxaEuribor method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testGetTaxaEuribor() {
        System.out.println("getTaxaEuribor");
        float expResult = 0.1f;
        float result = CreditoHabitacao.getTaxaEuribor();
        assert (expResult == result);
    }

    /**
     * Test of setTaxaEuribor method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testSetTaxaEuribor() {
        System.out.println("setTaxaEuribor");
        float aTaxaEuribor = 0.2f;
        CreditoHabitacao.setTaxaEuribor(aTaxaEuribor);
        float expResult = aTaxaEuribor;
        float result = CreditoHabitacao.getTaxaEuribor();
        assert (expResult == result);
    }

    /**
     * Test of getCapitalAmortizadoMensal method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testGetCapitalAmortizadoMensal() {
        System.out.println("getCapitalAmortizadoMensal");
        float expResult = CAPITAL / PRAZO;
        float result = completeInstance.getCapitalAmortizadoMensal();
        assert (expResult == result);
    }

    /**
     * Test of getCapitalAmortizadoMensal method, of class CreditoHabitacao,
     * with empty constructor.
     */
    @org.junit.Test
    public void testGetCapitalAmortizadoMensalEmpty() {
        System.out.println("getCapitalAmortizadoMensalEmpty");
        float expResult = 0;
        float result = emptyInstance.getCapitalAmortizadoMensal();
        assert (expResult == result);
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testCalcularMontanteTotalJuros() {
        System.out.println("calcularMontanteTotalJuros");
        float expResult = TOTAL_JUROS;
        float result = completeInstance.calcularMontanteTotalJuros();
        System.out.println(expResult);
        System.out.println(result);
        assert (Math.round(expResult) == Math.round(result));
    }

    /**
     * Test of calcularMontanteTotalJuros method, of class CreditoHabitacao.
     */
    @org.junit.Test
    public void testCalcularMontanteTotalJurosEmpty() {
        System.out.println("calcularMontanteTotalJurosEmpty");
        float expResult = 0;
        float result = emptyInstance.calcularMontanteTotalJuros();
        assert (expResult == result);
    }

    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class
     * CreditoHabitacao.
     */
    @org.junit.Test
    public void testCalcularMontanteAReceberPorCadaCredito() {
        System.out.println("calcularMontanteAReceberPorCadaCredito");
        float expResult = TOTAL_A_RECEBER;
        float result = completeInstance.calcularMontanteAReceberPorCadaCredito();
        assert (expResult == result);
    }

    /**
     * Test of calcularMontanteAReceberPorCadaCredito method, of class
     * CreditoHabitacao, with empty constructor.
     */
    @org.junit.Test
    public void testCalcularMontanteAReceberPorCadaCreditoEmpty() {
        System.out.println("calcularMontanteAReceberPorCadaCreditoEmpty");
        float expResult = 0;
        float result = emptyInstance.calcularMontanteAReceberPorCadaCredito();
        assert (expResult == result);
    }
}
