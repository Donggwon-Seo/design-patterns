package clothesShopToyProject.productfactory;

import clothesShopToyProject.product.Etc;
import clothesShopToyProject.transform.TransformEnumEtc;

public class EtcFactory { // enum type 변경
    public Etc createEtc(String tmp) throws ConditionInputException {
        Etc etc;

        switch (TransformEnumEtc.transformEnumEtc(tmp)) {
            case WATCH -> {
                etc = new Etc("시계", "TAG HEUER", 23000000);
            }
            case RING -> {
                etc = new Etc("반지", "OST", 12000);
            }
            case CAP -> {
                etc = new Etc("모자", "MLB", 43000);
            }
            default -> {
                throw new ConditionInputException("");
            }
        }

        return etc;
    }
}