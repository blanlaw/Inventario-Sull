package com.argo.user_commons.User.Application.dto;

public class UserDTO {
    private int idUser;

    private UserDetailsDTO userDetailsDTO;

    private String username;


    private String password;

    private UserDetailsDTO userDetails;


    private RolesDTO roles;


    public RolesDTO getRoles() {
        return roles;
    }

    public void setRoles(RolesDTO roles) {
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetailsDTO getUserDetailsDTO() {
        return userDetailsDTO;
    }

    public void setUserDetailsDTO(UserDetailsDTO userDetailsDTO) {
        this.userDetailsDTO = userDetailsDTO;
    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idUser=" + idUser +
                ", userDetailsDTO=" + userDetailsDTO +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + userDetails +
                ", roles=" + roles +
                '}';
    }
}
