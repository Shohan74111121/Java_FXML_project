package ceramic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ceramic.UserCredentials;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nufis
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginName;
    @FXML
    private PasswordField loginPassword;
    @FXML
    private ChoiceBox<String> employeeList;
    private ObservableList<String> Something1List = FXCollections.observableArrayList("Marketing Manager", "Marketing Staff" , "Human Resources" , "Account Manager" , "Shipment and Delivery Manager", "Shipment and Delivery Staff","Production Manager", "Production Supervisor");
    @FXML
    public Button submitButton;
    
    @FXML
    private Button registerEmployee;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeList.setItems(Something1List);
        
        
        
    }    
    @FXML
    void LoginSubmitClicked(ActionEvent event) throws IOException {
         //System.out.println(loginName.getText() + "and" + loginPassword.getText() );
         UserCredentials tempLogin = new UserCredentials();
         tempLogin.LoginVerification2(loginName.getText(), loginPassword.getText(), employeeList.getValue());
         if (tempLogin.loggedIn){
             SceneChanger();
             tempLogin.loggedIn = false;
         }
    }
    @FXML
    void RegisterButtonPressed(ActionEvent event) throws IOException {
          BinaryFileSaver savingData = new BinaryFileSaver();
          savingData.CreateBinaryFile();
    }
    
    public void SceneChanger(){
        
        try {
            String tempSceneName = employeeList.getValue();
            if (tempSceneName.equals("Marketing Manager")) {
                Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            else if (tempSceneName.equals("Marketing Staff")){
                Parent root = FXMLLoader.load(getClass().getResource( "HomepageMS.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            else if (tempSceneName.equals("Human Resources")){
                Parent root = FXMLLoader.load(getClass().getResource( "Homepage_OF_HR.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            else if (tempSceneName.equals("Account Manager")){
                Parent root = FXMLLoader.load(getClass().getResource( "HomePage_of_Account_Manager.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            else if (tempSceneName.equals("Production Manager")){
                Parent root = FXMLLoader.load(getClass().getResource( "PMdash.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            else if (tempSceneName.equals("Production Supervisor")){
                Parent root = FXMLLoader.load(getClass().getResource( "PSDash.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(loginName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    
}
}