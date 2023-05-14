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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListOfRawMaterialsController implements Initializable {

    @FXML
    private AnchorPane backButton;
    @FXML
    private ComboBox<?> materialTypeComboBox;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField deliveredTextField;
    @FXML
    private TextField deliveryReceivedTextField;
    @FXML
    private DatePicker deliveryDateDatePicker;
    @FXML
    private Label beforeShipmentLabel;
    @FXML
    private Label afterShipmentLabel;
    @FXML
    private Button updateButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
