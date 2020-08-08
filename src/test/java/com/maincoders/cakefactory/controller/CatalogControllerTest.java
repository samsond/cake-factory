package com.maincoders.cakefactory.controller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.*;

public class CatalogControllerTest {

    private WebClient webClient;

    @BeforeEach
    public void init() throws Exception {
        webClient = new WebClient();
    }

    @AfterEach
    public void close() throws Exception {
        webClient.close();
    }

    @Test
    public void testCatalogPage() throws Exception {
        HtmlPage page = webClient.getPage("http://localhost:8080/catalog");

        HtmlAnchor anchor = page.getAnchorByText("Chocolate Croissant");

        Assertions.assertEquals("Chocolate Croissant",anchor.asText());
    }
}
