package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }
   @Test
    public void login1(){
       app.getUser().initLogin();
       app.getUser().pause(2000);
       app.getUser().fillInLoginForm("irena9693541@gmail.com","04Darisopa09$");
       app.getUser().submitLogin();
       app.getUser().pause(2000);

       Assert.assertTrue(app.getUser().isLogged());

    }
}
