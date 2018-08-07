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

    public SelenideElement earnMHCLink(){
        return self.$("span[data-key*='promo-main-11']");
    }

    public SelenideElement marketCapLink(){
        return self.$("span[data-key*='promo-main-12']");
    }

    public SelenideElement forgingLink(){
        return self.$("span[data-key*='promo-main-13']");
    }

    public SelenideElement multiPOSLink(){
        return self.$("span[data-key*='promo-main-14']");
    }

    public SelenideElement downloadWhitePaperBtn(){
        return self.$("a[class*='download-white-paper']");
    }

    public SelenideElement downloadOnePagerBtn(){
        return self.$("a[class*='download-one-pager']");
    }

    public SelenideElement downloadMetaGateBtn(){
        return self.$("a[class*='download-metagate']");
    }

    public SelenideElement TelegramBtn() {
        return self.$("a[data-ga-label*='Telegram']");
    }
}
