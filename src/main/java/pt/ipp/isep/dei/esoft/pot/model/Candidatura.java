/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;



import java.util.Date;



/**
 *
 * @author Francisco
 */
public class Candidatura {
    
    private Date dataCandidatura;
    
    private double valorPretendido;
    
    private int nrDias;
    
    private String txtApresentacao;
    
    private String txtMotivacao;
    
    private Freelancer freelancer;
    
    private Tarefa tarefa;
    
    public Candidatura(Date dataCandidatura, double valorPretendido, int nrDias, String txtApresentacao, String txtMotivacao, Freelancer freelancer, Tarefa tarefa){
        this.dataCandidatura = dataCandidatura;
        this.valorPretendido = valorPretendido;
        this.nrDias = nrDias;
        this.txtApresentacao = txtApresentacao;
        this.txtMotivacao = txtMotivacao;
        this.freelancer = new Freelancer(freelancer);
        this.tarefa = new Tarefa(tarefa);
    }
    
    
    public Tarefa getTarefa(){
        return tarefa;
    }
    
    public Freelancer getFreelancer(){
        return freelancer;
    }
    
    public Date getDataCandidatura(){
        return dataCandidatura;
    }

    /**
     * @return the valorPretendido
     */
    public double getValorPretendido() {
        return valorPretendido;
    }

    /**
     * @return the nrDias
     */
    public int getNrDias() {
        return nrDias;
    }

    /**
     * @return the txtApresentacao
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
    }

    /**
     * @return the txtMotivacao
     */
    public String getTxtMotivacao() {
        return txtMotivacao;
    }
    
    
    
    public void setDataCandidatura(Date dataCandidatura){
        this.dataCandidatura = dataCandidatura;
    }

    /**
     * @param valorPretendido the valorPretendido to set
     */
    public void setValorPretendido(double valorPretendido) {
        this.valorPretendido = valorPretendido;
    }

    /**
     * @param nrDias the nrDias to set
     */
    public void setNrDias(int nrDias) {
        this.nrDias = nrDias;
    }

    /**
     * @param txtApresentacao the txtApresentacao to set
     */
    public void setTxtApresentacao(String txtApresentacao) {
        this.txtApresentacao = txtApresentacao;
    }

    /**
     * @param txtMotivacao the txtMotivacao to set
     */
    public void setTxtMotivacao(String txtMotivacao) {
        this.txtMotivacao = txtMotivacao;
    }
    
    
    
}
