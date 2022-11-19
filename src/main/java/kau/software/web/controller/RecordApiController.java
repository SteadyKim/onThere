package kau.software.web.controller;


import kau.software.domain.record.Record;
import kau.software.domain.user.Users;
import kau.software.service.RecordService;
import kau.software.web.dto.RecordDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RecordApiController {

    private final HttpSession httpSession;
    private final RecordService recordService;

    @GetMapping("/record")
    public List<RecordDto> findRecordApi() {
        Users user = (Users) httpSession.getAttribute("user");
        //TODO 1은 userId로 변경할 것.
        List<Record> records = recordService.findRecordsById(1L);

        List<RecordDto> recordDtoList = new ArrayList<>();
        for (Record record : records) {
            RecordDto recordDto = new RecordDto(record.getId(), record.getLocation(), record.getStartDate(), record.getEndDate());
            recordDtoList.add(recordDto);
        }

        return recordDtoList;
    }

    @DeleteMapping("/record/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteRecordApi(@PathVariable("id") Long id) {
        recordService.deleteRecordById(id);
        return "성공시 OK 코드를 보냅니다.";
    }
}
