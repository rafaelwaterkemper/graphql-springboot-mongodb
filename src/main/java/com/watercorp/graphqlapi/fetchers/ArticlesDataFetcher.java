package com.watercorp.graphqlapi.fetchers;

import com.watercorp.graphqlapi.models.Article;
import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.services.ArticleService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticlesDataFetcher implements DataFetcher<List<Article>> {

    private final ArticleService articleService;

    ArticlesDataFetcher(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public List<Article> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<String> articleIds = new ArrayList<>();

        if(user!=null){
            articleIds = user.getArticlesIds();
        }

        List<Article> articles = articleService.findAllUserArticles(articleIds);
        return articles;
    }
}
