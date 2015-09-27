package dashbotdemo.data.stargazers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubStargazersService {

    protected RestTemplate restTemplate;

    private String githubApiUrl;
    private String dashbotRepoName;

    @Autowired
    GithubStargazersService(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        githubApiUrl = env.getProperty("githubApiUrl");
        dashbotRepoName = env.getProperty("dashbotRepoName");
    }

    public int getStargazerCount() {
        String stargazerUrl = getStargazerUrl();
        return restTemplate.getForObject(stargazerUrl, Stargazer[].class).length;
    }

    protected String getStargazerUrl() {
        return githubApiUrl + "repos/" + dashbotRepoName + "/stargazers";
    }
}
