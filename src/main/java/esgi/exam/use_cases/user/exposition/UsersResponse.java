package esgi.exam.use_cases.user.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class UsersResponse {
    public final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }
}
