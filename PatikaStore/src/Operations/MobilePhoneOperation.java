package Operations;

import Products.MobilePhone;

import java.util.InputMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//MobilePhone class use this class for CRUD operations.

public class MobilePhoneOperation {
    static Scanner input = new Scanner(System.in);
    //Created the arraylist that will hold the MobilePhone.
    static List<MobilePhone> mobilePhones = new ArrayList<>();

    //objects to be added by default.
    public static void createDefaultPhones() {
        mobilePhones.add(new MobilePhone(1, "HUAWEI", "Mate 20", 17999, 3, 16, 128, 4000, 6.1, 6, "BLUE"));
        mobilePhones.add(new MobilePhone(2, "APPLE", "Iphone 14 Pro Max", 70999, 15, 5, 256, 4000, 8.1, 6, "BLACK"));
        mobilePhones.add(new MobilePhone(3, "XIAOMI", "ACAYIP 1.5", 20999, 1, 26, 256, 9000, 9.7, 12, "RED"));
        mobilePhones.add(new MobilePhone(4, "HUAWEI", "ALO POLIS 155", 1999, 1, 76, 64, 1000, 8.1, 3, "BLACK"));
        mobilePhones.add(new MobilePhone(5, "XIAOMI", "VERGISIZ PHONE 15", 999, 0, 16, 16, 250, 9.1, 1, "YOK MAVISI"));
    }

    //this method will add a mobile phone to the list with parameters to be entered by the user.
    public static void addMobilePhone() {
        try {
            int maxId = findMaxIdMobilePhone(mobilePhones);

            System.out.print("Please enter brand name of the product(String): ");
            String pBrandName = input.next();

            System.out.print("Please enter name of the product(String): ");
            String pName = input.next();

            System.out.print("Please enter price of the product(double)(use ',' instead of '.'): ");
            double pPrice = input.nextDouble();

            System.out.print("Please enter the stock quantity(int): ");
            int pStock = input.nextInt();

            System.out.print("Please enter discount rate(int): ");
            int pDiscountRate = input.nextInt();

            System.out.print("Please enter memory of product(int): ");
            int pMemory = input.nextInt();

            System.out.print("Please enter battery capacity of product(int): ");
            int pBatterCapacity = input.nextInt();

            System.out.print("Please enter screen size of product(double)(use ',' instead of '.'): ");
            double pScreenSize = input.nextDouble();

            System.out.print("Please enter RAM value of product(int): ");
            int pRam = input.nextInt();

            System.out.print("Please enter color of product(String): ");
            String pColor = input.next();

            //a new MobilePhone object will be generated with the received inputs.
            //and the object will be added with the largest id number.
            mobilePhones.add(new MobilePhone(maxId + 1, pBrandName, pName, pPrice, pStock, pDiscountRate, pMemory, pBatterCapacity, pScreenSize, pRam, pColor));
            System.out.println("Product added successfully!");

        } catch (InputMismatchException e) { //this block will work if a data type exception occurs!
            System.out.println("Product could not be added!");
            System.out.println("Incorrect data type has been detected!");
        }
        printMobilePhoneList(mobilePhones);
    }

    //this method will return mobile phone that match the brand name entered.
    public static void filterByBrandNameMobilePhone() {
        boolean isSucceed = false;

        printMobilePhoneList(mobilePhones);

        //ArrayList to hold products with matching brand name.
        List<MobilePhone> filteredPhones = new ArrayList<>();

        System.out.println("Please enter the brand name of the products you want to be listed: ");
        String searchThisName = input.next().toUpperCase();

        for (MobilePhone mp : mobilePhones) {
            if (searchThisName.equals(mp.getBrandName()))
                filteredPhones.add(mp);
            isSucceed = true;
        }
        if (isSucceed)
            printMobilePhoneList(filteredPhones);
        else
            System.out.println("No matching brand names found!");

    }

    //this method will return the mobile phone with using the id value.
    public static void filterByIdMobilePhone() {
        printMobilePhoneList(mobilePhones);
        try {
            //If the input had the String data type, the program could terminate unintentionally.
            //We prevented this situation with the help of this try-catch block.
            System.out.print("Please enter the ID number of the mobile phone you want to call: ");
            int filterId = input.nextInt();

            boolean found = false;
            for (MobilePhone mp : mobilePhones) {
                if (filterId == mp.getId()) {
                    found = true;
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-3s | %-12s |%n", "ID", "Brand Name", "Product Name", "Price", "Stock", "Discount Rate", "Battery Capacity", "Screen Size", "RAM", "Color");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-3s | %-12s |%n", mp.getId(), mp.getBrandName(), mp.getProductName(), mp.getProductPrice(), mp.getStock(), mp.getDiscountRate(), mp.getBatteryCapasity(), mp.getScreenSize(), mp.getRam(), mp.getColor());
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                }
            }

            if (!found) {
                System.out.println("Product with ID " + filterId + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data type has been detected!");
        }

    }

    //this method deletes mobile phone which is selected by the id number.
    public static void deleteByIdMobilePhone() {
        boolean isSucceed = false;
        printMobilePhoneList(mobilePhones);
        try {
            //If the input had the String data type, the program could terminate unintentionally.
            //We prevented this situation with the help of this try-catch block.
            System.out.print("Please enter the ID number of product you want to delete: ");
            int selectedId = input.nextInt();
            for (MobilePhone mp : mobilePhones) {
                if (selectedId == mp.getId()) {
                    mobilePhones.remove(mp);
                    System.out.println("The deletion has done successfully.");
                    printMobilePhoneList(mobilePhones);
                    isSucceed = true;
                    break;
                }

            }
            if (!isSucceed) {
                System.out.println("Product could not be deleted!");
                System.out.println("No matching data found.");
            }


        } catch (InputMismatchException e) { //to send an exception message without finishing the program.
            System.out.println("Incorrect data type has been detected! ");
        }

    }


    //I will use this method to find and return which has the largest id value in the elements of the list.
    //and I will use this value to determine the max id number of the objects in the list.
    //so I will add this object at the end of the list with the addMobilePhone() method.
    //so we will avoid possible id conflicts.
    public static int findMaxIdMobilePhone(List<MobilePhone> mobilePhones) {
        int maxId = -1;
        for (MobilePhone mp : mobilePhones) {
            if (mp.getId() > maxId) {
                maxId = mp.getId();
            }
        }
        return maxId;
    }

    //this method prints mobile phone list.
    public static void printMobilePhoneList(List<MobilePhone> mobilePhones) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-3s | %-12s |%n", "ID", "Brand Name", "Product Name", "Price", "Stock", "Discount Rate", "Battery Capacity", "Screen Size", "RAM", "Color");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone mobilePhone : mobilePhones) {
            System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-3s | %-12s |%n", mobilePhone.getId(), mobilePhone.getBrandName(), mobilePhone.getProductName(), mobilePhone.getProductPrice(), mobilePhone.getStock(), mobilePhone.getDiscountRate(), mobilePhone.getBatteryCapasity(), mobilePhone.getScreenSize(), mobilePhone.getRam(), mobilePhone.getColor());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

}
