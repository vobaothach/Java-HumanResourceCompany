package assigment3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Staff {
    private int hour;
    SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");

    public Employee() {

    }

    public Employee(String id, String n, int a, double c, String de, Date dw, int l, int h) {
        super(id, n, a, c, de, dw, l);
        hour = h;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int h) {
        hour = h;
    }

    @Override
    public void displayInformation() {
        System.out.print(this.getId() + " - " + this.getName() + " - " + this.getAge() + " - " + this.getCoefficient()
                + " - " + this.getDepartment() + " - " + df.format(this.getDate()) + " - " + this.getLeave() + " - "
                + this.getHour() + " ");
        /*
         * System.out.println("Name: " + this.getName());
         * System.out.println("Coefficient: " + this.getCoefficient()); //
         * System.out.println("Day to work: " + this.getDate());
         * System.out.println("Department salary: " + this.getDepartment());
         * System.out.println("Leave day: " + this.getLeave());
         * System.out.println("Over time: " + this.getHour());
         */
    }

    // ghi đè hàm tính lương của interface ICalculator
    @Override
    public double calculateSalary() {
        return (double) this.getCoefficient() * 3000000 + (double) this.getHour() * 200000;

    }
}
