package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Inicializador;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Seriacao;

public class SeriarAnuncioController {

    private Plataforma plataforma;
    private Colaborador user = new Colaborador("Bárbara","Estudante","123456789","1191507@isep.ipp.pt");//TEMPORARIO

    public SeriarAnuncioController() {
        this.plataforma = new Inicializador().iniciarPlataforma();
    }

    public List<String> getAnunciosPorSeriar() {
        return plataforma.getRegistoAnuncios().getAnunciosPorSeriar(user).toStringArray();
    }

    public List<String> getCandidaturas(int anuncioId) {
        List<String> candidaturas = getAnuncio(anuncioId).getListaCandidaturas().toStringArray();
        return candidaturas;
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

    public boolean addParticipante(int anuncioId, String emailPart) {
        Colaborador participante = plataforma.getRegistoOrganizacoes().getOrganizacaoByEmailUtilizador(emailPart).getListaColaboradores().getColaboradorByEmail(emailPart);
        return getAnuncio(anuncioId).getProcessoSeriacao().addParticipante(participante);
    }
    public List<String> getSeriacoes() {
        return Seriacao.mostrarOpcoes();
    }
    public void registaProcessoSeriacao(int anuncioId, String tipoSeriacao) {
        getAnuncio(anuncioId).novoProcessoSeriacao(tipoSeriacao);
    }
    public List<String> getParticipantes(int anuncioId) {
        return getAnuncio(anuncioId).getProcessoSeriacao().getParticipantes();
    }
}
