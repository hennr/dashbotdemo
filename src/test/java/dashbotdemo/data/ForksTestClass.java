package dashbotdemo.data;

import dashbotdemo.AbstractRestTestClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class ForksTestClass extends AbstractRestTestClass {

    @Test
    public void servesValidJson() {
        get("/data/forks").then().assertThat().statusCode(200).body("value", equalTo(2));
    }
}
