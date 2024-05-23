package com.dagh.users.user.controller;

import com.dagh.users.user.model.UserDto;
import com.dagh.users.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1.0/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto userDto){
        userService.save(userDto);
        return ResponseEntity.ok("El usuario se ha creado correctamente");
    }
}
