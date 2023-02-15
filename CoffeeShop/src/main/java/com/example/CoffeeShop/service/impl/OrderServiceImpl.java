package com.example.CoffeeShop.service.impl;

import com.example.CoffeeShop.models.Order;
import com.example.CoffeeShop.models.service.OrderServiceModel;
import com.example.CoffeeShop.models.view.OrderViewModel;
import com.example.CoffeeShop.repository.OrderRepository;
import com.example.CoffeeShop.service.CategoryService;
import com.example.CoffeeShop.service.OrderService;
import com.example.CoffeeShop.service.UserService;
import com.example.CoffeeShop.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper,
                            CurrentUser currentUser, UserService userService,
                            CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);

        order.setEmployee(userService.findById(currentUser.getId()));

        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersOrderByPrice() {


        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository
                .deleteById(id);
    }
}
