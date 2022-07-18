package kz.dar.academy.postcoreapi.service.post;


import kz.dar.academy.postcoreapi.model.PostRequest;
import kz.dar.academy.postcoreapi.model.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse createPost(PostRequest postModel);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postId);

    PostResponse updatePostById(PostRequest postModel);

    void deletePostById(String postId);
}
