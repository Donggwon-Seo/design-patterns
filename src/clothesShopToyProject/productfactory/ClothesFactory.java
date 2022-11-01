package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Clothes;
import clothesShopToyProject.transform.TransformEnumClothes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClothesFactory {
    private BufferedReader br;
//    private TransformEnumClothes tfClothes;

    public Clothes createClothes(String tmp) throws ConditionInputException, IOException {
        Clothes clothes;
        int size;

        switch (TransformEnumClothes.transformEnumClothes(tmp)) {
            case STUUSY -> {
                size = selectSize();
                clothes = new Clothes("후드티", "STUSSY", size, 150000);
            }
            case ROMANTIC_CROWN -> {
                size = selectSize();
                clothes = new Clothes("맨투맨", "Romantic Crown", size, 69000);
            }
            case EIGHT_DIVISION -> {
                size = selectSize();
                clothes = new Clothes("니트", "8DIVISION", size, 120000);
            }
            default -> {
                throw new ConditionInputException("");
            }
        }
        return clothes;
    }

    public int selectSize() throws IOException, ConditionInputException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("-------- 사이즈를 선택하여 주세요 ----");
        System.out.println("---- 1. 90 | 2. 95 | 3. 100 | 4. 105 | 5. 110 ----");

        String selectSize = br.readLine();

        int size = switch (TransformEnumClothes.transformEnumClothesSize(selectSize)) {
            case NINETY -> {
                yield 90;
            }
            case NINETY_FIVE -> {
                yield 95;
            }
            case ONE_HUNDRED -> {
                yield 100;
            }
            case ONE_HUNDRED_FIVE -> {
                yield 105;
            }
            case ONE_HUNDRED_TEN -> {
                yield 110;
            }
            default -> {
                throw new ConditionInputException("");
            }
        };
        return size;
    }
}


