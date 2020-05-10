package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Inicializador;
import pt.ipp.isep.dei.esoft.pot.model.ListaCandidaturas;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.RegistoAnuncios;

public class SeriarAnuncioController {

    private Plataforma plataforma;

    public SeriarAnuncioController() {
        plataforma = Inicializador.iniciarPlataforma("T4J");
    }

    public RegistoAnuncios getAnunciosPorSeriarNaoAutomaticos() {
        return plataforma.getRegistoAnuncios();
    }

    public ListaCandidaturas getCandidaturas(Colaborador colab, int anuncioId) {
        return plataforma.getRegistoAnuncios().getAnuncioPublicadoPor(colab, anuncioId).getListaCandidaturas();
    }

    public void classifica(int candId, int ordem) {
    }

    public void getColaboradores() {
    }

    public void addParticipante(String emailPart) {
    }

    public void registaProcessoSeriacao() {
    }
}
