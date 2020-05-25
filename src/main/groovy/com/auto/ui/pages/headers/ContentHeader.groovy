package com.auto.ui.pages.headers;

import com.auto.ui.pages.AbstractBasePage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContentHeader extends AbstractBasePage {

    @FindBy(css = "span[class*='HeaderRefreshDiv']")
    WebElement refreshButton

    @FindBy(css = "td.HeaderTd img[src*=\"logo\"]")
    WebElement logo

    /**
     * This method wait while loading element.
     */
    private void waitPage() {
        wait.until(ExpectedConditions.visibilityOf(logo))
    }

    public ContentHeader() {
        waitPage()
    }
}
