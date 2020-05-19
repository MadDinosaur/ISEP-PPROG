
package pt.ipp.isep.dei.esoft.pot.model;


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
     * O nível de porficiencia do freelancer.
     */
    private int nivelProficiencia;
    /**
     * Cria um objeto da classe Freelancer
     * @param nome o nome do freelancer
     * @param NIF o nº de identificação fiscal do freelancer
     * @param telefone o nº de telefone do freelancer
     * @param email o e-mail do freelancer
     */
    public Freelancer(String nome, String NIF, String telefone, String email, int nivelProficiencia){
        if (nome == null || NIF == null || telefone == null || email == null || nivelProficiencia == 0)
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.nome = nome;
        this.NIF = NIF;
        this.telefone = telefone;
        this.email = email;
        this.nivelProficiencia = nivelProficiencia;
    }
    /**
     * Cria um objeto da classe Freelancer como cópia do objeto recebido por parâmetro.
     * @param freelancer objeto da classe Freelancer
     */
    public Freelancer(Freelancer freelancer){
        if (freelancer == null)
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.nome = freelancer.getNome();
        this.NIF = freelancer.getNIF();
        this.telefone = freelancer.getTelefone();
        this.email = freelancer.getEmail();
        this.nivelProficiencia = freelancer.getNivelProficiencia();
    }
    
    /**
     * @return the nivelPorficiencia
     */
    public int getNivelProficiencia() {
        return nivelProficiencia;
    }

    /**
     * @param nivelPorficiencia the nivelPorficiencia to set
     */
    public void setNivelProficiencia(int nivelPorficiencia) {
        this.nivelProficiencia = nivelPorficiencia;
    }

    /**
     * Retorna o nome do freelancer
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o nº de identificação fiscal
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * Retorna o nº de telefone
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Retorna o e-mail
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o nome do freelancer
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica o nº de identificação fiscal
     * @param NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Modifica o nº de telefone
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Modifica o e-mail
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
