package org.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_Class {


    public static WebDriver driver;

    public static void scroll(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
public static void jclick (WebDriver driver,WebElement ele){
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click;", ele);
        }


//        public static void explicitwait(WebDriver driver) {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.alertIsPresent());
//        }

    public static void parentHandle(WebDriver driver) {
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
    }


}





