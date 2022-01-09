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
 * Classe que controla a janela de seleção do tipo de seriação das Candidaturas
 */
public class ClassificarCandidaturasUI implements Initializable {

    /**
     * Objeto da classe Controller da interface gráfica
     */
    private SeriarAnuncioController appController;
    /**
     * Objeto da classe SeriarAnuncioUI da interface gráfica
     */
    private SeriarAnuncioUI seriarAnuncioUI;
    /**
     * O nº de identificação do anúncio
     */
    private int anuncioID;
    /**
     * O botão para cancelar a operação
     */
    @FXML
    private Button btnVoltar;
    /**
     * A Combo Box para seleção do tipo de seriação
     */
    @FXML
    private ComboBox<String> cmbBoxSeriacao;
    /**
     * A Lista para visualização das candidaturas do Anuncio
     */
    @FXML
    private ListView<String> lstViewCandidaturas;
    /**
     * O botão para confirmar a operação
     */
    @FXML
    private Button btnValidar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Associa à classe o Controller e janela-mãe correspondentes
     *
     * @param seriarAnuncioUI a classe que controla a interface gráfica que faz
     * a ligação a esta classe
     */
    public void associarParentUI(SeriarAnuncioUI seriarAnuncioUI) {
        this.seriarAnuncioUI = seriarAnuncioUI;
        this.appController = seriarAnuncioUI.getAppController();
    }

    /**
     * Associa à classe o nº de identificação do Anuncio correpondente
     *
     * @param anuncioID o nº de identificação do Anuncio
     */
    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
    }

    /**
     * Preenche a lista de visualização de candidaturas com a informação
     * respetiva
     *
     * @return false se não existirem candidaturas para visualizar, true caso
     * contrário
     */
    public boolean preencherLista() {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(appController.getCandidaturas(anuncioID));
        lstViewCandidaturas.setItems(items);

        if (items.isEmpty()) {
            criarAlerta(Alert.AlertType.WARNING, "Sem Candidaturas!", "Ainda não existem candidaturas para este anúncio.");
            return false;
        }
        return true;
    }

    /**
     * Preenche a Combo Box de seleção do tipo de seriação com as respetivas
     * opções
     *
     * @param event o clique do utilizador na Combo Box
     */
    @FXML
    private void preencherCmbBoxSeriacao(Event event) {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll(appController.getSeriacoes());
        cmbBoxSeriacao.setItems(options);
    }

    /**
     * Cancela a operação e fecha a janela
     *
     * @param event o clique do utilizador no botão
     */
    @FXML
    private void voltar(ActionEvent event) {
        ((Stage) btnVoltar.getScene().getWindow()).close();
    }

    /**
     * Confirma a operação e fecha a janela
     *
     * @param event o clique do utilizador no botão
     */
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

    /**
     * Define a ativação/desativação do botão de confirmação conforme a seleção
     * na ComboBox
     *
     * @param event o clique do utilizador na Combo Box
     */
    @FXML
    private void triggerBtnValidar(ActionEvent event) {
        btnValidar.setDisable(false);
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
     * Retorna o Stage da classe
     *
     * @return o Stage
     */
    public Stage getStage() {
        return (Stage) btnValidar.getScene().getWindow();
    }

    /**
     * Retorna o objeto da classe SeriarAnuncioUI associado à classe
     *
     * @return a classe que controla a janela-mãe
     */
    public SeriarAnuncioUI getParent() {
        return seriarAnuncioUI;
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
