package com.ictakwebsite.scripts;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.ictakwebsite.constants.AutomationConstants;
import com.ictakwebsite.pages.LoginPage;
import com.ictakwebsite.utilities.ExcelUtility;
import com.ictakwebsite.pages.LogoutPage;

public class TestClass extends TestBase {

LoginPage objLogin;
LogoutPage objLogout;
	
	@Test(priority=1)

    public void verifyValidLogin() throws IOException {
    //Create Login Page object
    objLogin = new LoginPage(driver);
   //login to application
    for (int i=0;i<5;i++)
    {
    String username = ExcelUtility.getCellData(i,0 );
    String password = ExcelUtility.getCellData(i,1);
    objLogin.clickLogin();
    objLogin.setUserName(username);
    objLogin.setPassword(password);
    objLogin.clickSignin();
    String expectedUrl =AutomationConstants.LOGINURL;
    String actualUrl =driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);
    objLogout.clickLogout();
    }


}
}

