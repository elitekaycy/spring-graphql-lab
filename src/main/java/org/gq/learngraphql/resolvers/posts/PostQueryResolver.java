package org.gq.learngraphql.resolvers.posts;

import java.util.List;

import org.gq.learngraphql.model.Post;
import org.gq.learngraphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostQueryResolver  {

  private final PostService postService;

  public PostQueryResolver(PostService postService) {
    this.postService = postService;
  }

  @QueryMapping
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @QueryMapping
  public Post getPostById(@Argument Integer id) {
    return postService.getPostById(id);
  }
}
