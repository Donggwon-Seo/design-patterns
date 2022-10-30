package clothesShopToyProject.product;

public class Pants extends Product {
    public Pants(String description, String brand, int size, int price) {
        this.description = description;
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    @Override
    public int price(int price) {
        return price;
    }
}
