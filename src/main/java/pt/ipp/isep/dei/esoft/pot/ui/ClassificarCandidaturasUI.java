/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private int anuncioID;
    @FXML
    private Button btnVoltar;
    @FXML
    private ComboBox<String> cmbBoxSeriacao;
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

    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
    }

    public void preencherLista() {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(appController.getCandidaturas(anuncioID));
        lstViewCandidaturas.setItems(items);
    }

    @FXML
    private void preencherCmbBoxSeriacao(Event event) {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(appController.getSeriacoes());
        cmbBoxSeriacao.setItems(options);
    }

    @FXML
    private void voltar(ActionEvent event) {
        ((Stage) btnVoltar.getScene().getWindow()).close();
    }

    @FXML
    private void validar(ActionEvent event) {
        appController.registaProcessoSeriacao(anuncioID, cmbBoxSeriacao.getValue());

        //Carrega próxima janela
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConfirmarOrdenacaoScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage confirmarOrdenacaoStage = new Stage();
            confirmarOrdenacaoStage.setScene(scene);

            ConfirmarOrdenacaoUI confirmarOrdenacaoUI = loader.getController();
            confirmarOrdenacaoUI.associarParentUI(this);
            confirmarOrdenacaoUI.associarAnuncio(anuncioID);
            confirmarOrdenacaoUI.preencherListas();

            confirmarOrdenacaoStage.show();
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    public SeriarAnuncioController getAppController() {
        return appController;
    }

    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        alerta.showAndWait();

        return alerta;
    }
    public Stage getStage() {
        return (Stage) btnValidar.getScene().getWindow();
    }
    public SeriarAnuncioUI getParent() {
        return seriarAnuncioUI;
    }
}
