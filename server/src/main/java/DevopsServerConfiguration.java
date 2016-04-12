import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by sameto on 12/04/2016.
 */
public class DevopsServerConfiguration extends Configuration {

    @NotEmpty
    private String defaultName = "DevOpsCourse";

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}

