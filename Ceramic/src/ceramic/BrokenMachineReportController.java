/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class BrokenMachineReportController implements Initializable {

    @FXML
    private TextArea reportTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private ComboBox<?> machineTypeComboBox;
    @FXML
    private ComboBox<?> productComboBox;
    @FXML
    private DatePicker dateOfBreakdownDatePicker;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
