/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bdian
 */
public class ClassificarCandidaturasUI implements Initializable {
    private SeriarAnuncioUI seriarAnuncioUI;
    @FXML
    private TextArea txtCandidaturas;
    @FXML
    private TextField txtClassificacao;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnProximo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void associarParentUI(SeriarAnuncioUI seriarAnuncioUI) {
        this.seriarAnuncioUI = seriarAnuncioUI;
    }
}
