package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Inicializador;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

public class SeriarAnuncioController {

    private Plataforma plataforma;
    private Colaborador user = new Colaborador("nome 1", "funcao 1", "111111111", "nome1@org1.pt");//TEMPORARIO

    public SeriarAnuncioController() {
        plataforma = Inicializador.iniciarPlataforma("T4J");
    }

    public List<String> getAnunciosPorSeriar() {
        return plataforma.getRegistoAnuncios().getAnunciosPublicadosPor(user).toStringArray();
    }

    public List<String> getCandidaturas(int anuncioId) {
        return plataforma.getRegistoAnuncios().getAnuncioPublicadoPor(user, anuncioId).getListaCandidaturas().toStringArray();
    }
    
    public int getIdFromString(String anuncio) {
        String finder = "ID: ";
        return Character.getNumericValue(anuncio.charAt(anuncio.indexOf(finder)+ finder.length()));
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
