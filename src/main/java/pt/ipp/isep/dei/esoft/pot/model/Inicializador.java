/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Inicializador {

    /**
     * O nome do ficheiro que armazena os dados para instanciação de objetos
     */
    private static final String NOME_FICHEIRO = "dados.txt";
    /**
     * O conteúdo do ficheiro de texto, em que cada linha n do ficheiro está
     * armazenada no índice n-1 do array
     */
    private static ArrayList<String> dados = new ArrayList<>();
    /**
     * O número de linhas que separam um título e uma linha de dados no ficheiro
     * de texto
     */
    private static final int SEPARADOR_TITULO = 4;
    /**
     * O caráter que é usado em sequência no ficheiro de texto e tem a função de
     * separador de informação
     */
    private static final String DELIMITADOR = "-";
    private static final String NOME_PLATAFORMA = "T4J";
    private static Plataforma plataforma;
    private static Organizacao organizacao;
    private static RegistoAnuncios registoAnuncios;

    /**
     * Cria um objeto da classe Inicializador
     */
    public Inicializador() {
        lerFicheiro();
    }

    /**
     * Lê o conteudo de um dado ficheiro de texto
     */
    private static void lerFicheiro() {

        try {
            Scanner scanner = new Scanner(new File(NOME_FICHEIRO));

            while (scanner.hasNextLine()) {
                dados.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado!");
        }
    }

    private void iniciarPlataforma() {
        RegistoOrganizacoes registoOrganizacoes = new RegistoOrganizacoes();
        registoOrganizacoes.adicionarOrganizacao(organizacao);

        this.plataforma = new Plataforma(NOME_PLATAFORMA, registoOrganizacoes, registoAnuncios);
    }

    /**
     * Cria um objeto da classe Organizacao com a informação em ficheiro de
     * texto
     */
    private static void iniciarOrganizacao() {
        String[] params = dados.get(procurar("Organização") + SEPARADOR_TITULO).split(";");

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
            String[] params = dados.get(linha).split(";");

            linha += SEPARADOR_TITULO;

            ArrayList<String> paramsCompetencias = new ArrayList<>();
            if (!dados.get(linha).startsWith(DELIMITADOR)) {
                for (int i = linha; i < getProximoDelimitador(linha); i++) {
                    paramsCompetencias.add(dados.get(i));
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

            if (dados.get(linha).startsWith(DELIMITADOR)) {
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
            String[] params = dados.get(linha).split(";");

            try {
                Colaborador novoColaborador = organizacao.novoColaborador(params[0], params[1], params[2], params[3]);

                if (dados.get(linha + SEPARADOR_TITULO).startsWith(DELIMITADOR)) {
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

            String[] params = dados.get(linha).split(";");

            Anuncio novoAnuncio = new Anuncio(new Date(params[0]), new Date(params[1]), new Date(params[2]),
                    new Date(params[3]), new Date(params[4]), new Date(params[5]), organizacao.getListaTarefas().getTarefaPorNome(params[6]), colab);

            registoAnuncios.adicionarAnuncio(novoAnuncio);
        }
    }

    /**
     * Cria objetos da classe Freelancer com a informação em ficheiro de texto e
     * associa automaticamente à ???
     */
    private static void iniciarFreelancers() {
        int linha = procurar("Freelancers") + SEPARADOR_TITULO;
        boolean adicionarFreelancer = true;

        while (adicionarFreelancer) {
            String[] params = dados.get(linha).split(";");

            linha += SEPARADOR_TITULO;

            ArrayList<String> paramsCompetencias = new ArrayList<>();
            while (!dados.get(linha).isEmpty()) {
                paramsCompetencias.add(dados.get(linha));
                linha++;
            }

            try {
                Freelancer novoFreelancer = new Freelancer(params[0], params[1], params[2], params[3], paramsCompetencias);
                //ADICIONAR EM LISTA

                linha += SEPARADOR_TITULO - 1;

                if (!dados.get(linha).startsWith(DELIMITADOR)) {
                    iniciarCandidaturas(linha, novoFreelancer);
                }

                linha = getProximoDelimitador(linha) + 1;

                if (dados.get(linha).startsWith(DELIMITADOR)) {
                    adicionarFreelancer = false;
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Secção \"Freelancers\" mal formatada!");
            }
        }
    }

    private static void iniciarCandidaturas(int linha, Freelancer freelancer) throws IndexOutOfBoundsException {
        for (int i = linha; i < getProximoDelimitador(linha); i++) {

            String[] params = dados.get(linha).split(";");

            registoAnuncios.getAnuncioPorTarefa(params[4]).adicionarCandidatura(new Date(params[0]), 
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
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).trim().equalsIgnoreCase(keyword)) {
                return i;
            }
        }
        return -1;
    }

    private static int getProximoDelimitador(int startIndex) {
        for (int i = startIndex; i < dados.size(); i++) {
            if (dados.get(i).startsWith(DELIMITADOR)) {
                return i;
            }
        }
        return -1;
    }
}
