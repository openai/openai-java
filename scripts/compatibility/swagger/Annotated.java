import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class Annotated {
    @Schema(pattern = "[A-Z]{2}")
    @JsonProperty("country_code")
    public String countryCode;

    @ArraySchema(minItems = 2)
    public List<String> aliases;

    @JsonIgnore
    public String ignored;
}
