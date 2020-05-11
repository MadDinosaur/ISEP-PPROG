package pt.ipp.isep.dei.esoft.pot.model;

public class TipoRegimento {

    /**
     * O nome do tipo de regimento
     */
    private String designacao;
    /**
     * A descrição textual das regras associadas ao tipo de regimento
     */
    private String descricaoRegras;

    /**
     * Cria um objeto da classe TipoRegimento
     *
     * @param designacao o nome do tipo de regimento
     * @param descricaoRegras a descrição textual das regras associadas
     */
    public TipoRegimento(String designacao, String descricaoRegras) {
    }

    /**
     * Cria uma cópia de um objeto da classe TipoRegimento
     *
     * @param reg o TipoRegimento a copiar
     */
    public TipoRegimento(TipoRegimento reg) {
        this.designacao = reg.designacao;
        this.descricaoRegras = reg.descricaoRegras;
    }

    public TipoRegimento() {
    }

}
