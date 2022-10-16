package com.br.api.service.definition;

import com.br.api.model.AppUser;

import java.util.List;

public interface AppUserServiceDefinition {
    AppUser saveUser(AppUser user);
    void addCategoryToUser(String username, String categoryName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
