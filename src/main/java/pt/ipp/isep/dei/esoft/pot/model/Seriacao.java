/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;





/**
 *
 * @author Francisco
 */
public class Seriacao {
    
    private Comparator comparador; 
    
    public Seriacao(String tipoSeriacao){
        switch(tipoSeriacao){
            case "Seriação 1":
                comparador = seriacao1;
                break;
            case "Seriação 2":
                comparador = seriacao2;
                break;
        }
    }
    
    //criterio 1 / 2 / 3
    
    private static Comparator<Candidatura> seriacao1 = new Comparator<Candidatura>(){
        public int compare(Candidatura c1, Candidatura c2){
            if(maiorMediaProficiencia.compare(c1, c2) == 0){
                if(precoMaisBaixo.compare(c1, c2) == 0){
                    return propostaMaisRecente.compare(c1, c2);
                } else {
                    return precoMaisBaixo.compare(c1, c2);
                }
            } else {
                return maiorMediaProficiencia.compare(c1, c2);
            }
        }
        @Override
        public String toString() {
            return "Seriação 1";
        }
    };
    
    //criterio 1 / 4 / 2 / 3
            
    private static Comparator<Candidatura> seriacao2 = new Comparator<Candidatura>(){ // FALTA ACABAR
        public int compare(Candidatura c1, Candidatura c2){
            if(maiorMediaProficiencia.compare(c1, c2) == 0){
                if(menorDesvioProficiencia.compare(c1, c2) == 0){
                    if(precoMaisBaixo.compare(c1, c2) == 0){
                        return propostaMaisRecente.compare(c1, c2);
                    } else {
                        return precoMaisBaixo.compare(c1, c2);
                    }
                } else {
                    return menorDesvioProficiencia.compare(c1, c2);
                }
            } else {
                return maiorMediaProficiencia.compare(c1, c2);
            }
        }
        public String toString() {
            return "Seriação 2";
        }
    };
            
    public Comparator getComparador(){
        return comparador;
    }
    

    
    //SERIACAO 1
    
    private static Comparator<Candidatura> maiorMediaProficiencia = new Comparator<Candidatura>() {  

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                double nivelProficiencia1 = f1.getFreelancer().getNivelProficiencia(1); //FALTA ADQUIRIR NIVEL ESPECIFICO
                double nivelProficiencia2 = f2.getFreelancer().getNivelProficiencia(1);

                if (nivelProficiencia1 < nivelProficiencia2) {
                    return -1;
                } else if (nivelProficiencia1 > nivelProficiencia2) {                               
                    return 1;                                                                            
                } else {
                    return 0;
                }
            }
    };
    
     private static Comparator<Candidatura> precoMaisBaixo = new Comparator<Candidatura>() {

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                double precoServico1 = f1.getValorPretendido();
                double precoServico2 = f2.getValorPretendido();

                if (precoServico1 > precoServico2) {
                    return -1;
                } else if (precoServico1 < precoServico2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
     private static Comparator<Candidatura> propostaMaisRecente = new Comparator<Candidatura>() {

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                Date dataRegisto1 = f1.getDataCandidatura();
                Date dataRegisto2 = f2.getDataCandidatura();

                if (dataRegisto1.compareTo(dataRegisto2) < 0) {
                    return -1;
                } else if (dataRegisto1.compareTo(dataRegisto2) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    //SERIACAO 2
    
    private static Comparator<Candidatura> menorDesvioProficiencia = new Comparator<Candidatura>() {                           

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                double nivelProficiencia1 = f1.getTarefa().getNivelProficiencia(1) - f1.getFreelancer().getNivelProficiencia(1); //FALTA ADQUIRIR NIVEL ESPECIFICO
                double nivelProficiencia2 = f2.getTarefa().getNivelProficiencia(1) - f2.getFreelancer().getNivelProficiencia(1);

                if (nivelProficiencia1 > nivelProficiencia2) {
                    return -1;
                } else if (nivelProficiencia1 < nivelProficiencia2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    public static ArrayList<String> mostrarOpcoes() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(seriacao1.toString());
        opcoes.add(seriacao2.toString());
        return opcoes;
    }
}