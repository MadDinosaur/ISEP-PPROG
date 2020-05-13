package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

class ListaColaboradores {
    /**
     * Lista de Colaboradores de uma dada Organizacao
     */
    private ArrayList<Colaborador> listaColaboradores;
    /**
     * Cria um objeto da classe ListaColaboradores, com um ArrayList vazio.
     */
    public ListaColaboradores() {
        this.listaColaboradores = new ArrayList<>();
    }

    public void getColaboradores() {
    }

    /**
     * Retorna o Colaborador com o e-mail especificado
     *
     * @param email o e-mail do colaborador
     * @return o Colaborador
     */
    public Colaborador getColaboradorByEmail(String email) {
        for (Colaborador colab : listaColaboradores) {
            if (colab.getEmail().equals(email)) {
                return colab;
            }
        }
        return null;
    }

    /**
     * Adiciona um Colaborador à lista
     *
     * @param colab o Colaborador a adicionar
     * @return true se bem sucedido, false caso contrário
     */
    public boolean adicionarColaborador(Colaborador colab) {
        return listaColaboradores.add(colab);
    }
}
