package com.example.udemy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.udemy.Model.Account;
import com.example.udemy.Model.Authority;
import com.example.udemy.Model.Post;
import com.example.udemy.services.AccountService;
import com.example.udemy.services.AuthorityService;
import com.example.udemy.services.PostService;
import com.example.udemy.util.constants.Privillages;


@Component
public class SeedData implements CommandLineRunner{
    @Autowired
        private PostService postService;

    @Autowired
        private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;


    @Override
    public void run(String... args) throws Exception {
        for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

       }

        Account account01 = new Account();
        Account account02 = new Account();

        account01.setEmail("account1@gmail.com");
        account01.setPassword("123");
        account01.setFirstname("user01");
        account01.setLastname("lastname01");

        account02.setEmail("account2@gmail.com");
        account02.setPassword("123");
        account02.setFirstname("user02");
        account02.setLastname("lastname02");

        accountService.save(account01);
        accountService.save(account02);


        List<Post> posts = postService.getAll();
        if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("post 01");
            post01.setBody("Post 01 body ......");
            post01.setAccount(account01);
            postService.save(post01);


            Post post02 = new Post();
            post02.setTitle("post 02");
            post02.setBody("Post 02 body ......");
            post02.setAccount(account02);
            postService.save(post02);


       }

    }

}
