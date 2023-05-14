/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import ceramic.ProductionSupervisorClass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class PSPersonalInfoDisplayController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label dateOfJoiningLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label bloodGroupLabel;
    @FXML
    private Label contactNumberLabel;
    @FXML
    private Button leaveOfAbsenceApplyButton;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProductionSupervisorClass p = new ProductionSupervisorClass("Obaidul Qader", 69323, "Hosue no-19, Block-G, Bashundhara Residential Area, Dhaka","obaiduldoes69@gmail.com","09/06/1997","01/06/2021", (float) 3500.69,"AB+","01935123540");
        nameLabel.setText(p.getName());
        idLabel.setText(String.valueOf(p.getId()));
        dateOfBirthLabel.setText(p.getDoB());
        dateOfJoiningLabel.setText(p.getDoJ());
        addressLabel.setText(p.getAddress());
        emailLabel.setText(p.getEmailAddress());
        salaryLabel.setText(String.valueOf(p.getSalary()));
        bloodGroupLabel.setText(p.getBloodGroup());
        contactNumberLabel.setText(p.getContactNumber());
    }

    @FXML
    private void onLeaveOfAbsenceClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PSLeaveOfAbsence.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
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
