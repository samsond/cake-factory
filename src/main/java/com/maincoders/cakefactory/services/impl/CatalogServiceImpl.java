package com.maincoders.cakefactory.services.impl;

import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.repo.CatalogRepo;
import com.maincoders.cakefactory.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepo catalogRepo;

    public List<CatalogEntity> getCatalogs() {
        return catalogRepo.findAll();
    }
}
