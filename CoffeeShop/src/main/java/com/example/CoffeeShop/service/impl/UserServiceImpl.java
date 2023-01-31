package com.example.CoffeeShop.service.impl;

import com.example.CoffeeShop.models.User;
import com.example.CoffeeShop.models.service.UserServiceModel;
import com.example.CoffeeShop.repository.UserRepository;
import com.example.CoffeeShop.service.UserService;
import com.example.CoffeeShop.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        User  user = modelMapper.map(userServiceModel, User.class);

        //Because userRegister() returns UserServiceModel not User, it could be easier if the method is void
        //then I don't need this mapping
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }
}
