package kau.software.web.controller;

import kau.software.domain.travel.Travel;
import kau.software.web.dto.TravelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class BonusController {

    @GetMapping("/bonus")
    public String bonus() {

        return "frontend/bonus";
    }

    @GetMapping("/seoul")
    public String seoul(Model model) {
        ArrayList<TravelDto> travelDtoArrayList = new ArrayList<>();
        TravelDto travelDto1 = new TravelDto("창경궁", "서울 종로구 창경궁로 185", "frontend/png/seoul1.jpg");
        TravelDto travelDto2 = new TravelDto("별마당 도서관", "서울 강남구 영동대로 513", "frontend/png/seoul2.jpg");
        TravelDto travelDto3 = new TravelDto("남산 타워", "서울 용산구 남산공원길 105", "frontend/png/seoul3.jpg");
        TravelDto travelDto4 = new TravelDto("롯데 타워", "서울 송파구 올림픽로 300", "frontend/png/seoul4.jpg");
        TravelDto travelDto5 = new TravelDto("여의도 한강공원", "서울 영등포구 여의동로 330", "frontend/png/seoul5.jpg");
        TravelDto travelDto6 = new TravelDto("덕수궁", "서울 중구 세종대로 99", "frontend/png/seoul6.jpeg");
        TravelDto travelDto7 = new TravelDto("북촌 한옥마을", "서울 종로구 계동길 37", "frontend/png/seoul7.jpg");
        TravelDto travelDto8 = new TravelDto("청계천", "서울 종로구 창신동", "frontend/png/seoul8.jpg");

        travelDtoArrayList.add(travelDto1);
        travelDtoArrayList.add(travelDto2);
        travelDtoArrayList.add(travelDto3);
        travelDtoArrayList.add(travelDto4);
        travelDtoArrayList.add(travelDto5);
        travelDtoArrayList.add(travelDto6);
        travelDtoArrayList.add(travelDto7);
        travelDtoArrayList.add(travelDto8);

        model.addAttribute("travelDtoArrayList", travelDtoArrayList);

        return "frontend/bonus";
    }
}
