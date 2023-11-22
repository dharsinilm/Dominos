package org.Step;

import com.pom.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Base.Base_Class;
import org.junit.Assert;

import java.time.Duration;

public class StepDef extends Base_Class {
    Homepage pc = new Homepage();
    VegPizzaClass vegpizza = new VegPizzaClass();
    Beversges bp = new Beversges();

    ProductRemove pr=new ProductRemove();

    Checkoutpage c=new Checkoutpage();


    //Beverages bp=new Beverages();

    @Given("User enter thr url")
    public void user_enter_thr_url() {
        driver.get("https://www.dominos.co.in/");
        driver.manage().window().maximize();
    }

    @When("User clicks order online now button")
    public void userClicksOrderOnlineNowButton() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElement(pc.orderonlinenow).click();

    }

    @When("User enter the address and click first suggestion")
    public void user_enter_the_address_and_click_first_suggestion() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(pc.Dontallowbtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(pc.enterorderonline).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(pc.enterarealocality).sendKeys("600077");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(pc.locateme).click();

        // jclick(driver,driver.findElement(pc.locateme));
    }

    @And("User clicks the VEG PIZZA MENU")
    public void userClicksTheVEGPIZZAMENU() throws InterruptedException {

        driver.findElement(vegpizza.VegPizza).click();
        Thread.sleep(2000);
        // scroll(driver,driver.findElement(vegpizza.MargaritaAddtocart));

        driver.findElement(vegpizza.MargaritaAddtocart).click();

        //  jclick(driver, driver.findElement(vegpizza.MargaritaAddtocart));

        driver.findElement(vegpizza.NOthanks).click();

        Thread.sleep(3000);
        driver.findElement(vegpizza.peppypaneerAddtocart).click();
        // jclick(driver,driver.findElement(vegpizza.MargaritaIncreaseButton));


        // Thread.sleep(5000);
        //scroll(driver,driver.findElement(vegpizza.peppypaneerAddtocart));


        Thread.sleep(5000);

        driver.findElement(vegpizza.MargaritaIncreaseButton).click();

        driver.findElement(vegpizza.peppypaneerIncreaseButton).click();

        //Thread.sleep(2000);

        //  driver.findElement(vegpizza.MargaritaDecreaseButton).click();


    }

    @And("User clicks the BEVERAGES MENU")
    public void userClicksTheBEVERAGESMENU() {

        driver.findElement(bp.Beverages).click();

        driver.findElement(bp.pepsi).click();

scroll(driver,driver.findElement(pr.ScrollPepsi));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        for(int i=0;i<11;i++){
            driver.findElement(bp.pepsiAddButton).click();
        }

    }


    @When("User removes some products from the addtocart")
    public void user_removes_some_products_from_the_addtocart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

      //  driver.findElement(pr.ScrollPaneer).click();
        driver.findElement(pr.margaritaRemove).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        for(int i=0;i<6;i++) {
            driver.findElement(pr.pepsiRemove).click();

        }
    }


    @Then("User clicks check out button")
    public void userClicksCheckOutButton() {

        driver.findElement(c.checkout).click();


        String subtotal=driver.findElement(c.Subtotal).getText();
        System.out.println(subtotal);
        Double Subtotalvalue=Double.parseDouble(subtotal);
        System.out.println("SubTotalValue"+Subtotalvalue);


        String Taxandcharges=driver.findElement(c.Taxandcharges).getText();
        System.out.println(Taxandcharges);
        Double TaxAndCharges=Double.parseDouble(Taxandcharges);
        System.out.println("TaxAndCharges"+TaxAndCharges);

        String GrandTotal=driver.findElement(c.Grandtotal).getText();
        Double Grangtotal=Double.parseDouble(GrandTotal);
        System.out.println("GrandTotal"+GrandTotal);

        Double TotalValue=Double.parseDouble(String.valueOf(Subtotalvalue+TaxAndCharges));
        System.out.println("Total value: "+TotalValue);

        Assert.assertEquals(TotalValue,Grangtotal);

        driver.close();


    }
}









