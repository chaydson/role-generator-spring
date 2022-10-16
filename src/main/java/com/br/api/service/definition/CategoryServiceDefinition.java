package com.br.api.service.definition;

import com.br.api.model.Category;

import java.util.List;

public interface CategoryServiceDefinition {
    Category saveCategory(Category category);
    Category getCategory(String name);
    void addOptionToCategory(String optionName, String categoryName);
    List<Category> getCategories();
}
