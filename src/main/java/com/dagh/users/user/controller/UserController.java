package com.dagh.users.user.controller;

import com.dagh.users.user.model.UserDto;
import com.dagh.users.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public ResponseEntity update(@RequestBody UserDto userDto){
        userService.update(userDto);
        return ResponseEntity.ok("El usuario se ha modificado correctamente");
    }

    @GetMapping
    public ResponseEntity list(){
        List<UserDto> list = userService.list();
        if (list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

}
