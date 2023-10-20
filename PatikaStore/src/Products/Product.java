package Products;

public abstract class Product {
    private int id;
    private String brandName;
    private String productName;
    private double productPrice;
    private int stock;
    private int discountRate;
    //Other parameters are not taken here in order to keep the project open for development.
    public Product(int id,String brandName, String productName, double productPrice, int stock, int discountRate) {
        this.id = id;
        this.brandName = brandName;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock = stock;
        this.discountRate = discountRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }
}
