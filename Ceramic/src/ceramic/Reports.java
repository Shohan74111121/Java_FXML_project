
package ceramic;

public class Reports {
    private String month;
            private String year;
            private int productNumber;
            private String report;
            private int produced;
            
            public Reports(int productNumber,String month, String year, int produced, String report){
                this.productNumber = productNumber;
                this.month = month;
                this.year = year;
                this.report = report;
                this.produced = produced;
            }

            public int getProduced() {
                return produced;
            }

            public void setProduced(int produced) {
                this.produced = produced;
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

            public int getProductNumber() {
                return productNumber;
            }

            public void setProductNumber(int productNumber) {
                this.productNumber = productNumber;
            }

            public String getReport() {
                return report;
            }

            public void setReport(String report) {
                this.report = report;
            }
}
