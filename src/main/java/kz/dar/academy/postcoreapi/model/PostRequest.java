package kz.dar.academy.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotNull(message = "Post ID can not be null")
    private String postId;
    private String clientId;
    private String postRecipientId;
    private String postItem;
    @NotNull(message = "Status can not be null")
    private String status;
}
