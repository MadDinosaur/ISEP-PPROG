package isep.dm_tp1_1181626_1191507;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public abstract class CreditoBancario {

    private String nome;

    private String profissao;

    private float montante;

    private int mesesFinanciamento;

    private final String NOME_POR_OMISSAO = "";

    private final String PROFISSAO_POR_OMISSAO = "";

    private final float MONTANTE_POR_OMISSAO = 0;

    private final int MESESFINANCIAMENTO_POR_OMISSAO = 0;

    public final int MESES_POR_ANO = 12;

    /**
     * Constrói uma instância de CreditoBancario recebendo o nome, a profissão ,
     * o montante e os meses de financiamento.
     *
     *
     * @param nome o nome do cliente
     * @param profissao a profissao do cliente
     * @param montante o montante do cliente
     * @param mesesFinanciamento os meses de financiamento do cliente
     *
     */
    public CreditoBancario(String nome, String profissao, float montante, int mesesFinanciamento) {
        this.nome = nome;
        this.profissao = profissao;
        this.montante = montante;
        this.mesesFinanciamento = mesesFinanciamento;
    }

    /**
     * Constrói uma instância de CreditoBancario recebendo o nome por omissão ,
     * a profissão por omissão, o montante por omissão e os meses de
     * financiamento por omissão.
     */
    public CreditoBancario() {
        this.nome = NOME_POR_OMISSAO;
        this.profissao = PROFISSAO_POR_OMISSAO;
        this.montante = MONTANTE_POR_OMISSAO;
        this.mesesFinanciamento = MESESFINANCIAMENTO_POR_OMISSAO;
    }

    /**
     * Modifica o nome de um cliente.
     *
     * @param nome o novo nome do cliente
     *
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Modifica a profissão de um dado cliente.
     *
     * @param profissao a nova profissão do cliente
     *
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * Modifica o montante de um dado cliente.
     *
     * @param montante o novo montante do cliente
     *
     */
    public void setMontante(float montante) {
        this.montante = montante;
    }

    /**
     * Modifica os meses de financiamento de um dado cliente.
     *
     * @param mesesFinanciamento o novo período de financiamento em meses do
     * cliente
     *
     */
    public void setMesesFinanciamento(int mesesFinanciamento) {
        this.mesesFinanciamento = mesesFinanciamento;
    }

    /**
     * Devolve o nome de um cliente.
     *
     * @return nome de um cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a profissao de um cliente.
     *
     * @return profissao de um cliente
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * Devolve o montante de um cliente.
     *
     * @return montante de um cliente
     */
    public float getMontante() {
        return montante;
    }

    /**
     * Devolve os meses de financiamento de um cliente.
     *
     * @return mesesFinanciamento de um cliente
     */
    public int getMesesFinanciamento() {
        return mesesFinanciamento;
    }

    /**
     * Devolve a descrição textual de um crédito bancário.
     *
     * @return caraterísticas de um crédito bancário
     */
    @Override
    public String toString() {
        return String.format("O cliente %s, com a profissão %s, tem um crédito de %.2fEUR a %d meses", nome, profissao, montante, mesesFinanciamento);
    }

    /**
     * Obtém o montante de capital a amortizar a cada mês tendo em conta o prazo
     * e o montante do crédito
     *
     * @return capital amortizado mensal
     */
    public float getCapitalAmortizadoMensal() {
        if (mesesFinanciamento == 0)
            return 0;
         else
            return montante / mesesFinanciamento;
    }

    /**
     * Devolve o montante a receber por cada credito.
     *
     * @return montantePorCredito do crédito bancário
     */
    public float calcularMontanteAReceberPorCadaCredito() {
        return getMontante() + calcularMontanteTotalJuros();
    }

    /**
     * Devolve o montante total de juros.
     *
     * @return montanteJuros do crédito bancário
     */
    public abstract float calcularMontanteTotalJuros();

}
