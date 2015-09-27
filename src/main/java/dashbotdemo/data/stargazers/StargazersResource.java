package dashbotdemo.data.stargazers;

import dashbotdemo.data.ValueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class StargazersResource {

    @Autowired
    GithubStargazersService githubStargazersService;

    @RequestMapping("stargazers")
    public ValueDto stargazers() {
        return new ValueDto(githubStargazersService.getStargazerCount());
    }
}
