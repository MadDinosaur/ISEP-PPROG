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
    
    private ArrayList<Comparator> lista = new ArrayList<>(); 
    
    public Seriacao(ArrayList<Comparator> lista){
        this.lista = lista;
    }

    
    //SERIACAO 1
    
    Comparator<Candidatura> maiorMediaProficiencia = new Comparator<Candidatura>() {  //falta criar classe Freelancer

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                double nivelProficiencia1 = f1.getFreelancer().getNivelProficiencia();
                double nivelProficiencia2 = f2.getFreelancer().getNivelProficiencia();

                if (nivelProficiencia1 < nivelProficiencia2) {
                    return -1;
                } else if (nivelProficiencia1 > nivelProficiencia2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    Comparator<Candidatura> precoMaisBaixo = new Comparator<Candidatura>() {

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
    
    Comparator<Candidatura> propostaMaisRecente = new Comparator<Candidatura>() {

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
    
    Comparator<Candidatura> menorDesvioProficiencia = new Comparator<Candidatura>() { 

            @Override
            public int compare(Candidatura f1, Candidatura f2) {
                double nivelProficiencia1 = f1.getTarefa().getNivelPorficiencia() - f1.getFreelancer().getNivelProficiencia();
                double nivelProficiencia2 = f2.getTarefa().getNivelPorficiencia() - f2.getFreelancer().getNivelProficiencia();

                if (nivelProficiencia1 > nivelProficiencia2) {
                    return -1;
                } else if (nivelProficiencia1 < nivelProficiencia2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    /*public void tipoSeriacao(){
        switch(seriacao){
            
            case 1:
                //criterio 1 / 2 / 3
                ;
            
            case 2:
                //criterio 1 / 4 / 2 / 3
                ;
                
            case 3:
                System.out.println("Qual o ficheiro da seriação? ");
                String nomeFicheiro = ler.nextLine();
    
                                  //(ver SeriarAnuncioController)
                //interface -> classe Controller 
            
            default:
                System.out.println("Opção indisponível!");
                ;
                
        }
    }*/
    
    public ArrayList<Comparator> getSeriacao1(){
        ArrayList<Comparator> seriacao1 = new ArrayList();
        seriacao1.add(maiorMediaProficiencia);
        seriacao1.add(precoMaisBaixo);
        seriacao1.add(propostaMaisRecente);
        return seriacao1;
    }
    
    public ArrayList<Comparator> getSeriacao2(){
        ArrayList<Comparator> seriacao2 = new ArrayList();
        seriacao2.add(maiorMediaProficiencia);
        seriacao2.add(menorDesvioProficiencia);
        seriacao2.add(precoMaisBaixo);
        seriacao2.add(propostaMaisRecente);
        return seriacao2;
    }
    
    
    /*public void lerTipoSeriacao(String nomeFicheiro) throws FileNotFoundException{
        Scanner fInput = new Scanner(new File(nomeFicheiro));
        String[] seriacao = new String[100];
        int i = 0;
        while (fInput.hasNextLine()) {
            String linha = fInput.nextLine();
            // Verifica se linha não está em branco
            if ((linha.trim()).length() > 0) {
                seriacao[i] = linha;
                i++;
            }
        }
        fInput.close();
    }*/
 
}