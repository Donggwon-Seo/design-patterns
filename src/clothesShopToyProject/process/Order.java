package clothesShopToyProject.process;

import clothesShopToyProject.product.Product;
import clothesShopToyProject.productfactory.*;
import clothesShopToyProject.signup.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Order {
    Product product;
    loginAuthentication login = new loginAuthentication();
    ClothesFactory clothesFactory = new ClothesFactory();
    EtcFactory etcFactory = new EtcFactory();
    OptionFactory optionFactory = new OptionFactory();
    PantsFactory pantsFactory = new PantsFactory();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean exit = true;
    private static boolean etcCheck = false;
    int colorCheck = 1;

    public Order() throws ConditionInputException, IOException {
        do {
            System.out.println("--- 1. 회원가입 및 로그인 | 2. 상품 주문 | 3. 종료 ---");
            int selectOrder = Integer.parseInt(br.readLine());

            if (selectOrder == 1) {
                login.process();
            } else if (selectOrder == 2 && login.getLoginStatus()) {
                selectProduct();
                if (etcCheck) {
                    System.out.println(product.getBrand() +" "+ product.getDescription()+"의 주문이 완료되었습니다.");
                    break;
                }
                selectOptions();
            } else if (selectOrder == 2 && login.getLoginStatus() == false) {
                System.out.println("로그인을 진행하여 주세요.");
                login.process();
            } else if (selectOrder == 3) {
                exit = false;
            } else
                throw new ConditionInputException("1과 2의 숫자만 입력하여 주세요");
        } while (exit);
    }

    public void selectProduct() throws ConditionInputException, IOException { // switch expression 적용해보기 무조건 ~
        System.out.println("동권 멀티숍에 오신 걸 환영합니다.");
        System.out.println("---- 1. 상의 | 2. 하의 | 3. 악세서리 ----");

        int selectProductNum = Integer.parseInt(br.readLine());

        if (selectProductNum == 1) {
            System.out.println("-------- 원하시는 상의을 선택하여 주세요 --------");
            System.out.println("---- 1. 스투시 후드티 | 2. 로맨틱크라운 맨투맨 | 3. 8디비전 니트 ----");

            int selectClothesNum = Integer.parseInt(br.readLine());
            product = clothesFactory.createClothes(selectClothesNum);
        } else if (selectProductNum == 2) {
            System.out.println("-------- 원하시는 하의을 선택하여 주세요 --------");
            System.out.println("---- 1. 청바지 | 2. 슬랙스 | 3. 반바지 ----");

            int selectPantsNum = Integer.parseInt(br.readLine());
            product = clothesFactory.createClothes(selectPantsNum);
        } else if (selectProductNum == 3) {
            System.out.println("-------- 원하시는 악세서리를 선택하여 주세요 --------");
            System.out.println("---- 1. 시계 | 2. 반지 | 3. 모자 ----");

            int selectEtcNum = Integer.parseInt(br.readLine());
            product = etcFactory.createEtc(selectEtcNum);
            etcCheck = true;
        }
    }

    public void selectOptions() throws ConditionInputException, IOException {


        do {
            System.out.println("--------------------옵션 선택 창입니다.--------------------");
            System.out.println("----1. 기장 수선 | 2. 색상 변경 : White | 3. 색상 변경 : Red | 4. 옵션을 더 이상 추가하지 않음----");
            int selectOptionNum = Integer.parseInt(br.readLine());
            if (selectOptionNum == 1) {
                product = optionFactory.selectOption(selectOptionNum, product);
                System.out.println("기장 수선이 추가되었습니다");
            } else if (selectOptionNum == 2 && colorCheck == 1) {
                colorCheck--;
                product = optionFactory.selectOption(selectOptionNum, product);
                System.out.println("색상을 WHITE로 변경하였습니다.");
            } else if (selectOptionNum == 3 && colorCheck == 1) {
                colorCheck--;
                product = optionFactory.selectOption(selectOptionNum, product);
                System.out.println("색상을 RED로 변경하였습니다.");
            } else if (selectOptionNum == 4) {
                colorCheck--;
                product = optionFactory.selectOption(selectOptionNum, product);
                System.out.println("옵션 선택이 종료되었습니다.");
            } else if (colorCheck == 0) {
                System.out.println("색상 변경 기회가 없습니다.");
            } else
                throw new ConditionInputException("1부터 3사이의 숫자만 입력하세요");
        } while (colorCheck == 1);

        System.out.println(product.getDescription() + ", size :" + product.getSize() + "의 주문이 완료되었습니다.");
    }


}
