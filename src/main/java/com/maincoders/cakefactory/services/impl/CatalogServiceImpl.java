package com.maincoders.cakefactory.services.impl;

import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.repo.CatalogRepo;
import com.maincoders.cakefactory.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepo catalogRepo;

    public List<CatalogEntity> getCatalogs() {
        return catalogRepo.findAll();
    }

    public Optional<CatalogEntity> getCatalogById(String id) {
        return catalogRepo.findById(id);
    }

    public CatalogEntity getCatalogByTitle(String title) {
        return catalogRepo.findByTitle(title);
    }
}
