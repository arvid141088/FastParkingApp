package com.gmit.arvids.its.repository.entity;

import lombok.Data;

@Data
public class UserInfoEntity {

    private Integer id;
    private String login;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

}
