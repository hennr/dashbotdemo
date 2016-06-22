package dashbotdemo;

import org.junit.Test;

import static io.restassured.RestAssured.get;

public class DashbotdemoTest {

    @Test
    public void appStarts() {
	// when
	DashbotdemoApplication.main(new String[0]);

	// then
	get("/").then().assertThat().statusCode(200);
    }
}
