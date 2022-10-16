package com.br.api.controller;

import com.br.api.controller.form.OptionToCategoryForm;
import com.br.api.model.Category;
import com.br.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(){
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @PostMapping("/category")
    public ResponseEntity<Category>saveUser(@RequestBody Category category){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        return ResponseEntity.created(uri).body(categoryService.saveCategory(category));
    }

    @PostMapping("/category/option")
    public ResponseEntity<?>OptionToCategory(@RequestBody OptionToCategoryForm form){
        categoryService.addOptionToCategory(form.getOption(), form.getCategory());
        return ResponseEntity.ok().build();
    }
}
