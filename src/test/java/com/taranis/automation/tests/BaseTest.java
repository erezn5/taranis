package com.taranis.automation.tests;

import com.taranis.automation.ui.selenium.DriverWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public DriverWrapper driverWrapper;


    @BeforeClass
    public final void baseUiSetup(){
        driverWrapper = DriverWrapper.open();
    }

    @AfterClass
    public final void baseUiTearDown(){
        if(driverWrapper != null){
            driverWrapper.quit();
            //takescreenshot if test failed
        }
    }

    //I would add here screenshots if a test failed to be generated automatically into a well-defined folder.

}

