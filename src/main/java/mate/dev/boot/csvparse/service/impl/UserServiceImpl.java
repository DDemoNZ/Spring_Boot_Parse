package mate.dev.boot.csvparse.service.impl;

import java.util.Optional;
import mate.dev.boot.csvparse.entity.User;
import mate.dev.boot.csvparse.repository.UserRepository;
import mate.dev.boot.csvparse.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByUsername(String email) {
        return userRepository.getByUsername(email);
    }
}
