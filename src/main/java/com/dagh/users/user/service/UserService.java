package com.dagh.users.user.service;

import com.dagh.users.user.model.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);

    List<UserDto> list();
}
