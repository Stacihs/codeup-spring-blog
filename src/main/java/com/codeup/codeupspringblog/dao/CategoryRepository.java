package com.codeup.codeupspringblog.dao;

import com.codeup.codeupspringblog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
    Category findCategoryByName(String name);
}
