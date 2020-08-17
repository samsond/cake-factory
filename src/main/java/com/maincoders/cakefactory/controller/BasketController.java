package com.maincoders.cakefactory.controller;

import com.maincoders.cakefactory.domain.BasketDomain;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;


    @GetMapping
    public String retrieveBasket(Model model) {
        List<BasketDomain> basket = basketService.getBasket();
        model.addAttribute("items", basketService.getQuantity());
        model.addAttribute("basketItems", basket);
        model.addAttribute("total", basketService.getTotal());
        return "basket";
    }

    @PostMapping
    public String addBasket(Model model, @RequestParam("id") String id) {

        basketService.addBasket(id);

        model.addAttribute("items", basketService.getQuantity());
        return "redirect:/catalog";
    }

    @PostMapping("/delete")
    public String removeBasket(Model model, @RequestParam("title") String title) {

        basketService.removeBasket(title);
        List<BasketDomain> basket = basketService.getBasket();
        model.addAttribute("items", basketService.getQuantity());
        model.addAttribute("basketItems", basket);

        return "redirect:/basket";
    }
}
