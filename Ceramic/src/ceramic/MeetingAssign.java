/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Nufis
 */
public class MeetingAssign {
    public static void WriteMeetingToBinaryFile(String meetingTag, String meetingTime, LocalDate meetingDate , String meetingRoom) throws IOException {
    
    String fileName = "Meeting";
    String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";
    
    ArrayList<MeetingInfo> meetingList = new ArrayList<>();

    // Check if file exists
    File file = new File(filePath);
    if (file.exists()) {
        // If file exists, add the product to the binary file
        AddMeetingToBinary(meetingTag, meetingTime, meetingDate, meetingRoom);
    } else {
        // If file does not exist, create a new binary file and add the product
        meetingList.add(new MeetingInfo(meetingTag, meetingTime, meetingDate, meetingRoom));
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(meetingList);
        outputStream.close();
        System.err.println("binary file has been Created");
    }
}

public static void AddMeetingToBinary(String meetingTag, String meetingTime, LocalDate meetingDate , String meetingRoom) throws IOException {
    ArrayList<MeetingInfo> meetingList = new ArrayList<>();
    String fileName = "Meeting";
    String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
    try {
        meetingList = (ArrayList<MeetingInfo>) inputStream.readObject();
        meetingList.add(new MeetingInfo(meetingTag, meetingTime, meetingDate, meetingRoom));
    } catch (ClassNotFoundException e) {
        System.out.println("Error reading binary file: " + e.getMessage());
        throw new IOException("Error reading binary file: " + e.getMessage());
    }
    inputStream.close();

    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
    outputStream.writeObject(meetingList);
    outputStream.close();
    System.err.println("binary file has been added");
}
public static ArrayList<MeetingInfo> ReadMeetingFromBinary() throws FileNotFoundException, IOException, ClassNotFoundException {

        String fileName = "Meeting";
        String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";

        ArrayList<MeetingInfo> meetingList = new ArrayList<>();

        // If binary file exists, read its contents
        File file = new File(filePath);
        if (file.exists()) {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            try {
                meetingList = (ArrayList<MeetingInfo>) inputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + e.getMessage());
                meetingList = new ArrayList<>();
            }
            inputStream.close();
        } else {
            // If binary file doesn't exist, return an empty list
            System.err.println("NUll meetingLists");
            
        }

        return meetingList;
    }
    
}


class MeetingInfo implements Serializable {
    private final String meeting_tag;
    private final String meeting_time;
    private final LocalDate meeting_date;
    private final String meeting_room;

    public MeetingInfo(String meetingTag, String meetingTime, LocalDate meetingDate, String meetingRoom) {
        this.meeting_tag = meetingTag;
        this.meeting_time = meetingTime;
        this.meeting_date = meetingDate;
        this.meeting_room = meetingRoom;
    }

    public String getTag() {
        return meeting_tag;
    }

    public String getTime() {
        return meeting_time;
    }
    public LocalDate getDate(){
        return meeting_date;
    }
    public String getRoom(){
        return meeting_room;
    }
}