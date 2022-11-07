package kau.software.service;

import kau.software.config.auth.dto.SessionUser;
import kau.software.domain.user.UserRepository;
import kau.software.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(Users user) {
        return userRepository.save(user).getId();
    }
}
