package com.br.api.service;

import com.br.api.model.AppUser;
import com.br.api.model.Category;
import com.br.api.repository.AppUserRepository;
import com.br.api.repository.CategoryRepository;
import com.br.api.service.definition.AppUserServiceDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserService implements AppUserServiceDefinition, UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final CategoryRepository categoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findAppUserByUsername(username);
        if(appUser == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), new ArrayList<>());
    }

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user to the database");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return appUserRepository.findAppUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return appUserRepository.findAll();
    }

    @Override
    public void addCategoryToAppUser(String username, String category) {
        AppUser appUser = appUserRepository.findAppUserByUsername(username);
        Category userCategory = categoryRepository.findByCategoryName(category);
        appUser.getCategories().add(userCategory);
    }
}
