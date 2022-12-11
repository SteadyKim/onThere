package kau.software.web.controller;


import kau.software.domain.record.Record;
import kau.software.domain.user.Users;
import kau.software.service.RecordService;
import kau.software.service.UserService;
import kau.software.web.dto.RecordDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RecordApiController {

    private final HttpSession httpSession;
    private final RecordService recordService;
    private final UserService userService;

    @GetMapping("/record")
    public List<RecordDto> findRecordApi() {
        Users user = (Users) httpSession.getAttribute("user");
        List<Record> records = recordService.findRecordsById(user.getId());

        List<RecordDto> recordDtoList = new ArrayList<>();
        for (Record record : records) {
            RecordDto recordDto = new RecordDto(record.getId(), record.getLocation(), record.getStartDate(), record.getEndDate());
            recordDtoList.add(recordDto);
        }

        return recordDtoList;
    }
    @PostMapping("/record")
    public void addRecordApi(@RequestParam("location") String location,
                             @RequestParam("startDate") String startDate,
                             @RequestParam("endDate") String endDate) {
        Users user = (Users) httpSession.getAttribute("user");

        RecordDto recordDto = new RecordDto();

        recordDto.setLocation(location);
        recordDto.setStartDate(LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE));
        recordDto.setEndDate(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE));

        if(user == null) {
            return;
        }
        Users foundUser = userService.findById(user.getId());

        userService.updateRecord(foundUser, recordDto.toEntity());
    }

    @DeleteMapping("/record/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteRecordApi(@PathVariable("id") Long id) {
        recordService.deleteRecordById(id);
        return "성공시 OK 코드를 보냅니다.";
    }
}
