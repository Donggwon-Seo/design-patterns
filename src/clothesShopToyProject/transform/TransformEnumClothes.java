package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumClothes {
    STUUSY,
    ROMANTIC_CROWN,
    EIGHT_DIVISION,
    NINETY,
    NINETY_FIVE,
    ONE_HUNDRED,
    ONE_HUNDRED_FIVE,
    ONE_HUNDRED_TEN;

    public static TransformEnumClothes transformEnumClothes(String s) throws ConditionInputException {
        TransformEnumClothes transformEnumClothes = switch (s) {
            case "1" -> {
                yield STUUSY;
            }
            case "2" -> {
                yield ROMANTIC_CROWN;
            }
            case "3" -> {
                yield EIGHT_DIVISION;
            }
            default -> {
                throw new ConditionInputException("1부터 3사이의 값만 입력하세요");
            }

        };
        return transformEnumClothes;
    }

    public static TransformEnumClothes transformEnumClothesSize(String s) throws ConditionInputException {
        TransformEnumClothes transformEnumClothesSize = switch (s) {
            case "1" -> {
                yield NINETY;
            }
            case "2" -> {
                yield NINETY_FIVE;
            }
            case "3" -> {
                yield ONE_HUNDRED;
            }
            case "4" -> {
                yield ONE_HUNDRED_FIVE;
            }
            case "5" -> {
                yield ONE_HUNDRED_TEN;
            }
            default -> {
                throw new ConditionInputException("1부터 5사이의 값만 입력하세요");
            }
        };
        return transformEnumClothesSize;
    }
}
