package com.maincoders.cakefactory.controller;

import com.maincoders.cakefactory.domain.Pastry;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/catalog")
    public String retrievePastries(Model model){
        List<CatalogEntity> pastries = catalogService.getCatalogs();

        model.addAttribute("pastries", pastries);
        return "catalog";
    }
}
