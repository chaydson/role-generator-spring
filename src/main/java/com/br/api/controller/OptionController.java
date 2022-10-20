package com.br.api.controller;

import com.br.api.model.CategoryOption;
import com.br.api.service.OptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OptionController {
    private final OptionService optionService;

    @GetMapping("/options")
    public ResponseEntity<List<CategoryOption>> getOptions(){
        return ResponseEntity.ok().body(optionService.getOptions());
    }

    @PostMapping("/option")
    public ResponseEntity<CategoryOption>saveOption(@RequestBody CategoryOption categoryOption){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        return ResponseEntity.created(uri).body(optionService.saveOption(categoryOption));
    }
}
