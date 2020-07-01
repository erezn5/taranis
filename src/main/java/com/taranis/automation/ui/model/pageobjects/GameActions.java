package com.taranis.automation.ui.model.pageobjects;

import com.taranis.automation.ui.model.BasePage;
import com.taranis.automation.ui.selenium.DriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GameActions extends BasePage {

    @FindBy(how = How.CSS, using ="div.game-info div")
    private WebElement playerTypeElem; //could be 'X' or 'O'

    @FindBy(how = How.CSS, using ="div.game-info button[xpath='1']")
    private WebElement sortMoveElem;

    @FindBy(how = How.CSS, using = "button[class~='button--new-game']")
    private WebElement newGameElemButton;

    @FindBy(how = How.CSS, using = "div.game-info div[xpath='1']")
    private WebElement getWinnerElemText;

    public GameActions(DriverWrapper driver){
        super(driver);
    }

    public String getPlayerType() {
        return getElemText(playerTypeElem);
    }

    public void clickNewGameButton(){
        clickButton(newGameElemButton);
    }

    private boolean getWinnerText(){
        return getElemText(getWinnerElemText).contains("Winner");
    }

}
