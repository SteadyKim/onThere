package kau.software.web.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravelDto {

    String name;

    String location;

    String url;

    public TravelDto(String name, String location, String url) {
        this.name = name;
        this.location = location;
        this.url = url;
    }
}
