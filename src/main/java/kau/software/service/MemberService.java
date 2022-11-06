package kau.software.service;

import kau.software.domain.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository userRepository;
    private final BCryptPasswordEncoder encoder;
}
