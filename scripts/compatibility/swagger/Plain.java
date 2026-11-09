import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Plain {
    @JsonProperty("country_code")
    public String countryCode;

    @JsonIgnore
    public String ignored;
}
