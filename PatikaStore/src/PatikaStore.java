import Brands.Brand;
import Operations.MobilePhoneOperation;
import Operations.NotebookOperation;

import java.util.InputMismatchException;

import java.util.Scanner;

public class PatikaStore {
    Scanner input = new Scanner(System.in);

    //Method that prints the main menu.
    public void printMainMenu() {
        boolean isOkay = false;

        while (!isOkay) {

            System.out.println("MAIN MENU");
            System.out.println("1>> Notebook Operations");
            System.out.println("2>> Mobile Phone Operations");
            System.out.println("3>> Sort Brands");
            System.out.println("0>> Exit Store");

            //With the try-catch block I use here,
            //I prevent the same exception from terminating the program
            // in the printNotebookMenu() and printMobilePhoneMenu() methods.
            try {
                System.out.print("Please type your choice: ");
                int mainChoice = input.nextInt();

                switch (mainChoice) {
                    case 0 -> {
                        System.out.println("Goodbye, Come back again!");
                        isOkay = true;
                    }

                    case 1 -> {
                        printNotebookMenu();
                        isOkay = true;
                    }

                    case 2 -> {
                        printMobilePhoneMenu();
                        isOkay = true;
                    }

                    case 3 -> {
                        Brand.printBrands(); //alphabetical list of brand names
                        System.out.println("----------------------------");
                        //isOkay = false to go back to the main menu
                    }
                    default -> System.out.println("Invalid input!");
                }

            } catch (
                    InputMismatchException e) { //to prevent the program from terminating when an incorrect data type is entered.
                System.out.println("Incorrect data type has been detected!");
                System.out.println("Please try again!");
                input.next(); //incorrect input deleted.
            }
        }


    }

    //Method that prints the notebook operation menu.
    public void printNotebookMenu() {
        System.out.println("NOTEBOOK MENU");
        System.out.println("1>> Add a notebook");
        System.out.println("2>> Filter notebooks by the brand name");
        System.out.println("3>> Get a notebook by ID number");
        System.out.println("4>> Delete a notebook");
        System.out.println("0>> Back to main menu");
        System.out.print("Please type your choice: ");
        int notebookChoice = input.nextInt();
        switch (notebookChoice) {
            case 0 -> printMainMenu();
            case 1 -> {
                NotebookOperation.addNotebook();
                printNotebookMenu();
            }
            case 2 -> {
                NotebookOperation.filterByBrandNameNotebook();
                printNotebookMenu();
            }
            case 3 -> {
                NotebookOperation.filterByIdNotebook();
                printNotebookMenu();
            }
            case 4 -> {
                NotebookOperation.deleteByIdNotebook();
                printNotebookMenu();
            }
            default -> {
                System.out.println("Invalid input!");
                printNotebookMenu();
            }
        }

    }

    //Method that prints the mobile phone operation menu.
    public void printMobilePhoneMenu() {
        System.out.println("MOBILE PHONE MENU");
        System.out.println("1>> Add a mobile phone");
        System.out.println("2>> Filter mobile phones by the brand name");
        System.out.println("3>> Get a mobile phone by ID number");
        System.out.println("4>> Delete a mobile phone");
        System.out.println("0>> Back to main menu");
        System.out.print("Please type your choice: ");
        int mpChoice = input.nextInt();
        switch (mpChoice) {
            case 0 -> printMainMenu();
            case 1 -> {
                MobilePhoneOperation.addMobilePhone();
                printMobilePhoneMenu();
            }
            case 2 -> {
                MobilePhoneOperation.filterByBrandNameMobilePhone();
                printMobilePhoneMenu();
            }
            case 3 -> {
                MobilePhoneOperation.filterByIdMobilePhone();
                printMobilePhoneMenu();
            }
            case 4 -> {
                MobilePhoneOperation.deleteByIdMobilePhone();
                printMobilePhoneMenu();
            }
            default -> {
                System.out.println("Invalid input!");
                printMobilePhoneMenu();
            }
        }

    }

}