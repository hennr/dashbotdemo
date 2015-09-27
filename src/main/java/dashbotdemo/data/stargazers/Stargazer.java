package dashbotdemo.data.stargazers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stargazer {
    public String login;
    public Integer id;
}
