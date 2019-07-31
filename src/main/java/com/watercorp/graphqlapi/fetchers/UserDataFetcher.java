package com.watercorp.graphqlapi.fetchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class UserDataFetcher implements DataFetcher<User> {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    UserDataFetcher(UserService userService,
                    ObjectMapper objectMapper){
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @Override
    public User get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        try {
            Map filter = objectMapper.readValue(args.get("filter").toString(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
    }
}
