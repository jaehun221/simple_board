package com.jaehun.board_api.service;

import com.jaehun.board_api.entity.Post;
import com.jaehun.board_api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 작성
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // 게시글 목록 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 단일 게시글 조회
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
    }

    // 게시글 수정
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id); // 기존 게시글 확인
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());
        return postRepository.save(post);
    }

    // 게시글 삭제
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}