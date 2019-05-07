package com.kr.ui;

import com.kr.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Fees extends BaseUI {

    @Test
    public void testFees() {
        mainPage.acceptCookies();
        mainPage.clickFeesButton();
        List<String> entries = feesPage.getEntriesFeesFromTable();
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i));
            if (entries.get(0).contains(Data.expectedFeesValue)) {
                System.out.println("First fee: " + Data.expectedFeesValue);
            } else {
                Assert.fail();
            }
        }
    }
}
