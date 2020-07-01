package nobodyCanQuit.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import nobodyCanQuit.service.dust.DustAreaAddrService;
import nobodyCanQuit.service.address.AddressApiService;
import nobodyCanQuit.service.address.CityListService;
import nobodyCanQuit.web.model.address.AddressInputCommand;

@Controller
public class MainController {
	
	@Autowired
    private CityListService cityListService;
    @Autowired
    private AddressApiService addressApiService;
    @Autowired
    private DustAreaAddrService dustAreaAddrService;
    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String indexget(AddressInputCommand addressInputCommand, Model model) throws IOException {

        model.addAttribute("cityList", cityListService);

        addressApiService.buildApi();

        return "index";
    }
    
    @PostMapping("/")
    public String indexpost(AddressInputCommand addressInputCommand, Model model) throws Exception {

        /*
        * 계층별 주소검색
        */
        model.addAttribute("cityList", cityListService);

        addressApiService.buildApi();
        addressApiService.setAddressInputCommand(addressInputCommand);

//        AddressCommand addressCommand =
//                mapper.readValue(addressApiService.getAddressLevel2Url(), AddressCommand.class);
//        model.addAttribute("addressCommand", addressCommand);

//        AddressForDongCommand addressForDongCommand =
//                mapper.readValue(addressApiService.getAddressLevel3Url() ,AddressForDongCommand.class);
//        model.addAttribute("addressForDongCommand", addressForDongCommand);

        return "index";
    }

}
