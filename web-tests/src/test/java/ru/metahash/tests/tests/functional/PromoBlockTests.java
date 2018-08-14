package ru.metahash.tests.tests.functional;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metahash.tests.configuration.TestsConfiguration;
import ru.metahash.tests.core.browser.utils.BrowserUtils;
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.metahash.tests.core.browser.utils.BrowserUtils.waitForWindowWithUrlOpen;

@DisplayName("Promo block tests")
public class PromoBlockTests extends BaseTest {
    // не работает не ищет по айди
    @Test
    @DisplayName("Check 'Join ICO Round A' from promo block")
    @Description("Check open of 'ICO Round A' section by clicking 'Join ICO Round A' btn on promo page")
    public void checkJoinICOButton() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickPromoJoinIcoButton()
                .checkBlocksWithIdsShown("ico");
    }

    @Test
    @DisplayName("Check 'How do I earm #MHC?' link from promo block")
    @Description("Check opening of the second page by clicking 'How do I earm #MHC?' link from promo block")
    public void checkEarnMHCLink() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickEarnMHCLink();
        BrowserUtils.checkWindowUrl(TestsConfiguration.getConfig().getBaseSiteUrl() + "/important/#forging");
    }

    @Test
    @DisplayName("Check 'What's market cap?' link from promo block")
    @Description("Check opening of the second page by clicking 'Whats market cap?' link from promo block")
    public void checkMarketCapLink() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickMarketCapLink();
        BrowserUtils.checkWindowUrl("https://metahash.org/important/#market_cap");
    }

    @Test
    @DisplayName("Check 'What's the deal with forging?' link from promo block")
    @Description("Check opening of the second page by clicking 'What's the deal with forging?' link from promo block")
    public void checkForgingLink() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickForgingLink();
        BrowserUtils.checkWindowUrl("https://metahash.org/important/#deal");
    }

    @Test
    @DisplayName("Check 'Tell me about Multi-PoS' link from promo block")
    @Description("Check opening of the second page by clicking 'Tell me about Multi-PoS' link from promo block")
    public void checkMultiPOSLink() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickMultiPOSLink();
        BrowserUtils.checkWindowUrl("https://metahash.org/important/#about-Multi-PoS");
    }

    @Test
    @DisplayName("Check 'Download White Paper' from promo page")
    @Description("Check open of second page on click 'Download White paper' from promo page")
    public void checkDownloadWhitePaperBtnPromoPage() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickDownloadWhitePaperBtn();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_EN.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check 'Download One Pager' from promo page")
    @Description("Check open of second page on click 'Download One-Pager' from promo page")
    public void checkDownloadOnePagerBtnPromoPage() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickDownloadOnePagerBtn();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_OnePager_EN.pdf",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check 'Download #MetaGate client' from promo page")
    @Description("Check open of page on click btn 'Download #MetaGate client' from promo page")
    public void checkDownloadMetaGateClientBtnPromoPage() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickDownloadMetaGateBtn();

        assertTrue(waitForWindowWithUrlOpen(
                "https://metagate.metahash.org/?",
                5) != null,
                "Page not opened");
    }
//не работает- кнопка телеграм не визибл
    @Test
    @DisplayName("Check Telegram btn from promo page")
    @Description("Check open of page on click btn Telegram from promo page")
    public void checkTelegramBtnPromoPage() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickTelegramBtn();

        assertTrue(waitForWindowWithUrlOpen(
                "https://t.me/metahash_ENG",
                5) != null,
                "Page not opened");
    }
}