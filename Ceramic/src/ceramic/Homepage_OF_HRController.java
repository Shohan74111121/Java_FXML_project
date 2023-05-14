/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shohan
 */
public class Homepage_OF_HRController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button add_new_emp;
    
    @FXML
    private Button staff;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
   @FXML
    private void AddnewEmployee(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add_new_Employee.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void exitingEmployee_list(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tableviewOfemployeelist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void Delete_employee(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("tableviewOfemployeelist.fxml"));
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
    
    @FXML
        private void staff_salarylist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("lower_employee_salarylist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
     @FXML
     private void managers_salarylist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hisgher_employee_salarylist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    private void sign_out(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
