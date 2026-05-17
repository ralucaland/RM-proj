package tema;

import Config.ConfigTests;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TemaAPI_httpbin  {

    @Test
    public void CourseName_header () {

        Response response = given()
                .baseUri(ConfigTests.HTTPBIN_BASE_URL)
                .header("Course-Name", "API Automation")
                .when()
                .get(ConfigTests.HEADERS_ENDPOINT);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("headers.Course-Name", equalTo("API Automation"));
    }
    @Test
    public void basicAuthTest() {

        Response response = given()
                .baseUri(ConfigTests.HTTPBIN_BASE_URL)
                .auth()
                .basic("user", "passwd")

                .when()
                .get(ConfigTests.BASIC_AUTH_ENDPOINT);

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }
}

