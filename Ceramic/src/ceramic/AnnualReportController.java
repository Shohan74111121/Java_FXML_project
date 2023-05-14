package ceramic;

import ceramic.AnnualReportSubmissionController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class AnnualReportController implements Initializable {

    @FXML
    private AnchorPane backButton;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private LineChart<String, Integer> productLineChart;
    @FXML
    private Label reportLabel;
    @FXML
    private TableView<Integer> annualTable;
    @FXML
    private Button generateButton;
    @FXML

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void onGenerateClick(ActionEvent event) throws FileNotFoundException, IOException{
        String fileName2 = "ProductReports.bin";
        String fileName = "ProductTargets.bin";
        int targetSumP1 = 0;
        int targetSumP2 = 0;
        int targetSumP3 = 0;
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
        
    XYChart.Series<String, Integer> product1Series = new XYChart.Series<>();
    XYChart.Series<String, Integer> product2Series = new XYChart.Series<>();
    XYChart.Series<String, Integer> product3Series = new XYChart.Series<>();

    product1Series.setName("Product 1");
    product2Series.setName("Product 2");
    product3Series.setName("Product 3");
    product1Series.getData().add(new XYChart.Data<>("Target", targetSumP1));
    product1Series.getData().add(new XYChart.Data<>("Produced", producedSumP1));
    product2Series.getData().add(new XYChart.Data<>("Target", targetSumP2));
    product2Series.getData().add(new XYChart.Data<>("Produced", producedSumP2));
    product3Series.getData().add(new XYChart.Data<>("Target", targetSumP3));
    product3Series.getData().add(new XYChart.Data<>("Produced", producedSumP3));

    productLineChart.getData().clear();
    productLineChart.getData().addAll(product1Series, product2Series, product3Series);
}
    @FXML
    private void onBackClick(MouseEvent event) {
        
    }
    
}
