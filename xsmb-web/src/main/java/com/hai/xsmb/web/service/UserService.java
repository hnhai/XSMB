package com.hai.xsmb.web.service;

import com.hai.xsmb.core.entity.UserEntity;
import com.hai.xsmb.web.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserEntity loadByUserNameOrEmail(String usernameOrEmail);
    List<UserDTO> loadAll();
    Boolean loadByUsernameAndPassWord(String userName, String password);
}
