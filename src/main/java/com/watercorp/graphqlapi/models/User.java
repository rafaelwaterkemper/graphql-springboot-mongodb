package com.watercorp.graphqlapi.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "users")
public class User {

    private ObjectId id;

    private String name;

    private Integer age;

    private LocalDateTime createdAt;

    private String nationality;

    private List<String> friendsIds;

    private List<String> articlesIds;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<String> getFriendsIds() {
        return friendsIds;
    }

    public void setFriendsIds(List<String> friendsIds) {
        this.friendsIds = friendsIds;
    }

    public List<String> getArticlesIds() {
        return articlesIds;
    }

    public void setArticlesIds(List<String> articlesIds) {
        this.articlesIds = articlesIds;
    }
}
