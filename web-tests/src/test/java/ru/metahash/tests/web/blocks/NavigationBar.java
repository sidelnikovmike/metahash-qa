package ru.metahash.tests.web.blocks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ru.metahash.tests.core.browser.utils.BrowserUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationBar extends BaseBlock {

    private static final String BLOCK_LOCATOR = "#navigation";

    public NavigationBar() {
        super($(BLOCK_LOCATOR));
    }

    public void clickSideBarMenuButton() {
        self.$("div[class='offcanvas-button']").shouldBe(visible).click();
    }

    public void selectElementFromMenu(String text) {
        getMenuElements()
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1))
                .find(Condition.text(text).because("Element with text `" + text + "` not found in main menu"))
                .click();
    }

    private ElementsCollection getMenuElements() {
        return $$("div[class^='menu-item'] a");
    }

    public long getBlockHeight() {
        return BrowserUtils.getElementHeight(BLOCK_LOCATOR);
    }
}
