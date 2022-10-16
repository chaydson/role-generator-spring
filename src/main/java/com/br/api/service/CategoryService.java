package com.br.api.service;

import com.br.api.model.Category;
import com.br.api.model.Option;
import com.br.api.repository.CategoryRepository;
import com.br.api.repository.OptionRepository;
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
    private CategoryRepository categoryRepository;
    private OptionRepository optionRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void addOptionsToCategory(String categoryName, String optionName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        Option option = optionRepository.findOptionByOptionName(optionName);
        category.getOptions().add(option);
    }

    @Override
    public Category getCategory(String category) {
        return categoryRepository.findByCategoryName(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
