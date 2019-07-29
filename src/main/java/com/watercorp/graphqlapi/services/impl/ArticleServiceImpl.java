package com.watercorp.graphqlapi.services.impl;

import com.watercorp.graphqlapi.models.Article;
import com.watercorp.graphqlapi.repositories.ArticleRepository;
import com.watercorp.graphqlapi.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAllUserArticles(List<String> ids) {
        return articleRepository.findByIdIn(ids);
    }
}