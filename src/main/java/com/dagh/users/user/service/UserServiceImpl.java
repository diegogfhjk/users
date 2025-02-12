package com.dagh.users.user.service;

import com.dagh.users.user.entity.User;
import com.dagh.users.user.mapper.UserMapper;
import com.dagh.users.user.model.UserDto;
import com.dagh.users.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public List<UserDto> list(){
        List<User> all = userRepository.findAll();
        return UserMapper.INSTANCE.toDtoList(all);
    }

    @Override
    public void update(UserDto userDto){
        if (Objects.isNull(userDto)){
            throw new RuntimeException("Error al modificar el usuario");
        }
        User user = UserMapper.INSTANCE.toEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id){
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()){
            throw new RuntimeException("Usuario no encontrado");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findById(Integer id){
        Optional<User> byId = userRepository.findById(id);
        if (!byId.isPresent()){
            throw new RuntimeException("Usuario no encontrado");
        }
        UserDto userDto = UserMapper.INSTANCE.toDto(byId.get());
        return userDto;
    }
}
