package com.kr.ui;

import com.kr.Data;
import com.kr.FeesPage;
import com.kr.LoginProfile;
import com.kr.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    FeesPage feesPage;
    LoginProfile loginProfile;


    protected TestBox testBox;
    protected Browser testBrowser;


    protected enum TestBox {
        WEB, MOBILE
    }

    public enum Browser {
        CHROME, FIREFOX, IE
    }


    @BeforeMethod
    @Parameters({"testBrowser", "testBox", "mobileDevice"})
    public void setup(@Optional("chrome") String browser, @Optional("web") String box, @Optional("empty") String mobileDevice) {
        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        }

        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = Browser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = Browser.FIREFOX;
        } else if (browser.equalsIgnoreCase("ie")) {
            testBrowser = Browser.IE;
        }

        switch (testBox) {

            case WEB:
                switch (testBrowser) {
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                        driver = new FirefoxDriver();
                        driver.manage().deleteAllCookies();
                        break;
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                    case IE:
                        System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                        driver = new InternetExplorerDriver();
                        driver.manage().deleteAllCookies();
                        break;
                    default:
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }
                break;
            case MOBILE:
                switch (testBrowser) {
                    case CHROME:
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", mobileDevice);
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                }
        }
        wait = new WebDriverWait(driver, 30);
        mainPage = new MainPage(driver, wait);
        feesPage = new FeesPage(driver, wait);
        loginProfile = new LoginProfile(driver, wait);
        driver.manage().window().maximize();
        driver.get(Data.baseUrl);

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
