/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;


import ceramic.Machines;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
public class PMmachinereportsController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<Machines> machineReportTable;
    @FXML
    private TableColumn<Machines, String> machineIDColumn;
    @FXML
    private TableColumn<Machines, String> usedForColumn;
    @FXML
    private TableColumn<Machines, String> brokenColumn;
    @FXML
    private TableColumn<Machines, String> breakdownDateColumn;
    @FXML
    private TableColumn<Machines, String> typeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        machineIDColumn.setCellValueFactory(new PropertyValueFactory<>("machineID"));
        usedForColumn.setCellValueFactory(new PropertyValueFactory<>("usedFor"));
        brokenColumn.setCellValueFactory(new PropertyValueFactory<>("broken"));
        breakdownDateColumn.setCellValueFactory(new PropertyValueFactory<>("breakdownDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        populateTableWithData();
    }

    private void populateTableWithData() {
        File file = new File("ListOfMachines.bin");

        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {

                ArrayList<Machines> machines = (ArrayList<Machines>) ois.readObject();
                machineReportTable.getItems().addAll(machines);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfMachinery.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
