package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

/**
 * Classe que modela um Freelancer, que pode efetuar candidaturas a Tarefas com
 * base nas suas Competências Técnicas
 *
 */
public class Freelancer {

    /**
     * Nome do freelancer.
     */
    private String nome;
    /**
     * Número de indentificação fiscal do freelancer.
     */
    private String NIF;
    /**
     * Número de telefone do freelancer.
     */
    private String telefone;
    /**
     * E-mail do freelancer.
     */
    private String email;
    /**
     * Lista de Competências Técnicas do freelancer.
     */
    private ArrayList<CompetenciaTecnica> competencias = new ArrayList<>();

    /**
     * Cria um objeto da classe Freelancer
     *
     * @param nome o nome do freelancer
     * @param NIF o nº de identificação fiscal do freelancer
     * @param telefone o nº de telefone do freelancer
     * @param email o e-mail do freelancer
     * @param competencias a lista de competências técnicas associadas ao
     * freelancer
     */
    public Freelancer(String nome, String NIF, String telefone, String email, ArrayList<String> competencias) {
        if (nome == null || NIF == null || telefone == null || email == null) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.nome = nome;
        this.NIF = NIF;
        this.telefone = telefone;
        this.email = email;
        for (String str : competencias) {
            this.competencias.add(new CompetenciaTecnica(str));
        }
    }

    /**
     * Cria um objeto da classe Freelancer como cópia do objeto recebido por
     * parâmetro.
     *
     * @param freelancer objeto da classe Freelancer
     */
    public Freelancer(Freelancer freelancer) {
        if (freelancer == null) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.nome = freelancer.getNome();
        this.NIF = freelancer.getNIF();
        this.telefone = freelancer.getTelefone();
        this.email = freelancer.getEmail();
        this.competencias = freelancer.getCompetencias();
    }

    /**
     * Retorna o nome do freelancer
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o nº de identificação fiscal
     *
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Retorna o nº de telefone
     *
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna o e-mail
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o nome do freelancer
     *
     * @param nome o nome do freelancer
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o nº de identificação fiscal
     *
     * @param NIF o NIF do freelancer
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Modifica o nº de telefone
     *
     * @param telefone o nº de telefone do freelancer
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Modifica o e-mail
     *
     * @param email o e-mail do freelancer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna uma cópia da lista de competências
     *
     * @return the competencias
     */
    public ArrayList<CompetenciaTecnica> getCompetencias() {
        return new ArrayList<>(competencias);
    }

    /**
     * Retorna o nível de proficiencia numa dada competência técnica
     *
     * @param i a posição da Competencia Tecnica no ArrayList competencias
     * @return o nível de proficiência
     */
    public int getNivelProficiencia(int i) {
        if (i >= competencias.size()) {
            throw new IndexOutOfBoundsException("Competência não encontrada no índice " + i + ".");
        }
        return competencias.get(i).getNivelProficiencia();
    }

    /**
     * Verifica se dois Freelancers são iguais. Os Freelancers consideram-se
     * iguais se tiverem o mesmo endereço de e-mail.
     *
     * @param o Objeto a comparar
     * @return true se os Freelancers forem iguais, falso caso contrário
     */
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        return this.email.equals(((Freelancer) o).email);
    }
}
