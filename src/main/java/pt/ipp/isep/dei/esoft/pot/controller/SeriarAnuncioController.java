package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Inicializador;
import pt.ipp.isep.dei.esoft.pot.model.ListaCandidaturas;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Seriacao;

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
        return getAnuncio(anuncioId).getListaCandidaturas().toStringArray();
    }
    private Anuncio getAnuncio (int anuncioId) {
        return plataforma.getRegistoAnuncios().getAnuncioPublicadoPor(user, anuncioId);
    }
    
    public int getIdFromString(String anuncio) {
        String finder = "ID: ";
        return Character.getNumericValue(anuncio.charAt(anuncio.indexOf(finder)+ finder.length()));
    }

    public List<String> classifica(int anuncioId) {
        getAnuncio(anuncioId).getProcessoSeriacao().ordenar();
        return getCandidaturas(anuncioId);
    }

    public void getColaboradores() {
    }

    public void addParticipante(String emailPart) {
    }
    public ArrayList<String> getSeriacoes() {
        return Seriacao.mostrarOpcoes();
    }
    public void registaProcessoSeriacao(int anuncioId, String tipoSeriacao) {
        getAnuncio(anuncioId).novoProcessoSeriacao(user, tipoSeriacao);
    }
}
