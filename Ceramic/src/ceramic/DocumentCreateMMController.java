/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceramic;

import ceramic.SavingProductDoc;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nafis
 */
public class DocumentCreateMMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private Button goBack;

    @FXML
    private TextArea product_desc;

    @FXML
    private TextField product_name;

    @FXML
    private Button profile_scene;

    @FXML
    private Button signout_Scene;
    
    @FXML
    private Label labelSuccess;
    
    @FXML
    private TextField product_price;
    
    @FXML
    private TextField product_quantity;
    
     @FXML
    void SubmitButtonPressed(ActionEvent event)  {
        SavingProductDoc createDoc = new SavingProductDoc();
        float price = Float.parseFloat(product_price.getText());
        try {
            createDoc.WriteProductToBinaryFile("ProductInfo", product_name.getText(), product_desc.getText(), Float.parseFloat(product_price.getText()),  Integer.parseInt(product_quantity.getText()));
        } catch (IOException ex) {
            Logger.getLogger(DocumentCreateMMController.class.getName()).log(Level.SEVERE, null, ex);
        }
        product_name.setText("");
        product_desc.setText("");
        product_price.setText("");
        product_quantity.setText("");
        labelSuccess.setVisible(true);
    }
    @FXML
    void BackButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(product_name.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
    
}
