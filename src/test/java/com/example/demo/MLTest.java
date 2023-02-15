package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MLTest {

    MLsearch page;
    String parametroBusca;

    @BeforeEach
    public void inicializar(){

        parametroBusca = "Mochila";

        System.setProperty("webdriver.chrome.driver","/home/ricardo/Downloads/chromedriver_linux64/chromedriver");


         page = new MLsearch();

    }

    private void pesquisarPor(final String pesquisa){

        Assertions.assertEquals("Mercado Livre Brasil - Frete Grátis no mesmo dia" , page.getTitle());

    WebElement campoPesquisado = page.getSearchInput();

    campoPesquisado.clear();
    campoPesquisado.sendKeys(pesquisa);


    System.out.println("Titulo " + page.getTitle());

        System.out.println("Campo Pesquisado " + campoPesquisado);
    campoPesquisado.submit();

    }

    @Test
    public void pesquisar_Mochila(){

        pesquisarPor(parametroBusca);
    }

    private void verificaCabecalho(final String pesquisa){

        WebElement campoPesquisado = page.getSearchInput();

        campoPesquisado.clear();
        campoPesquisado.sendKeys(pesquisa);
        campoPesquisado.submit();

        final String text = page.getCabecalho().getText();

        System.out.println("Campo Pesquisado " + text);

        Assertions.assertEquals("Mochila" , text);


    }

    @Test
    public void pesquisar_Mochila_E_VerificarSeCabecalho_Eh_Mochila(){

        verificaCabecalho(parametroBusca);
    }

    public void verificarQuantidadeItens(final String pesquisa){


        WebElement campoPesquisado = page.getSearchInput();

        campoPesquisado.clear();
        campoPesquisado.sendKeys(pesquisa);
        campoPesquisado.submit();

        final List<WebElement> quantidadeItensPesquisa = page.getQuantidadeItensPesquisa();


        Assertions.assertTrue(quantidadeItensPesquisa.size() > 0);

    }


    @Test
    public void pesquisar_Mochila_E_VerificarSeCabecalho_Se_QuantidadeItens_EhMaiorDoqueUm(){

        verificarQuantidadeItens(parametroBusca);
    }






}
