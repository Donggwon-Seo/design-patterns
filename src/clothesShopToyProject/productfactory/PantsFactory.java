package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Pants;
import clothesShopToyProject.transform.TransformEnumPants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PantsFactory {
    private static BufferedReader br;

    public static Pants createPants(String tmp) throws ConditionInputException, IOException {
        Pants pants;
        int size;

        switch (TransformEnumPants.Transform(tmp)) {
            case BLUE_PANTS -> {
                size = selectSize();
                pants = new Pants("청바지", "GUESS", size, 170000);
            }
            case SLACKS -> {
                size = selectSize();
                pants = new Pants("슬랙스", "MUSINSA", size, 45000);
            }
            case HALF_PANTS -> {
                size = selectSize();
                pants = new Pants("반바지", "ZARA", size, 89000);
            }
            default -> {
                throw new ConditionInputException("");
            }
        }
        return pants;
    }

    public static int selectSize() throws IOException, ConditionInputException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("---- 1. 28 | 2. 30 | 3. 32 | 4. 34 | 5. 36 ----");
        String selectSize = br.readLine();

        int size = switch (TransformEnumPants.TransformEnumPantsSize(selectSize)) {
            case TWENTY_EIGHT -> {
                yield 28;
            }
            case THIRTY -> {
                yield 30;
            }
            case THIRTY_TWO -> {
                yield 32;
            }
            case THIRTY_FOUR -> {
                yield 34;
            }
            case THIRTY_SIX -> {
                yield 36;
            }
            default -> {
                throw new ConditionInputException("");
            }
        };
        return size;
    }
}
