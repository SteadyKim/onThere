package kau.software.web.dto;

import kau.software.domain.record.Record;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
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

    public Record toEntity() {
        Record record = new Record();

        record.setLocation(location);
        record.setStartDate(startDate);
        record.setEndDate(endDate);
        return record;
    }
}
