/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

/**
 *
 * @author bdian
 */
public class MainCredito {

    public static void main(String[] args) {
        CreditoHabitacao c1 = new CreditoHabitacao("Chico", "Viciado em Desporto", 120000, 240, 1);
        System.out.println(c1.calcularMontanteAReceberPorCadaCredito());
        System.out.println(c1.calcularMontanteTotalJuros());
       
    }
}
