package clothesShopToyProject.product;

public class Reform extends Extra {
    public Reform(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return product.getDescription() + " (기장수선)";
    }

    @Override
    public int price(int price) {
        return 5000 + product.price(price);
    }
}
