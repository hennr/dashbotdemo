package dashbotdemo.data;

import dashbotdemo.AbstractRestTestClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class IssuesTestClass extends AbstractRestTestClass {

    @Test
    public void servesValidJson() {
        get("/data/issues").then().assertThat().statusCode(200).body("value", equalTo(0));
    }
}