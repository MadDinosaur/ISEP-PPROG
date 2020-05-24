package pt.ipp.isep.dei.esoft.pot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe que instancia objetos de várias classes, necessários ao funcionamento
 * da aplicação, a partir de um ficheiro de texto.
 */
public class Inicializador {

    /**
     * O nome do ficheiro que armazena os dados para instanciação de objetos
     */
    private static final String NOME_FICHEIRO = "dados.txt";
    /**
     * O conteúdo do ficheiro de texto, em que cada linha n do ficheiro está
     * armazenada no índice n-1 do array
     */
    private static final ArrayList<String> DADOS = new ArrayList<>();
    /**
     * O número de linhas que separam um título e uma linha de dados no ficheiro
     * de texto
     */
    private static final int SEPARADOR_TITULO = 4;
    /**
     * O carater que é usado em sequência no ficheiro de texto e tem a função de
     * separador de informação
     */
    private static final String DELIMITADOR = "-";
    /**
     * O nome da plataforma
     */
    private static final String NOME_PLATAFORMA = "T4J";
    /**
     * A Plataforma que controla a aplicaçáo
     */
    private static Plataforma plataforma;
    /**
     * A Organização registada na plataforma
     */
    private static Organizacao organizacao;
    /**
     * A lista de todos os Anuncios que constam na platforma
     */
    private static RegistoAnuncios registoAnuncios = new RegistoAnuncios();

