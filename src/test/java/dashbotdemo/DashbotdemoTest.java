package dashbotdemo;

import static com.jayway.restassured.RestAssured.get;
import org.junit.Test;

public class DashbotdemoTest {

    @Test
    public void appStarts() {
	// when
	DashbotdemoApplication.main(new String[0]);

	// then
	get("/").then().assertThat().statusCode(200);
    }
}
