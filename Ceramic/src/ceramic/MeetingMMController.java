/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import ceramic.MeetingAssign;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nufis
 */
public class MeetingMMController implements Initializable {

    @FXML
    private DatePicker meetingDate;
    @FXML
    private TextField meetingTag;
    @FXML
    private TextField meetingTime;
    @FXML
    private Button meetingbutton;
    @FXML
    private TextField meetingRoom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void SubmitMeetingButtonPressed(ActionEvent event) throws IOException {
        PostMeeting();
    }
    @FXML
    void GoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource( "HomepageMM.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)(meetingbutton.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    void SignOut(ActionEvent event) {
        ArrayList<MeetingInfo> meetings = new ArrayList<>();
    try {
        meetings = MeetingAssign.ReadMeetingFromBinary();
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }   

        for (MeetingInfo meeting : meetings) {
        System.out.println("Meeting Tag: " + meeting.getTag());
        System.out.println("Meeting Time : " + meeting.getTime());
        System.out.println("Date : " + meeting.getDate());
        System.out.println("Room : " + meeting.getRoom());
        }
    }
    private  void PostMeeting() throws IOException{
        String meeting_tag = this.meetingTag.getText();
        String meeting_time = this.meetingTime.getText();
        LocalDate meeting_date = this.meetingDate.getValue();
        String meeting_room = this.meetingRoom.getText();
        MeetingAssign.WriteMeetingToBinaryFile(meeting_tag, meeting_time, meeting_date, meeting_room);
    }
}
