package ceramic;

import static ceramic.ManagingDocument.getProductNamesFromBinary;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ManageDashBoardMMController implements Initializable{

    @FXML
    private TextArea ProductDetailsField;
    
    String productNameSelected = " ";
    public ObservableList list = FXCollections.observableArrayList();
    
    @FXML
    private Button finishedButton;

    @FXML
    private ListView<String> productList;

    @FXML
    void FinishedButtonPressed(ActionEvent event) {
        
    }
    
     

    @FXML
    void GoBack(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(finishedButton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            
    }
    @FXML
void RemoveButtonPressed(ActionEvent event) throws IOException {
    int selectedIndex = productList.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        productList.getItems().remove(selectedIndex);
        SavingProductDoc.removeProductFromBinary(productNameSelected);
        
    }
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productList.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
    if (newValue.intValue() >= 0) {
        productNameSelected = productList.getItems().get(newValue.intValue());
        // Do something with the selected product
        System.out.println("Selected product: " + productNameSelected);
    }
});
    }
    @FXML
    void ShowDocuments(ActionEvent event) {
        ArrayList<String> productNamesList = new ArrayList<>();
        String filePath = "ProductInfo.bin";
        productList.getItems().add("John Smith");
        productList.getItems().clear();
        try {
           productNamesList = getProductNamesFromBinary(filePath);
           list.addAll(productNamesList);
        } catch (IOException e) {
            System.out.println("Here lies the problem 2: Fucker" + e.getMessage());
        } 
        
        productList.getItems().addAll(list);
       
    }
    
     @FXML
    void OpenDocumentFile(ActionEvent event)  {
        String filePath = "ProductInfo.bin";
        try {
           String[] productNamesList = ManagingDocument.getProductInfoFromBinary(filePath, productNameSelected);
           ProductDetailsField.setText("Product Details: " +"\n" + productNamesList[0] +"\n" + "Product Price: " +"\n" + productNamesList[1]  +"\n" + "Product Quantity: " + "\n" + productNamesList[2] );
           
        } catch (IOException e) {
            System.out.println("Here lies the problem 3: " + e.getMessage());
        } 
    }
}
