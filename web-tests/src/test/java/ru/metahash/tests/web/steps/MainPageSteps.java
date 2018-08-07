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
    public MainPageSteps selectSideBarMenuElement(String text, boolean scrollSideBarDown) {
        page.navigationBar().selectElementFromMenu(text, scrollSideBarDown);
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

    @Step("Click `Join ICO` button from promo block")
    public MainPageSteps clickPromoJoinIcoButton(){
        page.promoBlock().joinICOButton().click();
        return this;
    }

    @Step("Click `Contact us` button from navigation")
    public MainPageSteps clickContactUsFromNavigationBar(){
        page.navigationBar().contactUsButton().click();
        return this;
    }

    @Step("Click `White Paper` button from navigation")
    public MainPageSteps clickWhitePaperFromNavigationBar(){
        page.navigationBar().whitePaperButton().click();
        return this;
    }

    @Step("Click `One Pager` button from navigation")
    public MainPageSteps clickOnePagerFromNavigationBar(){
        page.navigationBar().onePagerButton().click();
        return this;
    }

    @Step("Select language `{language}`")
    public MainPageSteps selectLanguage(String language) {
        page.navigationBar().selectLanguage(language);
        return this;
    }

    @Step("Hide chat")
    public MainPageSteps hideChatElement(){
        page.hideChat();
        return this;
    }
}
