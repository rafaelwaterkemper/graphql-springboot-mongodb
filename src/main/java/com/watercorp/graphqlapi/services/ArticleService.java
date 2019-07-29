package com.watercorp.graphqlapi.services;

import com.watercorp.graphqlapi.models.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findAllUserArticles(List<String> userId);
}
