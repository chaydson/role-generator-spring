package com.br.api.service.definition;

import com.br.api.model.AppUser;
import com.br.api.model.Category;

import java.util.List;

public interface AppUserServiceDefinition {
    AppUser saveUser(AppUser user);
    void addCategoryToAppUser(String username, String category);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
