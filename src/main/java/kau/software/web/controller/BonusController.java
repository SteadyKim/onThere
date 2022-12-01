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

    @GetMapping("/jeonju")
    public String jeonju(Model model) {
        ArrayList<TravelDto> travelDtoArrayList = new ArrayList<>();
        TravelDto travelDto1 = new TravelDto("전주한옥마을", "전북 전주시 완산구 풍남동3가", "frontend/png/jeonju1.jpg");
        TravelDto travelDto2 = new TravelDto("전주향교", "전북 전주시 완산구 교동 26-3", "frontend/png/jeonju2.jpg");
        TravelDto travelDto3 = new TravelDto("전동성당", "전북 전주시 완산구 전동 200-1", "frontend/png/jeonju3.jpg");
        TravelDto travelDto4 = new TravelDto("경기전", "전북 전주시 완산구 풍남동3가", "frontend/png/jeonju4.png");
        TravelDto travelDto5 = new TravelDto("풍남문", "전북 전주시 완산구 전동 83-4", "frontend/png/jeonju5.jpg");
        TravelDto travelDto6 = new TravelDto("전주덕진공원", "전북 전주시 덕진구 덕진동1가", "frontend/png/jeonju6.png");
        TravelDto travelDto7 = new TravelDto("청연루", "전북 전주시 완산구 동서학동 940-2", "frontend/png/jeonju7.png");
        TravelDto travelDto8 = new TravelDto("오목대", "전라북도 전주시 완사눅 교동산 1-11", "frontend/png/jeonju8.jpg");

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

    @GetMapping("/cheonan")
    public String cheonan(Model model) {
        ArrayList<TravelDto> travelDtoArrayList = new ArrayList<>();
        TravelDto travelDto1 = new TravelDto("국학원 한민족역사문화공원", "충청남도 천안시 동남구 목천읍 교천지산길", "frontend/png/cheonan1.jpg");
        TravelDto travelDto2 = new TravelDto("천왕사 꽃정원", "충청남도 천안시 동남구 광덕면 원터길", "frontend/png/cheonan2.jpg");
        TravelDto travelDto3 = new TravelDto("아름다운정원 화수목", "충청남도 천안시 동남구 목천읍 교천지산길", "frontend/png/cheonan3.jpg");
        TravelDto travelDto4 = new TravelDto("유관순열사 사적지", "충청남도 천안시 동남구 병천면 유관순길", "frontend/png/cheonan4.jpg");
        TravelDto travelDto5 = new TravelDto("독립기념관", "충청남도 천안시 동남구 목천읍 독립기념관로", "frontend/png/cheonan5.jpg");
        TravelDto travelDto6 = new TravelDto("왕지봉 배꽃", "충청남도 천안시 서북구 성환읍 왕지1길", "frontend/png/cheonan6.jpg");
        TravelDto travelDto7 = new TravelDto("천안종합휴양관광지", "충청남도 천안시 동남구 성남면 종합휴양지로", "frontend/png/cheonan7.jpg");
        TravelDto travelDto8 = new TravelDto("천호지 야경", "충청남도 천안시 동남구 단대로", "frontend/png/cheonan8.jpg");

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

    @GetMapping("/busan")
    public String busan(Model model) {
        ArrayList<TravelDto> travelDtoArrayList = new ArrayList<>();
        TravelDto travelDto1 = new TravelDto("태종대", "부산광역시 영도구 전망로 24", "frontend/png/busan1.jpg");
        TravelDto travelDto2 = new TravelDto("감천문화마을", "부산 사하구 감천동 10-63", "frontend/png/busan2.jpg");
        TravelDto travelDto3 = new TravelDto("해운대해수욕장", "부산광역시 해운대구 중1동 해운대해변로 264", "frontend/png/busan3.jpg");
        TravelDto travelDto4 = new TravelDto("용궁구름다리", "부산광역시 서구 암남동 703", "frontend/png/busan4.jpg");
        TravelDto travelDto5 = new TravelDto("다대포해해수욕장", "부산광역시 사하구 다대동 몰운대1길 14", "frontend/png/busan5.jpg");
        TravelDto travelDto6 = new TravelDto("흰여울문화마을", "부산광역시 영도구 영선동4가 1043", "frontend/png/busan6.jpg");
        TravelDto travelDto7 = new TravelDto("송정해수욕장", "부산광역시 해운대구 송정도 712-2", "frontend/png/busan7.jpg");
        TravelDto travelDto8 = new TravelDto("오륙도 스카이워크", "부산 남구 용호동 산 197-4", "frontend/png/busan8.png");

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
