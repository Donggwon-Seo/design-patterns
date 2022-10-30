package clothesShopToyProject.product;

public abstract class Extra extends Product {
    Product product;

    public abstract String getDescription();

    public int getSize() {
        return product.getSize();
    }

}
