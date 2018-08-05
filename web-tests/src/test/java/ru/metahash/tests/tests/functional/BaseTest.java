package ru.metahash.tests.tests.functional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;

//TODO: add extentions for browser and screens
public class BaseTest {

    @BeforeEach
    public void beforeEach(){
        WebDriverUtils.initDriver();
    }

    @AfterEach
    public void afterEach(){
        WebDriverUtils.finishDriver();
    }
}
