package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptionFactory {
    private BufferedReader br;

    public Product selectOption(int tmp, Product product) throws ConditionInputException, IOException {

        if (tmp == 1) {
            return new Reform(product);
        } else if (tmp == 2) {
            return new White(product);
        } else if (tmp == 3) {
            return new Red(product);
        } else if (tmp == 4) {
            return new NoCommand(product);
        } else {
            throw new ConditionInputException("1 ~ 4의 값만 입력하세요.");
        }
    }
}
