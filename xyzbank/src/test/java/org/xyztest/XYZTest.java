package org.xyztest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class XYZTest {

    public void customerLogin(String username) {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        $(By.cssSelector("button[ng-click='customer()']")).click();
        $(By.name("userSelect")).selectOption(username);
        $(By.cssSelector("button[class='btn btn-default']")).click();
    }

    public void managerLogin() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        $(By.cssSelector("button[ng-click='manager()']")).click();
    }

    @Test
    public void customerCanLogin() {
        customerLogin("Hermoine Granger");
    }

    @Test
    public void bankManagerCanAddCustomer() {
        managerLogin();
        $(By.cssSelector("button[ng-class='btnClass1'")).click();
        $(By.cssSelector("input[ng-model='fName'")).sendKeys("Name");
        $(By.cssSelector("input[ng-model='lName'")).sendKeys("Lastname");
        $(By.cssSelector("input[ng-model='postCd'")).sendKeys("123");
        $(By.cssSelector("button[type='submit'][class='btn btn-default']")).click();
    }

    @Test
    public void bankManagerCanOpenAccount() {
        managerLogin();
        $(By.cssSelector("button[ng-class='btnClass2'")).click();
        $(By.name("userSelect")).selectOption("Hermoine Granger");
        $(By.name("currency")).selectOption("Dollar");
        $(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    public void bankManagerCanDeleteCustomer() {
        managerLogin();
        $(By.cssSelector("button[ng-class='btnClass3'")).click();
        $(By.cssSelector("button[ng-class='btnClass3'")).click();
        $$(By.cssSelector("button[ng-click='deleteCust(cust)']")).get(1).click();
    }


}
