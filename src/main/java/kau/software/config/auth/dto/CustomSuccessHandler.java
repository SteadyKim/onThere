package kau.software.config.auth.dto;

import kau.software.domain.user.UserRepository;
import kau.software.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class CustomSuccessHandler implements AuthenticationSuccessHandler  {
    private final UserRepository userRepository;
    private final HttpServletRequest httpServletRequest;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        DefaultOAuth2User loginUser = (DefaultOAuth2User)authentication.getPrincipal();
        Map<String, Object> attributes = loginUser.getAttributes();

        //email, oauth 받기
        String email = (String) attributes.get("email");
        String oauth = (String) attributes.get("oauth");
        Optional<Users> foundUser = userRepository.findByEmail(email);

        //분기처리
        if (!foundUser.isEmpty()) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", foundUser.get());

            response.sendRedirect("https://d2c9qluyjz9a0t.cloudfront.net");
        }
        else {
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("oauth", oauth);
            response.sendRedirect("https://d2c9qluyjz9a0t.cloudfront.net/join");
        }

    }
}
