package clothesShopToyProject.product;

public class White extends Extra {
    public White(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return product.getDescription() + "색상 변경 : White";
    }

    @Override
    public int price(int price) {
        return 10000 + product.price(price);
    }
}
