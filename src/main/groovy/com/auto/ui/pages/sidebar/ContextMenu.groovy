package com.auto.ui.pages.sidebar

import com.auto.ui.pages.AbstractBasePage
import com.auto.ui.pages.common.CommonActions
import com.auto.ui.pages.common.UICommonMethods
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ContextMenu extends AbstractBasePage {

    @FindBy(css = "ul[id='projectContextMenu'][style*='block'] li.edit")
    WebElement editBtn


    /**
     * Click on icon.
     *
     * @param iconId
     */
    public void clickOnIcon(String iconId) {
        // Select Icon
        By byIcon = By.cssSelector("ul[id='projectContextMenu'][style*='block'] span.IconFrame[iconid='${iconId}']")
        if (UICommonMethods.isElementPresent(byIcon)) {
            WebElement iconElement = driver.findElement(byIcon)
            CommonActions.clickElement(iconElement)
        }
    }

    public void clickOnEditBtn() {
        CommonActions.clickElement(editBtn)
    }
}
