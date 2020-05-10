package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegistoAnuncios {

    /**
     * A lista de anúncios registados na plataforma
     */
    private List<Anuncio> listaAnuncios;

    /**
     * Cria um objeto da classe RegistoAnuncios com um ArrayList vazio
     */
    public RegistoAnuncios() {
        this.listaAnuncios = new ArrayList<>();
    }

    /**
     * Cria um objeto da classe RegistoAnuncios
     *
     * @param listaAnuncios a lista dos Anuncios
     */
    public RegistoAnuncios(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public void getAnunciosPorSeriarNaoAutomaticos(Colaborador colab) {
    }

    public Anuncio getAnuncioPublicadoPor(Colaborador colab, int anuncioId) {
        //TEMPORARIO   
        return new Anuncio(new Date(), new Date(), new Date(), new Date(), new Date(), new Date());
    }
}
