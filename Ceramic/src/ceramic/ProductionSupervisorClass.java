
package ceramic;

public class ProductionSupervisorClass {
    
     private String name;
    private String address;
    private String emailAddress;
    private String bloodGroup;
    private String doB;
    private String doJ;
    private int id;
    private float salary;
    private String contactNumber;
    
    
    ProductionSupervisorClass(String name, int id, String address, String emailAddress, String doB, String doJ, float salary, String bloodGroup, String contactNumber){
        
        this.name = name;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.emailAddress = emailAddress;
        this.doB = doB;
        this.doJ = doJ;
        this.id = id;
        this.salary = salary;
        this.contactNumber = contactNumber;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getDoJ() {
        return doJ;
    }

    public void setDoJ(String doJ) {
        this.doJ = doJ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
}