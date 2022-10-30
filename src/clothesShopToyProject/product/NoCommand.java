package clothesShopToyProject.product;

public class NoCommand extends Extra {
    public NoCommand(Product product) {
        this.product = product;
    }
    public String getDescription() {
        return product.getDescription() + "";
    }
    @Override
    public int price(int price) {
        return product.price(price);
    }
}
