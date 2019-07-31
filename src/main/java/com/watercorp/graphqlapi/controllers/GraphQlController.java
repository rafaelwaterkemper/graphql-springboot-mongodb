package com.watercorp.graphqlapi.controllers;

import com.watercorp.graphqlapi.utilities.GraphQlUtility;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphQlController {

    private GraphQL graphQL;
    private GraphQlUtility graphQlUtility;

    public GraphQlController(GraphQL graphQL, GraphQlUtility graphQlUtility) {
        this.graphQL = graphQL;
        this.graphQlUtility = graphQlUtility;
    }

    @PostMapping("/graphql")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult executionResult = graphQL.execute(query);
        System.out.println(executionResult.getErrors());
        return ResponseEntity.ok(executionResult.getData());
    }
}
