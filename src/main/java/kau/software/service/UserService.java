package kau.software.service;

import kau.software.domain.user.UserRepository;
import kau.software.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(Users user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user).getId();
    }

    @Transactional
    public Users findByUserId(String userId) {
        Optional<Users> foundUser = userRepository.findByUserId(userId);
        return foundUser.orElse(null);
    }
}
