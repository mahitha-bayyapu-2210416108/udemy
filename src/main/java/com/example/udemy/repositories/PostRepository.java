package com.example.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udemy.Model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
