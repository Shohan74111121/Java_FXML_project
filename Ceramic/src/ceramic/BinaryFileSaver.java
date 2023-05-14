/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceramic;

import static ceramic.BinaryFileSaver.writeUserAccountsToBinaryFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author nafis
 */
public class BinaryFileSaver {
    
    
    public static void writeUserAccountsToBinaryFile(ArrayList<UserAccount> userAccounts) throws IOException {
     
     String filePath = System.getProperty("user.dir") + "/NewUsers"  + ".bin";
      try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
        outputStream.writeObject(userAccounts);
    } catch (IOException e) {
        System.out.println("Error writing binary file: " + e.getMessage());
        throw e;
    }
  }
    
    public void CreateBinaryFile() throws IOException{
         ArrayList<UserAccount> userAccounts = new ArrayList<>();
          userAccounts.add(new UserAccount("Nafis", "123", "Marketing Manager"));
          userAccounts.add(new UserAccount("Fuad", "222", "Marketing Staff"));
          userAccounts.add(new UserAccount("Sifan", "333", "Marketing Staff"));
          userAccounts.add(new UserAccount("Mark", "444", "Marketing Staff"));
          userAccounts.add(new UserAccount("Komol", "345", "Shipment and Delivery Manager"));
          userAccounts.add(new UserAccount("Shohan", "123", "Human Resources"));
          userAccounts.add(new UserAccount("Ronol", "123", "Account Manager"));
          userAccounts.add(new UserAccount("Shawkat", "123", "Production Manager"));
          userAccounts.add(new UserAccount("Shaw", "123", "Production Supervisor"));
          
          writeUserAccountsToBinaryFile(userAccounts);
  }
}

class UserAccount implements java.io.Serializable {
  private String username;
  private String password;
  private String verificationCode;

  public UserAccount(String username, String password, String verificationCode) {
    this.username = username;
    this.password = password;
    this.verificationCode = verificationCode;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getVerificationCode() {
    return verificationCode;
  }
  
  
}
