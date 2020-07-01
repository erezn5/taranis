package com.taranis.automation.ui.model.pageobjects;

import com.taranis.automation.ui.model.BasePage;
import com.taranis.automation.ui.selenium.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BoardActions extends BasePage {

    @FindBy(how = How.CSS, using ="div.board-row")
    List<WebElement> rowElemListElems;

    @FindBy(how = How.CSS, using ="div.board-row button[class=' square']")
    List<WebElement> squareListEles;

    @FindBy(how = How.CSS, using = "div.board-row button[class=' square']")
    private WebElement squareElemButton;

    @FindBy(how = How.CSS, using ="div[class='game-board'] div[xpath='1'] button")
    private WebElement firstSquare;
    public BoardActions(DriverWrapper driver){
        super(driver);
    }

    public void clickSquare(){
//        clickButton(firstSquare);
        for(WebElement squerqElem : squareListEles){
            clickButton(squerqElem);
        }
    }

    private void clickSquare(WebElement squareButton){
        if(!getElemText(squareElemButton).equals("X") || getElemText(squareElemButton).equals("O")){
            clickButton(squareButton);
        }
    }




}
