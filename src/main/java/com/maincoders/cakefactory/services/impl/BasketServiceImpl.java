package com.maincoders.cakefactory.services.impl;

import com.maincoders.cakefactory.domain.BasketDomain;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.services.BasketService;
import com.maincoders.cakefactory.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    private static ArrayList<BasketDomain> basketList = new ArrayList<>();
    private BasketDomain basketDomain;


    @Autowired
    private CatalogService catalogService;

    @Override
    public List<BasketDomain> getBasket() {

        return basketList;
    }

    @Override
    public void addBasket(String id) {

        Optional<CatalogEntity> catalogEntity = catalogService.getCatalogById(id);

        if (catalogEntity.isPresent() && basketList.isEmpty()) {
            basketDomain = new BasketDomain(
                    catalogEntity.get().getTitle(),
                    1,
                    catalogEntity.get().getFormattedPrice());
                    basketList.add(basketDomain);



        } else if (catalogEntity.isPresent() && !basketList.isEmpty()) {
            boolean isItemNew = true;

            for (BasketDomain basket: basketList) {
                if (basket.getTitle().equals(catalogEntity.get().getTitle())) {
                    basket.setQty(basket.getQty() + 1);
                    isItemNew = false;
                    break;
                }
            }

            if (isItemNew) {
                basketDomain = new BasketDomain(
                        catalogEntity.get().getTitle(),
                        1,
                        catalogEntity.get().getFormattedPrice());
                basketList.add(basketDomain);
            }
        }


    }

    @Override
    public int getQuantity() {
        int count = 0;
        for (BasketDomain basket: basketList) {
            count += basket.getQty();
        }
        return count;
    }

    @Override
    public String getTotal() {
        double total = 0;
        int qty = 0;
        for (BasketDomain basket: basketList) {
            qty = basket.getQty();

            total += qty * convertStringToInt(basket.getPrice());

        }

        return getFormattedPrice(total);
    }

    public static double convertStringToInt(String priceInString) {

        String newPriceString = priceInString.replaceAll("[£]", "");
        double price = Double.parseDouble(newPriceString);
        return price;

    }

    public static String getFormattedPrice(double total) {
        DecimalFormat d = new DecimalFormat("'£'0.00");
        return d.format(total);
    }
}
