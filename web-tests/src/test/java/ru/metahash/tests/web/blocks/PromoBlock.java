package ru.metahash.tests.web.blocks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PromoBlock extends BaseBlock {

    public PromoBlock() {
        super($("#promo"));
    }

    public SelenideElement joinICOButton(){
        return self.$("a[class*='ico-button btn']");
    }
}
