package mate.dev.boot.csvparse.controller;

import javax.annotation.PostConstruct;
import mate.dev.boot.csvparse.entity.Role;
import mate.dev.boot.csvparse.entity.User;
import mate.dev.boot.csvparse.service.RoleService;
import mate.dev.boot.csvparse.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitDataController {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserService userService;

    public InitDataController(RoleService roleService, UserService userService,
                              PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initData() {

        Role userRole = new Role();
        userRole.setRoleName("USER");

        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");

        roleService.save(userRole);
        roleService.save(adminRole);

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.getRoles().add(roleService.getByRoleName("USER"));

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.getRoles().add(roleService.getByRoleName("ADMIN"));

        userService.save(user);
        userService.save(admin);
    }

}
