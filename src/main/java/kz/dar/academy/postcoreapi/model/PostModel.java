package kz.dar.academy.postcoreapi.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    @NotNull(message = "Post ID can not be empty")
    private String postId;
    @NotNull(message = "Client ID can not be empty")
    private String clientId;
    @NotNull(message = "Recipient ID can not be empty")
    private String postRecipientId;
    private String postItem;
    private String status;
}
