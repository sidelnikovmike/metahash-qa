package ru.metahash.tests.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.metahash.tests.configuration.TestsConfiguration;
import ru.metahash.tests.core.browser.utils.BrowserUtils;
import ru.metahash.tests.web.blocks.NavigationBar;
import ru.metahash.tests.web.blocks.PromoBlock;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {

    public NavigationBar navigationBar() {
        return new NavigationBar();
    }

    public PromoBlock promoBlock() {return new PromoBlock();}

    public static MainPage openPage() {
        return open(TestsConfiguration.getConfig().getBaseSiteUrl(), MainPage.class);
    }

    public void checkBlockShown(String id) {
        sleep(3000); //wait until scroll finish
        $("#" + id).should(exist.because("Block with id `" + id + "` not found on page"));
        long elementYPosition = BrowserUtils.getElementYPosition("#" + id);
        long pageYOffset = BrowserUtils.getPageYOffset();
        long viewPortHeight = BrowserUtils.getViewPortHeight();
        long navigationBarHeight = navigationBar().getBlockHeight();
        assertTrue(
                elementYPosition > (pageYOffset - navigationBarHeight) &&
                        elementYPosition < (pageYOffset - navigationBarHeight) + viewPortHeight,
                "Block with id `" + id + "` not shown on page");
    }

    public void checkBlockNotShown(String id) {
        sleep(3000); //wait until scroll finish
        $("#" + id).should(exist.because("Block with id `" + id + "` not found on page"));
        long elementYPosition = BrowserUtils.getElementYPosition("#" + id);
        long pageYOffset = BrowserUtils.getPageYOffset();
        long viewPortHeight = BrowserUtils.getViewPortHeight();
        long navigationBarHeight = navigationBar().getBlockHeight();
        assertTrue(
                elementYPosition < (pageYOffset - navigationBarHeight) ||
                        elementYPosition > (pageYOffset - navigationBarHeight) + viewPortHeight,
                "Block with id `" + id + "` is shown on page,but should not");
    }
}
