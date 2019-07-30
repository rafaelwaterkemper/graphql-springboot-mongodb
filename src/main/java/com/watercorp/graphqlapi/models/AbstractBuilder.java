package com.watercorp.graphqlapi.models;

public class AbstractBuilder<T, B extends AbstractBuilder> {

    protected T entity;

    AbstractBuilder(T value) {
        entity = value;
    }

    public T build() {
        return entity;
    }
}
