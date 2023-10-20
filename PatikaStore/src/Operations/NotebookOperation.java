package Operations;

import Products.Notebook;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NotebookOperation {
    //Notebooks use this class for CRUD operations.
    static Scanner input = new Scanner(System.in);
    //Created the arraylist that will hold the Notebook.
    static List<Notebook> notebooks = new ArrayList<>();

    //objects to be added by default.
    public static void createDefaultNotebooks() {
        notebooks.add(new Notebook(1, "HUAWEI", "FENABOOK", 29999, 1, 1, 8, 512, 13.1));
        notebooks.add(new Notebook(2, "APPLE", "MACBOOK BABO", 70999, 7, 10, 16, 256, 13.1));
        notebooks.add(new Notebook(3, "XIAOMI", "MARIOBOOK", 2999, 1, 80, 8, 128, 13.1));
        notebooks.add(new Notebook(4, "HUAWEI", "KRALBU UK", 19999, 5, 76, 16, 512, 14.5));
        notebooks.add(new Notebook(5, "XIAOMI", "VERGISIZBUUK", 999, 0, 16, 16, 64, 14.5));
    }

    //this method will add a mobile phone to the list with parameters to be entered by the user.
    public static void addNotebook() {
        try {
            int maxId = findMaxIdNotebook(notebooks);

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

            System.out.print("Please enter RAM value of product(int): ");
            int pRam = input.nextInt();

            System.out.print("Please enter memory of product(int): ");
            int pMemory = input.nextInt();

            System.out.print("Please enter screen size of product(double)(use ',' instead of '.'): ");
            double pScreenSize = input.nextDouble();


            //a new Notebook object will be generated with the received inputs.
            //and the object will be added with the largest id number.
            notebooks.add(new Notebook(maxId + 1, pBrandName, pName, pPrice, pStock, pDiscountRate, pRam, pMemory, pScreenSize));
            System.out.println("Product added successfully!");

        } catch (InputMismatchException e) { //this block will work if a data type exception occurs!
            System.out.println("Product could not be added!");
            System.out.println("Incorrect data type has been detected!");
        }
        printNotebookList(notebooks);
    }

    //this method will return notebook that match the brand name entered.
    public static void filterByBrandNameNotebook() {
        boolean isSucceed = false;

        printNotebookList(notebooks);

        //ArrayList to hold products with matching brand name.
        List<Notebook> filteredNotebooks = new ArrayList<>();

        System.out.println("Please enter the brand name of the products you want to be listed: ");
        String searchThisName = input.next().toUpperCase();

        for (Notebook nb : notebooks) {
            if (searchThisName.equals(nb.getBrandName()))
                filteredNotebooks.add(nb);
            isSucceed = true;
        }
        if (isSucceed)
            printNotebookList(filteredNotebooks);
        else
            System.out.println("No matching brand names found!");

    }

    //this method will return the notebook with using the id value.
    public static void filterByIdNotebook() {
        try {
            boolean found = false;

            printNotebookList(notebooks);

            //If the input had the String data type, the program could terminate unintentionally.
            //We prevented this situation with the help of this try-catch block.
            System.out.print("Please enter the ID number of the notebook you want to call: ");
            int filterId = input.nextInt();

            for (Notebook nb : notebooks) {
                if (filterId == nb.getId()) {
                    found = true;
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-12s |%n", "ID", "Brand Name", "Product Name", "Price", "Stock", "Discount Rate", "RAM", "Memory", "Screen Size");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-12s |%n", nb.getId(), nb.getBrandName(), nb.getProductName(), nb.getProductPrice(), nb.getStock(), nb.getDiscountRate(), nb.getRam(), nb.getMemory(), nb.getScreenSize());
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                }
            }

            if (!found) {
                System.out.println("Product with ID " + filterId + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Incorrect data type has been detected!");
        }

    }

    //this method deletes the notebook which is selected by the id number.
    public static void deleteByIdNotebook() {
        boolean isSucceed = false;

        printNotebookList(notebooks);

        try {
            //If the input had the String data type, the program could terminate unintentionally.
            //We prevented this situation with the help of this try-catch block.
            System.out.print("Please enter the ID number of product you want to delete: ");
            int selectedId = input.nextInt();
            for (Notebook nb : notebooks) {
                if (selectedId == nb.getId()) {
                    notebooks.remove(nb);
                    System.out.println("The deletion has done successfully.");
                    printNotebookList(notebooks);
                    isSucceed = true;
                    break;
                }

            }
            if (!isSucceed) {
                System.out.println("Product could not be deleted!");
                System.out.println("No matching data found.");
            }


        } catch (InputMismatchException e) { //to send an exception message without finishing the program.
            //System.err was used to give a message in red color.
            System.out.println("Incorrect data type has been detected! ");
        }

    }


    //I will use this method to find and return which has the largest id value in the elements of the list.
    //and I will use this value to determine the max id number of the objects in the list.
    //so I will add this object at the end of the list with the addMNotebook() method.
    //so we will avoid possible id conflicts.
    public static int findMaxIdNotebook(List<Notebook> notebooks) {
        int maxId = -1;
        for (Notebook nb : notebooks) {
            if (nb.getId() > maxId) {
                maxId = nb.getId();
            }
        }
        return maxId;
    }

    //this method prints mobile phone list.
    public static void printNotebookList(List<Notebook> notebooks) {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-12s |%n", "ID", "Brand Name", "Product Name", "Price", "Stock", "Discount Rate", "RAM", "Memory", "Screen Size");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook nb : notebooks) {
            System.out.format("| %-3s | %-11s | %-17s | %-7s | %-6s | %-13s | %-16s | %-13s | %-12s |%n", nb.getId(), nb.getBrandName(), nb.getProductName(), nb.getProductPrice(), nb.getStock(), nb.getDiscountRate(), nb.getRam(), nb.getMemory(), nb.getScreenSize());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
