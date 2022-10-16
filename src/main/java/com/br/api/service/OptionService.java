package com.br.api.service;

import com.br.api.model.Category;
import com.br.api.model.Option;
import com.br.api.repository.CategoryRepository;
import com.br.api.repository.OptionRepository;
import com.br.api.service.definition.OptionServiceDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OptionService implements OptionServiceDefinition {
    private CategoryRepository categoryRepository;
    private OptionRepository optionRepository;

    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public void setCategoryToOption(String optionName, String categoryName) {
        Option option = optionRepository.findOptionByOptionName(optionName);
        Category category = categoryRepository.findByCategoryName(categoryName);
        option.setCategory(category);
    }

    @Override
    public Option getOption(String option) {
        return optionRepository.findOptionByOptionName(option);
    }

    @Override
    public List<Option> getOptions() {
        return optionRepository.findAll();
    }
}
