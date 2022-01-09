package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que modela uma Organização na plataforma
 *
 * @author paulomaio
 */
public class Organizacao {

    /**
     * O nome da organização
     */
    private String m_strNome;
    /**
     * O NIPC da organização
     */
    private String m_strNIF;
    /**
     * A morada da organização
     */
    private EnderecoPostal m_oEnderecoPostal;
    /**
     * O endereço web da organização
     */
    private String m_strWebsite;
    /**
     * O nº de telefone da organização
     */
    private String m_strTelefone;
    /**
     * O endereço de e-mail da organização
     */
    private String m_strEmail;
    /**
     * O Colaborador principal (gestor)
     */
    private Colaborador m_oGestor;
    /**
     * A lista de todos os Colaboradores
     */
    private ListaColaboradores listaColaboradores = new ListaColaboradores();
    /**
     * A lista de todas as Tarefas criadas pela organizacao
     */
    private ListaTarefas listaTarefas = new ListaTarefas();

    /**
     * Cria um objeto da classe Organizacao
     *
     * @param strNome o nome da organização
     * @param strNIF o NIF da organização
     * @param strWebsite o website da organização
     * @param strTelefone o nº de telefone da organização
     * @param strEmail o e-mail da organização
     * @param oMorada a morada da organização, em formato EnderecoPostal
     * @param oColaborador o gestor da organização
     */
    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
            String strEmail, EnderecoPostal oMorada, Colaborador oColaborador) {
        if ((strNome == null) || (strNIF == null) || (strTelefone == null)
                || (strEmail == null) || (oMorada == null) || (oColaborador == null)
                || (strNome.isEmpty()) || (strNIF.isEmpty()) || (strTelefone.isEmpty())
                || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;
        this.listaColaboradores.adicionarColaborador(oColaborador);

    }

    /**
     * Retorna a extensão de e-mail da organização, isto é, a porção do e-mail
     * que procede o caracter '@'
     *
     * @return a extensão de e-mail
     */
    public String getEmailExtensao() {
        return this.m_strEmail.split("@")[this.m_strEmail.split("@").length - 1];
    }

    /**
     * Retorna o Colaborador identificado como gestor da organização
     *
     * @return o gestor da organização
     */
    public Colaborador getGestor() {
        return this.m_oGestor;
    }

    /**
     * Retorna uma cópia da lista de colaboradores
     *
     * @return a lista de colaboradores
     */
    public ListaColaboradores getListaColaboradores() {
        return new ListaColaboradores(listaColaboradores);
    }

    /**
     * Retorna uma cópia da lista de tarefas
     *
     * @return a lista de tarefas
     */
    public ListaTarefas getListaTarefas() {
        return new ListaTarefas(listaTarefas);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }

    /**
     * Cria um novo Colaborador e associa-o à lista de colaboradores da
     * Organização
     *
     * @param strNome o nome do Colaborador
     * @param strFuncao a função do Colaborador
     * @param strTelefone o nº de telefone do Colaborador
     * @param strEmail o e-mail do Colaborador
     * @return o novo Colaborador
     */
    public Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        Colaborador novoColab = new Colaborador(strNome, strFuncao, strTelefone, strEmail);
        this.listaColaboradores.adicionarColaborador(novoColab);
        return novoColab;
    }

    /**
     * Cria uma nova Tarefa e associa-a à lista de tarefas da Organização
     *
     * @param referencia a referência da tarefa
     * @param designacao o nome da tarefa
     * @param descInformal a descrição informal da tarefa
     * @param descTecnica a descrição técnica da tarefa
     * @param duracaoEst a duração estimada da tarefa
     * @param custoEst o custo estimado da tarefa
     * @param competencias a lista de competências técnicas associadas à tarefa
     * @return a nova Tarefa
     */
    public Tarefa novaTarefa(String referencia, String designacao, String descInformal, String descTecnica,
            Integer duracaoEst, Double custoEst, ArrayList<String> competencias) {
        Tarefa novaTarefa = new Tarefa(referencia, designacao, descInformal, descTecnica, duracaoEst, custoEst, competencias);
        this.listaTarefas.adicionarTarefa(novaTarefa);
        return novaTarefa;
    }

    /**
     * Verifica se duas Organizações são iguais. As Organizações consideram-se
     * iguais se tiverem o mesmo NIF.
     *
     * @param o Objeto a comparar
     * @return true se as Organizações forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

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
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    /**
     * Retorna a descrição textual de uma Organização
     *
     * @return a descrição da Organização, em formato de texto
     */
    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oEnderecoPostal.toString(), this.m_oGestor.toString());
        return str;
    }

}
