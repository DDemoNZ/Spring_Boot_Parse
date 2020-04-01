package mate.dev.boot.csvparse.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import mate.dev.boot.csvparse.entity.Role;
import mate.dev.boot.csvparse.entity.User;
import mate.dev.boot.csvparse.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username).get();
        UserBuilder userBuilder;
        if (userService.getByUsername(username).isPresent()) {
            userBuilder = withUsername(username);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles().stream()
                    .map(Role::getRoleName)
                    .toArray(String[]::new));
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User with username " + username + " not found.");
        }
    }
}
