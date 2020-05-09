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

/**
 *
 * @author bdian
 */
public class Inicializador {

    String plataforma = "plataforma.txt";
    String organizacoes = "organizacoes.txt";
    String anuncios = "anuncios.txt";
    String tarefas = "tarefas.txt";
    String colaboradores = "colaboradores.txt";
    String candidaturas = "candidaturas.txt";
    String freelancers = "freelancers.txt";

    public Inicializador(String plataforma, String organizacoes, String anuncios,
            String tarefas, String colaboradores, String candidaturas, String freelancers) {
        this.plataforma = plataforma;
        this.organizacoes = organizacoes;
        this.anuncios = anuncios;
        this.tarefas = tarefas;
        this.colaboradores = colaboradores;
        this.candidaturas = candidaturas;
        this.freelancers = freelancers;
    }

    /**
     * Lê o conteúdo de um dado ficheiro de texto
     *
     * @param nomeFicheiro nome do ficheiro seguido da extensão ".txt"
     */
    private ArrayList<String> lerFicheiro(String nomeFicheiro) {
        ArrayList<String> conteudo = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(nomeFicheiro));

            while (scanner.hasNextLine()) {
                conteudo.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado!");
        }

        return conteudo;
    }

    /**
     * Cria um objeto da classe Plataforma a partir da informação em ficheiro
     */
    private void iniciarPlataforma() {
        ArrayList<String> info = lerFicheiro(plataforma);

        String designacao;
        RegistoOrganizacoes registoOrganizacoes;
        RegistoAnuncios registoAnuncios;
    }

    private ArrayList<Organizacao> iniciarOrganizacoes() {
        ArrayList<Organizacao> listOrganizacoes = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(organizacoes);
        for (String linha : info) {
            String[] params = linha.split(";");
            try {
                listOrganizacoes.add(new Organizacao(params[0].trim(), params[1].trim(), params[2].trim(),
                        params[3].trim(), params[4].trim(), new EnderecoPostal(params[5].trim(),
                        params[6].trim(), params[7].trim()), new Colaborador(params[8].trim(), params[9].trim(),
                        params[10].trim(), params[11].trim())));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listOrganizacoes;
    }

    private ArrayList<Anuncio> iniciarAnuncios() {
        ArrayList<Anuncio> listAnuncios = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(anuncios);
        for (String linha : info) {
            String[] params = linha.split(";");
            try {
                listAnuncios.add(new Anuncio(new Date(params[0]), new Date(params[1]), new Date(params[2]),
                        new Date(params[3]), new Date(params[4]), new Date(params[5])));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listAnuncios;
    }
    private ArrayList<Tarefa> iniciarTarefas() {
        ArrayList<Tarefa> listTarefas = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(tarefas);
        for (String linha : info) {
            String[] params = linha.split(";");
            try {
                listTarefas.add(new Tarefa(//TODO));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listTarefas;
    }
}
