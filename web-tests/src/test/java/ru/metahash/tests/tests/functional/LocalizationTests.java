package ru.metahash.tests.tests.functional;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metahash.tests.core.browser.checker.domain.TextCheckEntity;
import ru.metahash.tests.core.browser.checker.service.TextChecker;
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.metahash.tests.core.browser.utils.BrowserUtils.waitForWindowWithUrlOpen;

@DisplayName("Smoke tests on localization")
public class LocalizationTests extends BaseTest {

    @Test
    @DisplayName("Check language switch to ru")
    @Description("Check language switched to ru, keywords is also in Russian")
    public void checkLanguageSwitchRU() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ru");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("Русский", "Напишите нам",
                        "Как мы достигли таких скоростей",
                        "Ресурсы для майнинга","Преимущества","Команда"),
                new TextCheckEntity().withLocator("#promo").withTexts("быстрая","безопасная",
                        "децентрализованная", "криптовалюта")
        );
    }

    @Test
    @DisplayName("Check language switch to CH")
    @Description("Check language switched to CH, keywords is also in Chinese")
    public void checkLanguageSwitchCN() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("cn");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("中文", "联系我们",
                        "如何实现如此迅速？",
                        "#MHC的挖掘和锻造","主要区块链系统的对比表","我们的团队"),
                new TextCheckEntity().withLocator("#promo").withTexts("快速","安全",
                        "去中心化式", "虚拟货币")
        );
    }

    @Test
    @DisplayName("Check language switch to KO")
    @Description("Check language switched to KO, keywords is also in Korean")
    public void checkLanguageSwitchKO() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ko");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("한국어", "연락주십시오",
                        "어떻게 그러한 신속함을 이루어 냈습니까?",
                        "#MHC 채굴/포징하기","주요 블록체인 시스템의 비교표","우리 팀"),
                new TextCheckEntity().withLocator("#promo").withTexts("삐른 속도","안정성",
                        "분산화", "암호화폐")
        );
    }

    @Test
    @DisplayName("Check language switch to JA")
    @Description("Check language switched to JA, keywords is also in Japanese")
    public void checkLanguageSwitchJA() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ja");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("日本語", " お問い合わせ",
                        "どのようにしてこの迅速性にたどりついたのでしょう？",
                        "#MHCのマイニング/フォージング","主なブロックチェーン・システムの比較表","当チーム"),
                new TextCheckEntity().withLocator("#promo").withTexts("速い","安全性",
                        "分散化", "仮想通貨")
        );
    }

    @Test
    @DisplayName("Check language switch to MS")
    @Description("Check language switched to MS, keywords is also in Malaysian")
    public void checkLanguageSwitchMS() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ms");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("Bahasa Melayu", "Hubungi kami",
                        "Bagaimanakah kami dapat mencapai kepantasan sedemikian?",
                        "Perlombongan / penempaan #MHC","Jadual perbandingan bagi sistem Blockchain utama","Pasukan kami"),
                new TextCheckEntity().withLocator("#promo").withTexts("pantas","selamat",
                        "desentralisasi", "matawang kripto")
        );
    }

    @Test
    @DisplayName("Check language switch to PT")
    @Description("Check language switched to PT, keywords is also in Portugese")
    public void checkLanguageSwitchPT() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("pt");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("Português", "Contacte-nos",
                        "Como atingimos tal rapidez?",
                        "Mineração / forjamento de #MHC","Vantagens #MetaHash","A nossa equipa"),
                new TextCheckEntity().withLocator("#promo").withTexts("rápido","seguro",
                        "descentralizado", "criptomoeda")
        );
    }

    @Test
    @DisplayName("Check language switch to es")
    @Description("Check language switched to es, keywords is also in Spain")
    public void checkLanguageSwitchES() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("es");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("Español", "Ponte en contacto con nosotros",
                        "¿Cómo hemos conseguido esta rapidez?",
                        "Minería / forjado de #MHC","Ventajas de #MetaHash","Nuestro equipo"),
                new TextCheckEntity().withLocator("#promo").withTexts("rápido","seguro",
                        "descentralizado", "criptomoneda")
        );
    }

    @Test
    @DisplayName("Check language switch to TR")
    @Description("Check language switched to TR, keywords is also in Turkey language")
    public void checkLanguageSwitchTR() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("tr");

        new TextChecker().checkTexts(
                new TextCheckEntity().withLocator("body").withTexts("Türkçe", "Bizimle iletişime geçin",
                        "Bu sürati nasıl elde ettik?",
                        "#MHC madenciliği / dövmeciliği","#MetaHash avantajları","Ekibimiz"),
                new TextCheckEntity().withLocator("#promo").withTexts("hızlı","güvenli",
                        "dağıtık", "kriptopara birimi")
        );
    }

    @Test
    @DisplayName("Check downloaded White Paper on RU")
    @Description("Check language switched to ru, White Paper is on RU")
    public void checkDownloadWhitePaperRU() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ru")
                .clickDownloadWhitePaperBtn();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_RU.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on CN")
    @Description("Check language switched to CN, White Paper is on Chinese")
    public void checkDownloadWhitePaperCN() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("cn")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_CN.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on KO")
    @Description("Check language switched to KO, White Paper is on Korean")
    public void checkDownloadWhitePaperKO() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ko")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_KO.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on Japanese")
    @Description("Check language switched to Japanese, White Paper is on Japanese")
    public void checkDownloadWhitePaperJA() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ja")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_JP.pdf?v=4",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on Malaysian")
    @Description("Check language switched to Malaysian, White Paper is on Malaysian")
    public void checkDownloadWhitePaperMS() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("ms")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_MS.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on Portugal")
    @Description("Check language switched to Portugal, White Paper is on Portugal")
    public void checkDownloadWhitePaperPT() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("pt")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_PT.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on Spain language")
    @Description("Check language switched to Spain language, White Paper is on Spain language")
    public void checkDownloadWhitePaperES() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("es")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_ES.pdf?v=5",
                5) != null,
                "Page not opened");
    }

    @Test
    @DisplayName("Check downloaded White Paper on Turkey language")
    @Description("Check language switched to Turkey language, White Paper is on Turkey language")
    public void checkDownloadWhitePaperTR() {
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .selectLanguage("tr")
                .clickWhitePaperFromNavigationBar();

        assertTrue(waitForWindowWithUrlOpen(
                "https://static.metahash.org/docs/MetaHash_WhitePaper_TR.pdf?v=5",
                5) != null,
                "Page not opened");
    }
}
