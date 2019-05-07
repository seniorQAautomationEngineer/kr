package com.kr;

import org.openqa.selenium.By;

public class Locators {

    public static final By MOBILE_MENU = By.xpath("//button[@class='hamburger hamburger--spring']");

    public static final By BUTTON_ACCEPT_COOKIES = By.xpath("//div[@class='warning-container']//button[@class='kraken-cta accept']");
    public static final By BUTTON_FEES = By.xpath("//a[@href='/en-us/features/fee-schedule'][@class='kraken-cta inverted']");
    public static final By CELL_OF_FEES_TABLE = By.xpath("//table[@class='nowrap']//tr//td");

    //Login
    public static final By LINK_LOGIN = By.xpath("//ul[@class='secondary']//li//a[@href='/login']");
    public static final By LINK_LOGIN_MOBILE = By.xpath("//ul[@class='account-links']//li//a[@href='/login']");

    public static final By TEXT_FEILD_USERNAME = By.xpath("//input[@name='username']");
    public static final By TEXT_FEILD_PASSWORD = By.xpath("//input[@name='password']");
    public static final By BUTTON_SUBMIT_LOGIN = By.cssSelector("#btn-login");


    public static final By USERNAME_INSIDE_PROFILE = By.cssSelector("#header-username");
    public static final By CHECKBOX_CAPTCHA = By.xpath("//span[@id='recaptcha-anchor']");
    public static final By ERROR_USERS_MESSAGES = By.xpath("//div[@class='alert alert-danger']");
}
