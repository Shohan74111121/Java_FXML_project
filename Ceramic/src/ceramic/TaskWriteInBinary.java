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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nufis
 */
public class TaskWriteInBinary {
    public static void WriteTasksInBinary(String employeeName , String taskTitle, String taskDetail, LocalDate assingedDate) throws FileNotFoundException, IOException{
    String fileName = "EmployeeTasks";
    String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";
    ArrayList<TaskInfo> taskList = new ArrayList<>();
    
    File file = new File(filePath);
    if (file.exists()){
        AddTaskToBinary(employeeName, taskTitle, taskDetail, assingedDate);
    }
    else{
        taskList.add(new TaskInfo(employeeName, taskTitle, taskDetail, assingedDate));
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(taskList);
        outputStream.close();
        System.err.println("binary file has been Created");
    }
    
    }
    
    public static void  AddTaskToBinary(String employeeName , String taskTitle, String taskDetail, LocalDate assingedDate) throws FileNotFoundException, IOException{
       ArrayList<TaskInfo> taskInfos = new ArrayList<>();
       String fileName = "EmployeeTasks";
       String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";
       
       ObjectInputStream  inputStream = new ObjectInputStream(new FileInputStream (filePath));
       try {
           taskInfos = (ArrayList<TaskInfo>) inputStream.readObject();
           taskInfos.add(new TaskInfo(employeeName, taskTitle, taskDetail, assingedDate));
           
       } catch (ClassNotFoundException ex) { 
            Logger.getLogger(TaskWriteInBinary.class.getName()).log(Level.SEVERE, null, ex);
        } 
       inputStream.close();
       ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(taskInfos);
        outputStream.close();
        System.err.println("binary file has been Added");
    }
    
    public static ArrayList<TaskInfo> ReadTasksFromBinary() throws FileNotFoundException, IOException, ClassNotFoundException {

        String fileName = "EmployeeTasks";
        String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";

        ArrayList<TaskInfo> taskList = new ArrayList<>();

        // If binary file exists, read its contents
        File file = new File(filePath);
        if (file.exists()) {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            try {
                taskList = (ArrayList<TaskInfo>) inputStream.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + e.getMessage());
                
            }
            inputStream.close();
        } else {
            // If binary file doesn't exist, return an empty list
            System.err.println("NUll tasks");
            taskList = new ArrayList<>();
        }

        return taskList;
    }
}



class TaskInfo implements Serializable {
    private final String employeeName;
    private final String taskTitle;
    private final String taskDetails;
    private final LocalDate assignedDate;

    public TaskInfo(String employee_name, String task_title, String task_detail, LocalDate assigned_date) {
        this.employeeName = employee_name;
        this.taskTitle = task_title;
        this.taskDetails = task_detail;
        this.assignedDate = assigned_date;
    }

    public String getName() {
        return employeeName;
    }

    public String getTitle() {
        return taskTitle;
    }
    public String getDetail(){
        return taskDetails;
    }
    public LocalDate getDate(){
        return assignedDate;
    }
    

    
}