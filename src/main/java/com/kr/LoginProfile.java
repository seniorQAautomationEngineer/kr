package com.kr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginProfile extends BaseActions {
    public LoginProfile(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void fillInLoginForm(String username, String password) {
        driver.findElement(Locators.TEXT_FEILD_USERNAME).sendKeys(username);
        driver.findElement(Locators.TEXT_FEILD_PASSWORD).sendKeys(password);
        driver.findElement(Locators.BUTTON_SUBMIT_LOGIN).click();
    }


    public String getUsername() {
        String username = driver.findElement(Locators.USERNAME_INSIDE_PROFILE).getText();
        username = username.trim();
        return username;
    }

    public void getCaptchaCheckbox() {

        driver.switchTo().frame(0);
        ajaxClick(Locators.CHECKBOX_CAPTCHA);
        System.out.println("I can't automate captcha and verify login");
    }

    public void getErrorMessage() {
        String errorMessage = driver.findElement(Locators.ERROR_USERS_MESSAGES).getText();
        System.out.println(errorMessage);

    }


}
