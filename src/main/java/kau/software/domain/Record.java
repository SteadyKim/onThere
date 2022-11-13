package kau.software.domain;

import kau.software.domain.user.Role;
import kau.software.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private Users users;


    @Builder
    public Record(String location, LocalDate startDate, LocalDate endDate) {
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
