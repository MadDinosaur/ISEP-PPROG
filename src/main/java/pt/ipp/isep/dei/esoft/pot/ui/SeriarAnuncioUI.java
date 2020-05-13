package pt.ipp.isep.dei.esoft.pot.ui;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;

public class SeriarAnuncioUI {

    private SeriarAnuncioController appController = new SeriarAnuncioController();
    @FXML
    private ComboBox<String> cmbBoxAnuncios;
    @FXML
    private Button btnClassificar;
    @FXML
    private Button btnAdicionarParticipante;

    @FXML
    private void classificar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ClassificarCandidaturasScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage classificarStage = new Stage();
            classificarStage.setScene(scene);

            ClassificarCandidaturasUI classificarUI = loader.getController();
            classificarUI.associarParentUI(this);

            classificarStage.show();
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    @FXML
    private void adicionarParticipante(ActionEvent event) {
    }
    
    @FXML
    private void preencherAnuncios(Event event) {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(appController.getAnunciosPorSeriar());
        cmbBoxAnuncios.setItems(options);
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
}
