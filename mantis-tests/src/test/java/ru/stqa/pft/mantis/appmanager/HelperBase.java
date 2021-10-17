package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public HelperBase(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    protected void type(By locator, String text) {
        wd.findElement(locator).click();
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }


    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void choose(String day, By locator) {
        new Select(wd.findElement(locator)).selectByVisibleText(day);
    }
}
