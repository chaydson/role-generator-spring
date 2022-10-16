package com.br.api.repository;

import com.br.api.model.CategoryOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<CategoryOption, Long> {
    CategoryOption findOptionByName(String name);
}
