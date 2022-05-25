package com.saidproject.saidproject.dao.description;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saidproject.saidproject.repo.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "description")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Description extends AbstractEntity {

    @Column(name = "description_name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Description{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return status == that.status &&
                name.equals(that.name) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, comments);
    }
}
