package com.example.CoffeeShop.service;

import com.example.CoffeeShop.models.Category;
import com.example.CoffeeShop.models.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
