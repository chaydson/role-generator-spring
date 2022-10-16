package com.br.api.repository;

import com.br.api.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
    Option findOptionByOptionName(String optionName);
}
