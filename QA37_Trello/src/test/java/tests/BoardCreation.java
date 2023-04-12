package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{


    @Test
    public void boardCreation1() {
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa371");
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
//app.getBoard().isCreated();

        Assert.assertTrue(app.getBoard().isCreated());
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
    }
@Test
    public void boardCreation2(){
     int boardCountBeforeCreation = app.getBoard().getBoardCount();
    app.getBoard().initBoardCreationFromHeader();
    app.getBoard().fillInBoardCreationForm("qa372");
    app.getBoard().scrollDownTheForm();
    app.getBoard().pause(2000);
    app.getBoard().submitBoardCreation();
    app.getBoard().pause(2000);
    app.getBoard().returnToHomePage();
    app.getBoard().pause(2000);

    int boardCountAfterCreation = app.getBoard().getBoardCount();

    Assert.assertEquals(boardCountAfterCreation,boardCountAfterCreation+1);

}



}
