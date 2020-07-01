package com.taranis.automation.ui.model;


import com.taranis.automation.ui.selenium.DriverWrapper;
import org.openqa.selenium.support.PageFactory;


public class BasePage extends PageElement {
    private final String url;

    protected final static String URL_ADDRESS= "http://localhost:3000/";

    public BasePage(DriverWrapper driver){
        super(driver);
        this.url = URL_ADDRESS;
        PageFactory.initElements(driver, this);
    }

    public void navigate(){
        driver.get(url);
    }

    //would add here a verifier that I reached the correct page
}
