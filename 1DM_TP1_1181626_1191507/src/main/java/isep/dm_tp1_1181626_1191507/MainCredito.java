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
        CreditoEducacao c2 = new CreditoEducacao("Babuska", "Engenheira", 18000, 60, 24);
        // System.out.println(c1.toString());
        System.out.println("Credito Habitacao");
        System.out.println(c1.calcularMontanteAReceberPorCadaCredito());
        System.out.println(c1.calcularMontanteTotalJuros());

        System.out.println("Credito Educação");
        System.out.println(c2);
        System.out.println(c2.calcularMontanteAReceberPorCadaCredito());
        System.out.println(c2.calcularMontanteTotalJuros());

    }
}
