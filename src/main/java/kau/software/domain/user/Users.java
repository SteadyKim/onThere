package kau.software.domain.user;

import kau.software.domain.record.Record;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(
        name="USERS",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"USER_ID"})
)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "id")
    private String userId;

    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String oauth;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Record> records = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public Users(String userId, String password, String name, String oauth, Role role, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.oauth = oauth;
        this.role = role;
        this.email = email;
    }

    public Users update(String name) {
        this.name = name;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    /**
     * 연관관계 편의 메서드
     */
    public void addRecord(Record record) {
        record.setUsers(this);
        records.add(record);
    }
}
