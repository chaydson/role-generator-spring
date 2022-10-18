package com.br.api.service;

import com.br.api.model.CategoryOption;
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
    private final OptionRepository optionRepository;
    private final CategoryService categoryService;

    @Override
    public CategoryOption saveOption(CategoryOption categoryOption) {
//        categoryService.addOptionToCategory(categoryOption.getName(), categoryOption.getCategory().getName());
        log.info("Saving new option to the database");
        return optionRepository.save(categoryOption);
    }

    @Override
    public CategoryOption getOption(String name) {
        log.info("Fetching option {}", name);
        return optionRepository.findOptionByName(name);
    }

    @Override
    public List<CategoryOption> getOptions() {
        return optionRepository.findAll();
    }
}
