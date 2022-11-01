package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumProducts {
    CLOTHES,
    PANTS,
    ETC;

    public static TransformEnumProducts transform(String s) throws ConditionInputException{
        TransformEnumProducts transformEnumProducts = switch (s) {
            case "1" -> {
                yield CLOTHES;
            }
            case "2" -> {
                yield PANTS;
            }
            case "3" -> {
                yield ETC;
            }
            default -> {
                throw new ConditionInputException("1과 3사이의 값만 입력하세요");
            }
        };
        return transformEnumProducts;
    }
}
