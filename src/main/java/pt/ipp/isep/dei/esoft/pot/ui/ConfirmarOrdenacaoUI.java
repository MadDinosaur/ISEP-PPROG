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
 * Classe que controla a janela de confirmação da seriação das Candidaturas
 */
public class ConfirmarOrdenacaoUI implements Initializable {

    /**
     * Objeto da classe Controller da interface gráfica
     */
    private SeriarAnuncioController appController;
    /**
     * Objeto da classe ClassificarCandidaturasUI da interface gráfica
     */
    private ClassificarCandidaturasUI classificarCandidaturaUI;
    /**
     * O nº de identificação do anúncio
     */
    private int anuncioID;
    /**
     * O botão para cancelar a operação
     */
    @FXML
    private Button btnCancelar;
    /**
     * O botão para confirmar a operação
     */
    @FXML
    private Button btnOK;
    /**
     * A Lista para visualização das candidaturas seriadas do Anuncio
     */
    @FXML
    private ListView<String> lstViewCandidaturas;
    /**
     * A Lista para visualização dos Participantes na seriação do Anuncio
     */
    @FXML
    private ListView<String> lstViewParticipantes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Cancela a operação e fecha a janela
     *
     * @param event
     */
    @FXML
    private void cancelar(ActionEvent event) {
        appController.limpaProcessoSeriacao(anuncioID);
        ((Stage) btnCancelar.getScene().getWindow()).close();
    }

    /**
     * Confirma a operação e fecha a janela
     *
     * @param event
     */
    @FXML
    private void OKAction(ActionEvent event) {
        //Atualizar a lista de anúncios disponíveis para seriar
        classificarCandidaturaUI.getParent().atualizar();
        //Fechar janela de confirmação
        ((Stage) btnOK.getScene().getWindow()).close();
        //Fechar janela de escolha de seriação
        classificarCandidaturaUI.getStage().close();
    }

    /**
     * Associa à classe o Controller e janela-mãe correspondentes
     *
     * @param classificarCandidaturaUI a classe que controla a interface gráfica
     * que faz a ligação a esta classe
     */
    public void associarParentUI(ClassificarCandidaturasUI classificarCandidaturaUI) {
        this.classificarCandidaturaUI = classificarCandidaturaUI;
        this.appController = classificarCandidaturaUI.getAppController();
    }

    /**
     * Associa à classe o nº de identificação do Anuncio correpondente
     *
     * @param anuncioID
     */
    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
    }

    /**
     * Preenche as listas de visualização de candidaturas e participantes com a
     * informação respetiva
     *
     */
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
