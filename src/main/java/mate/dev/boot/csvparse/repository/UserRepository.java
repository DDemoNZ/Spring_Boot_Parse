package mate.dev.boot.csvparse.repository;

import java.util.Optional;
import mate.dev.boot.csvparse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getByUsername(String email);
}
