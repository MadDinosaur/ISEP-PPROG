
package com.mycompany.dm_tp2_1181626_1191507;

import java.util.ArrayList;


public class Olxyz {
    
    public static void main (String[] args) {
        Anunciante[] anunciantes = new Anunciante[5];
        //----------------------Criação do Anunciante a1-------------------------------
        Anunciante a1 = new Anunciante ("Ana", "Rua Amora", "1111-111", "Amarante");
        
        Telemovel tel1 = new Telemovel("Motorola", 60);
        Apartamento apart1 = new Apartamento("Rua Andorinha", "1111-111", "Amarante", 140, 2300);
        Automovel aut1 = new Automovel("Nissan", "Micra", 3000, 500);
        
        a1.addListVendavel(tel1);
        a1.addListAlugavel(apart1);
        a1.addListAlugavel(aut1);
        //----------------------Criação do Anunciante a2-------------------------------
        Endereco endereco = new Endereco("Rua Bernadim", "2222-222", "Bragança");
        Anunciante a2 = new Anunciante ("Bárbara", endereco);
        
        a2.addListVendavel(new Automovel("Citroen", "C4", 10000, 1000));
        a2.addListVendavel(new Telemovel("iPhone", 800));
        a2.addListAlugavel(new Apartamento(endereco, 145, 700));
        //----------------------Criação do Anunciante a3-------------------------------
        Anunciante a3 = new Anunciante();
        
        a3.addListAlugavel(new Apartamento("Rua Croácia", "3333-333", "Carcavelos",400, 760));
        a3.addListAlugavel(new Apartamento ("Rua Carnaval", "4444-444", "Cascais", 550, 890));
        //----------------------Inserção dos anunciantes no array----------------------
        anunciantes[0] = a1;
        anunciantes[1] = a2;
        anunciantes[2] = a3;
        //---------------Visualização da quantidade de artigos para aluguer------------
        int totalAlugaveis = 0;
        for (Anunciante a: anunciantes){
            totalAlugaveis += a.getNObjetosAlugaveis();
        }
        System.out.printf("Quantidade de artigos disponíveis para aluguer na plataforma Olxyz: %d%n", totalAlugaveis);
        //---------------Visualização dos Anunciantes que publicitam vendas-------------
        for (Anunciante a: anunciantes){
            if(a.getNObjetosVendaveis()!=0){
                System.out.printf("%s. Somatório de possíveis vendas: %.2f€.%n", a, a.getTotalValorVendas());
            }
        }
        //---------------Visualização dos alugáveis que podem gerar mais lucro----------
        for (Anunciante a: anunciantes) {
            if (a.getNObjetosAlugaveis()!= 0) {
                System.out.printf("Anunciante: %s, Alugável: %s, Lucro: %.2f€%n.",a.getNome(),a.getAlugavelMaisCaro(),a.calcularValorAluguer(a.getAlugavelMaisCaro())/(1+Anunciante.TAXA_ALUGAVEL));
            }
        }
    }
}
