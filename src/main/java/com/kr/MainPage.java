package com.kr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseActions {
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickMobileHamburger() {
        driver.findElement(Locators.MOBILE_MENU).click();
    }

    public void clickWebSignIn() {
        ajaxClick(Locators.LINK_LOGIN);
    }

    public void clickMobileSignIn() {
        driver.findElement(Locators.LINK_LOGIN_MOBILE).click();
    }

    public void clickFeesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_FEES));
        driver.findElement(Locators.BUTTON_FEES).click();
    }

        public void acceptCookies(){
            try{
                ajaxClick(Locators.BUTTON_ACCEPT_COOKIES);
        }catch (Exception e){

            }
    }


}
