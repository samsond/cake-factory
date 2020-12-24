package com.maincoders.cakefactory.controller;

import com.maincoders.cakefactory.domain.BasketDomain;
import com.maincoders.cakefactory.dto.BasketDTO;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.services.BasketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    private static BasketDTO convertEntityToBasketDTO(BasketDomain basketDomain) {

        BasketDTO basketDTO = new BasketDTO();
        BeanUtils.copyProperties(basketDomain, basketDTO);
//        if (basketDomain.getPrice() != 0) {
            basketDTO.setPrice(getFormattedPrice(basketDomain.getPrice()));
//        }
        return basketDTO;
    }

    private static BasketDomain convertBasketDTOToEntity(BasketDTO basketDTO) {
        BasketDomain basketDomain = new BasketDomain();

        double price = convertStringToInt(basketDTO.getPrice());

        BeanUtils.copyProperties(basketDTO, basketDomain);

        basketDomain.setPrice(price);

        return basketDomain;
    }

    public static String getFormattedPrice(double price) {
        DecimalFormat d = new DecimalFormat("'£'0.00");
        return d.format(price);
    }

    public static double convertStringToInt(String priceInString) {

        String newPriceString = priceInString.replaceAll("[£]", "");
        double price = Double.parseDouble(newPriceString);
        return price;

    }


    @GetMapping
    public String retrieveBasket(Model model) {
        List<BasketDomain> basket = basketService.getBasket();
        List<BasketDTO> basketDTOS = basket.stream().map(BasketController::convertEntityToBasketDTO).collect(Collectors.toList());
        model.addAttribute("items", basketService.getQuantity());
        model.addAttribute("basketItems", basketDTOS);
        model.addAttribute("total", basketService.getTotal());
        return "basket";
    }

//    @PostMapping
//    public String addBasket(Model model, @RequestParam("id") String id) {
//
//        basketService.addBasket(id);
//
//        model.addAttribute("items", basketService.getQuantity());
//        return "redirect:/catalog";
//    }
    @PostMapping
    public String addBasket(Model model, @ModelAttribute("basketDTO") BasketDTO basketDTO) {
        basketService.addBasket(convertBasketDTOToEntity(basketDTO));

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
