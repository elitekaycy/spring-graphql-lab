package org.gq.learngraphql.resolvers.posts;

import org.gq.learngraphql.model.Post;
import org.gq.learngraphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostQueryMutation {

  private final PostService postService;

  public PostQueryMutation(PostService postService) {
    this.postService = postService;
  }

  @MutationMapping
  public Post addPost(@Argument String title, @Argument String description) {
    return postService.addPost(title, description);
  }

  @MutationMapping
  public Post updatePost(@Argument int id, @Argument String title, @Argument String description) {
    return postService.updatePost(id, title, description);
  }

  @MutationMapping
  public Boolean deletePost(@Argument int id) {
    return postService.deletePost(id);
  }
}
