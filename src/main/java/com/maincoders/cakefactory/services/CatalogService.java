package com.maincoders.cakefactory.services;

import com.maincoders.cakefactory.domain.Pastry;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.repo.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface CatalogService {

    public List<CatalogEntity> getCatalogs();
}
