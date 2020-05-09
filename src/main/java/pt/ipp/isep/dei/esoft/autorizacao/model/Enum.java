/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.Comparator;

/**
 *
 * @author Francisco
 */
public class Enum {
    
    int seriacao;
    
    //SERIACAO 1
    
    Comparator<Figura> criterio1 = new Comparator<Figura>() {  // criar classe Candidatura??

            @Override
            public int compare(Figura f1, Figura f2) {
                double nivelProficiencia1 = f1.calcularArea();
                double nivelProficiencia2 = f2.calcularArea();

                if (nivelProficiencia1 < nivelProficiencia2) {
                    return -1;
                } else if (nivelProficiencia1 > nivelProficiencia2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    Comparator<Figura> criterio2 = new Comparator<Figura>() {

            @Override
            public int compare(Figura f1, Figura f2) {
                double precoServico1 = f1.calcularArea();
                double precoServico2 = f2.calcularArea();

                if (precoServico1 > precoServico2) {
                    return -1;
                } else if (precoServico1 < precoServico2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    Comparator<Figura> criterio3 = new Comparator<Figura>() {

            @Override
            public int compare(Figura f1, Figura f2) {
                double dataRegisto1 = f1.calcularArea();
                double dataRegisto2 = f2.calcularArea();

                if (dataRegisto1 > dataRegisto2) {
                    return -1;
                } else if (dataRegisto1 < dataRegisto2) {
                    return 1;
                } else {
                    return 0;
                }
            }
    };
    
    //SERIACAO 2
    
    Comparator<Figura> criterio4 = new Comparator<Figura>() {

            @Override
            public int compare(Figura f1, Figura f2) {
                double dataRegisto1 = f1.calcularArea();
                double dataRegisto2 = f2.calcularArea();

                if (dataRegisto1 > dataRegisto2) {
                    return -1;
                } else if (dataRegisto1 < dataRegisto2) {
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
                
                // ou
                
                // permitir carregar tipo de seriacao atraves ficheiro
                ;
                
        }
    }
    
    
}
