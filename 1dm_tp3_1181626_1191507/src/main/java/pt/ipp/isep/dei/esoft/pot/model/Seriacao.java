package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Classe que cria um Comparator com os critérios de seriação pretendidos para
 * as Candidaturas de um Anuncio.
 */
public class Seriacao {

    /**
     * O Comparator que contêm os critérios de seriação pretendidos
     */
    private Comparator comparador;
    /**
     * O nome da primeira seriação
     */
    private static final String STRING_SERIACAO_1 = "Seriação 1";
    /**
     * O nome da segunda seriação
     */
    private static final String STRING_SERIACAO_2 = "Seriação 2";
    //SERIACOES
    /**
     * O Comparator que contém os critérios de ordenação da Seriação 1
     */
    private final static Comparator<Candidatura> SERIACAO_1 = new Comparator<Candidatura>() {
        @Override
        public int compare(Candidatura c1, Candidatura c2) {
            if (maiorMediaProficiencia.compare(c1, c2) == 0) {
                if (precoMaisBaixo.compare(c1, c2) == 0) {
                    return propostaMaisRecente.compare(c1, c2);
                } else {
                    return precoMaisBaixo.compare(c1, c2);
                }
            } else {
                return maiorMediaProficiencia.compare(c1, c2);
            }
        }

        @Override
        public String toString() {
            return STRING_SERIACAO_1;
        }

        public String getDescricao() {
            return "Critérios:\n"
                    + "1. Maior	 média dos níveis de proficiência em cada uma das competências técnicas exigidas para a tarefa;\n"
                    + "2. Preço mais baixo;\n"
                    + "3. Proposta registada mais cedo.";
        }
    };
    /**
     * O Comparator que contém os critérios de ordenação da Seriação 2
     */
    private final static Comparator<Candidatura> SERIACAO_2 = new Comparator<Candidatura>() { // FALTA ACABAR
        public int compare(Candidatura c1, Candidatura c2) {
            if (maiorMediaProficiencia.compare(c1, c2) == 0) {
                if (menorDesvioProficiencia.compare(c1, c2) == 0) {
                    if (precoMaisBaixo.compare(c1, c2) == 0) {
                        return propostaMaisRecente.compare(c1, c2);
                    } else {
                        return precoMaisBaixo.compare(c1, c2);
                    }
                } else {
                    return menorDesvioProficiencia.compare(c1, c2);
                }
            } else {
                return maiorMediaProficiencia.compare(c1, c2);
            }
        }

        public String toString() {
            return STRING_SERIACAO_2;
        }

        public String getDescricao() {
            return "Critérios:\n"
                    + "1. Maior	 média dos níveis de proficiência em cada uma das competências técnicas exigidas para a tarefa;\n"
                    + "2. Menor desvio padrão dos níveis de proficiência em cada uma das competências técnicas exigidas para a tarefa;\n"
                    + "3. Preço mais baixo;\n"
                    + "4. Proposta registada mais cedo.";
        }
    };
    //CRITERIOS
    /**
     * Compara a média dos níveis de proficiência nas Competências Técnicas
     * exigidas de duas dadas Candidaturas
     */
    private final static Comparator<Candidatura> maiorMediaProficiencia = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura f1, Candidatura f2) {
            float nivelProficiencia1 = f1.getMediaNiveisProficiencia();
            float nivelProficiencia2 = f2.getMediaNiveisProficiencia();

            if (nivelProficiencia1 > nivelProficiencia2) {
                return -1;
            } else if (nivelProficiencia1 < nivelProficiencia2) {
                return 1;
            } else {
                return 0;
            }
        }
    };
    /**
     * Compara o valor pretendido de duas dadas Candidaturas
     */
    private final static Comparator<Candidatura> precoMaisBaixo = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura f1, Candidatura f2) {
            double precoServico1 = f1.getValorPretendido();
            double precoServico2 = f2.getValorPretendido();

            if (precoServico1 < precoServico2) {
                return -1;
            } else if (precoServico1 > precoServico2) {
                return 1;
            } else {
                return 0;
            }
        }
    };
    /**
     * Compara a data de realização de duas dadas Candidaturas
     */
    private final static Comparator<Candidatura> propostaMaisRecente = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura f1, Candidatura f2) {
            Date dataRegisto1 = f1.getDataCandidatura();
            Date dataRegisto2 = f2.getDataCandidatura();
            return -dataRegisto1.compareTo(dataRegisto2);
        }
    };
    /**
     * Compara o desvio padrão dos níveis de proficiência nas Competências
     * Técnicas exigidas de duas dadas Candidaturas
     */
    private final static Comparator<Candidatura> menorDesvioProficiencia = new Comparator<Candidatura>() {

        @Override
        public int compare(Candidatura f1, Candidatura f2) {
            double nivelProficiencia1 = f1.getDesvioPadraoNiveisProficiencia();
            double nivelProficiencia2 = f2.getDesvioPadraoNiveisProficiencia();

            if (nivelProficiencia1 < nivelProficiencia2) {
                return -1;
            } else if (nivelProficiencia1 > nivelProficiencia2) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    /**
     * Cria um objeto da classe Seriacao, atribuíndo um tipo de seriação
     * adequado em relação à String recebida como parâmetro
     *
     * @param tipoSeriacao o tipo de seriação pretendida, tendo que corresponder
     * exatamente à descrição textual definida nos atributos da classe.
     */
    public Seriacao(String tipoSeriacao) {
        switch (tipoSeriacao) {
            case STRING_SERIACAO_1:
                comparador = SERIACAO_1;
                break;
            case STRING_SERIACAO_2:
                comparador = SERIACAO_2;
                break;
            default:
                throw new IllegalArgumentException("Tipo de seriação inválida!");
        }
    }

    /**
     * Retorna o Comparator com os critérios de ordenação da Seriacao
     *
     * @return o Comparator
     */
    public Comparator getComparador() {
        return comparador;
    }

    /**
     * Retorna uma lista de Strings com o nome das seriações existentes
     *
     * @return as seriações existentes, em formato String
     */
    public static ArrayList<String> mostrarOpcoes() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add(SERIACAO_1.toString());
        opcoes.add(SERIACAO_2.toString());
        return opcoes;
    }
}
