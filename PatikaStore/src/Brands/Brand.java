package Brands;

import java.util.TreeSet;

public class Brand implements Comparable<Brand> {
    private int id;
    private String name;

    //I defined it static. Because I want this codes treeset .
    static TreeSet<Brand> brandTreeSet = new TreeSet<>();

    //When the program runs, this block will run directly and these products will be created.
    static {
        //Brands has been created.
        brandTreeSet.add(new Brand(1, "Samsung"));
        brandTreeSet.add(new Brand(2, "Lenovo"));
        brandTreeSet.add(new Brand(3, "Apple"));
        brandTreeSet.add(new Brand(4, "Huawei"));
        brandTreeSet.add(new Brand(5, "Casper"));
        brandTreeSet.add(new Brand(6, "Asus"));
        brandTreeSet.add(new Brand(7, "HP"));
        brandTreeSet.add(new Brand(8, "Xiaomi"));
        brandTreeSet.add(new Brand(9, "Monster"));
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Using this method, brand names we keep in the brandTreeSet are sorted alphabetically.
    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.name);
    }
    public static void printBrands(){
        System.out.println("Brands : ");
        for (Brand brand: brandTreeSet) {
            System.out.println("- "+ brand.getName());
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
