package kau.software.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordDto {
    private Long id;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    public RecordDto(Long id, String location, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
