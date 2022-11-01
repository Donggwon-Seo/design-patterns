package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumOptions {
    REFORM,
    COLOR_WHITE,
    COLOR_RED,
    EXIT;

    public static TransformEnumOptions transform(String s) throws ConditionInputException {
        TransformEnumOptions transformEnumOptions = switch (s) {
            case "1" -> {
                yield REFORM;
            }
            case "2" -> {
                yield COLOR_WHITE;
            }
            case "3" -> {
                yield COLOR_RED;
            }
            case "4" ->{
                yield EXIT;
            }
            default -> {
                throw new ConditionInputException("1과 4사이의 값만 입력하세요");
            }
        };
        return transformEnumOptions;
    }

}
