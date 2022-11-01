package clothesShopToyProject.transform;

import clothesShopToyProject.productfactory.ConditionInputException;

public enum TransformEnumPants {
    BLUE_PANTS,
    SLACKS,
    HALF_PANTS,
    TWENTY_EIGHT,
    THIRTY,
    THIRTY_TWO,
    THIRTY_FOUR,
    THIRTY_SIX;

    public static TransformEnumPants Transform(String s) throws ConditionInputException {
        TransformEnumPants transformEnumPants = switch (s) {
            case "1" -> {
                yield BLUE_PANTS;
            }
            case "2" -> {
                yield SLACKS;
            }
            case "3" -> {
                yield HALF_PANTS;
            }
            default -> {
                throw new ConditionInputException("1과 3사이의 값만 입력하세요");
            }
        };
        // TransformEnumPants.values(); -> 여기서 인덱스를 처리하는 것도 괜찮을거 같음 (고려)
        return transformEnumPants;
    }

    public static TransformEnumPants TransformEnumPantsSize(String s) throws ConditionInputException {
        TransformEnumPants transformEnumPantsSize = switch (s) {
            case "1" -> {
                yield TWENTY_EIGHT;
            }
            case "2" -> {
                yield THIRTY;
            }
            case "3" -> {
                yield THIRTY_TWO;
            }
            case "4" -> {
                yield THIRTY_FOUR;
            }
            case "5" -> {
                yield THIRTY_SIX;
            }
            default -> {
                throw new ConditionInputException("1부터 5사이의 값만 입력하세요");
            }
        };
        return transformEnumPantsSize;
    }
}
