package com.maincoders.cakefactory.service.impl;

import com.maincoders.cakefactory.services.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
public class CatalogServiceImplTest {

    @Autowired
    private CatalogServiceImpl catalogService;


    @Test
    public void catalogServiceImplAutowired() {
        Assertions.assertNotNull(catalogService);
    }
}
