package com.saidproject.saidproject.dao.user;

import com.google.common.base.Objects;
import com.saidproject.saidproject.repo.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Column(name = "role")
    public Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return Objects.equal(firstName, user.firstName) && Objects.equal(lastName, user.lastName) && Objects.equal(userName, user.userName) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, userName, role);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + firstName + '\'' + ", surname='" + lastName + '\'' + ", userName='" + userName + '\'' + ", role=" + role + '}';
    }

    public enum Role {
        ADMIN, USER;
    }
}
