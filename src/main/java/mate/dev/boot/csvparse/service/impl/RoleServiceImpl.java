package mate.dev.boot.csvparse.service.impl;

import mate.dev.boot.csvparse.entity.Role;
import mate.dev.boot.csvparse.repository.RoleRepository;
import mate.dev.boot.csvparse.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
