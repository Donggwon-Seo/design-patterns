package clothesShopToyProject.process;

import clothesShopToyProject.product.Product;
import clothesShopToyProject.productfactory.*;
import clothesShopToyProject.signup.*;
import clothesShopToyProject.transform.TransformEnumOptions;
import clothesShopToyProject.transform.TransformEnumOrder;
import clothesShopToyProject.transform.TransformEnumProducts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Order {
    Product product;
    LoginAuthentication login = new LoginAuthentication();
    ClothesFactory clothesFactory = new ClothesFactory();
    EtcFactory etcFactory = new EtcFactory();
    OptionFactory optionFactory = new OptionFactory();
    PantsFactory pantsFactory = new PantsFactory();
    //    TransformEnumProducts tfProduct;
//    TransformEnumOptions tfOption;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean exit = true;
    private static boolean etcCheck = false;
    private static boolean selectOptionCheck = true;
    int colorCheck = 1;

    public Order() throws ConditionInputException, IOException {
        do {
            // console에 보여주는 클래스들을 별도로 구현
            // colsole에 보여주는 방법을 구현하는 비즈니스 로직들을 따로 구현
            System.out.println("--- 1. 회원가입 및 로그인 | 2. 상품 주문 | 3. 종료 ---");
            String selectOrder = br.readLine();

            switch (TransformEnumOrder.transform(selectOrder)) {
                case LOGIN_AND_SIGNUP -> {
                    login.process();
                }
                case ORDER -> {
                    if (login.getLoginStatus()) { // STATE PATTERN 사용해보기 -> 공부하기
                        selectProduct();
                        if (etcCheck) {
                            System.out.println(product.getBrand() + " " + product.getDescription() + "의 주문이 완료되었습니다.");
                            break;
                        }
                        selectOptions();
                    } else {
                        System.out.println("로그인을 진행하여 주세요.");
                        login.process();
                    }
                }
                case EXIT -> {
                    exit = false;
                }
                default -> {
                    throw new ConditionInputException("");
                }
            }
        } while (exit);
    }

    public void selectProduct() throws ConditionInputException, IOException { // switch expression 적용해보기 무조건 ~
        System.out.println("동권 멀티숍에 오신 걸 환영합니다.");
        System.out.println("---- 1. 상의 | 2. 하의 | 3. 악세서리 ----");

        String selectProduct = br.readLine();
        switch (TransformEnumProducts.transform(selectProduct)) {
            case CLOTHES -> {
                System.out.println("-------- 원하시는 상의을 선택하여 주세요 --------");
                System.out.println("---- 1. 스투시 후드티 | 2. 로맨틱크라운 맨투맨 | 3. 8디비전 니트 ----");

                String selectClothes = br.readLine();
                product = clothesFactory.createClothes(selectClothes);
            }
            case PANTS -> {
                System.out.println("-------- 원하시는 하의을 선택하여 주세요 --------");
                System.out.println("---- 1. 청바지 | 2. 슬랙스 | 3. 반바지 ----");

                String selectPants = br.readLine();
                product = PantsFactory.createPants(selectPants);
            }
            case ETC -> {
                System.out.println("-------- 원하시는 악세서리를 선택하여 주세요 --------");
                System.out.println("---- 1. 시계 | 2. 반지 | 3. 모자 ----");

                String selectEtc = br.readLine();
                product = etcFactory.createEtc(selectEtc);
                etcCheck = true;
            }
            default -> {
                throw new ConditionInputException("");
            }
        }
    }

    public void selectOptions() throws ConditionInputException, IOException {


        do {
            System.out.println("--------------------옵션 선택 창입니다.--------------------");
            System.out.println("----1. 기장 수선 | 2. 색상 변경 : White | 3. 색상 변경 : Red | 4. 옵션을 더 이상 추가하지 않음----");

            String selectOption = br.readLine();
            switch (TransformEnumOptions.transform(selectOption)) {
                case REFORM -> {
                    product = optionFactory.selectOption(selectOption, product);
                    System.out.println("기장 수선이 추가되었습니다");
                }
                case COLOR_WHITE -> {
                    if (colorCheck < 1) {
                        System.out.println("색상을 변경할 수 없습니다.");
                        break;
                    }
                    colorCheck--;
                    product = optionFactory.selectOption(selectOption, product);
                    System.out.println("색상을 WHITE로 변경하였습니다.");
                }
                case COLOR_RED -> {
                    if (colorCheck < 1) {
                        System.out.println("색상을 변경할 수 없습니다.");
                        break;
                    }
                    colorCheck--;
                    product = optionFactory.selectOption(selectOption, product);
                    System.out.println("색상을 RED로 변경하였습니다.");
                }
                case EXIT -> {
                    product = optionFactory.selectOption(selectOption, product);
                    System.out.println("옵션 선택이 종료되었습니다.");
                    selectOptionCheck = false;
                }
                default -> {
                }
            }
        } while (selectOptionCheck);
        colorCheck = 1;
        System.out.println(product.getDescription() + ", size :" + product.getSize() + "의 주문이 완료되었습니다.");
    }


}
