/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Comparator;
import java.util.Date;



/**
 *
 * @author Francisco
 */
public class Seriacao {
    
    int seriacao;
   /* 
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
    
    Comparator<Candidatura> menorDesvioProficiencia = new Comparator<Candidatura>() { //falta criar classe Freelancer e classe Tarefa

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
    
    public void tipoSeriacao(){
        switch(seriacao){
            
            case 1:
                //criterio 1 / 2 / 3
                ;
            
            case 2:
                //criterio 1 / 4 / 2 / 3
                ;
            
            default:
                // criar criterio novo / comparators novos

                ;
                
        }
    }
 */   
}
