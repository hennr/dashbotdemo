package dashbotdemo.data;

import dashbotdemo.AbstractRestTestClass;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class CollaboratorsTestClass extends AbstractRestTestClass {

    @Test
    public void servesValidJson() {
        get("/data/collaborators").then().assertThat().statusCode(200).body("value", equalTo(2));
    }
}
