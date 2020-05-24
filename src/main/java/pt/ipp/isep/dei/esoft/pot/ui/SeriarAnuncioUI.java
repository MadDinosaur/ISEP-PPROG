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

    /**
     * Objeto da classe Controller da interface gráfica
     */
    private SeriarAnuncioController appController = new SeriarAnuncioController();
    /**
     * A Combo Box para seleção do Anuncio
     */
    @FXML
    private ComboBox<String> cmbBoxAnuncios;
    /**
     * Botão que inicia um processo de seriação de Candidaturas Espoleta a
     * interface gráfica ClassificarCandidaturasUI
     */
    @FXML
    private Button btnClassificar;
    /**
     * Botão que inicia um processo de adição de Participante Espoleta a
     * interface gráfica AdicionarParticipanteUI
     */
    @FXML
    private Button btnAdicionarParticipante;

    /**
     * Abre a janela de classificação de candidaturas
     *
     * @param event
     */
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
            classificarUI.associarAnuncio(appController.getIdFromString(cmbBoxAnuncios.getValue()));
            if (classificarUI.preencherLista()) {
                classificarStage.show();
            }
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    /**
     * Abre a janela de adição de participante
     *
     * @param event
     */
    @FXML
    private void adicionarParticipante(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdicionarParticipanteScene.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage addParticipanteStage = new Stage();
            addParticipanteStage.setScene(scene);

            AdicionarParticipanteUI addParticipanteUI = loader.getController();
            addParticipanteUI.associarParentUI(this);
            addParticipanteUI.associarAnuncio(appController.getIdFromString(cmbBoxAnuncios.getValue()));

            addParticipanteStage.show();
        } catch (IOException ex) {
            criarAlerta(Alert.AlertType.ERROR, "Erro", ex.getMessage());
        }
    }

    /**
     * Preenche a Combo Box de seleção do anúncio com as respetivas opções
     *
     * @param event
     */
    @FXML
    private void preencherAnuncios(Event event) {
        atualizar();
    }

    /**
     * Define a ativação/desativação dos botões conforme a seleção ativa da
     * Combo Box
     *
     * @param event
     */
    @FXML
    private void triggerBtn(ActionEvent event) {
        btnAdicionarParticipante.setDisable(false);
        btnClassificar.setDisable(false);
    }

    /**
     * Atualiza a informação acerca dos anúncios disponíveis para seleção e
     * ativa/desativa os botões conforme a seleção que está ativa
     */
    public void atualizar() {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(appController.getAnunciosPorSeriar());
        cmbBoxAnuncios.setItems(options);

        btnAdicionarParticipante.setDisable(true);
        btnClassificar.setDisable(true);
    }

    /**
     * Retorna o objeto da classe Controller da interface gráfica
     *
     * @return o objeto da classe SeriarAnuncioController
     */
    public SeriarAnuncioController getAppController() {
        return appController;
    }

    /**
     * Gera uma janela de confirmação/aviso/erro
     *
     * @param tipoAlerta o tipo de janela a mostrar
     * @param cabecalho o texto no cabeçalho da janela
     * @param mensagem o texto no corpo da janela
     * @return o Alerta
     */
    private Alert criarAlerta(Alert.AlertType tipoAlerta, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoAlerta);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        alerta.showAndWait();

        return alerta;
    }

}
