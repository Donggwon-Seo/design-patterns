package clothesShopToyProject.signup;


import clothesShopToyProject.productfactory.ConditionInputException;
import clothesShopToyProject.transform.TransformEnumLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LoginAuthentication {
    private static Set<User> userData;
    private BufferedReader br;
    public static boolean loginStatus = false;
//    private TransformEnumLogin tf;

    public LoginAuthentication() {
        userData = new HashSet<>();
    }

    public boolean getLoginStatus() {
        return loginStatus;
    }

    public void process() throws IOException, ConditionInputException {

        System.out.println("---- 1. 회원가입 | 2. 로그인 ----");
        br = new BufferedReader(new InputStreamReader(System.in));

        String selectAuth = br.readLine();
//      tf = TransformEnumLogin.LOGIN;

        switch (TransformEnumLogin.transform(selectAuth)) {

            case SIGNUP -> {
//              System.out.println(tf);
                signUp();
                process();
            }
            case LOGIN -> {
                login();
            }
            default -> {
                throw new ConditionInputException("");
            }
        }
    }


    private void signUp() throws IOException {
        System.out.println("----------회원가입----------");

        System.out.print("id를 입력하세요 > ");
        String id = br.readLine();

        System.out.print("password를 입력하세요 > ");
        String password = br.readLine();

        System.out.print("name를 입력하세요 > ");
        String name = br.readLine();

        if (idValidation(id)) {
            userData.add(new User(id, password, name));
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("동일한 id가 있습니다.");
        }
    }

    private boolean idValidation(String id) {
        Iterator<User> iter = userData.iterator();
        while (iter.hasNext()) {
            User nextUser = iter.next();
            System.out.println(nextUser.getId());
            if (id.equals(nextUser.getId())) {
                return false;
            }
        }
        return true;
    }

    private boolean login() throws IOException {
        System.out.println("----------로그인----------");

        System.out.print("id를 입력하세요 > ");
        String id = br.readLine();

        System.out.print("password를 입력하세요 > ");
        String password = br.readLine();

        Iterator<User> iter = userData.iterator();
        while (iter.hasNext()) {
            User nextUser = iter.next();

            if (id.equals(nextUser.getId()) && password.equals(nextUser.getPassword())) {
                System.out.println("로그인 성공!");
                return loginStatus = true;
            } else if (!id.equals(nextUser.getId()) || !password.equals(nextUser.getPassword())) {
                System.out.println("잘못된 id 또는 password를 입력하였습니다.");
                return loginStatus = false;
            }
        }
        return loginStatus = false;
    }
}

