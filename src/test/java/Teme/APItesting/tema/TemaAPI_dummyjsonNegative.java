package Teme.APItesting.tema;

import Teme.Config.ConfigTests;
import Teme.DataAPI_tests.Data;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TemaAPI_dummyjsonNegative {

    @Test
    public void invalidEndpointTest() {

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .when()
                .get("/invalid-endpoint");

        response.prettyPrint();

        response.then()
                .statusCode(404)
                .body("message", notNullValue())
                .body("message", not(equalTo("")));
    }

    @Test
    public void productNotFoundTest() {

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .when()
                .get("/products/999999");

        response.prettyPrint();

        response.then()
                .statusCode(404)
                .body("message", notNullValue())
                .body("message", not(equalTo("")));
    }

    @Test
    public void loginWithWrongPasswordTest() {

        String body = """
                {
                    "username": "%s",
                    "password": "wrongPassword"
                }
                """.formatted(Data.LOGIN_USERNAME);

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(ConfigTests.LOGIN_ENDPOINT_dummy);

        response.prettyPrint();

        response.then()
                .statusCode(400)
                .body("message", notNullValue())
                .body("message", not(equalTo("")));
    }

    @Test
    public void invalidTokenTest() {

        Response response = given()
                .baseUri(ConfigTests.Dummy_Domain)
                .header("Authorization", "Bearer invalid_token_123")
                .when()
                .get(ConfigTests.AUTH_ME_ENDPOINT_dummy);

        response.prettyPrint();

        response.then()
                .statusCode(401)
                .body("message", notNullValue())
                .body("message", not(equalTo("")));
    }
}
