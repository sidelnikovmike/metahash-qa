package ru.metahash.tests.tests.functional;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

@DisplayName("Tests on navigation")
public class NavigationTests extends BaseTest {

    @Test
    @DisplayName("Check show of News block")
    @Description("Check show of News block after select in sidebar menu")
    public void checkNewsShow() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .showSideBarMenu()
                .selectSideBarMenuElement("#MetaHash News")
                .checkBlocksWithIdsShown("news");
    }


}
