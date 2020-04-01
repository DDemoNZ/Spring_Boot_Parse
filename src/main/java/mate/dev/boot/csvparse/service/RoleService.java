package mate.dev.boot.csvparse.service;

import mate.dev.boot.csvparse.entity.Role;

public interface RoleService {

    Role save(Role role);

    Role getByRoleName(String roleName);
}
