package com.auto.ui.pages;


import com.auto.ui.pages.headers.ContentHeader
import com.auto.ui.pages.headers.MenuHeader
import com.auto.ui.pages.sidebar.LeftSideBar

public class MainPage extends AbstractBasePage {

    private MenuHeader menuHeader;
    private ContentHeader contentHeader;
    private LeftSideBar leftSideBar;


    public MainPage() {
        this.menuHeader = new MenuHeader()
        this.contentHeader = new ContentHeader();
        this.leftSideBar = new LeftSideBar();
    }

    MenuHeader getMenuHeader() {
        return menuHeader
    }

    ContentHeader getContentHeader() {
        return contentHeader
    }

    LeftSideBar getLeftSideBar() {
        return leftSideBar
    }
}
