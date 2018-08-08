package ru.metahash.tests.tests.functional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.metahash.tests.core.browser.junit.ScreenShotOnFailExcension;
import ru.metahash.tests.core.browser.runner.WebDriverUtils;

@ExtendWith(ScreenShotOnFailExcension.class)
public class BaseTest {

    @BeforeEach
    public void beforeEach() {
        WebDriverUtils.initDriver();
    }

}
