package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;

public class RegistoOrganizacoes {

    private List<Organizacao> listaOrganizacoes;

    public RegistoOrganizacoes() {
        this.listaOrganizacoes = new ArrayList<>();
    }

    public RegistoOrganizacoes(List<Organizacao> listaOrganizacoes) {
        this.listaOrganizacoes = listaOrganizacoes;
    }

    public void getOrganizacaoByEmailUtilizador(String email) {
    }
}
