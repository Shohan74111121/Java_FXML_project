/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nufis
 */
public class UserCredentials {
   
    public String temptempPassword;
    public boolean loggedIn;
    public static String currentUsername;
    public void LoginVerification2(String _Name, String _Password, String _UserType){
    String filePath = System.getProperty("user.dir") + "/NewUsers"  + ".bin";
     try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
        
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<UserAccount> userAccounts = (ArrayList<UserAccount>) ois.readObject();
        ois.close();

        
        for (UserAccount userAccount : userAccounts) {
            if (userAccount.getUsername().equals(_Name) &&
                    userAccount.getPassword().equals(_Password) &&
                    userAccount.getVerificationCode().equals(_UserType)) {
                System.out.println("Login successful!");
                currentUsername = userAccount.getUsername();
                System.out.println(currentUsername);
                loggedIn = true;
                break;
            }
            else{
              System.out.println("password input : " + _Password );  
            }
        }

        if (!loggedIn) {
            System.out.println("Invalid username, password, or verification code. Please try again.");
            
        }
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        }
{
        
    }
}
    public static ArrayList<String> LoginVerification3() throws FileNotFoundException, IOException{
    ArrayList<UserAccount> userList = null ;
    String filePath = System.getProperty("user.dir") + "/NewUsers"  + ".bin";
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath)); 
        try {
            userList = (ArrayList<UserAccount>)inputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        }
        inputStream.close();
    
    
    ArrayList<String> userAccounts = new ArrayList<>();
        for (UserAccount user : userList) {
            if (user.getVerificationCode().equals("Marketing Staff")){
            userAccounts.add(user.getUsername());
            }
    }
        System.err.println(userAccounts);
        return userAccounts;

}
}