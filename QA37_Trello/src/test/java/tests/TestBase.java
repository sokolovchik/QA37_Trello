package tests;

import manage.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    @BeforeSuite
    public void setUp(){
        app.init();
    }
 @AfterSuite
 public void stop() {
        app.quit();
 }
}
