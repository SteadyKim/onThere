package kau.software.web.controller;


import kau.software.domain.record.Record;
import kau.software.domain.user.Users;
import kau.software.service.RecordService;
import kau.software.web.dto.RecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecordController {

    private final HttpSession httpSession;
    private final RecordService recordService;

    //TODO api 요청하면 record 정보 주기
    @GetMapping("/record")
    public List<RecordDto> findRecordApi() {
        Users user = (Users) httpSession.getAttribute("user");
        List<Record> records = recordService.findRecordsById(1L);

        List<RecordDto> recordDtoList = new ArrayList<>();
        for (Record record : records) {
            RecordDto recordDto = new RecordDto(record.getId(), record.getLocation(), record.getStartDate(), record.getEndDate());
            recordDtoList.add(recordDto);
        }

        return recordDtoList;
    }

}
