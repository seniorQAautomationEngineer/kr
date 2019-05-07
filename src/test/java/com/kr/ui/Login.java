package com.kr.ui;

import com.kr.DataProviders;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Login extends BaseUI {

    String actualUsername;


    @Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
    public void testMarkets(String username, String password, boolean requirement, ITestContext context) throws InterruptedException {
        String testBox = context.getCurrentXmlTest().getParameter("testBox");
        if (testBox != null && testBox.contains("mobile")) {
            mainPage.clickMobileSignIn();
        } else {
            mainPage.clickWebSignIn();
        }
        loginProfile.fillInLoginForm(username, password);
        try {
            loginProfile.getCaptchaCheckbox();
            return;
        } catch (Exception e) {

        }
        if (requirement) {
            actualUsername = loginProfile.getUsername();
            Assert.assertEquals(actualUsername, username);
        } else {
            loginProfile.getErrorMessage();
        }

    }
}
