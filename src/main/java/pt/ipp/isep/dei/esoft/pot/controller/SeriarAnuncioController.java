package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Inicializador;
import pt.ipp.isep.dei.esoft.pot.model.ListaCandidaturas;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

public class SeriarAnuncioController {

    private Plataforma plataforma;

    public SeriarAnuncioController() {
        plataforma = Inicializador.iniciarPlataforma("T4J");
    }

    public List<String> getAnunciosPorSeriar() {
        return plataforma.getRegistoAnuncios().toStringArray();
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
