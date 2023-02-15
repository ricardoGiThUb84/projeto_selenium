package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MLsearch extends Browser{

    public MLsearch() {

        super();

        driver.get("https://www.mercadolivre.com.br/");

    }

    public WebElement getSearchInput(){

        return driver.findElement(By.id("cb1-edit"));


    }

    public WebElement getCabecalho(){

        return driver.findElement(By.tagName("h1"));
    }

    public List<WebElement> getQuantidadeItensPesquisa(){

        return driver.findElements(By.className("ui-search-link"));
    }

    @Override
    public String getTitle(){
        return driver.getTitle();
    }
}
