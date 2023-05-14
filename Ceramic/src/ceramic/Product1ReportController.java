
package ceramic;

import ceramic.Reports;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Product1ReportController implements Initializable {

    @FXML
    private Button yieldButton;
    @FXML
    private Label yieldLabel;
    @FXML
    private TextArea reportTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private Button backButton;
    @FXML
    private TextField producedTextField;
    @FXML
    private TextField matsTextField;
    @FXML
    private Label targetLabel;
    @FXML
    private ComboBox<String> yearComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
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
        
        ArrayList<String> years = new ArrayList<>();
        years.add("2020");
        years.add("2021");
        years.add("2022");
        years.add("2023");
        yearComboBox.getItems().addAll(years);
        yearComboBox.setOnAction((event) -> {
        String selectedYear = yearComboBox.getSelectionModel().getSelectedItem();
    });
        
        initializeReportsData();

    }    

    
    private void initializeReportsData(){
        File file = new File("ProductReports.bin");
        if (!file.exists()) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ArrayList<Reports> reports = new ArrayList<>();
            reports.add(new Reports(1, "January","2020",900,"A total of 900 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "February","2020",1000,"A total of 1000 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "March","2020",1300,"A total of 1300 pieces of this product was produced at a 87% yield rate"));
            reports.add(new Reports(1, "April","2020",1150,"A total of 1150 pieces of this product was produced at a 95% yield rate"));
            reports.add(new Reports(1, "May","2020",550,"A total of 550 pieces of this product was produced at a 79% yield rate"));
            reports.add(new Reports(1, "June","2020",75,"A total of 750 pieces of this product was produced at a 83% yield rate"));
            reports.add(new Reports(1, "July","2020",490,"A total of 490 pieces of this product was produced at a 98% yield rate"));
            reports.add(new Reports(1, "August","2020",600,"A total of 600 pieces of this product was produced at a 75% yield rate"));
            reports.add(new Reports(1, "September","2020",900,"A total of 900 pieces of this product was produced at a 90% yield rate"));
            reports.add(new Reports(1, "October","2020",950,"A total of 950 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "November","2020",1040,"A total of 1040 pieces of this product was produced at a 87% yield rate"));
            reports.add(new Reports(1, "December","2020",1450,"A total of 1450 pieces of this product was produced at a 85% yield rate"));
            reports.add(new Reports(1, "January","2021",900,"A total of 900 pieces of this product was produced at a 69% yield rate"));
            reports.add(new Reports(1, "February","2021",1820,"A total of 1820 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "March","2021",630,"A total of 630 pieces of this product was produced at a 90% yield rate"));
            reports.add(new Reports(1, "April","2021",400,"A total of 400 pieces of this product was produced at a 67% yield rate"));
            reports.add(new Reports(1, "May","2021",1020,"A total of 1020 pieces of this product was produced at a 85% yield rate"));
            reports.add(new Reports(1, "June","2021",670,"A total of 670 pieces of this product was produced at a 74% yield rate"));
            reports.add(new Reports(1, "July","2021",400,"A total of 400 pieces of this product was produced at a 80% yield rate"));
            reports.add(new Reports(1, "August","2021",780,"A total of 780 pieces of this product was produced at a 87% yield rate"));
            reports.add(new Reports(1, "September","2021",1200,"A total of 1200 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "October","2021",1470,"A total of 1470 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "November","2021",930,"A total of 930 pieces of this product was produced at a 87% yield rate"));
            reports.add(new Reports(1, "December","2021",600,"A total of 600 pieces of this product was produced at a 80% yield rate"));
            reports.add(new Reports(1, "January","2022",560,"A total of 560 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "February","2022",865,"A total of 865 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "March","2022",390,"A total of 390 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "April","2022",675,"A total of 675 pieces of this product was produced at a 75% yield rate"));
            reports.add(new Reports(1, "May","2022",1000,"A total of 1000 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "June","2022",860,"A total of 860 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "July","2022",245,"A total of 245 pieces of this product was produced at a 70% yield rate"));
            reports.add(new Reports(1, "August","2022",470,"A total of 470 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "September","2022",645,"A total of 645 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "October","2022",640,"A total of 640 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "November","2022",600,"A total of 600 pieces of this product was produced at a 75% yield rate"));
            reports.add(new Reports(1, "December","2022",430,"A total of 430 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "January","2023",710,"A total of 710 pieces of this product was produced at a 75% yield rate"));
            reports.add(new Reports(1, "February","2023",365,"A total of 365 pieces of this product was produced at a 91% yield rate"));
            reports.add(new Reports(1, "March","2023",260,"A total of 260 pieces of this product was produced at a 86% yield rate"));
            reports.add(new Reports(1, "April","2023",1140,"A total of 1140 pieces of this product was produced at a 95% yield rate"));
            oos.writeObject(reports);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }
    
    @FXML
    private void onYieldClick(ActionEvent event) throws FileNotFoundException, IOException {
    String month = monthComboBox.getSelectionModel().getSelectedItem();
    String year = yearComboBox.getSelectionModel().getSelectedItem();
    int produced = Integer.parseInt(producedTextField.getText());
    String fileName = "ProductTargets.bin";
    String fileMonth;
    String fileYear;
    int fileTarget;
    int fileProductNumber;
    int targetSet = 0;
    int yield;

    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        while (file.getFilePointer() < file.length()) {
            fileProductNumber = file.readInt();
            fileMonth = file.readUTF();
            fileYear = file.readUTF();
            fileTarget = file.readInt();
            
            if (fileMonth.equals(month) && fileYear.equals(year) && fileProductNumber == 1) {
                targetSet = fileTarget;
                break;
            }
        }
    }

    if (targetSet == 0) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Input");
        alert.setContentText("The target for the selected month and year is not set.");
        alert.showAndWait();
        return;
    }

    yield = produced / targetSet;
    yieldLabel.setText(Integer.toString(yield));
}
        
  
    
    @FXML
    private void onSubmitClick(ActionEvent event) throws FileNotFoundException, IOException {
    String month = monthComboBox.getSelectionModel().getSelectedItem();
    String year = yearComboBox.getSelectionModel().getSelectedItem();
    String fileName = "ProductReports.bin";
    String report = reportTextArea.getText();
    int mat = Integer.parseInt(matsTextField.getText());
    String matStr = "Materials Used: " + Integer.toString(mat);

    try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        while (file.getFilePointer() < file.length()) {
            int fileProductNumber = file.readInt();
            String fileMonth = file.readUTF();
            String fileYear = file.readUTF();
            int fileTarget = file.readInt();

            if (fileMonth.equals(month) && fileYear.equals(year)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Input");
                alert.setContentText("The report for that particular month already exists!");
                alert.showAndWait();
                return;
            }
        }

        file.seek(file.length());
        file.writeInt(1);
        file.writeUTF(month);
        file.writeUTF(year);
        file.writeUTF(report);
        file.writeUTF(matStr);
    }   
}

    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PSDash.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
    
}
