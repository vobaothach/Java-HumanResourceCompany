package assigment3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Staff {
    String title;
    SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");

    public Manager() {
    }

    public Manager(String id, String n, int a, double c, String de, Date dw, int l, String t) {
        super(id, n, a, c, de, dw, l);
        title = t;
    }

    public double getTitleSalary() {
        if (title.equals("Business Leader"))
            return 8000000;
        if (title.equals("Project Leader "))
            return 5000000;
        return 6000000;
    }

    public String getTitle() {
        return title;
    }

    public String toTitle(int a) {
        if (a == 1)
            return "Business Leader";
        if (a == 2)
            return "Technical Leader";
        return "Project Leader";
    }

    public void setTitle(String t) {
        title = t;
    }

    @Override
    public void displayInformation() {
        System.out.print(
                this.getId() + " - " + this.getName() + " - " + this.getCoefficient() + " - " + this.getDepartment()
                        + " - " + df.format(this.getDate()) + " - " + this.getLeave() + " - " + this.getTitle() + " ");
        /*
         * System.out.println("Name: " + this.getName());
         * System.out.println("Coefficient: " + this.getCoefficient());
         * System.out.println("Day to work: " + this.getDate());
         * System.out.println("Department salary: " + this.getDepartment());
         * System.out.println("Leave day: " + this.getLeave());
         * System.out.println("Tittle: " + this.getTitle());
         */
    }

    // ghi đè hàm tính lương của interface ICalculator
    @Override
    public double calculateSalary() {
        return (double) this.getCoefficient() * 5000000 + (double) this.getTitleSalary();
    }

}
