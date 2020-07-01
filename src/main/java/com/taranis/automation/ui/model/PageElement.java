package com.taranis.automation.ui.model;


import com.taranis.automation.ui.selenium.DriverWrapper;
import org.openqa.selenium.*;


public class PageElement {

    protected final DriverWrapper driver;

    protected PageElement(DriverWrapper driver) {
        this.driver = driver;
    }


    public void clickButton(WebElement bthElm){
        bthElm.click();
    }

    public String getElemText(WebElement element){
        return element.getText();
    }

}
