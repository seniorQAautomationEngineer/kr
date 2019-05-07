package com.kr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class FeesPage extends BaseActions {
    public FeesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public List<String> getEntriesFeesFromTable() {
        return driver.findElements(Locators.CELL_OF_FEES_TABLE).stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
