package com.jk.SpringBootHT.model;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    private String username;
    @NotEmpty(message = "Password shouldn't be empty")
    private String plainPassword;

    public UserDto(String username, String plainPassword) {
        this.username = username;
        this.plainPassword = plainPassword;
    }

    public UserDto() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }
}
