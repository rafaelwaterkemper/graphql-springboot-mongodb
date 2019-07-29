package com.watercorp.graphqlapi.fetchers;

import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {

    private final UserService userService;

    public AllUsersDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<User> friends;
        if (Objects.nonNull(user)) {
            friends = userService.findByIdIn(user.getFriendsIds());
        } else {
            friends = userService.findAllUsers();
        }

        return friends;
    }

}
