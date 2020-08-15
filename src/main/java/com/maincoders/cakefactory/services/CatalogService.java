package com.maincoders.cakefactory.services;

import com.maincoders.cakefactory.entity.CatalogEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CatalogService {

    public List<CatalogEntity> getCatalogs();
    public Optional<CatalogEntity> getCatalogById(String id);
    public CatalogEntity getCatalogByTitle(String title);
}
