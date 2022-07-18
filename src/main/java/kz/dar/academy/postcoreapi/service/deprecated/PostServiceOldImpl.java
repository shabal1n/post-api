package kz.dar.academy.postcoreapi.service.deprecated;

import kz.dar.academy.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceOldImpl implements PostServiceOld {
    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel post1 = new PostModel(UUID.randomUUID().toString(), "145",
                "745", "Iphone", "delivered");
        PostModel post2 = new PostModel(UUID.randomUUID().toString(), "489",
                "544", "Food", "new");
        PostModel post3 = new PostModel(UUID.randomUUID().toString(), "678",
                "987", "Clothes", "on the way");

        postMap.put(post1.getPostId(), post1);
        postMap.put(post2.getPostId(), post2);
        postMap.put(post3.getPostId(), post3);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        postMap.put(postId, postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }
}
