package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Clothes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClothesFactory {
    private BufferedReader br;

    public Clothes createClothes(int tmp) throws ConditionInputException, IOException {
        Clothes clothes;
        int size;

        if (tmp == 1) {
            size = selectSize();
            clothes = new Clothes("후드티", "STUSSY", size,150000);
        } else if (tmp == 2) {
            size = selectSize();
            clothes = new Clothes("맨투맨", "Romantic Crown", size,69000);
        } else if (tmp == 3) {
            size = selectSize();
            clothes = new Clothes("니트", "8DIVISION", size,120000);
        } else {
            throw new ConditionInputException("1 ~ 3의 값만 입력하세요.");
        }

        return clothes;
    }

    public int selectSize() throws IOException, ConditionInputException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("-------- 사이즈를 선택하여 주세요 ----");
        System.out.println("---- 1. 90 | 2. 95 | 3. 100 | 4. 105 | 5. 110 ----");

        int selectSize = Integer.parseInt(br.readLine());

        if (selectSize == 1)
            return 90;
        else if (selectSize == 2)
            return 95;
        else if (selectSize == 3)
            return 100;
        else if (selectSize == 4)
            return 105;
        else if (selectSize == 5)
            return 110;
        else
            throw new ConditionInputException("90 ~ 110 사이즈만 있습니다. 1부터 5 사이의 숫자만 입력하세요");
    }
}
