package dashbotdemo.data;

import com.jayway.restassured.RestAssured;
import dashbotdemo.DashbotdemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DashbotdemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ForksTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void servesValidJson() {
        get("/data/forks").then().assertThat().statusCode(200).body("value", equalTo(2));
    }
}
