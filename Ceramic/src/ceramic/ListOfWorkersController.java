/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class ListOfWorkersController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<Workers> workerTable;
    @FXML
    private TableColumn<Workers, String> nameColumn;
    @FXML
    private TableColumn<Workers, Integer> idColumn;
    @FXML
    private TableColumn<Workers, String> departmentColumn;
    @FXML
    private TableColumn<Workers, String> emergencyContactColumn;

    private ObservableList<Workers> workersList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String file = "ListOfWorkers.bin";
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        emergencyContactColumn.setCellValueFactory(new PropertyValueFactory<>("emergencyContact"));
        workerTable.getColumns().addAll(nameColumn, departmentColumn, idColumn, emergencyContactColumn);
        
        initializeWorkerList();
        
        String fileName = "ListOfWorkers.bin";
        
        try (FileInputStream fis = new FileInputStream(fileName);
         ObjectInputStream ois = new ObjectInputStream(fis)) {

        List<Workers> workers = (List<Workers>) ois.readObject();

        workersList = FXCollections.observableArrayList(workers);
        workerTable.setItems(workersList);

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    }
    
    private void initializeWorkerList() {
        Workers workers = new Workers();
        try {
            workers.initializeWorkerList();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
