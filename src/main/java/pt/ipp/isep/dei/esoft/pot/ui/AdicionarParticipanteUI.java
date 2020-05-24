package pt.ipp.isep.dei.esoft.pot.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;

/**
 * Classe que controla a janela de inserção de e-mail do Participante a
 * adicionar ao Processo de Seriação
 */
public class AdicionarParticipanteUI implements Initializable {

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
     * O campo de texto para inserir o e-mail
     */
    @FXML
    private TextField txtEmail;
    /**
     * O botão para cancelar a operação
     */
    @FXML
    private Button btnCancelar;
    /**
     * O botão para confirmar a operação
     */
    @FXML
    private Button btnConfirmar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Cancela a operação e fecha a janela
     *
     * @param event
     */
    @FXML
    private void cancelar(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).close();
    }

    /**
     * Confirma a operação e fecha a janela
     *
     * @param event
     */
    @FXML
    private void confirmar(ActionEvent event) {
        try {
            appController.addParticipante(anuncioID, txtEmail.getText());
            criarAlerta(Alert.AlertType.INFORMATION, "Participante adicionado com sucesso!", "");
            ((Stage) btnConfirmar.getScene().getWindow()).close();
        } catch (NullPointerException e) {
            criarAlerta(Alert.AlertType.ERROR, "E-mail não existente!",
                    "O participante que pretende adicionar não está registado.\n"
                    + "Por favor insira novamente o e-mail.");
        }
    }
    /**
     * Define a ativação/desativação do botão de confirmação conforme o conteúdo
     * do campo de texto
     *
     * @param event
     */
    @FXML
    private void triggerBtnConfirmar(KeyEvent event) {
        if (!txtEmail.getText().isEmpty()) {
            btnConfirmar.setDisable(false);
        }
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
     * @param anuncioID
     */
    public void associarAnuncio(int anuncioID) {
        this.anuncioID = anuncioID;
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
