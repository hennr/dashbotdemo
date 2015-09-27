package dashbotdemo.data.stargazers;

import com.jayway.restassured.RestAssured;
import dashbotdemo.AbstractRestTestClass;
import dashbotdemo.DashbotdemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = DashbotdemoApplication.class)
public class StargazersResourceTest extends AbstractRestTestClass {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void returnsZeroOnEmptyStargazersList() {
        // given
        GithubStargazersService githubStargazersService = applicationContext.getBean(GithubStargazersService.class);
        final String stargazerUrl = githubStargazersService.getStargazerUrl();

        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo(stargazerUrl))
                .andRespond(withSuccess("[]", MediaType.APPLICATION_JSON));

        githubStargazersService.restTemplate = restTemplate;

        // expect
        RestAssured.get("/data/stargazers").then().assertThat().statusCode(200).body("value", equalTo(0));
    }

    @Test
    public void returnsCorrectStargazerCountOnNonEmptyResult() {
        // given
        GithubStargazersService githubStargazersService = applicationContext.getBean(GithubStargazersService.class);
        final String stargazerUrl = githubStargazersService.getStargazerUrl();

        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(requestTo(stargazerUrl))
                .andRespond(withSuccess(
                        "[\n" +
                        "  {\n" +
                        "    \"login\": \"hans\",\n" +
                        "    \"id\": 666,\n" +
                        "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/11?v=3\",\n" +
                        "    \"gravatar_id\": \"\",\n" +
                        "    \"url\": \"https://api.github.com/users/hans\",\n" +
                        "    \"html_url\": \"https://github.com/hans\",\n" +
                        "    \"followers_url\": \"https://api.github.com/users/hans/followers\",\n" +
                        "    \"following_url\": \"https://api.github.com/users/hans/following{/other_user}\",\n" +
                        "    \"gists_url\": \"https://api.github.com/users/hans/gists{/gist_id}\",\n" +
                        "    \"starred_url\": \"https://api.github.com/users/hans/starred{/owner}{/repo}\",\n" +
                        "    \"subscriptions_url\": \"https://api.github.com/users/hans/subscriptions\",\n" +
                        "    \"organizations_url\": \"https://api.github.com/users/hans/orgs\",\n" +
                        "    \"repos_url\": \"https://api.github.com/users/hans/repos\",\n" +
                        "    \"events_url\": \"https://api.github.com/users/hans/events{/privacy}\",\n" +
                        "    \"received_events_url\": \"https://api.github.com/users/hans/received_events\",\n" +
                        "    \"type\": \"User\",\n" +
                        "    \"site_admin\": false\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"login\": \"peter\",\n" +
                        "    \"id\": 667,\n" +
                        "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/111?v=3\",\n" +
                        "    \"gravatar_id\": \"\",\n" +
                        "    \"url\": \"https://api.github.com/users/peter\",\n" +
                        "    \"html_url\": \"https://github.com/peter\",\n" +
                        "    \"followers_url\": \"https://api.github.com/users/peter/followers\",\n" +
                        "    \"following_url\": \"https://api.github.com/users/peter/following{/other_user}\",\n" +
                        "    \"gists_url\": \"https://api.github.com/users/peter/gists{/gist_id}\",\n" +
                        "    \"starred_url\": \"https://api.github.com/users/peter/starred{/owner}{/repo}\",\n" +
                        "    \"subscriptions_url\": \"https://api.github.com/users/peter/subscriptions\",\n" +
                        "    \"organizations_url\": \"https://api.github.com/users/peter/orgs\",\n" +
                        "    \"repos_url\": \"https://api.github.com/users/peter/repos\",\n" +
                        "    \"events_url\": \"https://api.github.com/users/peter/events{/privacy}\",\n" +
                        "    \"received_events_url\": \"https://api.github.com/users/peter/received_events\",\n" +
                        "    \"type\": \"User\",\n" +
                        "    \"site_admin\": false\n" +
                        "  }\n" +
                        "]\n"
                        , MediaType.APPLICATION_JSON));

        githubStargazersService.restTemplate = restTemplate;

        // expect
        RestAssured.get("/data/stargazers").then().assertThat().statusCode(200).body("value", equalTo(2));
    }
}
