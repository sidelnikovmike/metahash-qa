package ru.metahash.tests.tests.functional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metahash.tests.web.pages.MainPage;
import ru.metahash.tests.web.steps.MainPageSteps;

@DisplayName("Promo block tests")
public class PromoBlockTests extends BaseTest {

    @Test
    public void checkJoinICOButton(){
        new MainPageSteps()
                .forPage(MainPage.openPage())
                .clickPromoJoinIcoButton()
                .checkBlocksWithIdsShown("ico");
    }
}
