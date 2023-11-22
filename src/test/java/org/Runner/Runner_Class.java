package org.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.Base.Base_Class;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//Dominos.feature",
        glue = "org/Step", dryRun = false)
public class Runner_Class extends Base_Class {
    @BeforeClass
    public static void start() {
        driver = new ChromeDriver();
    }
}
