package com.example.CoffeeShop.repository;

import com.example.CoffeeShop.models.Category;
import com.example.CoffeeShop.models.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum name);
}
