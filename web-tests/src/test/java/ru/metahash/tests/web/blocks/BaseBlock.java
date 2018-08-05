package ru.metahash.tests.web.blocks;

import com.codeborne.selenide.SelenideElement;

public class BaseBlock {

    protected SelenideElement self;

    protected BaseBlock(SelenideElement self){
        this.self = self;
    }
}
