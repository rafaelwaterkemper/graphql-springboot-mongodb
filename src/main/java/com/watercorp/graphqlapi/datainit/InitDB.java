package com.watercorp.graphqlapi.datainit;

import com.watercorp.graphqlapi.models.User;
import com.watercorp.graphqlapi.repositories.ArticleRepository;
import com.watercorp.graphqlapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitDB {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    InitDB(UserRepository userRepository, ArticleRepository articleRepository){
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @PostConstruct
    private void generateData(){
        List<User> users = new ArrayList<>();
        users.add(User.Builder.create().name("Igor").age(24).build());
        users.add(User.Builder.create().name("Ellen").age(24).build());
        users.add(User.Builder.create().name("John").age(24).build());

        users = (ArrayList) userRepository.saveAll(users);

        User me = users.get(0);

        List<String> myFriendsIds = new ArrayList<>();
        for (int i = 1; i<users.size(); i++){
            myFriendsIds.add(users.get(i).getId().toHexString());
        }
        me.setFriendsIds(myFriendsIds);
        userRepository.save(me);
    }
}