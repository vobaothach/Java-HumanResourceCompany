package assigment3;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HumanResoucres {
    public static void main(String[] args) throws Exception {
        Validate check = new Validate();
        ArrayList<Staff> employee = new ArrayList<Staff>();
        String ansewr = "y";
        Scanner sc = new Scanner(System.in);
        Department java = new Department("DP1", "Java");
        Department csharp = new Department("DP2", "C#");
        Department php = new Department("DP3", "PHP");
        ArrayList<Department> dpList = new ArrayList<Department>();
        dpList.add(java);
        dpList.add(csharp);
        dpList.add(php);
        do {
            System.out.println("Select function ");
            System.out.println("1. Display a list of existing employees in the company");
            System.out.println("2. Show department in company");
            System.out.println("3. Display of employees by department");
            System.out.println("4. Adding new employees to the company");
            System.out.println("5. Search employee information by employee name or employee id");
            System.out.println("6. Display the payroll of employees throughout the company");
            System.out.println("7. Display employee payroll in ascending or descending order");
            System.out.println("8. Exit");
            System.out.print("I choise: ");
            int choise = check.validateInt(sc);
            System.out.println("");
            switch (choise) {
                case 1:// in thông tin nhân viện không theo thứ tự không có lương
                    System.out.println("1. Display a list of existing employees in the company");
                    System.out.println(
                            "ID - Name - Age - Coefficient salary - Department salary - Leave day - Over time/Tittle ");
                    for (int i = 0; i < employee.size(); i++) {
                        employee.get(i).displayInformation();
                        // System.out.println("- " + employee.get(i).getSalary());
                    }
                    break;
                case 2:// in số thành viên của mỗi bộ phận
                    System.out.println("2. Show department in company");
                    System.out.println("ID - Name - Member");
                    for (int i = 0; i < dpList.size(); i++) {
                        System.out.println(dpList.get(i).toString());
                    }
                    break;
                case 3:// in thông tin của các thành viên theo bộ phận
                    System.out.println("3. Display of employees by department");
                    for (int i = 0; i < dpList.size(); i++) {
                        System.out.println("Member of " + dpList.get(i).getName() + " : ");
                        System.out.println(
                                "ID - Name - Age - Coefficient salary - Department - Date start work - Leave day - Over time/Tittle");
                        for (int j = 0; j < employee.size(); j++) {
                            if (employee.get(j).getDepartment().equals(dpList.get(i).getName())) {
                                employee.get(j).displayInformation();
                                System.out.println("");
                            }
                        }
                    }
                    break;
                case 4:// thêm một nhân viên bằng hàm addEmployee
                    System.out.println("4. Adding new employees to the company");
                    Staff e = addEmployee(sc, check, dpList, employee);
                    employee.add(e);
                    break;
                case 5:// in thông tin nếu nhập đúng tên hoặc mã nhân viên
                    System.out.println("Search for: ");
                    sc.nextLine();
                    String search = sc.nextLine();
                    System.out.println("|"+search+"|");
                    boolean isExists = false;
                    if (employee.size() > 0) {
                        for (int i = 0; i < employee.size(); i++) {
                            System.out.println("|"+employee.get(i).getName()+"|");
                            if (search.equals(employee.get(i).getId()) || search.equals(employee.get(i).getName())) {
                                employee.get(i).displayInformation();
                                System.out.print("");
                                isExists = true;
                                break;
                            }
                        }
                        if (isExists == false)
                            System.out.print("Does not exits!\n");
                    } else
                        System.out.print("There are no employees in the company \n");
                    break;
                case 6:// in bảng lương nhân viên toàn công ty
                    System.out.println(
                            "ID - Name - Age - Coefficient salary - Department salary - Leave day - Over time/Tittle - Salary");
                    for (int i = 0; i < employee.size(); i++) {
                        employee.get(i).displayInformation();
                        System.out.println((int) employee.get(i).calculateSalary());
                    }
                    break;
                case 7:// sắp xếp bảng lương theo thứ tự tăng dần hoặc giảm dần
                    System.out.print("Display salary in ascending < 1 > or descending order <other key>");
                    String asSalary = sc.next();
                    /*
                     * for (int i = 0; i < employee.size(); i++) { int s = (int)
                     * employee.get(i).calculateSalary(); employee.get(i).setSalary(s); }
                     */
                    // nếu 1 là tăng dần
                    if (asSalary.equals("1")) {
                        System.out.println("Display salary in ascending: ");
                        for (int i = 0; i < employee.size() - 1; i++) {
                            for (int j = i + 1; j < employee.size(); j++) {
                                if (employee.get(i).getSalary() > employee.get(j).getSalary()) {
                                    Staff temp = employee.get(i);
                                    employee.set(i, employee.get(j));
                                    employee.set(j, temp);
                                }
                            }
                        }
                    } else {// ngược lại giảm dần
                        System.out.println("Display salary in descending: ");
                        for (int i = 0; i < employee.size() - 1; i++) {
                            for (int j = i + 1; j < employee.size(); j++) {
                                if (employee.get(i).getSalary() < employee.get(j).getSalary()) {
                                    Staff temp = employee.get(i);
                                    employee.set(i, employee.get(j));
                                    employee.set(j, temp);
                                }
                            }
                        }
                    }
                    for (int i = 0; i < employee.size(); i++) {
                        employee.get(i).displayInformation();
                        System.out.println(employee.get(i).getSalary());
                    }
                    break;
                default:
                    ansewr = "n";
            }
            // kiểm tra người dùng có muốn tiếp tục hay không
            if (ansewr.equals("y")) {
                System.out.print("Continue ? < y > to yes and < other key > to close!");
                ansewr = sc.next();
            }
        } while (ansewr.equals("y"));
        System.out.print("Goodbye");
    }

    // hàm thêm một đối tượng Staff
    public static Staff addEmployee(Scanner sc, Validate check, ArrayList<Department> dpList,
            ArrayList<Staff> employee) {
        System.out.print("Id of employee: ");
        String id;
        while (true) {
            boolean isExists = false;
            id = sc.next();
            sc.nextLine();
            // lấy id của các đối tượng nhân viên hiện có so sánh với id nhập vào
            // nếu id đã tồng tại thì ngắt vòng lặp gán biến isExist bằng true
            for (int i = 0; i < employee.size(); i++) {
                if (id.equals(employee.get(i).getId())) {
                    isExists = true;
                    break;
                }
            } // kết thúc vòng lặp biến isExist bằng false có nghĩa không trùng
              // kết thúc vòng lặp while
            if (isExists == false)
                break;
            else// ngược lại thông báo bị trùng và nhập lại
                System.out.print("This ID already exists. Please enter another ID ");
        }

        System.out.print("Name of employee: ");
        String name = sc.nextLine();
        // sc.nextLine();
        System.out.print("Age of employee: ");
        int age = check.validateInt(sc);
        while (true) {
            if (age > 0) {
                break;
            } else
                System.out.print("The age must be greater than 0: ");
            age = check.validateInt(sc);
        }
        System.out.print("Coefficient salary: ");
        double coefficient = check.validateDouble(sc);
        while (true) {
            if (coefficient >= 0) {
                break;
            } else {
                System.out.print("The coefficient must be >= 0: ");
                coefficient = check.validateDouble(sc);
            }
        }
        System.out.println("Department for employee: ");
        for (int i = 0; i < dpList.size(); i++) {
            System.out.print("< " + (i + 1) + " > " + dpList.get(i).getName() + " ");
        }
        String department;
        int choiseDepartment = check.validateInt(sc);
        while (true) {
            if (choiseDepartment <= dpList.size()) {
                int i = choiseDepartment - 1;
                department = dpList.get(i).getName();
                int member = dpList.get(i).getNumber();
                dpList.get(i).setNumber(member + 1);
                break;
            } else {
                System.out.print("Does not have this department ");
                choiseDepartment = check.validateInt(sc);
            }
        }
        // nhập ngày làm việc kiểu Date
        sc.nextLine();
        System.out.print("Date to work (dd-mm-yyyy):");
        Date daytowork = check.validateDate(sc);
        /*
         * SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy"); // SimpleDateFormat
         * dfday = new SimpleDateFormat("dd"); SimpleDateFormat dfmonth = new
         * SimpleDateFormat("mm"); SimpleDateFormat dfyear = new
         * SimpleDateFormat("yyyy"); while (true) { try { //
         * System.out.print("Day to work: "); String checkdate = sc.nextLine();// lưu
         * dãy String đã nhập String[] arr = checkdate.split("-", 3); // kiểm tra ngày
         * có hợp lệ hay không if (Integer.parseInt(arr[0]) > 0 &&
         * Integer.parseInt(arr[0]) < 32) { daytowork = df.parse(checkdate);
         * 
         * // if (Integer.parseInt(dfday.format(daytowork)) <= 31 && //
         * Integer.parseInt(dfday.format(daytowork)) > 0) { // kiểm tra tháng có hợp lệ
         * hay không if (Integer.parseInt(dfmonth.format(daytowork)) <= 12 &&
         * Integer.parseInt(dfmonth.format(daytowork)) > 0) { // kiểm tra năm có hợp lệ
         * hay không if (Integer.parseInt(dfyear.format(daytowork)) <= 2021 &&
         * Integer.parseInt(dfmonth.format(daytowork)) > 0) { break; } else {
         * System.err.print(
         * "yyyy in the range 0-2021. Re-enter the correct date format (dd-mm-yyyy):  "
         * ); } } else { System.out.
         * print("mm in the range 0-12. Re-enter the correct date format (dd-mm-yyyy):  "
         * ); }
         * 
         * } else { System.out.
         * print("dd in the range 0-31. Re-enter the correct date format (dd-mm-yyyy):  "
         * ); }
         * 
         * } catch (Exception e) {
         * System.out.print("Enter the correct date format (dd-mm-yyyy): ");
         * 
         * } }
         */

        System.out.print("Date of leave: ");
        // số ngày nghỉ phép
        int dayleave = check.validateInt(sc);
        System.out.print("Do you want to add an employee or a manager? \n< 1 > Manager \n< 2 > Employee ");
        int choisePosition = check.validateInt(sc);
        while (choisePosition < 0 || choisePosition > 2) {
            System.out.print("Please re-enter: ");
            choisePosition = check.validateInt(sc);
        }
        Staff e;
        // tạo đối tương Employee
        if (choisePosition == 2) {
            System.out.print("Over time: ");
            int hour = check.validateInt(sc);
            e = new Employee(id, name, age, coefficient, department, daytowork, dayleave, hour);
        } else {// tạo đối tượng Manage
            System.out.print(
                    "What is the title of manager? \n< 1 > Business Leader \n< 2 > Technical Leader \n< 3 > Project Leader ");
            int choiseTittle = check.validateInt(sc);
            while (choiseTittle < 0 || choisePosition > 3) {
                System.out.print("Please re-enter: ");
                choiseTittle = check.validateInt(sc);
            }
            Manager mn = new Manager();
            String tittle = mn.toTitle(choiseTittle);
            /*
             * if (choiseTittle == 1) tittle = "Business Leader"; else if (choiseTittle ==
             * 2) tittle = "Technical Leader"; else tittle = "Project Leader";
             */

            e = new Manager(id, name, age, coefficient, department, daytowork, dayleave, tittle);
        }
        // tính lương
        int s = (int) e.calculateSalary();
        e.setSalary(s);
        System.out.println("Success");
        return e;
    }
}
