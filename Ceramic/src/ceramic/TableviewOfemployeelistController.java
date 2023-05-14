/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceramic;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Shohan
 */
public class TableviewOfemployeelistController implements Initializable {   
    
    
    @FXML
    private TableView<Employee> employee_table;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> contact;

    @FXML
    private TableColumn<Employee, LocalDate> dob;

    @FXML
    private TableColumn<Employee, LocalDate> doj;

    @FXML
    private TableColumn<Employee, Double> salary;
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        id.setCellValueFactory(new PropertyValueFactory<>("new_id"));
//        name.setCellValueFactory(new PropertyValueFactory<>("name"));
//        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
//        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
//        doj.setCellValueFactory(new PropertyValueFactory<>("doj"));
//        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
//
//        // load Employee object from file and add to TableView
//        try {
//            FileInputStream fileIn = new FileInputStream("employee.bin");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            Employee employee = (Employee) in.readObject();
//            employee_table.getItems().add(employee);
//            in.close();
//            fileIn.close();
//        } catch (IOException i) {
//            i.printStackTrace();
//        } 
//        catch (ClassNotFoundException c) {
//            System.out.println("Employee class not found");
//            c.printStackTrace();
//        }
//    }
    
    
    
    
@Override
public void initialize(URL url, ResourceBundle rb) {
    id.setCellValueFactory(new PropertyValueFactory<>("new_id"));
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
    doj.setCellValueFactory(new PropertyValueFactory<>("doj"));
    salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    
   
    
//    // load employees from file and add to TableView
//    try {
//        FileInputStream fileIn = new FileInputStream("employee.bin");
//        ObjectInputStream in = new ObjectInputStream(fileIn);
//        List<Employee> employees = new ArrayList<>();
//        while (fileIn.available() > 0) {
//            Employee employee = (Employee) in.readObject();
//            employees.add(employee);
//        }
//        in.close();
//        fileIn.close();
//        
//        // sort employees by ID
//        employees.sort(Comparator.comparing(Employee::getNew_id));
//        
//        // add employees to TableView
//        ObservableList<Employee> employeeList = FXCollections.observableArrayList(employees);
//        employee_table.setItems(employeeList);
//    }
//    catch (IOException | ClassNotFoundException e) {
//        e.printStackTrace();
//    }
//}

    // load Employee objects from file and add to TableView
    try {
        FileInputStream fileIn = new FileInputStream("employee.bin");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Employee employee;
        while ((employee = (Employee) in.readObject())!= null) {
            employee_table.getItems().add(employee);
        }
        in.close();
        fileIn.close();
    } 
    catch (EOFException e) {
        // end of file reached, do nothing
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}

    @FXML
    private void onDeleteClicked() {
        // get selected Employee object and remove from TableView
        Employee employee = employee_table.getSelectionModel().getSelectedItem();
        if (employee != null) {
            employee_table.getItems().remove(employee);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Confirmed");
            alert.setHeaderText("Employee Deleted Successfully");
            alert.showAndWait();
        }
    }

    @FXML
    private void onEditClicked() {
        // get selected Employee object and show edit dialog
        Employee employee = employee_table.getSelectionModel().getSelectedItem();
        if (employee != null) {
            // show edit dialog
        }
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
      private void Go_back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add_new_Employee.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}



