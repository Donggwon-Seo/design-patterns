package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Etc;

public class EtcFactory { // enum type 변경
    public Etc createEtc(int tmp) throws ConditionInputException {
        Etc etc;

        if (tmp == 1) { // switch 변경 | switch expression 적용하기
            etc = new Etc("시계", "TAG HEUER",23000000);
        } else if (tmp == 2) {
            etc = new Etc("반지", "OST",12000);
        } else if (tmp == 3) {
            etc = new Etc("모자", "MLB",43000);
        } else {
            throw new ConditionInputException("1~3의 값만 입력하세요.");
        }

        return etc;
    }
}