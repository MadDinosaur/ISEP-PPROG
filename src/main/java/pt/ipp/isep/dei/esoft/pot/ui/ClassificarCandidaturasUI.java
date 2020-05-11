/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;

/**
 * FXML Controller class
 *
 * @author bdian
 */
public class ClassificarCandidaturasUI implements Initializable {
    private SeriarAnuncioController appController;
    private SeriarAnuncioUI seriarAnuncioUI;
    @FXML
    private TextArea txtCandidaturas;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnProximo;
    @FXML
    private ComboBox<?> cmbBoxSeriacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void associarParentUI(SeriarAnuncioUI seriarAnuncioUI) {
        this.seriarAnuncioUI = seriarAnuncioUI;
        this.appController = seriarAnuncioUI.getAppController();
    }

    @FXML
    private void preencherCmbBoxSeriacao(Event event) {
    }
}
