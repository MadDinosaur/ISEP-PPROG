/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dm_tp2_1181626_1191507;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de testes unitários para os métodos da classe Anunciante.
 */
public class AnuncianteTest {

    Anunciante a = new Anunciante();

    Apartamento apart1 = new Apartamento(new Endereco(), 145, 700);
    Apartamento apart2 = new Apartamento("Rua Andorinha", "1111-111", "Amarante", 140, 2300);
    Automovel aut1 = new Automovel("Citroen", "C4", 10000, 1000);
    Automovel aut2 = new Automovel("Nissan", "Micra", 3000, 500);
    Telemovel tel1 = new Telemovel("iPhone", 800);
    
    public void declareVariables(){
    a.addListVendavel(aut1);
    a.addListVendavel(tel1);
    
    a.addListAlugavel(apart1);
    a.addListAlugavel(apart2);
    a.addListAlugavel(aut2);
    }

    /**
     * Test of getAlugavelMaisCaro method, of class Anunciante.
     */
    @Test
    public void testGetAlugavelMaisCaro() {
        System.out.println("getAlugavelMaisCaro");
        declareVariables();
        Alugavel expResult = apart2;
        Alugavel result = a.getAlugavelMaisCaro();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalValorVendas method, of class Anunciante.
     */
    @Test
    public void testGetTotalValorVendas() {
        System.out.println("getTotalValorVendas");
        declareVariables();
        float expResult = 11124f;
        float result = a.getTotalValorVendas();
        assertEquals(expResult, result, 0.0);
    }

}
