package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumEtc {
    WATCH,
    RING,
    CAP;

    public static TransformEnumEtc transformEnumEtc(String s) throws ConditionInputException {
        TransformEnumEtc transformEnumEtc = switch (s) {
            case "1" -> {
                yield WATCH;
            }
            case "2" -> {
                yield RING;
            }
            case "3" -> {
                yield CAP;
            }
            default -> {
                throw new ConditionInputException("1부터 3사이의 숫자를 입력하세요");
            }
        };
        return transformEnumEtc;
    }
}
