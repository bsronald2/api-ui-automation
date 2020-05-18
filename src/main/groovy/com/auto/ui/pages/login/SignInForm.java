package com.auto.ui.pages.login;

import com.auto.ui.pages.AbstractBasePage;

public class SignInForm extends AbstractBasePage {




    public static void loginAs(String userName, String password) {
        Welcome welcome = new Welcome();
        SignInForm signInForm = welcome.clickSigninLink();
    }
}
