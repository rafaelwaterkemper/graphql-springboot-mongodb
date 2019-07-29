package com.watercorp.graphqlapi.fetchers;

import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserDataFetcher implements DataFetcher<User> {

    private final UserService userService;

    UserDataFetcher(UserService userService){
        this.userService = userService;
    }

    @Override
    public User get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        User user = userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
        return null;
    }
}
