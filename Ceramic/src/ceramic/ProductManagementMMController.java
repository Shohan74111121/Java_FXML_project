/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import ceramic.ProductOnSale;
import java.io.IOException;
import static java.lang.System.in;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nufis
 */
public class ProductManagementMMController implements Initializable {

    @FXML
    private TableView<ProductOnSale> tableView;
    @FXML
    private TableColumn<ProductOnSale, String> productName;
    @FXML
    private TableColumn<ProductOnSale, String> productType;
    @FXML
    private TableColumn<ProductOnSale, Float> productPrice;
    @FXML
    private TableColumn<ProductOnSale, Integer> productQuantity;
    
    @FXML
    private TextField InputProductPrice;

    @FXML
    private ChoiceBox<String> comboProductType;

    @FXML
    private TextField inputProductName;

    @FXML
    private TextField inputProductQuantity;

    private final ObservableList<String> Something1List = FXCollections.observableArrayList("Mug", "Teapot" , "Tile" , "Pottery", "PLate", "Bowl");
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productName.setCellValueFactory(new PropertyValueFactory<>("productNameString"));
        productPrice.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
        productQuantity.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        productType.setCellValueFactory(new PropertyValueFactory<>("productType"));
        comboProductType.setItems(Something1List);
    }    
    @FXML
    void SaveAndUpload(ActionEvent event) {
        //PopulateTableView();
    }
    public void PopulateTableView(ActionEvent event){
     String productName = inputProductName.getText();
     Float productPrice = Float.parseFloat(InputProductPrice.getText());
     Integer productQuantity = Integer.parseInt(inputProductQuantity.getText());
     String ProductType = comboProductType.getValue();
     
     ProductOnSale product = new ProductOnSale(productName, productPrice, productQuantity, ProductType);
    ObservableList<ProductOnSale> products = tableView.getItems();
    products.add(product);
    tableView.setItems(products);
    }
        @FXML
    void GoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(inputProductName.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }
   
}


