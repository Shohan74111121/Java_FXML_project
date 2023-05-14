package ceramic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnnualReportSubmissionController implements Initializable {

    @FXML
    private LineChart<String, Integer> product123LineChart;
    @FXML
    private Label product1Label;
    @FXML
    private Label product2Label;
    @FXML
    private Label product3Label;
    @FXML
    private Button backButton;
    @FXML
    private TextArea reportTextArea;
    @FXML
    private Button submitButton;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private Label targetP1Label;
    @FXML
    private Label targetP2Label;
    @FXML
    private Label targetP3Label;
    @FXML
    private Button generateButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String fileName = "ProductTargets.bin";
        int targetSumP1 = 0;
        int targetSumP2 = 0;
        int targetSumP3 = 0;
        
        ArrayList<String> years = new ArrayList<>();
        years.add("2020");
        years.add("2021");
        years.add("2022");
        years.add("2023");
        yearComboBox.getItems().addAll(years);
        yearComboBox.setOnAction((event) -> {
        String selectedYear = yearComboBox.getSelectionModel().getSelectedItem();
    });
        
        String year = yearComboBox.getSelectionModel().getSelectedItem();
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        while (file.getFilePointer() < file.length()) {
            String fileYear = file.readUTF();
            int fileTarget = file.readInt();
            int fileProductNumber = file.readInt();

            if (fileYear.equals(year) && fileProductNumber == 1) {
                targetSumP1 += fileTarget;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 2){
                targetSumP2 += fileTarget;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 3){
                targetSumP3 += fileTarget;
                break;
                }
            }
        targetP1Label.setText(String.valueOf(targetSumP1));
        targetP2Label.setText(String.valueOf(targetSumP2));
        targetP3Label.setText(String.valueOf(targetSumP3));
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnnualReportSubmissionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnnualReportSubmissionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        String fileName2 = "ProductReports.bin";
        int producedSumP1 = 0;
        int producedSumP2 = 0;
        int producedSumP3 = 0;
        
        try (RandomAccessFile file = new RandomAccessFile(fileName2, "rw")) {
        while (file.getFilePointer() < file.length()) {
            String fileYear = file.readUTF();
            int fileProduced = file.readInt();
            int fileProductNumber = file.readInt();

            if (fileYear.equals(year) && fileProductNumber == 1) {
                producedSumP1 += fileProduced;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 2){
                producedSumP2 += fileProduced;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 3){
                producedSumP3 += fileProduced;
                break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnnualReportSubmissionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AnnualReportSubmissionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        product1Label.setText(Integer.toString(producedSumP1));
        product2Label.setText(Integer.toString(producedSumP2));
        product3Label.setText(Integer.toString(producedSumP3));
    }    

    @FXML
    private void onGenerateClick(ActionEvent event) throws FileNotFoundException, IOException{
        
        String fileName2 = "ProductReports.bin";
        String fileName = "ProductTargets.bin";
        int targetSumP1 = 0;
        int targetSumP2 = 0;
        int targetSumP3 = 0;
        String year = yearComboBox.getSelectionModel().getSelectedItem();
        
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
        while (file.getFilePointer() < file.length()) {
            int fileProductNumber = file.readInt();
            String fileMonth = file.readUTF();
            String fileYear = file.readUTF();
            int fileTarget = file.readInt();
            

            if (fileYear.equals(year) && fileProductNumber == 1) {
                targetSumP1 += fileTarget;
            }
            if(fileYear.equals(year) && fileProductNumber == 2){
                targetSumP2 += fileTarget;
            }
            if(fileYear.equals(year) && fileProductNumber == 3){
                targetSumP3 += fileTarget;
                }
            }
        System.out.println(targetSumP1);
        }
        
        
        int producedSumP1 = 0;
        int producedSumP2 = 0;
        int producedSumP3 = 0;
        
        try (RandomAccessFile file = new RandomAccessFile(fileName2, "rw")) {
        while (file.getFilePointer() < file.length()) {
            String fileYear = file.readUTF();
            int fileProduced = file.readInt();
            int fileProductNumber = file.readInt();

            if (fileYear.equals(year) && fileProductNumber == 1) {
                producedSumP1 += fileProduced;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 2){
                producedSumP2 += fileProduced;
                break;
            }
            if(fileYear.equals(year) && fileProductNumber == 3){
                producedSumP3 += fileProduced;
                break;
                }
            }
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

    @FXML
    private void onSubmitClick(ActionEvent event) throws FileNotFoundException, IOException {
        
        String report = reportTextArea.getText();
        String year = yearComboBox.getSelectionModel().getSelectedItem();
        
        class AnnualReport implements java.io.Serializable{
            private String year;
            private String reports;
            
            AnnualReport(String year, String reports){
                this.year = year;
                this.reports = reports;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public String getReports() {
                return reports;
            }

            public void setReports(String reports) {
                this.reports = reports;
            }
            
        }
        
        File file = new File("AnnualReports.bin");
        if (!file.exists()) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ArrayList<AnnualReport> annualReports = new ArrayList<>();
            annualReports.add(new AnnualReport(year, report));
            oos.writeObject(annualReports);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }
}
