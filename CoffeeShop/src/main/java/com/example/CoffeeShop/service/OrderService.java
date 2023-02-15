package com.example.CoffeeShop.service;

import com.example.CoffeeShop.models.service.OrderServiceModel;
import com.example.CoffeeShop.models.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    public void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPrice();

    void readyOrder(Long id);
}
