/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.dm_tp1_1181626_1191507;

import java.util.ArrayList;

/**
 *
 * @author bdian
 */
public class MainCredito {

    public static void main(String[] args) {
        CreditoHabitacao habitacao1 = new CreditoHabitacao("Francisco", "Atleta", 120000, 240, 1);
        CreditoHabitacao habitacao2 = new CreditoHabitacao("Bárbara", "Engenheira Informática", 118000, 200, 1);
        CreditoAutomovel automovel1 = new CreditoAutomovel ("Pedro", "Arquiteto", 70000, 100, 0);
        CreditoAutomovel automovel2 = new CreditoAutomovel ("António", "Chefe de cozinha", 10000, 90, 1);
        CreditoEducacao educacao1 = new CreditoEducacao("Bruno", "Gestor", 1000, 4, 2);
        CreditoEducacao educacao2 = new CreditoEducacao("Juliana", "Polícia", 5000, 10, 6);
        
        ArrayList<CreditoBancario> list = new ArrayList();
        list.add(habitacao1);
        list.add(habitacao2);
        list.add(automovel1);
        list.add(automovel2);
        list.add(educacao1);
        list.add(educacao2);
        
        
        for(int i = 0; i < list.size(); i++){
            System.out.printf("Cliente %s irá pagar à instituição bancária %.2f%%.%n", list.get(i).getNome(), list.get(i).calcularMontanteAReceberPorCadaCredito());
        }
        
        System.out.printf("Instâncias crédito de habitação = %d%n",habitacao1.getInstancias());
        System.out.printf("Instâncias crédito automóvel = %d%n", automovel1.getInstancias());
        System.out.printf("Instâncias crédito educação = %d%n", educacao1.getInstancias());
        
        float totalValorReceber = 0;
        for(int i = 0; i < list.size(); i++){
           totalValorReceber = totalValorReceber + list.get(i).calcularMontanteAReceberPorCadaCredito();
        }
        System.out.printf("Juros a receber pela instituíção bancária = %.2fEUR%n", totalValorReceber);
        

    }
}
