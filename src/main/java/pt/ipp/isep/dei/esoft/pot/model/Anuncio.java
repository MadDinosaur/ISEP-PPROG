/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

public class Anuncio {

    Date dtInicioPublicitacao;
    Date dtFimPublicitacao;
    Date dtInicioCandidatura;
    Date dtFimCandidatura;
    Date dtInicioSeriacao;
    Date dtFimSeriacao;
    
    //SE ESTE CONTRUTOR FOR ALTERADO: ALTERAR EM INICIALIZADOR.JAVA
    public Anuncio(Date dtInicioPublicitacao, Date dtFimPublicitacao, Date dtInicioCandidatura,
            Date dtFimCandidatura, Date dtInicioSeriacao, Date dtFimSeriacao) {
        this.dtInicioPublicitacao = dtInicioPublicitacao;
        this.dtFimPublicitacao = dtFimPublicitacao;
        this.dtInicioCandidatura = dtInicioCandidatura;
        this.dtFimCandidatura = dtFimCandidatura;
        this.dtInicioSeriacao = dtInicioSeriacao;
        this.dtFimSeriacao = dtFimSeriacao;
    }

    public void getListaCandidaturas() {
    }

    public void novoProcessoSeriacao(Colaborador colab) {
    }

    public void registaProcessoSeracao(ProcessoSeriacao ps) {
    }

    private void validaProcessoSeriacao(ProcessoSeriacao ps) {
    }

    private void setProcessoSeriacao(ProcessoSeriacao ps) {
    }
}
