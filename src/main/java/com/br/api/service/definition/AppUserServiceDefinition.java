package com.br.api.service.definition;

import com.br.api.model.AppUser;

import java.util.List;

public interface AppUserServiceDefinition {
    AppUser saveUser(AppUser user);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
