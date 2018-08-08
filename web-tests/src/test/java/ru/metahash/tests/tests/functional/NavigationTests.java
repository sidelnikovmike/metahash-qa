package ru.metahash.tests.tests.functional;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metahash.tests.core.browser.utils.BrowserUtils;
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.metahash.tests.core.browser.utils.BrowserUtils.waitForWindowWithUrlOpen;

@DisplayName("Tests on navigation")
public class NavigationTests extends BaseTest {

    @Test
    @DisplayName("Check show of News block")
    @Description("Check show of News block after select in sidebar menu")
    public void checkNewsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("#MetaHash News", false)
                .checkBlocksWithIdsShown("news");
    }

    @Test
    @DisplayName("Check show of What's #Metahash? block")
    @Description("Check show of What's #Metahash? block after select in sidebar menu")
    public void checkWhatsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("What is #MetaHash?", false)
                .checkBlocksWithIdsShown("whatis");
    }

    @Test
    @DisplayName("Check show of #TraceChain block")
    @Description("Check show of #TraceChain block after select in sidebar menu")
    public void checkTraceChainShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("TraceChain", false)
                .checkBlocksWithIdsShown("tracechain");
    }

    @Test
    @DisplayName("Check show of #MetaApps block")
    @Description("Check show of #MetaApps block after select in sidebar menu")
    public void checkMetaAppsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("MetaApps", false)
                .checkBlocksWithIdsShown("metaapps");
    }

    @Test
    @DisplayName("Check show of #MetaGate block")
    @Description("Check show of #MetaGate block after select in sidebar menu")
    public void checkMetaGateShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("MetaGate", false)
                .checkBlocksWithIdsShown("metagate");
    }

    @Test
    @DisplayName("Check show of RoadMap block")
    @Description("Check show of RoadMap block after select in sidebar menu")
    public void checkRoadMapShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("RoadMap", false)
                .checkBlocksWithIdsShown("timemap");
    }

    @Test
    @DisplayName("Check show of Advisors&Consultants block")
    @Description("Check show of Advisors&Consultants block after select in sidebar menu")
    public void checkAdvisorsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("Advisors", false)
                .checkBlocksWithIdsShown("advisors-and-consultants");
    }

    @Test
    @DisplayName("Check show of The Team block")
    @Description("Check show of The Team block after select in sidebar menu")
    public void checkTeamShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("Team", false)
                .checkBlocksWithIdsShown("teambanner");
    }

// donot work- не находит блок с указанным айди
    @Test
    @DisplayName("Check show of ICO Round A block")
    @Description("Check show of ICO Round A after select in sidebar menu")
    public void checkICOShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("ICO", true)
                .checkBlocksWithIdsShown("ico");
    }

    // donot work- не находит блок с указанным айди - не докручивает
    @Test
    @DisplayName("Check show of FAQ block")
    @Description("Check show of FAQ block after select in sidebar menu")
    public void checkFAQShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .hideChatElement()
                .selectSideBarMenuElement("F.A.Q", true)
                .checkBlocksWithIdsShown("faq");
    }

    @Test
    @DisplayName("Check show of Press block")
    @Description("Check show of Press block after select in sidebar menu")
    public void checkPressShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .hideChatElement()
                .selectSideBarMenuElement("Press", false)
                .checkBlocksWithIdsShown("press");
    }


    @Test
    @DisplayName("Check show of Contact us block")
    @Description("Check show of Contact us block after select in sidebar menu")
    public void checkContactUsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .hideChatElement()
                .selectSideBarMenuElement("Contact", true)
                .checkBlocksWithIdsShown("contacus");
    }

    @Test
    @DisplayName("Check White Paper")
    @Description("Check open of second page on click on White paper from navigation bar")
    public void checkWhitePaper() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_EN.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check White Paper from sidebar menu")
    @Description("Check open of second page on click on White paper from sidebar menu")
    public void checkWhitePaperSideMenu() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("White Paper", false);

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_EN.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check Important block from sidebar menu")
    @Description("Check open of Important page from sidebar menu")
    public void checkImportantPageShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("Important", false);
        BrowserUtils.checkWindowUrl("https://metahash.org/important/");
    }

    @Test
    @DisplayName("Check One Pager")
    @Description("Check open of second page on click on ONE Pager from navigation bar")
    public void checkOnePager() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickOnePagerFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_OnePager_EN.pdf",
                5) != null,
                "Page not opened");

    }

    //do not work- не находит блок с указанным айди - это баг
    @Test
    @DisplayName("NavBar:Contact Us")
    @Description("Check open of Contact Us from navigation bar")
    public void checkContactUsShowNavBar() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickContactUsFromNavigationBar()
                .checkBlocksWithIdsShown("contacus");
    }


}
