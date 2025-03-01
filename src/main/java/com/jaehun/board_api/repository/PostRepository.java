package com.jaehun.board_api.repository;

import com.jaehun.board_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}