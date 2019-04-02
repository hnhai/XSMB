package com.hai.xsmb.web.service.Impl;

import com.hai.xsmb.core.entity.UserEntity;
import com.hai.xsmb.core.repository.UserRepository;
import com.hai.xsmb.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity loadByUserNameOrEmail(String usernameOrEmail) {
        UserEntity user = userRepository.findByUsernameAndDeleted(usernameOrEmail, Boolean.FALSE);
        if (user == null){
            user = userRepository.findByEmailAndDeleted(usernameOrEmail, Boolean.FALSE);
        }
        return user;
    }

    @Override
    public List<UserEntity> loadAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean loadByUsernameAndPassWord(String userName, String password) {
        UserEntity user = userRepository.findByUsernameAndDeleted(userName, Boolean.FALSE);
        if (user == null){
            user = userRepository.findByEmailAndDeleted(userName, Boolean.FALSE);
        }
        return passwordEncoder.matches(password, user.getPassword());
    }
}
