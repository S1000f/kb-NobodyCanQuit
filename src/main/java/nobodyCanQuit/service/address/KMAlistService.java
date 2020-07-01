package nobodyCanQuit.service.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import nobodyCanQuit.web.model.address.*;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class KMAlistService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<String, String> cityMap;

    public KMAlistService() {
        this.cityMap = new TreeMap<>();
        initCityList();
    }

    private void initCityList() {
        cityMap.put("서울특별시", "11");
        cityMap.put("부산광역시", "26");
        cityMap.put("대구광역시", "27");
        cityMap.put("인천광역시", "28");
        cityMap.put("광주광역시", "29");
        cityMap.put("대전광역시", "30");
        cityMap.put("울산광역시", "31");
        cityMap.put("경기도", "41");
        cityMap.put("강원도", "42");
        cityMap.put("충청북도", "43");
        cityMap.put("충청남도", "44");
        cityMap.put("전라북도", "45");
        cityMap.put("전라남도", "46");
        cityMap.put("경상북도", "47");
        cityMap.put("경상남도", "48");
        cityMap.put("제주특별자치도", "50");
        cityMap.put("세종특별자치시", "0");
    }

    public FxxxKMAcoord getKMAcoord(AddressCommand address, AddressInputCommand addressInput) throws IOException {

        String kmaCityCode = cityMap.get(addressInput.getCity());
        String gu = address.getName(addressInput.getGu());
        String dong = addressInput.getDong();
        String kmaGuCode = "";

        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, FxxxKMA.class);
        List<FxxxKMA> fxxxKMAList =
                mapper.readValue(
                        new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/mdl." + kmaCityCode + ".json.txt"),
                        collectionType
                );

        for (FxxxKMA f: fxxxKMAList) {
            if (f.getValue().equals(gu)) {
                kmaGuCode = f.getCode();
            }
        }

        collectionType = mapper.getTypeFactory().constructCollectionType(List.class, FxxxKMAcoord.class);
        List<FxxxKMAcoord> fcoordList = new ArrayList<>();
        try {
            fcoordList = mapper.readValue(
                    new URL("http://www.kma.go.kr/DFSROOT/POINT/DATA/leaf." + kmaGuCode + ".json.txt"),
                    collectionType
            );
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        for (FxxxKMAcoord fcoord: fcoordList) {
            if (fcoord.getValue().equals(dong)) {
                return fcoord;
            }
        }
        return new FxxxKMAcoord();
    }

}