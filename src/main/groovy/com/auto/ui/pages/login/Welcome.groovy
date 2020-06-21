package com.auto.ui.pages.login

import com.auto.ui.pages.AbstractBasePage;
import com.auto.ui.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Welcome extends AbstractBasePage {

    @FindBy(css = "div.HPHeaderLogin > a > img")
    private WebElement signinLink;

    /**
     * This method to clicks on the "Signin" button.
     *
     * @return Return to SignInForm page.
     */
    public SignInForm clickSigninLink() {
        waitPage()
        CommonActions.clickElement(signinLink);

        return new SignInForm();
    }

    /**
     * This method wait while loading element.
     */
    public void waitPage() {
        wait.until(ExpectedConditions.visibilityOf(signinLink));
    }
}
