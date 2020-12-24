package com.maincoders.cakefactory.services;

import com.maincoders.cakefactory.domain.BasketDomain;
import com.maincoders.cakefactory.dto.BasketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {

    public List<BasketDomain> getBasket();
//    public void addBasket(String id);
    public int getQuantity();
    public String getTotal();
    public void removeBasket(String id);
    public void addBasket(BasketDomain basketDomain);
}
