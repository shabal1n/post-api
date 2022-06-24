package kz.dar.academy.postcoreapi.controller;

import kz.dar.academy.postcoreapi.model.PostModel;
import kz.dar.academy.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("post-core-api is working", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostModel postModel) {
        postService.createPost(postModel);
        return new ResponseEntity<>("Post was added", HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId,
                                                 @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<>("Post was updated", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Deleted a post", HttpStatus.OK);
    }
}