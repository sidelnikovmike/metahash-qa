package ru.metahash.tests.core.browser.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.Set;

import static com.codeborne.selenide.Selenide.sleep;

public class BrowserUtils {

    public static void scrollToBottomOfThePage(int waitTimeoutInMilliseconds) {
        int pageHeight = getPageHeight();
        long viewportHeight = getViewPortHeight();
        int scrollCount = (int) Math.ceil(pageHeight / viewportHeight);
        for (int i = 1; i < scrollCount; i++) {
            scrollDown(viewportHeight * i);
            sleep(waitTimeoutInMilliseconds);
        }
    }

    public static void scrollDown(long viewportHeight) {
        Selenide.executeJavaScript("document.documentElement.scrollTop = " + viewportHeight);
    }

    public static long getViewPortHeight() {
//        return 500; //default value for screenshots
//        return ((Number) Selenide.executeJavaScript("return document.documentElement.clientHeight;")).intValue() / 2; //for screenshots
        return ((Number) Selenide.executeJavaScript("return document.documentElement.clientHeight;")).intValue(); //for screenshots
    }

    public static int getViewPortWidth() {
        return ((Number) Selenide.executeJavaScript("return document.documentElement.clientWidth;")).intValue();
    }

    public static int getPageHeight() {
        return ((Number) Selenide.executeJavaScript(("return document.documentElement.scrollHeight;"))).intValue();
    }

    public static long getPageYOffset() {
        return (Long) Selenide.executeJavaScript(("return window.pageYOffset;"));
    }

    public static long getElementYPosition(String locator) {
        return ((Number) Selenide.executeJavaScript(("return $(\"" + locator + "\").position().top"))).longValue();
    }

    public static long getElementHeight(String locator) {
        return (Long) Selenide.executeJavaScript(("return $(\"" + locator + "\").height()"));
    }

    /**
     * waits for window with url to be opened
     *
     * @param url              page url
     * @param timeoutInSeconds timeout in second for wait
     * @return window handle or null if window not opened
     */
    public static String waitForWindowWithUrlOpen(String url, int timeoutInSeconds) {
        int waitCount = 0;
        String windowHandle = getWindowWithUrl(url);
        while (windowHandle == null && waitCount < timeoutInSeconds) {
            sleep(1000);
            waitCount++;
            windowHandle = getWindowWithUrl(url);
        }
        return windowHandle;
    }

    private static String getWindowWithUrl(String expected) {
        String currentWindowHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        String neededHandle = null;
        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        if (windowHandles.size() == 1) {
            return null;
        } else {
            for (String handle : windowHandles) {
                switchToWindowByHandle(handle);
                if (WebDriverRunner.getWebDriver().getCurrentUrl().contains(expected)) {
                    neededHandle = handle;
                }
            }
            switchToWindowByHandle(currentWindowHandle);
            return neededHandle;
        }
    }

    @Step("Switching to window by handle")
    public static void switchToWindowByHandle(String handle) {
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

}
