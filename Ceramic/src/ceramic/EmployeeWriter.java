/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceramic;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Shohan
 */
class EmployeeWriter {
    private final List<Employee> employees;

    public EmployeeWriter(List<Employee> employees) {
        this.employees = employees;
    }
    public void writeToFile(String filename) throws IOException {
        
    try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
        for (Employee employee : employees) {
            out.writeInt(employee.getNew_id());
            out.writeUTF(employee.getName());
            out.writeUTF(employee.getContact());
            out.writeUTF(employee.getDob().toString());
            out.writeUTF(employee.getDoj().toString());
            out.writeDouble(employee.getSalary());
        }
    }
}
    
}
