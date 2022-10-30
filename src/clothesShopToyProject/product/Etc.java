package clothesShopToyProject.product;

public class Etc extends Product {
    public Etc(String description, String brand, int price) {
        this.description = description;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int price(int price) {
        return price;
    }
}
