package com.pom;

import org.openqa.selenium.By;

public class Checkoutpage {

    public By checkout= By.xpath("//span[.='CHECKOUT']");

    public By Subtotal=By.xpath("(//span[@class='rupee'])[4]");

    public By Taxandcharges=By.xpath("(//span[@class='rupee'])[5]");

    public By Grandtotal=By.xpath("(//span[@class='rupee'])[6]");
}
