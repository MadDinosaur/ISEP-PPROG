
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;


class ListaColaboradores {
    private ArrayList<Colaborador> listaColaboradores;
    
    public ListaColaboradores() {
        this.listaColaboradores = new ArrayList<>();
    }
    
    public void getColaboradores() {
        
    }
    
    public void getColaboradorByEmail(String email) {
        
    }
    
    public boolean add(Colaborador colab) {
        return listaColaboradores.add(colab);
    }
}
