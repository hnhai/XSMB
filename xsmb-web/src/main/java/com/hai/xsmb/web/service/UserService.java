package com.hai.xsmb.web.service;

import com.hai.xsmb.core.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity loadByUserNameOrEmail(String usernameOrEmail);
    List<UserEntity> loadAll();
    Boolean loadByUsernameAndPassWord(String userName, String password);
}
