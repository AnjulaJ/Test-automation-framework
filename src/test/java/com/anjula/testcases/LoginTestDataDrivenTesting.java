package com.anjula.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anjula.pages.BaseTest;
import com.anjula.pages.LoginPage;
import com.anjula.utility.ReadExcelFile;

public class LoginTestDataDrivenTesting extends BaseTest{

    @Test(priority =1,dataProviderClass = ReadExcelFile.class,dataProvider="LoginDataProvider")
    public void VerifyLogin(String userEmail,String userPwd) throws IOException
    {
        LoginPage lp=new LoginPage(driver);
//		String username ="Demo12";
//		String password ="Test123456$";
        lp.loginToPortal(userEmail, userPwd);

        if(userEmail.equals(userEmail) && userPwd.equals(userPwd))
        {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
            lp.logout();
        }
        else
        {
            captureScreenShot(driver,"VerifyLogin");
            Assert.assertTrue(false);
        }
    }

}
