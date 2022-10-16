package com.br.api.service.definition;

import com.br.api.model.Category;

import java.util.List;

public interface CategoryServiceDefinition {
    Category saveCategory(Category category);
    void addOptionsToCategory(String categoryName, String optionName);
    Category getCategory(String category);
    List<Category> getCategories();
}
