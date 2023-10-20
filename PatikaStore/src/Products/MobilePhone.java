package Products;

public class MobilePhone extends Product {
    //I did not define these variables in super because the products to be added later may not have these properties,
    //And this situation will cause us problems later in the development process.
    private int memory;
    private double screenSize;
    private int ram;
    private int batteryCapasity;
    private String color;

    //extended from super because brands registered in system will use in this project.
    public MobilePhone(int id, String brandName, String productName, double productPrice, int stock, int discountRate, int memory, int batteryCapasity, double screenSize, int ram, String color) {
        super(id,brandName, productName, productPrice, stock, discountRate);
        this.memory = memory;
        this.batteryCapasity = batteryCapasity;
        this.screenSize = screenSize;
        this.ram = ram;
        this.color = color;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBatteryCapasity() {
        return batteryCapasity;
    }

    public void setBatteryCapasity(int batteryCapasity) {
        this.batteryCapasity = batteryCapasity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
