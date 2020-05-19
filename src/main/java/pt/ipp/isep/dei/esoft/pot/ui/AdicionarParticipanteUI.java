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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;

/**
 * FXML Controller class
 *
 * @author bdian
 */
public class AdicionarParticipanteUI implements Initializable {

    private SeriarAnuncioController appController;
    private SeriarAnuncioUI seriarAnuncioUI;
    private int anuncioID;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnConfirmar;

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
    private void confirmar(ActionEvent event) {
        appController.addParticipante(anuncioID, txtEmail.getText());
        //FALTA VALIDAÇÃO
    }

    public void associarParentUI(SeriarAnuncioUI seriarAnuncioUI) {
        this.seriarAnuncioUI = seriarAnuncioUI;
        this.appController = seriarAnuncioUI.getAppController();
    }

    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        alerta.showAndWait();

        return alerta;
    }
}
