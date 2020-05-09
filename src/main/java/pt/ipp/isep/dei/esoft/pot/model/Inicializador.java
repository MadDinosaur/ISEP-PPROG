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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    private Plataforma iniciarPlataforma() {
        Plataforma novaPlataforma = new Plataforma();
        ArrayList<String> info = lerFicheiro(plataforma);

        String[] params = info.get(0).split(";");
        for (String s : params) {
                s = s.trim();
            }
        try {
            novaPlataforma = new Plataforma(params[0], iniciarOrganizacoes(), iniciarAnuncios());
        } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        return novaPlataforma;
    }

    private Set<Organizacao> iniciarOrganizacoes() {
        Set<Organizacao> listOrganizacoes = new HashSet<>();
        ArrayList<String> info = lerFicheiro(organizacoes);
        for (String linha : info) {
            String[] params = linha.split(";");
            for (String s : params) {
                s = s.trim();
            }
            try {
                listOrganizacoes.add(new Organizacao(params[0], params[1], params[2],
                        params[3], params[4], new EnderecoPostal(params[5],
                                params[6], params[7]), new Colaborador(params[8], params[9],
                                params[10], params[11])));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listOrganizacoes;
    }

    private Set<Anuncio> iniciarAnuncios() {
        Set<Anuncio> listAnuncios = new HashSet<>();
        ArrayList<String> info = lerFicheiro(anuncios);
        for (String linha : info) {
            String[] params = linha.split(";");
            for (String s : params) {
                s = s.trim();
            }
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
            for (String s : params) {
                s = s.trim();
            }
            try {
                listTarefas.add(new Tarefa(params[0], params[1], params[2], params[3],
                        Integer.parseInt(params[4]), Double.parseDouble(params[5])));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            } catch (IllegalArgumentException e) {
                System.out.println("Valores em ficheiro inválidos!");
            }
        }
        return listTarefas;
    }

    private ArrayList<Colaborador> iniciarColaboradores() {
        ArrayList<Colaborador> listColaboradores = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(colaboradores);
        for (String linha : info) {
            String[] params = linha.split(";");
            for (String s : params) {
                s = s.trim();
            }
            try {
                listColaboradores.add(new Colaborador(params[0], params[1], params[2], params[3]));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listColaboradores;
    }

    private ArrayList<Candidatura> iniciarCandidaturas() {
        ArrayList<Candidatura> listCandidaturas = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(candidaturas);
        for (String linha : info) {
            String[] params = linha.split(";");
            for (String s : params) {
                s = s.trim();
            }
            try {
                listCandidaturas.add(new Candidatura(new Date(params[0]), Double.parseDouble(params[1]),
                        Integer.parseInt(params[2]), params[3], params[4], new Freelancer(params[5], params[6], params[7], params[8]),
                        new Tarefa(params[9], params[10], params[11], params[12],
                                Integer.parseInt(params[13]), Double.parseDouble(params[14]))));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listCandidaturas;
    }
    
    private ArrayList<Freelancer> iniciarFreelancers() {
        ArrayList<Freelancer> listFreelancers = new ArrayList<>();
        ArrayList<String> info = lerFicheiro(freelancers);
        for (String linha : info) {
            String[] params = linha.split(";");
            for (String s : params) {
                s = s.trim();
            }
            try {
                listFreelancers.add(new Freelancer(params[0], params[1], params[2], params[3]));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ficheiro " + e + "mal formulado!");
            }
        }
        return listFreelancers;
    }
}
