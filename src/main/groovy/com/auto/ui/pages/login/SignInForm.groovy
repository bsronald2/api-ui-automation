package com.auto.ui.pages.login;

import com.auto.ui.pages.AbstractBasePage;
import com.auto.ui.pages.MainPage;
import com.auto.ui.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInForm extends AbstractBasePage {

    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxEmail")
    WebElement textBoxEmail;

    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxPassword")
    WebElement textBoxPassword;

    @FindBy(className = "HPLoginBtn")
    WebElement loginButton;


    /**
     * This method perform the login task.
     *
     * @param userName
     * @param password
     * @return Main Page
     */
    public static MainPage loginAs(String userName, String password) {
        Welcome welcome = new Welcome();
        SignInForm signInForm = welcome.clickSigninLink();
        signInForm.fillOutEmail(userName);
        signInForm.fillOutPassword(password);

        return signInForm.clickOnLoginButton();
    }

    /**
     * Perform click on Login Button
     * @return
     */
    private MainPage clickOnLoginButton() {
        CommonActions.clickElement(loginButton);

        return new MainPage();
    }

    /**
     * Fill out form with Password
     * @param password
     */
    private void fillOutPassword(String password) {
        CommonActions.clearTextField(textBoxPassword);
        CommonActions.sendKeys(textBoxPassword, password);
    }

    /**
     * Fill out form with userName
     * @param userName
     */
    private void fillOutEmail(String userName) {
        CommonActions.clearTextField(textBoxEmail);
        CommonActions.sendKeys(textBoxEmail, userName);
    }
}
