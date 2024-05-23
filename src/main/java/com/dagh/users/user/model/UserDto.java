package com.dagh.users.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String rol;
    private String password;

}
