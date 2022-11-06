package kau.software.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String oauth;


    @Builder
    public Member(String userId, String password, String name, String oauth) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.oauth = oauth;
    }

}
