/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ceramic;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

/**
 * FXML Controller class
 *
 * @author Shohan
 */
public class Hisgher_employee_salarylistController implements Initializable {

   
    @FXML private TableView<salary_emp> tableView;
    
    @FXML private TableColumn<salary_emp, String> id;
    
    @FXML private TableColumn<salary_emp, String> name;
    
    @FXML private TableColumn<salary_emp, Double> salary;
    
    @FXML private TableColumn<salary_emp, String> dept;
    
    
    @FXML
    private TextField newid;

    @FXML
    private TextField newname;

    @FXML
    private TextField newsalary;
    
    @FXML
    private TextField newdept;

    @FXML
    private Button remove_employee_salary;
    
    @FXML
    private Button add_employee_salary;
    @FXML
    private Button detailed_view;

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<salary_emp,String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<salary_emp,String>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<salary_emp,Double>("salary"));
        dept.setCellValueFactory(new PropertyValueFactory<salary_emp,String>("dept"));
        
        tableView.setItems(getemployee());    
        
        //Allow first and last name to be edittable
        tableView.setEditable(true);
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        salary.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        dept.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // TODO
    } 
    public ObservableList<salary_emp> getemployee(){
        ObservableList<salary_emp> semployee = FXCollections.observableArrayList();
        semployee.add(new salary_emp("0001", "Shohan", 70000,"HR Manager"));
        semployee.add(new salary_emp("0002", "Shohan 2", 50000,"Accounts Manager"));
        semployee.add(new salary_emp("0003", "Shawkot", 68164,"Production Manager"));
        semployee.add(new salary_emp("0004", "KOMOL Da",85645, "Shipping Manager"));
        semployee.add(new salary_emp("0005", "Nafis", 56840,"Marketing Manager"));
        semployee.add(new salary_emp("0085", "Douch", 56815,"Fakibuj Manager"));
        return semployee;
    }

 
    
  
        
   
    //create a new salary_emp 
    @FXML
    public void addNewSalary(ActionEvent event) {
        salary_emp newSalaryEmp = new salary_emp(newid.getText(),
                                            newname.getText(),
                                            Double.parseDouble(newsalary.getText()),
                                            newdept.getText());
        tableView.getItems().add(0, newSalaryEmp);
        newid.setText(null);
        newname.setText(null);
        newsalary.setText(null);
        newdept.setText(null);
}


    
    //remove employee from list
    @FXML
    public void remove(ActionEvent event) {
        int selectedID = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(selectedID);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmed");
        alert.setHeaderText("Employee Deleted Successfully");
        alert.showAndWait();
    }


    
    //updating first name by clicking a corresponding table cell
    @FXML
    public void changeIDEvent(TableColumn.CellEditEvent edittedCell){
        salary_emp personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setId(edittedCell.getNewValue().toString());
    }
    
    //updating last name by clicking a corresponding table cell
    @FXML
    public void changeNameEvent(TableColumn.CellEditEvent edittedCell){
        salary_emp personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(edittedCell.getNewValue().toString());
    }
    
    
     @FXML
    public void changeSalaryEvent(TableColumn.CellEditEvent<salary_emp, Double> edittedCell){
        salary_emp personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setSalary(edittedCell.getNewValue());
    }
     @FXML
    public void changedeptEvent(TableColumn.CellEditEvent edittedCell){
        salary_emp personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setName(edittedCell.getNewValue().toString());
    }
   
    

//        pass selected row to detailed person view scene
@FXML
 private void detailedsalary_empView(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("manager_detail_view.fxml"));
    Parent personViewParent = loader.load();

    //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
    Scene personViewScene = new Scene(personViewParent);

    //access the controller
    Manager_detail_viewController controller = loader.getController();
    //controller = new salary_empViewSceneController();
    controller.initData(tableView.getSelectionModel().getSelectedItem());

    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(personViewScene);
    window.show();
    }

    @FXML
    private void homepage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Homepage_OF_HR.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
  
}
