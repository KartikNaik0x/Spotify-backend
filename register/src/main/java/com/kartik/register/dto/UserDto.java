package com.kartik.register.dto;

/**
 * @author {2095949}
 * @Date {30-11-2023}
 */
public class UserDto {

    private String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public UserDto(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UserDto() {

    }

}
