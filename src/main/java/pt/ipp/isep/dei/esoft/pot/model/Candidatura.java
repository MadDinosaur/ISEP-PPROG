package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Date;

public class Candidatura {

    /**
     * A data em que foi efetuada a candidatura
     */
    private Date dataCandidatura;
    /**
     * Valor pretendido para executar a tarefa anunciada
     */
    private double valorPretendido;
    /**
     * Nº de dias para executar a tarefa anunciada
     */
    private int nrDias;
    /**
     * Texto de apresentação do candidato
     */
    private String txtApresentacao;
    /**
     * Texto de motivação do candidato
     */
    private String txtMotivacao;
    /**
     * O Freelancer que efetuou a Candidatura
     */
    private Freelancer freelancer;
    /**
     * O Anuncio para a qual a Candidatura se destina
     */
    private Anuncio anuncio;
    /**
     * O Tarefa para a qual a Candidatura se destina
    */
    private Tarefa tarefa;

    /**
     * Cria um objeto da classe Candidatura.
     *
     * @param dataCandidatura a data de criação da candidatura
     * @param valorPretendido o valor pretendido para executar a tarefa na
     * candidatura
     * @param nrDias o nº de dias para executar a tarefa na candidatura
     * @param txtApresentacao o texto de apresentação do candidato
     * @param txtMotivacao o texto de motivação do candidato
     * @param freelancer o Freelancer que efetua a candidatura
     * @param anuncio o Anuncio para a qual a Candidatura se destina
     */
    public Candidatura(Date dataCandidatura, double valorPretendido, int nrDias,
            String txtApresentacao, String txtMotivacao, Freelancer freelancer, Anuncio anuncio) {
        if (dataCandidatura == null || txtApresentacao == null || txtMotivacao == null || freelancer == null)
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.dataCandidatura = dataCandidatura;
        this.valorPretendido = valorPretendido;
        this.nrDias = nrDias;
        this.txtApresentacao = txtApresentacao;
        this.txtMotivacao = txtMotivacao;
        this.freelancer = new Freelancer(freelancer);
        this.anuncio = new Anuncio(anuncio);
        this.tarefa = this.anuncio.getTarefa();
    }
    
    /**
     * Retorna a Tarefa para a qual se destina a candidatura
     *
     * @return o Tarefa
     */
    public Tarefa getTarefa(){
        return new Tarefa(tarefa);
    }

    /**
     * Retorna o Anuncio para a qual se destina a candidatura
     *
     * @return o Anuncio
     */
    public Anuncio getAnuncio() {
        return new Anuncio(anuncio);
    }

    /**
     * Retorna o Freelancer que efetua a candidatura
     *
     * @return o Freelancer
     */
    public Freelancer getFreelancer() {
        return new Freelancer(freelancer);
    }

    /**
     * Retorna a data de criação da candidatura
     *
     * @return a data de candidatura
     */
    public Date getDataCandidatura() {
        return dataCandidatura;
    }

    /**
     * Retorna o valor pretendido para executar a tarefa alvo da candidatura
     *
     * @return o valor pretendido
     */
    public double getValorPretendido() {
        return valorPretendido;
    }

    /**
     * Retorna o nº de dias para executar a tarefa alvo da candidatura
     *
     * @return o número de dias
     */
    public int getNrDias() {
        return nrDias;
    }

    /**
     * Retorna o texto de apresentação do candidato
     *
     * @return o texto de apresentação
     */
    public String getTxtApresentacao() {
        return txtApresentacao;
    }

    /**
     * Retorna o texto de motivação do candidato
     *
     * @return o texto de motivação
     */
    public String getTxtMotivacao() {
        return txtMotivacao;
    }

    /**
     * Modifica a data de candidatura
     *
     * @param dataCandidatura
     */
    public void setDataCandidatura(Date dataCandidatura) {
        this.dataCandidatura = dataCandidatura;
    }

    /**
     * Modifica o valor pretendido constante na candidatura
     *
     * @param valorPretendido
     */
    public void setValorPretendido(double valorPretendido) {
        this.valorPretendido = valorPretendido;
    }

    /**
     * Modifica o número de dias constante na candidatura
     *
     * @param nrDias
     */
    public void setNrDias(int nrDias) {
        this.nrDias = nrDias;
    }

    /**
     * Modifica o texto de apresentação constante na candidatura
     *
     * @param txtApresentacao
     */
    public void setTxtApresentacao(String txtApresentacao) {
        this.txtApresentacao = txtApresentacao;
    }

    /**
     * Modifica o texto de motivação constante na candidatura
     *
     * @param txtMotivacao
     */
    public void setTxtMotivacao(String txtMotivacao) {
        this.txtMotivacao = txtMotivacao;
    }
    @Override
    public String toString() {
        return String.format("Data: %s, Valor: %.2f€, Dias: %d, Nome: %s", dataCandidatura, valorPretendido, nrDias, freelancer.getNome());
    }
    
    public double getDesvioPadrao(){
        double somatorio = 0;
        int cont = 0;
        float media = getMediaNiveisProficiencia();
        for(int i = 0; i < tarefa.getCompetencias().size(); i++){
            for(int j = 0; j < freelancer.getCompetencias().size(); j++){
                if(freelancer.getCompetencias().get(j).equals(tarefa.getCompetencias().get(i))){
                    somatorio = somatorio + Math.pow(freelancer.getNivelProficiencia(i) - media, 2);
                    cont++;
                    break;
                }
            }
        }
        somatorio = somatorio / cont;
        return Math.sqrt(somatorio);
    }
    
    public float getMediaNiveisProficiencia(){
        float media = 0;
        int cont = 0;
        for(int i = 0; i < tarefa.getCompetencias().size(); i++){
            for(int j = 0; j < freelancer.getCompetencias().size(); j++){
                if(freelancer.getCompetencias().get(j).equals(tarefa.getCompetencias().get(i))){
                    media = media + freelancer.getNivelProficiencia(i);
                    cont++;
                    break;
                }
            }
        }
        return (float) media / cont;
    }
    
    @Override
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
        Candidatura other = (Candidatura) o;
        return this.anuncio.equals(other.anuncio) && this.freelancer.equals(other.freelancer);
    }
}
