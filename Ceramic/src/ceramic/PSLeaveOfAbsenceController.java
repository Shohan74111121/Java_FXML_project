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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PSLeaveOfAbsenceController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private TextField emergencyContactNumberTextField;
    @FXML
    private DatePicker leaveStartDatePicker;
    @FXML
    private DatePicker leaveEndDatePicker;
    @FXML
    private Label label;
    @FXML
    private Button applyButton;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    int id = Integer.parseInt(idTextField.getText());
    String name = nameTextField.getText();
    String reason = reasonTextArea.getText();
    String number = emergencyContactNumberTextField.getText();
    LocalDate selectedDate = leaveStartDatePicker.getValue(); 
    LocalDate selectedDate2 = leaveEndDatePicker.getValue();
    
    String startDate = selectedDate.toString();
    String endDate = selectedDate2.toString();
    
    
    
    @FXML
private void onApplyClick(ActionEvent event) {
    int iD = Integer.parseInt(idTextField.getText());
    String names = nameTextField.getText();
    String reasons = reasonTextArea.getText();
    String numbers = emergencyContactNumberTextField.getText();
    LocalDate selectedDates = leaveStartDatePicker.getValue();
    LocalDate selectedDate2s = leaveEndDatePicker.getValue();

    String startDates = selectedDates.toString();
    String endDates = selectedDate2s.toString();

    String labelText = "Name: " + names + "\n" + "ID: " + iD + "\n" + "Start Date: " + startDates + "\n" + "End Date: " + endDates + "\n" + "Reason: " + reasons + "\n" + "Contact Number: " + numbers + "\n" + "Applied for leave successfully!";

    label.setText(labelText);
}

    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PSPersonalInfoDisplay.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    
}
