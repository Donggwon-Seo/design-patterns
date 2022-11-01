package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumOrder {
    LOGIN_AND_SIGNUP,
    ORDER,
    EXIT;

    public static TransformEnumOrder transform(String s) throws ConditionInputException {
        TransformEnumOrder transformEnumOrder = switch (s) {
            case "1" -> {
                yield LOGIN_AND_SIGNUP;
            }
            case "2" -> {
                yield ORDER;
            }
            case "3" -> {
                yield EXIT;
            }
            default -> {
                throw new ConditionInputException("1부터 3사이의 숫자를 입력하세요");
            }
        };
        return transformEnumOrder;
    }
}
