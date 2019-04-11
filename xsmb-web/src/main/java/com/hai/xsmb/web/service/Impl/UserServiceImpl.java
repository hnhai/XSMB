package com.hai.xsmb.web.service.Impl;

import com.hai.xsmb.core.entity.UserEntity;
import com.hai.xsmb.core.repository.UserRepository;
import com.hai.xsmb.web.dto.UserDTO;
import com.hai.xsmb.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<UserDTO> loadAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<UserEntity> users = userRepository.findAll();
        users.forEach(user -> userDTOS.add(new UserDTO(user.getId(), user.getUsername(), user.getEmail())));
        return userDTOS;
    }

    @Override
    public Boolean loadByUsernameAndPassWord(String userName, String password) {
        if(StringUtils.isEmpty(password)){
            return false;
        }
        UserEntity user = userRepository.findByUsernameAndDeleted(userName, Boolean.FALSE);
        if (user == null){
            user = userRepository.findByEmailAndDeleted(userName, Boolean.FALSE);
        }
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}
