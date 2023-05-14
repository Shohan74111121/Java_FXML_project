/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;


import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int new_id;
    private String contact;
    private LocalDate dob;
    private LocalDate doj;
    private double salary;

    public Employee(String name, int new_id, String contact, LocalDate dob, LocalDate doj, double salary) {
        this.name = name;
        this.new_id = new_id;
        this.contact = contact;
        this.dob = dob;
        this.doj = doj;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNew_id() {
        return new_id;
    }

    public void setNew_id(int new_id) {
        this.new_id = new_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

   

}