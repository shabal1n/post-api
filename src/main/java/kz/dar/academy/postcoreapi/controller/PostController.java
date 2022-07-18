package kz.dar.academy.postcoreapi.controller;

import kz.dar.academy.postcoreapi.model.PostRequest;
import kz.dar.academy.postcoreapi.model.PostResponse;
import kz.dar.academy.postcoreapi.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@EnableEurekaClient
public class PostController {

    @Autowired
    private Environment env;
    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("post-core-api is working at " + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest postModel) {
        return postService.createPost(postModel);
    }

    @PutMapping("/{postId}")
    public PostResponse updatePostById(@RequestBody PostRequest postModel) {
        return postService.updatePostById(postModel);
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Deleted a post", HttpStatus.OK);
    }
}
