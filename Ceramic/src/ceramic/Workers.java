
package ceramic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Workers {
    private String name;
        private String department;
        private int id;
        private String emergencyContact;
        
        public Workers(String name, int id, String department, String emergencyContact){
            this.name = name;
            this.id = id;
            this.department = department;
            this.emergencyContact = emergencyContact;
            
        }

    public Workers() {
    }

        
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmergencyContact() {
            return emergencyContact;
        }

        public void setEmergencyContact(String emergencyContact) {
            this.emergencyContact = emergencyContact;
        }       
        
        public void initializeWorkerList() throws FileNotFoundException, IOException {
        File file = new File("ListOfWorkers.bin");
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file, true); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                ArrayList<Workers> workers = new ArrayList<>();
                workers.add(new Workers("Abul Karim", 2571,"Production","01723-531456"));
                workers.add(new Workers("Aminul Islam", 1923,"Production","01712-543210"));
                workers.add(new Workers("Sabina Khatun", 3578,"Production","01987-654321"));
                workers.add(new Workers("Mohammad Rahim Khan", 4865,"Production","01654-123456"));
                workers.add(new Workers("Tanvir Ahmed", 6097,"Production","01876-987654"));
                workers.add(new Workers("Sania Hasan", 7241,"Production","01543-210987"));
                workers.add(new Workers("Farhana Khan", 8356,"Production","01345-678901"));
                workers.add(new Workers("Jahidul Islam", 9520,"Production","01432-109876"));
                workers.add(new Workers("Noor Alam", 0634,"Production","01678-765432"));
                workers.add(new Workers("Farida Begum", 1789,"Production","01923-456789"));
                oos.writeObject(workers);
                oos.close();
                fos.close();
            }catch (IOException e) {
            e.printStackTrace();
        }
        }
        }
}
