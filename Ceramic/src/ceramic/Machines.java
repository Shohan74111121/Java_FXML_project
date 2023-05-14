/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

/**
 *
 * @author Lenovo
 */
public class Machines {
    private String usedFor;
        private String broken;
        private String breakdownDate;
        private String type;
        private int machineID;
    
    public Machines(int machineID, String usedFor, String broken, String breakdownDate, String type){
        this.usedFor = usedFor;
        this.machineID = machineID;
        this.broken = broken;
        this.breakdownDate = breakdownDate;
        this.type = type;
    }

        public String getUsedFor() {
            return usedFor;
        }

        public void setUsedFor(String usedFor) {
            this.usedFor = usedFor;
        }

        public String getBroken() {
            return broken;
        }

        public void setBroken(String broken) {
            this.broken = broken;
        }

        public String getBreakdownDate() {
            return breakdownDate;
        }

        public void setBreakdownDate(String breakdownDate) {
            this.breakdownDate = breakdownDate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getMachineID() {
            return machineID;
        }

        public void setMachineID(int machineID) {
            this.machineID = machineID;
        }
}
