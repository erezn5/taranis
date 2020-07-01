package com.taranis.automation.tests;

import com.taranis.automation.ui.model.pageobjects.BoardActions;
import com.taranis.automation.ui.model.pageobjects.GameActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TicTacToeTest extends BaseTest{

    private GameActions gameActions;
    private BoardActions boardActions;

    @BeforeClass
    public void setup() {

        boardActions = new BoardActions(driverWrapper);
        gameActions = new GameActions(driverWrapper);
    }

    @Test(priority = 5)
    public void navigateToTicTacToePage(){
        boardActions.navigate();
    }

    @Test(priority = 10)
    public void startNewGame(){
        gameActions.clickNewGameButton();
    }

    @Test(priority = 15)
    public void clickSquarePlayerX(){
        boardActions.clickSquare(); //click first square in first row
    }

}
