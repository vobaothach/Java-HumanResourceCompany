package assigment3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Validate {
    public Validate() {

    }

    public int validateInt(Scanner sc) {
        int numberInt = 0;
        while (true) {
            try {
                numberInt = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("Please enter a number: ");
            }
        }
        return numberInt;
    }

    public double validateDouble(Scanner sc) {
        double numberBouble;
        while (true) {
            try {
                numberBouble = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.print("Please enter a number:");
            }
        }
        return numberBouble;
    }

    public Date validateDate(Scanner sc) {
        Date daytowork;
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        SimpleDateFormat dfmonth = new SimpleDateFormat("mm");
        SimpleDateFormat dfyear = new SimpleDateFormat("yyyy");
        while (true) {
            try {
                // System.out.print("Day to work: ");
                String checkdate = sc.nextLine();// lưu dãy String đã nhập
                String[] arr = checkdate.split("-", 3);
                // kiểm tra ngày có hợp lệ hay không
                if (Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) < 32) {
                    daytowork = df.parse(checkdate);

                    // if (Integer.parseInt(dfday.format(daytowork)) <= 31 &&
                    // Integer.parseInt(dfday.format(daytowork)) > 0) {
                    // kiểm tra tháng có hợp lệ hay không
                    if (Integer.parseInt(dfmonth.format(daytowork)) <= 12
                            && Integer.parseInt(dfmonth.format(daytowork)) > 0) {
                        // kiểm tra năm có hợp lệ hay không
                        if (Integer.parseInt(dfyear.format(daytowork)) <= 2021
                                && Integer.parseInt(dfmonth.format(daytowork)) > 0) {
                            break;
                        } else {
                            System.err.print(
                                    "yyyy in the range 0-2021. Re-enter the correct date format (dd-mm-yyyy):  ");
                        }
                    } else {
                        System.out.print("mm in the range 0-12. Re-enter the correct date format (dd-mm-yyyy):  ");
                    }

                } else {
                    System.out.print("dd in the range 0-31. Re-enter the correct date format (dd-mm-yyyy):  ");
                }

            } catch (Exception e) {
                System.out.print("Enter the correct date format (dd-mm-yyyy): ");

            }
        }
        return daytowork;

    }
}