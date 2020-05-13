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
     * O nº de idenficação do Anuncio, atribuído sequencialmente
     */
    private int ID = 0;

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

    private boolean adicionarAnuncio(Anuncio a) {
        if (this.listaAnuncios.add(a)) {
            a.setID(ID++);
            return true;
        } else {
            return false;
        }

    }

    public RegistoAnuncios getAnunciosPorSeriar(Colaborador colab) {
        RegistoAnuncios anunciosPorSeriar = new RegistoAnuncios();
        for (Anuncio anuncio : listaAnuncios) {
            if (anuncio.getColaborador().equals(colab) && anuncio.getProcessoSeriacao() != null) {
                anunciosPorSeriar.adicionarAnuncio(anuncio);
            }
        }
        return anunciosPorSeriar;
    }

    /**
     * Retorna o Anuncio publicado por um dado Colaborador e com o ID
     * especificado
     *
     * @param colab o Colaborador que publicou o Anuncio
     * @param anuncioId o ID do Anuncio
     * @return o Anuncio pretendido ou null se este não existir
     */
    public Anuncio getAnuncioPublicadoPor(Colaborador colab, int anuncioId) {
        for (Anuncio anuncio : listaAnuncios) {
            if (anuncioId == anuncio.getID() && anuncio.getColaborador().equals(colab)) {
                return anuncio;
            }
        }
        return null;
    }
    
    public RegistoAnuncios getAnunciosPublicadosPor(Colaborador colab) {
        RegistoAnuncios publicacoes = new RegistoAnuncios();
        for (Anuncio anuncio : listaAnuncios) {
            if (anuncio.getColaborador().equals(colab)) {
                publicacoes.adicionarAnuncio(anuncio);
            }
        }
        return publicacoes;
    }

    public ArrayList<String> toStringArray() {
        ArrayList<String> stringList = new ArrayList<>();
        for (Anuncio a : listaAnuncios) {
            stringList.add(a.toString());
        }
        return stringList;
    }
}
