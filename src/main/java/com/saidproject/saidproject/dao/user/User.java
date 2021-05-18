package com.saidproject.saidproject.dao.user;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Role> roles = new HashSet<>();
    @Id
    @Column(name = "user_id")
    private long id;
    @Id
    @Column(name = "user_name")
    private String firstName;
    @Id
    @Column(name = "last_name")
    private String lastName;
    @Id
    @Column(name = "user_name")
    private String userName;
    @Id
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(firstName, user.firstName) && Objects.equal(lastName, user.lastName) && Objects.equal(userName, user.userName) && roles == user.roles;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, userName, roles);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + firstName + '\'' + ", surname='" + lastName + '\'' + ", userName='" + userName + '\'' + ", role=" + roles + '}';
    }

    public enum Role {
        ADMIN, USER;
    }
}
