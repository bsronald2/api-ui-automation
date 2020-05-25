package com.auto.ui.pages.login;

import com.auto.ui.pages.AbstractBasePage;
import com.auto.ui.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractBasePage {

    @FindBy(css = "div.HPHeaderLogin > a > img")
    private WebElement loginButton;


    public void clickOnLoginButton() {
        CommonActions.clickElement(loginButton);
    }

    public static void loginAs(String userName, String password) {

    }
}
