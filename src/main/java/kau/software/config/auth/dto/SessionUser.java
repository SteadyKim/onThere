package kau.software.config.auth.dto;

import kau.software.domain.user.Role;
import kau.software.domain.user.Users;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Data
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String password;
    private String oauth;


    public SessionUser() {
    }

    /*Entity -> Dto */
    public SessionUser(Users user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.oauth = user.getOauth();
    }

    public void encodePassword(String encode) {
        this.password = encode;
    }

    public Users toEntity() {
        return Users.builder()
                .name(name)
                .password(password)
                .oauth(oauth)
                .role(Role.GUEST)
                .build();
    }
}