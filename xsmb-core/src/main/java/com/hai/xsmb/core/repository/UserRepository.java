package com.hai.xsmb.core.repository;

import com.hai.xsmb.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameAndDeleted(String username, Boolean deleted);

    UserEntity findByEmailAndDeleted(String email, Boolean deleted);
}
