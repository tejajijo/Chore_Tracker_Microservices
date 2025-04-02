package choremanagement.user_service.service;

import choremanagement.user_service.model.User;
import choremanagement.user_service.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public boolean authenticateUser(String email, String rawPassword) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.filter(value -> passwordEncoder.matches(rawPassword, value.getPassword())).isPresent();
    }
}
