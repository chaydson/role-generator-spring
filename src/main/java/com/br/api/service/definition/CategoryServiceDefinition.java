package com.br.api.service.definition;

import com.br.api.model.Category;

import java.util.List;

public interface CategoryServiceDefinition {
    Category saveCategory(Category category);
    Category getCategory(String name);
    List<Category> getCategories();
}
