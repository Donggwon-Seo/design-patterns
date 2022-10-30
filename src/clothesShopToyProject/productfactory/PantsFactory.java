package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Pants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PantsFactory {
    private BufferedReader br;

    public Pants createPants(int tmp) throws ConditionInputException, IOException {
        Pants pants;
        int size;


        if (tmp == 1) {
            size = selectSize();
            pants = new Pants("청바지", "GUESS", size, 170000);
        } else if (tmp == 2) {
            size = selectSize();
            pants = new Pants("슬랙스", "MUSINSA", size, 45000);
        } else if (tmp == 3) {
            size = selectSize();
            pants = new Pants("반바지", "ZARA", size, 89000);
        } else {
            throw new ConditionInputException("1 ~ 3의 값만 입력하세요.");
        }

        return pants;
    }

    public int selectSize() throws IOException, ConditionInputException {
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("---- 1. 28 | 2. 30 | 3. 32 | 4. 34 | 5. 36 ----");
        int selectSize = Integer.parseInt(br.readLine());

        if (selectSize == 1)
            return 28;
        else if (selectSize == 2)
            return 30;
        else if (selectSize == 3)
            return 32;
        else if (selectSize == 4)
            return 34;
        else if (selectSize == 5)
            return 36;
        else
            throw new ConditionInputException("28 ~ 36 사이즈만 있습니다. 1부터 5 사이의 숫자만 입력하세요");
    }
}
