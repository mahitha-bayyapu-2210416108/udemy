package com.example.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udemy.Model.Authority;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
