package com.panda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panda.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
