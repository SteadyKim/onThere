package kau.software.web.controller;

import kau.software.domain.user.Users;
import kau.software.service.UserService;
import kau.software.web.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/logins")
    public String login() {

        return "backend/logins";
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

        return "backend/join";
    }

    @PostMapping("/join")
    public String join(CreateUserDto userDto) {

        Users user = userDto.toEntity();
        httpSession.setAttribute("user", user);

        userService.join(user);
        return "redirect:/";
    }
}
