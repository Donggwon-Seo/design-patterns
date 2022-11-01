package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.*;
import clothesShopToyProject.transform.TransformEnumOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptionFactory {
    private BufferedReader br;
//  private TransformEnumOptions tfOption;

    public Product selectOption(String tmp, Product product) throws ConditionInputException {

        switch (TransformEnumOptions.transform(tmp)) {
            case REFORM -> {
                return new Reform(product);
            }
            case COLOR_WHITE -> {
                return new White(product);
            }
            case COLOR_RED -> {
                return new Red(product);
            }
            case EXIT -> {
                return new NoCommand(product);
            }
            // 메소드를 사용하는 곳에서 예외를 던지면 던진 곳에서 예외를 처리하라
            // Main 까지 올라가면 실행이 종료됨
            default -> {
                throw new ConditionInputException("");
            }
        }

    }
}
