package com.br.api.controller;

import com.br.api.model.Option;
import com.br.api.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OptionController {
    private final OptionService optionService;

    @GetMapping("/options")
    public ResponseEntity<List<Option>> getOptions(){
        return ResponseEntity.ok().body(optionService.getOptions());
    }

    @PostMapping("/option")
    public ResponseEntity<Option>saveOption(@RequestBody Option option){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
        return ResponseEntity.created(uri).body(optionService.saveOption(option));
    }
}
