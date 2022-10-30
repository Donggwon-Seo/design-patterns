package clothesShopToyProject.product;

public class Clothes extends Product {
    public Clothes(String description, String brand, int size, int price) {
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
