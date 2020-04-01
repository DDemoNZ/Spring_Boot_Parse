package mate.dev.boot.csvparse.repository;

import mate.dev.boot.csvparse.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
