package clothesShopToyProject.product;

public class Red extends Extra {
    public Red(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return product.getDescription() + " 색상 변경 : Red ";
    }

    @Override
    public int price(int price) {
        return 7000 + product.price(price);
    }
}
