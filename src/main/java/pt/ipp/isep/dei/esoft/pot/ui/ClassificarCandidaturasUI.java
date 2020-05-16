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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
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
    private Button btnVoltar;
    @FXML
    private ComboBox<?> cmbBoxSeriacao;
    @FXML
    private ListView<String> lstViewCandidaturas;
    @FXML
    private Button btnValidar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void associarParentUI(SeriarAnuncioUI seriarAnuncioUI) {
        this.seriarAnuncioUI = seriarAnuncioUI;
        this.appController = seriarAnuncioUI.getAppController();
    }

    @FXML
    private void preencherCmbBoxSeriacao(Event event) {
    }

    public void preencherLista(int anuncioID) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(appController.getCandidaturas(anuncioID));
        lstViewCandidaturas.setItems(items);
    }

    @FXML
    private void voltar(ActionEvent event) {
        ((Stage) btnVoltar.getScene().getWindow()).close();
    }

    @FXML
    private void validar(ActionEvent event) {
        //fazer copy paste da coisa
    }

}
