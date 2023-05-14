/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;


import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Add_new_EmployeeController implements Initializable {

    private static void AddProductToBinary(String filePath, String name, int new_id, String contact, LocalDate dob, LocalDate doj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @FXML
    private TextField name;

    @FXML
    private TextField new_id;

    @FXML
    private TextField contact;

    @FXML
    private DatePicker dob;

    @FXML
    private DatePicker doj;

    @FXML
    private TextField salary;
    
    private final List<Employee> employees = null;

    
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set default values
        dob.setValue(LocalDate.now().minusYears(18)); // set default DOB to 18 years ago
        doj.setValue(LocalDate.now());
        name.setText(null);
        new_id.setText(null);
        contact.setText(null);
        dob.setValue(null);
        doj.setValue(null);
        salary.setText(null);
    }


 @FXML
private void onSaveClicked(ActionEvent event) {
    // get input values
    String nameValue = name.getText();
    int newIdValue = Integer.parseInt(new_id.getText());
    String contactValue = contact.getText();
    LocalDate dobValue = dob.getValue();
    LocalDate dojValue = doj.getValue();
    double salaryValue = Double.parseDouble(salary.getText());
    name.setText(null);
    new_id.setText(null);
    contact.setText(null);
    dob.setValue(null);
    doj.setValue(null);
    salary.setText(null);
    
    // create new Employee object
    Employee employee = new Employee(nameValue, newIdValue, contactValue, dobValue, dojValue, salaryValue);
    
    // save Employee object to file
    try {
        FileOutputStream fileOut = new FileOutputStream("employee.bin", true); // append to the file
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(employee);
        out.close();
        fileOut.close();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmed");
        alert.setHeaderText("Employee Saved Successfully");
        alert.showAndWait();
    } catch (IOException i) {
        i.printStackTrace();
    }
    
}
   
    

 
//@FXML
//private void onSaveClicked(ActionEvent event) {
//    // get input values
//    String nameValue = name.getText();
//    int newIdValue = Integer.parseInt(new_id.getText());
//    String contactValue = contact.getText();
//    LocalDate dobValue = dob.getValue();
//    LocalDate dojValue = doj.getValue();
//    double salaryValue = Double.parseDouble(salary.getText());
//    name.setText(null);
//    new_id.setText(null);
//    contact.setText(null);
//    dob.setValue(null);
//    doj.setValue(null);
//    salary.setText(null);
//    // create new Employee object
//    Employee employee = new Employee(nameValue,newIdValue, contactValue,dobValue,dojValue,salaryValue);
//    
//    // save Employee object to file
//    try {
//        FileOutputStream fileOut = new FileOutputStream("employee.bin", true); // append to the file
//        ObjectOutputStream out = new ObjectOutputStream(fileOut);
//        
//        out.writeObject(employee);
////        out.writeBytes("\n");
//        out.close();
//        fileOut.close();
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.setTitle("Confirmed");
//        alert.setHeaderText("Employee Saved Successfully");
//        alert.showAndWait();
//    }
//    catch (IOException i) {
//        i.printStackTrace();
//    }
//}

    @FXML
    private void homepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Homepage_OF_HR.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
        @FXML
        private void go_to_employelist(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("tableviewOfemployeelist.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

