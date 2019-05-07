package com.kr;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "Login")
    public static Object[][] testGifts() {
        return new Object[][]{
                {Data.username, Data.password, true},
                {MainPage.generateNewUsernameOrPassword(5), MainPage.generateNewUsernameOrPassword(31), false},
                {MainPage.generateNewUsernameOrPassword(10), MainPage.generateNewUsernameOrPassword(10), false},
                {MainPage.generateNewUsernameOrPassword(31), MainPage.generateNewUsernameOrPassword(5), false},


        };
    }
}
