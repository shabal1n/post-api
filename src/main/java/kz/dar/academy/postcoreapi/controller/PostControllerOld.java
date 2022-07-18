package kz.dar.academy.postcoreapi.controller;

import kz.dar.academy.postcoreapi.model.PostModel;
import kz.dar.academy.postcoreapi.service.deprecated.PostServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deprecated/post")
@EnableEurekaClient
public class PostControllerOld {

    @Autowired
    private Environment env;
    @Autowired
    private PostServiceOld postServiceOld;

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return new ResponseEntity<>("post-core-api is working at " + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostModel postModel) {
        postServiceOld.createPost(postModel);
        return new ResponseEntity<>("Post was added", HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId,
                                                 @RequestBody PostModel postModel) {
        postServiceOld.updatePostById(postId, postModel);
        return new ResponseEntity<>("Post was updated", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postServiceOld.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postServiceOld.getPostById(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postServiceOld.deletePostById(postId);
        return new ResponseEntity<>("Deleted a post", HttpStatus.OK);
    }
}