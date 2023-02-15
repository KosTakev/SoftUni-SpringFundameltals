package com.example.CoffeeShop.service;

import com.example.CoffeeShop.models.User;
import com.example.CoffeeShop.models.service.UserServiceModel;
import com.example.CoffeeShop.models.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUsersAndCountOfOrdersOrderByCountDesc();
}
