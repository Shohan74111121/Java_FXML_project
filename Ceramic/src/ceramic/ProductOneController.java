
package ceramic;

import ceramic.Target;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductOneController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private TextField targetTextField;
    @FXML
    private Button backButton;
    @FXML
    private TextField yearTextField;
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    File file = new File("ProductTargets.bin");
    if (!file.exists()) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ArrayList<Target> targets = new ArrayList<>();
            targets.add(new Target(1, "January", "2020", 1050));
            targets.add(new Target(1, "February", "2020", 1100));
            targets.add(new Target(1,"March", "2020", 1500));
            targets.add(new Target(1,"April", "2020", 1200));
            targets.add(new Target(1,"May", "2020", 700));
            targets.add(new Target(1,"June", "2020", 900));
            targets.add(new Target(1,"July", "2020", 500));
            targets.add(new Target(1,"August", "2020", 800));
            targets.add(new Target(1,"September", "2020", 1000));
            targets.add(new Target(1,"October", "2020", 1100));
            targets.add(new Target(1,"November", "2020", 1200));
            targets.add(new Target(1,"December", "2020", 1700));
            targets.add(new Target(1,"January", "2021", 1300));
            targets.add(new Target(1,"February", "2021", 2000));
            targets.add(new Target(1,"March", "2021", 700));
            targets.add(new Target(1,"April", "2021", 600));
            targets.add(new Target(1,"May", "2021", 1200));
            targets.add(new Target(1,"June", "2021", 800));
            targets.add(new Target(1,"July", "2021", 500));
            targets.add(new Target(1,"August", "2021", 900));
            targets.add(new Target(1,"September", "2021", 1400));
            targets.add(new Target(1,"October", "2021", 1300));
            targets.add(new Target(1,"November", "2021", 1070));
            targets.add(new Target(1,"December", "2021", 750));
            targets.add(new Target(1,"January", "2022", 650));
            targets.add(new Target(1,"February", "2022", 950));
            targets.add(new Target(1,"March", "2022", 450));
            targets.add(new Target(1,"April", "2022", 900));
            targets.add(new Target(1,"May", "2022", 1100));
            targets.add(new Target(1,"June", "2022", 1000));
            targets.add(new Target(1,"July", "2022", 350));
            targets.add(new Target(1,"August", "2022", 550));
            targets.add(new Target(1,"September", "2022", 750));
            targets.add(new Target(1,"October", "2022", 700));
            targets.add(new Target(1,"November", "2022", 800));
            targets.add(new Target(1,"December", "2022", 500));
            targets.add(new Target(1,"January", "2023", 950));
            targets.add(new Target(1,"February", "2023", 400));
            targets.add(new Target(1,"March", "2023", 300));
            targets.add(new Target(1,"April", "2023", 1200));
            oos.writeObject(targets);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> months = new ArrayList<String>();
    months.add("January");
    months.add("February");
    months.add("March");
    months.add("April");
    months.add("May");
    months.add("June");
    months.add("July");
    months.add("August");
    months.add("September");
    months.add("October");
    months.add("November");
    months.add("December");
    
    monthComboBox.getItems().addAll(months);
    monthComboBox.setOnAction((event) -> {
        String selectedMonth = monthComboBox.getSelectionModel().getSelectedItem();
    });
}    
    

    @FXML
    private void onSetTargetClick(ActionEvent event) throws IOException {
    String fileName = "ProductTargets.bin";
    String selectedMonth = monthComboBox.getSelectionModel().getSelectedItem();
    String year = yearTextField.getText();
    int target = Integer.parseInt(targetTextField.getText());
    
    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        while (file.getFilePointer() < file.length()) {
            String month = file.readUTF();
            String fileYear = file.readUTF();
            int fileTarget = file.readInt();
            int fileProduct = file.readInt();
                    
            if (month.equals(selectedMonth) && fileYear.equals(year) && fileProduct != 1) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Input");
                alert.setContentText("Wrong product number or Target for that particular month already exists!");
                alert.showAndWait();
                return;
            }
        }

        file.seek(file.length());
        file.writeInt(1);
        file.writeUTF(selectedMonth);
        file.writeUTF(year);
        file.writeInt(target);
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
