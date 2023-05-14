/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shohan
 */
public class Manager_detail_viewController implements Initializable {

     private salary_emp selectedsalary_emp;
    
    @FXML Label did;
    @FXML Label dname;    
    @FXML Label dsalary;
    @FXML Label ddept; 
    
    @FXML
    private Button go_back;
      
    @FXML
    public void initData(salary_emp p){
        selectedsalary_emp = p;
        did.setText(selectedsalary_emp.getId());
        dname.setText(selectedsalary_emp.getName());
        dsalary.setText(Double.toString(selectedsalary_emp.getSalary()));
        ddept.setText(selectedsalary_emp.getDept());
}
     @FXML
     private void go_back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hisgher_employee_salarylist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void homepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Homepage_OF_HR.fxml"));
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
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

}