    /**
     * Lê o conteudo do ficheiro de texto
     */
    private static void lerFicheiro() {

        try {
            Scanner scanner = new Scanner(new File(NOME_FICHEIRO));

            while (scanner.hasNextLine()) {
                DADOS.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    /**
     * Cria um objeto da classe Plataforma que contém toda a informação em
     * ficheiro de texto, no formato de objetos da classe adequada
     *
     * @return a Plataforma
     */
    public static Plataforma iniciarPlataforma() {
        lerFicheiro();
        iniciarOrganizacao();
        iniciarTarefas();
        iniciarColaboradores();
        iniciarFreelancers();

        RegistoOrganizacoes registoOrganizacoes = new RegistoOrganizacoes();
        registoOrganizacoes.adicionarOrganizacao(organizacao);

        plataforma = new Plataforma(NOME_PLATAFORMA, registoOrganizacoes, registoAnuncios);

        return plataforma;
    }

    /**
     * Cria um objeto da classe Organizacao com a informação em ficheiro de
     * texto
     */
    private static void iniciarOrganizacao() {
        int linha = procurar("Organizacao") + SEPARADOR_TITULO;

        String[] params = DADOS.get(linha).split(";");

        try {
            organizacao = new Organizacao(params[0], params[1], params[2],
                    params[3], params[4], new EnderecoPostal(params[5], params[6], params[7]),
                    new Colaborador(params[8], params[9], params[10], params[11]));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Secção \"Organização\" mal formatada!");
        }
    }

    /**
     * Cria objetos da classe Tarefa com a informação em ficheiro de texto e
     * associa automaticamente à Organização
     */
    private static void iniciarTarefas() {
        int linha = procurar("Tarefas") + SEPARADOR_TITULO;
        boolean adicionarTarefa = true;

        while (adicionarTarefa) {
            String[] params = DADOS.get(linha).split(";");

            linha += SEPARADOR_TITULO;

            ArrayList<String> paramsCompetencias = new ArrayList<>();
            if (!DADOS.get(linha).startsWith(DELIMITADOR)) {
                for (int i = linha; i < getProximoDelimitador(linha); i++) {
                    paramsCompetencias.add(DADOS.get(i));
                }
            }

            try {
                organizacao.novaTarefa(params[0], params[1], params[2], params[3],
                        Integer.parseInt(params[4]), Double.parseDouble(params[5]), paramsCompetencias);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Secção \"Tarefas\" mal formatada!");
            } catch (IllegalArgumentException e) {
                System.out.println("Valores em ficheiro inválidos!");
            }

            linha = getProximoDelimitador(linha) + 1;

            if (DADOS.get(linha).startsWith(DELIMITADOR)) {
                adicionarTarefa = false;
            }
        }
    }

    /**
     * Cria objetos da classe Colaborador com a informação em ficheiro de texto
     * e automaticamente associa à Organização
     */
    private static void iniciarColaboradores() {

        int linha = procurar("Colaboradores") + SEPARADOR_TITULO;
        boolean adicionarColab = true;

        while (adicionarColab) {
            String[] params = DADOS.get(linha).split(";");

            try {
                Colaborador novoColaborador = organizacao.novoColaborador(params[0], params[1], params[2], params[3]);

                if (DADOS.get(linha + SEPARADOR_TITULO).startsWith(DELIMITADOR)) {
                    adicionarColab = false;
                } else {
                    linha += SEPARADOR_TITULO;
                    iniciarAnuncios(linha, novoColaborador);
                    linha = getProximoDelimitador(linha) + 1;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Secção \"Colaboradores\" mal formatada!");
            }
        }
    }

    /**
     * Cria objetos da classe Anuncio com a informação em ficheiro de texto e
     * automaticamente associa ao Colaborador responsável
     */
    private static void iniciarAnuncios(int linha, Colaborador colab) throws IndexOutOfBoundsException {
        for (int i = linha; i < getProximoDelimitador(linha); i++) {

            String[] params = DADOS.get(i).split(";");

            Anuncio novoAnuncio = new Anuncio(new Date(params[0]), new Date(params[1]), new Date(params[2]),
                    new Date(params[3]), new Date(params[4]), new Date(params[5]), organizacao.getListaTarefas().getTarefaPorNome(params[6]), colab);

            registoAnuncios.adicionarAnuncio(novoAnuncio);
        }
    }

    /**
     * Cria objetos da classe Freelancer com a informação em ficheiro de texto
     */
    private static void iniciarFreelancers() {
        int linha = procurar("Freelancers") + SEPARADOR_TITULO;
        boolean adicionarFreelancer = true;

        while (adicionarFreelancer) {
            String[] params = DADOS.get(linha).split(";");

            linha += SEPARADOR_TITULO;

            ArrayList<String> paramsCompetencias = new ArrayList<>();
            while (!DADOS.get(linha).isEmpty()) {
                paramsCompetencias.add(DADOS.get(linha));
                linha++;
            }

            try {
                Freelancer novoFreelancer = new Freelancer(params[0], params[1], params[2], params[3], paramsCompetencias);
                //ADICIONAR EM LISTA

                linha += SEPARADOR_TITULO - 1;

                if (!DADOS.get(linha).startsWith(DELIMITADOR)) {
                    iniciarCandidaturas(linha, novoFreelancer);
                }

                linha = getProximoDelimitador(linha) + 1;

                if (DADOS.get(linha).startsWith(DELIMITADOR)) {
                    adicionarFreelancer = false;
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Secção \"Freelancers\" mal formatada!");
            }
        }
    }

    /**
     * Cria objetos da classe Candidatura e associa automaticamente ao respetivo
     * Anuncio
     *
     * @param linha o número da linha no ficheiro de texto onde se situa a
     * informação sobre a Candidatura
     * @param freelancer o Freelancer responsável pela Candidatura
     * @throws IndexOutOfBoundsException
     */
    private static void iniciarCandidaturas(int linha, Freelancer freelancer) throws IndexOutOfBoundsException {
        for (int i = linha; i < getProximoDelimitador(linha); i++) {

            String[] params = DADOS.get(i).split(";");

            registoAnuncios.getAnuncioPorTarefa(params[5]).adicionarCandidatura(new Date(params[0]),
                    Double.parseDouble(params[1]), Integer.parseInt(params[2]), params[3], params[4], freelancer);
        }
    }

    /**
     * Procura a linha no ficheiro cujo texto é igual à string recebida por
     * parâmetro
     *
     * @param keyword o conteúdo da linha a procurar
     * @return o índice da linha pretendida ou -1 caso não exista
     */
    private static int procurar(String keyword) {
        for (int i = 0; i < DADOS.size(); i++) {
            if (DADOS.get(i).trim().equalsIgnoreCase(keyword)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Procura o próximo separador no ficheiro de texto, de acordo com a
     * formatação definida no atributo DELIMITADOR da classe
     *
     * @param startIndex o nº de linha a partir do qual deve ser procurado o
     * delimitador
     * @return o nº da linha no ficheiro de texto onde se encontra o delimitador
     */
    private static int getProximoDelimitador(int startIndex) {
        for (int i = startIndex; i < DADOS.size(); i++) {
            if (DADOS.get(i).startsWith(DELIMITADOR)) {
                return i;
            }
        }
        return -1;
    }
}
