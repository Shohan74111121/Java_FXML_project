/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import static ceramic.UserCredentials.LoginVerification3;
import ceramic.TaskInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nufis
 */
public class AssigningTaskMMController implements Initializable {
    
     @FXML
    private ListView<String> employeeList;
    @FXML
    private TextArea taskDescAreaText;
    @FXML
    private TextField taskTitleTextField;
    @FXML
    private DatePicker DateAssignedTask;

    String employeeNameSelected = " ";
    public ObservableList list = FXCollections.observableArrayList();
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    ShowList();
    employeeList.getSelectionModel().selectedIndexProperty().addListener((observable , oldValue, newValue)-> {
    if (newValue.intValue() >= 0){
        employeeNameSelected = employeeList.getItems().get(newValue.intValue());
        System.out.println("Selected Employee" + employeeNameSelected);
    }
    });
         
    }

    @FXML
    private void GoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(taskTitleTextField.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void AddMoreEmployeeButtonPressed(ActionEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList<TaskInfo> tasks = null;
    try {
        tasks = TaskWriteInBinary.ReadTasksFromBinary();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }   

        for (TaskInfo task : tasks) {
        System.out.println("Employee Name: " + task.getName());
        System.out.println("Task Title: " + task.getTitle());
        System.out.println("Task Detail: " + task.getDetail());
        System.out.println("Assigned Date: " + task.getDate());
        }
    }
    @FXML
    private void PostTaskButtonPressed(ActionEvent event) throws IOException {
        PostTaskInfo();
    }
    
    private void ShowList(){
    employeeList.getItems().add("John Smith");
    employeeList.getItems().clear();

    try {
        ArrayList<String> userAccounts = LoginVerification3();
        list.addAll(userAccounts);
    } catch (Exception e) {
        System.out.println("Error getting user accounts: " + e.getMessage());
    }
    employeeList.getItems().addAll(list);        
    }
  
    private void PostTaskInfo() throws IOException {
        
        String employeeName = employeeNameSelected;
        String taskTitle = taskTitleTextField.getText();
        String taskDesc = taskDescAreaText.getText();
        LocalDate assignedDate = DateAssignedTask.getValue();
        TaskWriteInBinary.WriteTasksInBinary(employeeName, taskTitle, taskDesc, assignedDate);
    
}
}
