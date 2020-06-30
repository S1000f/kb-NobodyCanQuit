package nobodyCanQuit.web.model.viligeDust;

import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties({"parm","CtprvnMesureLIstVo","totalCount"})
@Data
public class DustAttemptAddr {
	 @JsonProperty("list")
	 private List<DustAttempt> dustAttempt;
}
