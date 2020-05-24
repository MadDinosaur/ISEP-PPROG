package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela a lista de Anuncios da plataforma
 *
 */
public class RegistoAnuncios {

    /**
     * A lista de anúncios registados na plataforma
     */
    private List<Anuncio> listaAnuncios;
    /**
     * O nº de idenficação do Anuncio, atribuído sequencialmente por ordem de
     * criação
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
        this.listaAnuncios = new ArrayList<>();
        for (Anuncio anun : listaAnuncios) {
            adicionarAnuncio(anun);
        }
    }

    /**
     * Adiciona um Anuncio ao registo de anúncios, sem atribuição de ID. Este
     * método é utilizado para adicionar anúncios aos registos de anúncios
     * secundário, como o registo de anúncios por seriar.
     *
     * @param a o Anuncio a adicionar
     * @return true se o Anuncio for adicionado, false caso contrário
     */
    private boolean add(Anuncio a) {
        return listaAnuncios.add(a);
    }

    /**
     * Adiciona um novo Anuncio ao registo de anúncios, atribuíndo-lhe um ID
     *
     * @param a o Anuncio a adicionar
     * @return true se o Anuncio for adicionado, false caso contrário
     */
    public boolean adicionarAnuncio(Anuncio a) {
        if (this.listaAnuncios.add(a)) {
            a.setID(ID++);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna um Registo de Anúncios por seriar, ou seja, cuja Seriação está
     * por definifir (null)
     *
     * @param colab o Colaborador que publicou os Anúncios
     * @return o registo de anúncios por seriar
     */
    public RegistoAnuncios getAnunciosPorSeriar(Colaborador colab) {
        RegistoAnuncios anunciosPorSeriar = new RegistoAnuncios();
        for (Anuncio anuncio : listaAnuncios) {
            if (anuncio.getColaborador().equals(colab) && anuncio.getProcessoSeriacao().getSeriacao() == null) {
                anunciosPorSeriar.add(anuncio);
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

    /**
     * Retorna o Anúncio igual ao especificado dentro do Registo
     *
     * @param anuncio o Anúncio a procurar
     * @return o Anúncio correspondente em Registo
     */
    public Anuncio getAnuncio(Anuncio anuncio) {
        for (Anuncio a : listaAnuncios) {
            if (a.equals(anuncio)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Retorna o Anuncio com o ID especificado
     *
     * @param ID o nº de identificação do Anúncio
     * @return o Anúncio
     */
    public Anuncio getAnuncioPorID(int ID) {
        for (Anuncio a : listaAnuncios) {
            if (a.getID() == ID) {
                return a;
            }
        }
        return null;
    }

    /**
     * Retorna o Anúncio associado à Tarefa especificada
     *
     * @param nomeTarefa o nome da Tarefa a procurar
     * @return o Anúncio
     */
    public Anuncio getAnuncioPorTarefa(String nomeTarefa) {
        for (Anuncio a : listaAnuncios) {
            if (a.getTarefa().getDesignacao().equalsIgnoreCase(nomeTarefa)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Retorna o RegistoAnuncios em formato ArrayList<String>
     *
     * @return o registo de anúncio, em formato de texto
     */
    public ArrayList<String> toStringArray() {
        ArrayList<String> stringList = new ArrayList<>();
        for (Anuncio a : listaAnuncios) {
            stringList.add(a.toString());
        }
        return stringList;
    }
}
