package col.com.er.rest.response;

import col.com.er.entity.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private long id;
    private String username;
    private String message;

    public UserResponse(String message, Users userResponse) {
        this.id = userResponse.getId();
        this.message = message;
        this.username = userResponse.getUsername();

    }

}
