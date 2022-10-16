package com.br.api.service.definition;

import com.br.api.model.CategoryOption;

import java.util.List;

public interface OptionServiceDefinition {
    CategoryOption saveOption(CategoryOption categoryOption);
    CategoryOption getOption(String name);
    List<CategoryOption> getOptions();
}
