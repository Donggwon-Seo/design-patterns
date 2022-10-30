package clothesShopToyProject.product;

public abstract class Product {

    int price;
    String description;
    String brand;
    int size;

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract int price(int price); // default로 구현 getter 사용
}
