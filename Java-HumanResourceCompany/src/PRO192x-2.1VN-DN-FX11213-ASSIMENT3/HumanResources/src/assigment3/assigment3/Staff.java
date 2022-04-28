package assigment3;

import java.util.Date;

public abstract class Staff implements ICalculator {
    private String emplyeeId;
    private String employeeName;
    private int employeeAge;
    private double employeeCoefficient;
    private Date employeeDate;
    private String department;
    private int employeeLeave;
    private int salary;

    public Staff() {

    }

    public Staff(String id, String n, int a, double c, String de, Date dw, int l) {
        emplyeeId = id;
        employeeName = n;
        employeeAge = a;
        employeeCoefficient = c;
        employeeDate = dw;
        department = de;
        employeeLeave = l;
    }

    // public abstract double calculateSalary();
    public abstract void displayInformation();

    public String getId() {
        return emplyeeId;
    }

    public String getName() {
        return employeeName;
    }

    public int getAge() {
        return employeeAge;
    }

    public double getCoefficient() {
        return employeeCoefficient;
    }

    public Date getDate() {
        return employeeDate;
    }

    public String getDepartment() {
        return department;
    }

    public int getLeave() {
        return employeeLeave;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(String id) {
        emplyeeId = id;
    }

    public void setName(String name) {
        employeeName = name;
    }

    public void setAge(int age) {
        employeeAge = age;
    }

    public void setCoefficient(double cf) {
        employeeCoefficient = cf;
    }

    public void setDate(Date d) {
        employeeDate = d;
    }

    public void setDepartment(String de) {
        department = de;
    }

    public void setLeave(int l) {
        employeeLeave = l;
    }

    public void setSalary(int s) {
        salary = s;
    }

}
