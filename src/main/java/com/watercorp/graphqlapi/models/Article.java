package com.watercorp.graphqlapi.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Article")
public class Article {

    private ObjectId id;

    private String title;

    private Integer minutesRead;

    private String authorId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinutesRead() {
        return minutesRead;
    }

    public void setMinutesRead(Integer minutesRead) {
        this.minutesRead = minutesRead;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}