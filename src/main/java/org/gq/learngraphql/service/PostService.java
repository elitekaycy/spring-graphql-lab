package org.gq.learngraphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.gq.learngraphql.model.Post;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }


    public Post getPostById(Integer id) {
        return posts.stream()
                    .filter(post -> post.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public Post addPost(String title, String description) {
        Post newPost = new Post(title, description);
        posts.add(newPost);
        return newPost;
    }

    public Post updatePost(Integer id, String title, String description) {
        Optional<Post> postOpt = posts.stream()
                                      .filter(post -> post.getId().equals(id))
                                      .findFirst();

        if (postOpt.isPresent()) {
            Post postToUpdate = postOpt.get();
            postToUpdate.setTitle(title);
            postToUpdate.setDescription(description);
            return postToUpdate;
        } else {
            throw new RuntimeException("Post with id " + id + " not found");
        }
    }

    public boolean deletePost(Integer id) {
      return posts.removeIf(post -> post.getId().equals(id));
    }

    @PostConstruct
    private void initPosts() {
        posts.add(new Post("GraphQL Introduction", "A brief introduction to GraphQL."));
        posts.add(new Post("GraphQL vs REST", "A comparison between GraphQL and REST API."));
        posts.add(new Post("Advanced GraphQL Queries", "Learn how to perform advanced queries using GraphQL."));
    }
}

