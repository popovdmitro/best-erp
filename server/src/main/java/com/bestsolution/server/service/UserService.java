package com.bestsolution.server.service;

import com.bestsolution.server.model.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    public List<User> findAllUsers() {
        List<User> result = new ArrayList<>();

        result.add(User.builder().id(1).name("User 1").build());
        result.add(User.builder().id(2).name("User 2").build());
        result.add(User.builder().id(3).name("User 3").build());
        result.add(User.builder().id(4).name("User 4").build());

        return result;
    }

}
