/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PMLeaveOfAbsenceController implements Initializable {

    @FXML
    private Button applyButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField reasonTextField;
    @FXML
    private TextField emergencyContactNumberTextField;
    @FXML
    private DatePicker leaveStartDatePicker;
    @FXML
    private DatePicker leaveEndDatePicker;
    @FXML
    private TextField idTextField;
    @FXML
    private Button backButton;
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    int id = Integer.parseInt(idTextField.getText());
    String name = nameTextField.getText();
    String reason = reasonTextField.getText();
    String number = emergencyContactNumberTextField.getText();
    LocalDate selectedDate = leaveStartDatePicker.getValue(); 
    LocalDate selectedDate2 = leaveEndDatePicker.getValue();
    
    String startDate = selectedDate.toString();
    String endDate = selectedDate2.toString();
    
    
    
    @FXML
private void onApplyClick(ActionEvent event) {
    int id = Integer.parseInt(idTextField.getText());
    String name = nameTextField.getText();
    String reason = reasonTextField.getText();
    String number = emergencyContactNumberTextField.getText();
    LocalDate selectedDate = leaveStartDatePicker.getValue();
    LocalDate selectedDate2 = leaveEndDatePicker.getValue();

    String startDate = selectedDate.toString();
    String endDate = selectedDate2.toString();

    String labelText = "Name: " + name + "\n" + "ID: " + id + "\n" + "Start Date: " + startDate + "\n" + "End Date: " + endDate + "\n" + "Reason: " + reason + "\n" + "Contact Number: " + number + "\n" + "Applied for leave successfully!";

    label.setText(labelText);
}

    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PMdash.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
