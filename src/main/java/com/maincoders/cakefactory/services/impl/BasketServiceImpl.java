package com.maincoders.cakefactory.services.impl;

import com.maincoders.cakefactory.domain.BasketDomain;
import com.maincoders.cakefactory.dto.BasketDTO;
import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.services.BasketService;
import com.maincoders.cakefactory.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

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

//    @Override
//    public void addBasket(String id) {
//
//        Optional<CatalogEntity> catalogEntity = catalogService.getCatalogById(id);
//
//        if (catalogEntity.isPresent() && basketList.isEmpty()) {
//            basketDomain = new BasketDomain(
//                    catalogEntity.get().getTitle(),
//                    1,
//                    catalogEntity.get().getFormattedPrice());
//                    basketList.add(basketDomain);
//
//
//
//        } else if (catalogEntity.isPresent() && !basketList.isEmpty()) {
//            boolean isItemNew = true;
//
//            for (BasketDomain basket: basketList) {
//                if (basket.getTitle().equals(catalogEntity.get().getTitle())) {
//                    basket.setQty(basket.getQty() + 1);
//                    isItemNew = false;
//                    break;
//                }
//            }
//
//            if (isItemNew) {
//                basketDomain = new BasketDomain(
//                        catalogEntity.get().getTitle(),
//                        1,
//                        catalogEntity.get().getFormattedPrice());
//                basketList.add(basketDomain);
//            }
//        }
//
//
//    }

    @Override
    public void addBasket(BasketDomain basketDomain) {

        if (basketDomain.getQty() == 0 && basketList.isEmpty()) {
            basketDomain.setQty(basketDomain.getQty() + 1);
            basketList.add(basketDomain);
        } else if (!basketList.isEmpty()) {
            boolean isItemNew = true;

            for (BasketDomain basket: basketList) {
                if (basket.getTitle().equals(basketDomain.getTitle())) {
                    basket.setQty(basket.getQty() + 1);
                    isItemNew = false;
                    break;
                }
            }

            if (isItemNew) {
                basketDomain.setQty(basketDomain.getQty() + 1);
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

//            total += qty * convertStringToInt(basket.getPrice());

//            System.out.println("################################## " + basket);

            total += (double) qty * basket.getPrice();

        }

        return getFormattedPrice(total);
    }

    @Override
    public void removeBasket(String title) {

        if (!basketList.isEmpty()) {
            for (BasketDomain basket: basketList) {
                if (basket.getTitle().equals(title)) {
                    int quantity = basket.getQty();
                    if (quantity != 0) {
                        basket.setQty(quantity - 1);
                    }

                }
            }


        }

        for (Iterator<BasketDomain> iterator = basketList.iterator(); iterator.hasNext();) {
            BasketDomain basket = iterator.next();
            if (basket.getQty() == 0) {
                iterator.remove();
            }
        }





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
