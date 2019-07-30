package com.watercorp.graphqlapi.utilities;

import com.watercorp.graphqlapi.fetchers.AllUsersDataFetcher;
import com.watercorp.graphqlapi.fetchers.ArticlesDataFetcher;
import com.watercorp.graphqlapi.fetchers.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQlUtility {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;
    private GraphQL graphQL;
    private AllUsersDataFetcher allUsersDataFetcher;
    private UserDataFetcher userDataFetcher;
    private ArticlesDataFetcher articlesDataFetcher;

    GraphQlUtility(AllUsersDataFetcher allUsersDataFetcher, UserDataFetcher userDataFetcher,
                   ArticlesDataFetcher articlesDataFetcher) throws IOException {
        this.allUsersDataFetcher = allUsersDataFetcher;
        this.userDataFetcher = userDataFetcher;
        this.articlesDataFetcher = articlesDataFetcher;
    }

    @PostConstruct
    @Bean
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("users", allUsersDataFetcher)
                        .dataFetcher("user", userDataFetcher))
                .type("User", typeWiring -> typeWiring
                        .dataFetcher("articles", articlesDataFetcher)
                        .dataFetcher("friends", allUsersDataFetcher))
                .build();
    }
}
