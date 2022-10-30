package clothesShopToyProject;

import clothesShopToyProject.process.Order;
import clothesShopToyProject.productfactory.ConditionInputException;

import java.io.IOException;

public class TestDrive {
    private static Order order;

    public static void main(String[] args) throws ConditionInputException, IOException {
        order = new Order();
    }
}
