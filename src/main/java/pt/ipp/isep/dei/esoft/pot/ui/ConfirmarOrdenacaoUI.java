/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;

/**
 * FXML Controller class
 *
 * @author Francisco
 */
public class ConfirmarOrdenacaoUI implements Initializable {
    
    private SeriarAnuncioController appController;
    
    private ClassificarCandidaturasUI classificarCandidaturaUI;

    private int anuncioID;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnOK;
    @FXML
    private ListView<String> lstViewCandidaturas;
    @FXML
    private ListView<String> lstViewParticipantes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).close();
    }

    @FXML
    private void OKAction(ActionEvent event) {
        //Atualizar a lista de anúncios disponíveis para seriar
        classificarCandidaturaUI.getParent().atualizar();
        //Fechar janela de confirmação
        ((Stage) btnOK.getScene().getWindow()).close();
        //Fechar janela de escolha de seriação
        classificarCandidaturaUI.getStage().close();
    }
    
    public void associarParentUI(ClassificarCandidaturasUI classificarCandidaturaUI) {
        this.classificarCandidaturaUI = classificarCandidaturaUI;
        this.appController = classificarCandidaturaUI.getAppController();
    }
    
    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
    }
    
    public void preencherListas() {
        //Mostra a lista dos candidatos
        ObservableList<String> candList = FXCollections.observableArrayList();
        candList.addAll(appController.classifica(anuncioID));
        lstViewCandidaturas.setItems(candList);
        //Mostra a lista dos participantes
        ObservableList<String> partList = FXCollections.observableArrayList();
        partList.addAll(appController.getParticipantes(anuncioID));
        lstViewParticipantes.setItems(partList);
    }
}
