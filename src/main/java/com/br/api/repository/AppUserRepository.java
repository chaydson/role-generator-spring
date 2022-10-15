package com.br.api.repository;

import com.br.api.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
}
