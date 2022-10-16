package com.br.api.service.definition;

import com.br.api.model.Option;

import java.util.List;

public interface OptionServiceDefinition {
    Option saveOption(Option option);
    void setCategoryToOption(String optionName, String categoryName);
    Option getOption(String option);
    List<Option> getOptions();
}
