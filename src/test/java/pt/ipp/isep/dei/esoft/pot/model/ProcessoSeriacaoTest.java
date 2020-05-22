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

    private final Plataforma APP = Inicializador.iniciarPlataforma();

    private final Colaborador COLAB = APP.getRegistoOrganizacoes().getOrganizacaoByEmailUtilizador("1191507@isep.ipp.pt").getListaColaboradores().getColaboradorByEmail("1191507@isep.ipp.pt");
    private final RegistoAnuncios ANUNCIOS = APP.getRegistoAnuncios().getAnunciosPorSeriar(COLAB);

    private final Anuncio ANUNCIO1 = ANUNCIOS.getAnuncioPorID(0);
    private final Anuncio ANUNCIO2 = ANUNCIOS.getAnuncioPorID(1);
    private final Anuncio ANUNCIO3 = ANUNCIOS.getAnuncioPorID(2);
    private final Anuncio anuncio4 = ANUNCIOS.getAnuncioPorID(3); //REMOVER

    private final Candidatura CAND11 = ANUNCIO1.getListaCandidaturas().get(0);
    private final Candidatura CAND12 = ANUNCIO1.getListaCandidaturas().get(1);
    private final Candidatura CAND13 = ANUNCIO1.getListaCandidaturas().get(2);
    private final Candidatura CAND21 = ANUNCIO2.getListaCandidaturas().get(0);
    private final Candidatura CAND22 = ANUNCIO2.getListaCandidaturas().get(1);
    private final Candidatura CAND23 = ANUNCIO2.getListaCandidaturas().get(2);
    private final Candidatura CAND31 = ANUNCIO3.getListaCandidaturas().get(0);
    private final Candidatura CAND32 = ANUNCIO3.getListaCandidaturas().get(1);
    private final Candidatura CAND33 = ANUNCIO3.getListaCandidaturas().get(2);

    private final String SERIACAO_1 = "Seriação 1";
    private final String SERIACAO_2 = "Seriação 2";

    public ProcessoSeriacaoTest() {
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
        expResult.adicionarCandidatura(CAND13);
        expResult.adicionarCandidatura(CAND11);
        expResult.adicionarCandidatura(CAND12);

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
        expResult.adicionarCandidatura(CAND21);
        expResult.adicionarCandidatura(CAND23);
        expResult.adicionarCandidatura(CAND22);

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
        expResult.adicionarCandidatura(CAND33);
        expResult.adicionarCandidatura(CAND31);
        expResult.adicionarCandidatura(CAND32);

        ListaCandidaturas result = ANUNCIO3.getListaCandidaturas();

        assertEquals(expResult, result);
    }
}
