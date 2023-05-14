/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Nufis
 */
public class HomepageMSController implements Initializable {

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
    private void SignOutButtonPressed(ActionEvent event) {
    }

    @FXML
    private void ProfileButtonPressed(ActionEvent event) {
    }

    @FXML
    private void ProductDetailButtonPressed(ActionEvent event) {
    }

    @FXML
    private void MeetingButtonPressed(ActionEvent event) {
    }

    @FXML
    private void TaskButtonPressed(ActionEvent event) {
    }
    private void ShowProfileName(){
        userName.setText(UserCredentials.currentUsername);
    }
}
