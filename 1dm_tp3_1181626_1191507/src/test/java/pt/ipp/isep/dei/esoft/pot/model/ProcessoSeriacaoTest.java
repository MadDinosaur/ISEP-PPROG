package pt.ipp.isep.dei.esoft.pot.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de teste da funcionalidade de seriação. O teste da funcionalidade tem
 * como base os dados no ficheiro "dados.txt" que contém um conjunto de cenários
 * disponibilizados pelo professor Emanuel Silva por e-mail
 *
 */
public class ProcessoSeriacaoTest {

    private final Plataforma APP;

    private final Colaborador COLAB;
    private final RegistoAnuncios ANUNCIOS;

    private final Anuncio ANUNCIO1;
    private final Anuncio ANUNCIO2;
    private final Anuncio ANUNCIO3;

    private final Candidatura CAND11;
    private final Candidatura CAND12;
    private final Candidatura CAND13;
    private final Candidatura CAND21;
    private final Candidatura CAND22;
    private final Candidatura CAND23;
    private final Candidatura CAND31;
    private final Candidatura CAND32;
    private final Candidatura CAND33;

    private final String SERIACAO_1 = "Seriação 1";
    private final String SERIACAO_2 = "Seriação 2";

    public ProcessoSeriacaoTest() {
        APP = Inicializador.iniciarPlataforma();
        COLAB = APP.getRegistoOrganizacoes().getOrganizacaoByEmailUtilizador("1191507@isep.ipp.pt").
                getListaColaboradores().getColaboradorByEmail("1191507@isep.ipp.pt");
        ANUNCIOS = APP.getRegistoAnuncios().getAnunciosPorSeriar(COLAB);

        ANUNCIO1 = ANUNCIOS.getAnuncioPorID(0); //ESCREVER ARTIGO PARA REVISTA
        CAND11 = ANUNCIO1.getListaCandidaturas().get(0); 
        CAND12 = ANUNCIO1.getListaCandidaturas().get(1); 
        CAND13 = ANUNCIO1.getListaCandidaturas().get(2); 
        
        ANUNCIO2 = ANUNCIOS.getAnuncioPorID(1); //ARRANJAR JARDIM
        CAND21 = ANUNCIO2.getListaCandidaturas().get(0); 
        CAND22 = ANUNCIO2.getListaCandidaturas().get(1); 
        CAND23 = ANUNCIO2.getListaCandidaturas().get(2); 
        
        ANUNCIO3 = ANUNCIOS.getAnuncioPorID(2); //APP PARA PPROG
        CAND31 = ANUNCIO3.getListaCandidaturas().get(0); 
        CAND32 = ANUNCIO3.getListaCandidaturas().get(1); 
        CAND33 = ANUNCIO3.getListaCandidaturas().get(2); 
    }

    /**
     * Test of ordenar method, of class ProcessoSeriacao.
     */
    @Test
    public void testOrdenarSeriacao1Caso1() {
        System.out.println("ordenar - Seriação 1 - Caso 1");

        ProcessoSeriacao instance = new ProcessoSeriacao(COLAB, SERIACAO_1, ANUNCIO1);
        instance.ordenar();

        ListaCandidaturas expResult = new ListaCandidaturas();
        expResult.adicionarCandidatura(CAND13); //ZE
        expResult.adicionarCandidatura(CAND11); //JOAO
        expResult.adicionarCandidatura(CAND12); //MANEL

        ListaCandidaturas result = ANUNCIO1.getListaCandidaturas();

        assertEquals(expResult, result);
    }

    /**
     * Test of ordenar method, of class ProcessoSeriacao.
     */
    @Test
    public void testOrdenarSeriacao2Caso1() {
        System.out.println("ordenar - Seriação 2 - Caso 1");

        ProcessoSeriacao instance = new ProcessoSeriacao(COLAB, SERIACAO_2, ANUNCIO1);
        instance.ordenar();

        ListaCandidaturas expResult = new ListaCandidaturas();
        expResult.adicionarCandidatura(CAND11); //ZE
        expResult.adicionarCandidatura(CAND13); //MANEL
        expResult.adicionarCandidatura(CAND12); //JOAO

        ListaCandidaturas result = ANUNCIO1.getListaCandidaturas();

        assertEquals(expResult, result);
    }

    /**
     * Test of ordenar method, of class ProcessoSeriacao.
     */
    @Test
    public void testOrdenarSeriacao1Caso2() {
        System.out.println("ordenar - Seriação 1 - Caso 2");

        ProcessoSeriacao instance = new ProcessoSeriacao(COLAB, SERIACAO_1, ANUNCIO2);
        instance.ordenar();

        ListaCandidaturas expResult = new ListaCandidaturas();
        expResult.adicionarCandidatura(CAND21); //XICO DAS COUVES
        expResult.adicionarCandidatura(CAND23); //MANEL CEBOLAS
        expResult.adicionarCandidatura(CAND22); //QUIM DA HORTA

        ListaCandidaturas result = ANUNCIO2.getListaCandidaturas();

        assertEquals(expResult, result);
    }

    /**
     * Test of ordenar method, of class ProcessoSeriacao.
     */
    @Test
    public void testOrdenarSeriacao1Caso3() {
        System.out.println("ordenar - Seriação 1 - Caso 3");

        ProcessoSeriacao instance = new ProcessoSeriacao(COLAB, SERIACAO_1, ANUNCIO3);
        instance.ordenar();

        ListaCandidaturas expResult = new ListaCandidaturas();
        expResult.adicionarCandidatura(CAND32); //MANEL CEBOLAS
        expResult.adicionarCandidatura(CAND33); //CATIA VANESSA
        expResult.adicionarCandidatura(CAND31); //JOAO

        ListaCandidaturas result = ANUNCIO3.getListaCandidaturas();

        assertEquals(expResult, result);
    }
}
