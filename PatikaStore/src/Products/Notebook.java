package Products;

public class Notebook extends Product {
    //I did not define these variables in super.
    //Because the products to be added later, may not have these properties.
    private int ram;
    private int memory;
    private double screenSize;


    public Notebook(int id, String brandName, String productName, double productPrice, int stock, int discountRate, int ram, int memory, double screenSize) {
        super(id,brandName, productName, productPrice, stock, discountRate);
        this.ram = ram;
        this.memory = memory;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
