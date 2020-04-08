package mate.dev.boot.csvparse.service;

import java.util.Optional;
import mate.dev.boot.csvparse.entity.User;

public interface UserService {

    User save(User user);

    Optional<User> getByUsername(String email);
}
