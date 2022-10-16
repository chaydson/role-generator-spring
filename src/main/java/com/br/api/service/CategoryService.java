package com.br.api.service;

import com.br.api.model.Category;
import com.br.api.repository.CategoryRepository;
import com.br.api.service.definition.CategoryServiceDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryService implements CategoryServiceDefinition {
    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        log.info("Saving new category to the database");
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(String name) {
        log.info("Fetching category {}", name);
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public List<Category> getCategories() {
        log.info("Fetching all categories");
        return categoryRepository.findAll();
    }
}
