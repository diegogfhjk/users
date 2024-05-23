package com.dagh.users.user.service;

import com.dagh.users.user.entity.User;
import com.dagh.users.user.mapper.UserMapper;
import com.dagh.users.user.model.UserDto;
import com.dagh.users.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(UserDto userDto){
        if (Objects.isNull(userDto)){
            throw new RuntimeException("Error al guardar el usuario");
        }
        User user = UserMapper.INSTANCE.toEntity(userDto);
        userRepository.save(user);
    }

}
