package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {

    protected WebDriver driver;

    public Browser(){

        driver = new ChromeDriver();
    }

    public String getTitle(){

        return driver.getTitle();
    }
}
