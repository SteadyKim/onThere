package kau.software;

import kau.software.domain.record.Record;
import kau.software.domain.user.Role;
import kau.software.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;
//    @PostConstruct
//    public void init() {
//        initService.dbInit();
//    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        private final BCryptPasswordEncoder encoder;
        public void dbInit() {
            String encode = encoder.encode("1234");
            Users users = Users.builder()
                    .userId("rereers1125")
                    .role(Role.USER)
                    .password(encode)
                    .email("rereers1125@naver.com")
                    .name("김태우")
                    .oauth("oauth")
                    .build();

            Record record = Record.builder()
                    .location("부산")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now())
                    .build();


            Record record2 = Record.builder()
                    .location("부산")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now())
                    .build();

            Record record3 = Record.builder()
                    .location("부산")
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now())
                    .build();

            users.addRecord(record);
            users.addRecord(record2);
            users.addRecord(record3);

            em.persist(users);

        }
    }
}
