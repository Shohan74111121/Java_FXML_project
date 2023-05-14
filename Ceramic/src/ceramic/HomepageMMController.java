/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceramic;

import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nafis
 */
public class HomepageMMController implements Initializable {

    @FXML
    private Button signOutButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button createDocumentButton;
    @FXML
    private Button managingDocumentButton;
    
    @FXML
    private Label userName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowProfileName();
    }    

    @FXML
    private void SignOutButtonClicked(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource( "Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void ProfileButtonClicked(ActionEvent event) {
        /*String filePath = "ProductInfo.bin";
        try {
            ManagingDocument.PrintProductFromBinary(filePath);
        } catch (IOException e) {
            System.out.println("Error printing products from binary file: " + e.getMessage());
        }*/
        
    }

    @FXML
    private void CreateDocumentsButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "DocumentCreateMM.fxml"));
                Scene scene = new Scene(root, 850, 600);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void ManagaingDocumentButtonClicked(ActionEvent event) throws IOException {
        
        
           Parent root = FXMLLoader.load(getClass().getResource( "ManageDashBoardMM.fxml"));
        
                Scene scene = new Scene(root, 850, 600);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
    @FXML
    private void TaskManagemenntButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "AssigningTaskMM.fxml"));
                Scene scene = new Scene(root, 850, 600);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
    @FXML
    void MeetingScheduleButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "MeetingMM.fxml"));
                Scene scene = new Scene(root, 850, 600);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
      @FXML
    void ProductManagementButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "ProductManagementMM.fxml"));
                Scene scene = new Scene(root, 850, 600);
                Stage stage = (Stage)(signOutButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
    
    private void ShowProfileName(){
        userName.setText(UserCredentials.currentUsername);
    }
}
