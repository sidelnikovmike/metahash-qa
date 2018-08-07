package ru.metahash.tests.web.blocks;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.metahash.tests.core.browser.utils.BrowserUtils;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.attribute;
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

    public void selectElementFromMenu(String text, boolean scrollSideBarDown) {
        getMenuElements()
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1))
                .find(Condition.text(text).because("Element with text `" + text + "` not found in main menu"))
                .scrollIntoView(scrollSideBarDown)
                .click();
    }

    public void selectLanguage(String language) {
        self.$("div[class*='lang-switch']").click();
        self.$("div[class*='lang-switch-container']").shouldBe(visible.because("Language select popup not displayed"));
        self.$$("div[class*='switch_item']")
                .shouldHave(sizeGreaterThanOrEqual(1).because("Elements with language select not found in popup"))
                .filter(attribute("data-value", language))
                .shouldHave(size(1).because(String.format("Not found element for language `%s`", language)))
                .first()
                .click();
    }

    private ElementsCollection getMenuElements() {
        return $$("div[class^='menu-item'] a");
    }

    public long getBlockHeight() {
        return BrowserUtils.getElementHeight(BLOCK_LOCATOR);
    }

    public SelenideElement contactUsButton() {
        return self.$("a[href*='contacus']");
    }

    public SelenideElement whitePaperButton() {
        return self.$("a[class*='download-white-paper'");
    }

    public SelenideElement onePagerButton() {
        return self.$("a[class*='download-one-pager'");
    }
}
