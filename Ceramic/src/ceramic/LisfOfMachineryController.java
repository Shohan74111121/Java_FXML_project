
package ceramic;

import ceramic.Machines;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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

public class LisfOfMachineryController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<Machines> machineListTableView;
    @FXML
    private TableColumn<Machines, Integer> idColumn;
    @FXML
    private TableColumn<Machines, String> usedForColumn;
    @FXML
    private TableColumn<Machines, String> brokenColumn;
    @FXML
    private TableColumn<Machines, String> dateColumn;
    @FXML
    private TableColumn<Machines, String> typeColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        usedForColumn.setCellValueFactory(new PropertyValueFactory<>("Used For"));
        brokenColumn.setCellValueFactory(new PropertyValueFactory<>("Broken"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("Date of Breakdown"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        
        try {
            initializeMachinesData();
        } catch (IOException ex) {
            Logger.getLogger(LisfOfMachineryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeMachinesData() throws IOException {
        
        File file = new File("ListOfMachines.bin");
        if (!file.exists()) {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ArrayList<Machines> machines = new ArrayList<>();
            machines.add(new Machines(4287, "Product 1", "No", "-", "Kilns"));
            machines.add(new Machines(1459, "Product 2","Yes","20/06/2023","Spray Booth"));
            machines.add(new Machines(3901, "Product 3","No","-","Ball Mill"));
            machines.add(new Machines(4581, "Product 2","No","-","Extruder"));
            machines.add(new Machines(2598, "Product 2","No","-","Extruder"));
            machines.add(new Machines(1296, "Product 1","No","-","Ball Mill"));
            machines.add(new Machines(6529, "Product 3","Yes","28/05/2023","Kiln"));
            machines.add(new Machines(3683, "Product 1","No","-","Spray Booth"));
            machines.add(new Machines(4572, "Product 1","No","-","Pottery Wheel"));
            machines.add(new Machines(1348, "Product 3","No","-","Kiln"));
            machines.add(new Machines(1235, "Product 3","No","-","Ball Mill"));
            machines.add(new Machines(3951, "Product 2","No","-","Spray Booth"));
            machines.add(new Machines(3501, "Product 1","Yes","07/03/2023","Extruder"));
            machines.add(new Machines(5932, "Product 3","No","-","Pottery Wheel"));
            machines.add(new Machines(6941, "Product 2","No","-","Pottery Wheel"));
            oos.writeObject(machines);
            oos.close();
            fos.close();
            machineListTableView.setItems(FXCollections.observableArrayList(machines));
        }
        
    }
    
    @FXML
    private void onBackClicks(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PMdash.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    
}
