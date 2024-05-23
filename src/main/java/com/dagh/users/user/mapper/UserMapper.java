package com.dagh.users.user.mapper;

import com.dagh.users.user.entity.User;
import com.dagh.users.user.model.UserDto;

import java.util.List;
import java.util.Objects;

public enum UserMapper {

    INSTANCE;

    public User toEntity(UserDto dto){
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .rol(dto.getRol())
                .build();
    }

    public UserDto toDto(User entity){
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .email(entity.getEmail())
                .rol(entity.getRol())
                .build();
    }

    public User update(User newNode,User oldNode){
        return User.builder()
                .id(oldNode.getId())
                .name(Objects.isNull(newNode.getName()) ? oldNode.getName() : newNode.getName())
                .lastname(Objects.isNull(newNode.getLastname()) ? oldNode.getLastname() : newNode.getLastname())
                .email(Objects.nonNull(newNode.getEmail()) ? newNode.getEmail() : oldNode.getEmail())
                .rol(Objects.nonNull(newNode.getRol()) ? newNode.getRol() : oldNode.getRol())
                .password(Objects.nonNull(newNode.getPassword()) ? newNode.getPassword() : oldNode.getPassword())
                .build();
    }

    public List<UserDto> toDtoList(List<User> list){
        return list
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<User> toEntityList(List<UserDto> list){
        return list
                .stream()
                .map(this::toEntity)
                .toList();
    }
}
