import Operations.MobilePhoneOperation;
import Operations.NotebookOperation;


public class Main {
    public static void main(String[] args) {
        PatikaStore store = new PatikaStore();
        MobilePhoneOperation.createDefaultPhones();
        NotebookOperation.createDefaultNotebooks();
        store.printMainMenu();
    }
}