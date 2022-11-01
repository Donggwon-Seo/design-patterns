package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumLogin {
    SIGNUP,
    LOGIN;

    public static TransformEnumLogin transform(String s) throws ConditionInputException{
        TransformEnumLogin transformEnumLogin = switch (s) {
            case "1" -> {
                yield SIGNUP;
            }
            case "2" -> {
                yield LOGIN;
            }
            default -> throw new ConditionInputException("1과 2의 값만 입력하세요");
        };
        return transformEnumLogin;
    }
}
