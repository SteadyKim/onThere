package kau.software.service;

import kau.software.domain.record.Record;
import kau.software.domain.record.RecordRepository;
import kau.software.domain.user.UserRepository;
import kau.software.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class RecordService {

    private final UserRepository userRepository;
    private final RecordRepository recordRepository;

    @Transactional
    public List<Record> findRecordsById(Long id) {
        Optional<Users> user = userRepository.findById(id);
        List<Record> records = user.get().getRecords();

        return records;
    }
}
