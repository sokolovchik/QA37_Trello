package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        click(By.cssSelector("[data-testid='header-create-menu-button']"));
        click(By.cssSelector("[data-testid='header-create-board-button']"));//("[aria-label='BoardIcon']")
    }

    public void fillInBoardCreationForm(String title) {
        type(By.cssSelector("[data-testid='create-board-title-input']"),title);
    }

    public void scrollDownTheForm() {
        Actions action = new Actions(wd);
    WebElement container = wd.findElement(By.cssSelector("[data-testid='header-create-menu-popover']"));
     Rectangle rect = container.getRect();
     int x = rect.getX()+20;
     int y = rect.getY()+rect.getHeight()/2;
     action.moveByOffset(x,y).click().perform();
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[data-testid='create-board-submit-button']"));
    }

    public boolean isCreated() {
        return wd.findElements(By.cssSelector(".list-name-input")).size()>0;
    }

    public void returnToHomePage() {
        click(By.cssSelector("[aria-label='Back to home']"));
    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".board-tile-details ")).size()-1-recentlyViewed();
    }

    private int recentlyViewed() {
        return wd.findElements(By.xpath("//*[contains(@class, 'icon-clock')]/../..//div")).size();
    }

    public void clickTheFirstBoard() {
        click(By.cssSelector(".board-tile-details"));
    }

    public void openSideBar() {
        click(By.cssSelector(".show-sidebar-button-react-root"));
    }

    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
    }

    public void deleteBoard() {
        click(By.cssSelector("[data-testid='close-board-delete-board-button']"));
        click(By.cssSelector("[data-testid='close-board-delete-board-confirm-button']"));
    }
}
