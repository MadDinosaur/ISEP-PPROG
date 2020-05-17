/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnOK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).close();
    }

    @FXML
    private void OKAction(ActionEvent event) {
    }
    
    public void associarParentUI(ClassificarCandidaturasUI classificarCandidaturaUI) {
        this.classificarCandidaturaUI = classificarCandidaturaUI;
        this.appController = classificarCandidaturaUI.getAppController();
    }
    
}
