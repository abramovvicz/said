package com.saidproject.saidproject.dao.user;

import com.google.common.base.Objects;
import com.saidproject.saidproject.repo.AbstractEntity;

public class User extends AbstractEntity {

    private String name;
    private String surname;
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Role role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(name, user.name) &&
                Objects.equal(surname, user.surname) &&
                Objects.equal(userName, user.userName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, surname, userName, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }

    public enum Role {
        ADMIN, USER;
    }
}
