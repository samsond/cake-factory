package com.maincoders.cakefactory.controller;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.maincoders.cakefactory.services.CatalogService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

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

        HtmlAnchor anchor = page.getAnchorByText("Sweetie Pies");

        Assertions.assertEquals("Sweetie Pies",anchor.asText());
    }
}
