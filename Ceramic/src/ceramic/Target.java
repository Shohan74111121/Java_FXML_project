package ceramic;

public class Target {
    
    private String month;
    private String year;
    private int target;
    private int productNumber;
    
    public Target(int productNumber, String month, String year, int target){
        this.month = month;
        this.productNumber = productNumber;
        this.year = year;
        this.target = target;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    
    
}
