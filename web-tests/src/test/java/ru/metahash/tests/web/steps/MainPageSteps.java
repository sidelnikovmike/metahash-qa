package ru.metahash.tests.web.steps;

import io.qameta.allure.Step;
import ru.metahash.tests.web.pages.MainPage;

public class MainPageSteps {

    private MainPage page;

    public MainPageSteps forPage(MainPage page) {
        this.page = page;
        return this;
    }

    @Step("Select show sidebar menu element")
    public MainPageSteps showSideBarMenu() {
        page.navigationBar().clickSideBarMenuButton();
        return this;
    }

    @Step("Select sidebar menu element by text `{text}`")
    public MainPageSteps selectSideBarMenuElement(String text) {
        page.navigationBar().selectElementFromMenu(text);
        return this;
    }

    @Step("Check blocks with ids `{ids}` shown on page")
    public MainPageSteps checkBlocksWithIdsShown(String... ids) {
        for (String id : ids) {
            page.checkBlockShown(id);
        }
        return this;
    }

    @Step("Check blocks with ids `{ids}` not shown on page")
    public MainPageSteps checkBlocksWithIdsNotShown(String... ids) {
        for (String id : ids) {
            page.checkBlockNotShown(id);
        }
        return this;
    }

}
