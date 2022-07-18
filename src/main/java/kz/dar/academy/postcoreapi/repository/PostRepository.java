package kz.dar.academy.postcoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    PostEntity getPostEntityByPostId(String postId);

    void deletePostEntityByPostId(String postId);

    List<PostEntity> getPostEntitiesBy();
}
