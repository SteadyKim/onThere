package kau.software.web.dto;


import kau.software.domain.user.Role;
import kau.software.domain.user.Users;
import lombok.Data;

@Data
public class CreateUserDto {

    private String userId;
    private String password;
    private String name;
    private String email;

    public Users toEntity() {
        Users user = new Users();
        user.setUserId(userId);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setRole(Role.USER);

        return user;
    }
}
