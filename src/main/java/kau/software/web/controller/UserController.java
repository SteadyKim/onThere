package kau.software.web.controller;

import kau.software.domain.user.Users;
import kau.software.service.UserService;
import kau.software.web.dto.CreateUserDto;
import kau.software.web.dto.LoginUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    private final BCryptPasswordEncoder encoder;
    @GetMapping("/logins")
    public String loginForm(Model model) {

        model.addAttribute("loginUserDto", new LoginUserDto());

        return "frontend/logins";
    }

    @PostMapping("/logins")
    public String login(@ModelAttribute LoginUserDto loginUserDto) {
        Users foundUser = userService.findByUserId(loginUserDto.getUserId());
        // 회원 가입이 되지 않은 경우
        if(foundUser == null) {
            System.out.println("회원이 없습니다. 로그인 실패");
            return "frontend/logins";
        }

        // 회원 가입이 되어 있는 경우

        // 비밀번호가 다른 경우
        String encodedPassword = foundUser.getPassword();
        if(!(encoder.matches(loginUserDto.getPassword(), encodedPassword))) {
            //TODO @VALID 옵션 적용하기
            System.out.println("비밀번호가 다릅니다.");
            return "frontend/logins";
        }

        httpSession.setAttribute("user", foundUser);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("userDto", new CreateUserDto());

        return "frontend/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute CreateUserDto userDto) {

        Users user = userDto.toEntity();
        httpSession.setAttribute("user", user);

        userService.join(user);
        return "redirect:/";
    }
}
